
package Logica;

import Persistencia.Licencia;
import Persistencia.Persona;
import Persistencia.Vigencias;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import net.sf.jasperreports.engine.JRException;


public class LicenciaController {
    
    private final LicenciaDAO LicenciaDAO;
    
    public enum Motivo{ORIGINAL, RENOVACION}
    
    public LicenciaController(){
        this.LicenciaDAO = new LicenciaDAO();
    }
    
    public List<Licencia> getLicencias(){
        return LicenciaDAO.readAll();
    }
    
    public List<Licencia> getLicenciasVigentes(){
        return LicenciaDAO.readAllVigentes();
    }
    
    public List<Licencia> getLicenciasExpiradas(){
        return LicenciaDAO.readAllExpiradas();
    }
    
    public List<Licencia> getLicenciasRangoVigentes(String fecha1, String fecha2){
        return LicenciaDAO.readRangoVigentes(fecha1, fecha2);
    }
    
    public List<Licencia> getLicenciasRangoExpiradas(String fecha1, String fecha2){
        return LicenciaDAO.readRangoExpiradas(fecha1, fecha2);
    }
    
    public List<Licencia> getLicenciasVigentes(Date fechaVigencia){
        return LicenciaDAO.read(fechaVigencia);
    }  
    
    public List<Licencia> getLicenciasTitular(Persona titular){
        if(titular.getId()!=null){
            return LicenciaDAO.getLicenciasTitular(titular.getId());
        }
        else{
            return new ArrayList<Licencia>();
        }
        
    }
    
    public void actualizarLicencia(Licencia l){
        LicenciaDAO.update(l);
    }
    
    public boolean verificarClase(String clase, Persona titular){
        ClaseController cc = new ClaseController();
        //Si la clase existe
        if(cc.verificarClase(clase)){

            if(clase =="A" || clase =="B" || clase== "F" || clase =="G" ){
                //Si es de esta clase no necesita validacion extra, puede sacarla sin problema a la licencia
                return true;
            }
            else{
                List<Licencia> licencias_anteriores = LicenciaDAO.getLicenciasTitular(titular.getId());
                for(int i=0; i<licencias_anteriores.size(); i++){
                    
                //Verifica si tuvo una licencia de clase B en algun momento, al menos 1 anio antes
                    if(licencias_anteriores.get(i).getClaseId() == "B"){
                        int diffAnios = getDiferenciaAnios(licencias_anteriores.get(i).getFechaEmision());
                        if(diffAnios>= 365){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
    
    public boolean validarClaseNuevoTitular(String clase){
        ClaseController cc = new ClaseController();
        
        if(cc.verificarClase(clase)){
            if(clase =="A" || clase =="B" || clase== "F" || clase =="G" ){
                //Si es de esta clase no necesita validacion extra, puede sacarla sin problema a la licencia
                return true;
            }
        }
        
        return false;
        
    }
    
    public void eliminarClasesHeredadas(String clase, Persona titular){
        //Cancela la vigencia de las clases heredadas
        //Por ejemplo, si se emite una nueva licencia de la clase C
        //Si el titular posee una licencia de clase B, pierde la vigencia de la misma
        //Porque C hereda todo loq ue posea B
        
        switch (clase){
            case "A":
                return;
            case "B":
                return;
            case"C":
                List<String> heredadasC = LicenciaDAO.getHeredadas("E");
                for(int i=0; i<heredadasC.size(); i++){
                    List<Licencia> licencia_anterior = LicenciaDAO.getLicenciasPorClase(titular.getId(), heredadasC.get(i));
                    for(int j=0; j<licencia_anterior.size(); j++){
                        licencia_anterior.get(j).setFechaVenc(new Date());
                    }   
                }
                break;
            case "D":
                List<String> heredadasD = LicenciaDAO.getHeredadas("E");
                for(int i=0; i<heredadasD.size(); i++){
                    List<Licencia> licencia_anterior = LicenciaDAO.getLicenciasPorClase(titular.getId(), heredadasD.get(i));
                    for(int j=0; j<licencia_anterior.size(); j++){
                        licencia_anterior.get(j).setFechaVenc(new Date());
                    }   
                }
                break;
            case "E":
                List<String> heredadasE = LicenciaDAO.getHeredadas("E");
                for(int i=0; i<heredadasE.size(); i++){
                    List<Licencia> licencia_anterior = LicenciaDAO.getLicenciasPorClase(titular.getId(), heredadasE.get(i));
                    for(int j=0; j<licencia_anterior.size(); j++){
                        licencia_anterior.get(j).setFechaVenc(new Date());
                    }   
                }
                break;
            case "F":
                return;
            case "G":
                return;
        }
    }
    
    
    public Persona getPersona(int id){
              
        PersonaController personaController = new PersonaController();
        
        return personaController.getPersona(id);
    }
    //Retorna la fecha de vencimiento de la licencia
    //A partir de la vigencia y la fecha de nacimiento
    public Date getFechaVigencia(Vigencias v,Date fechaNacimiento){
        
        PersonaController personaController = new PersonaController();
        
        //Obtenemos fecha actual     
        Calendar fechaVigencia = Calendar.getInstance();
        
        //Obtenemos la edad de la persona
        int edad = personaController.getEdad(fechaNacimiento);
        
        //A la fecha actual obtenida le agregamos la duración de la vigencia
        fechaVigencia.add(Calendar.YEAR, v.getDuracion());
        
        //Obtenemos otra instancia de Calendar y la seteamos en la fecha de nacimiento
        Calendar c = Calendar.getInstance();
        c.setTime(fechaNacimiento);
        
        //Seteamos a la fecha de vigencia el día y mes de nacimiento del titular
        fechaVigencia.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));
        fechaVigencia.set(Calendar.MONTH, c.get(Calendar.MONTH));
        
        //Retornamos la fecha en formato Date
        return fechaVigencia.getTime();
    }
    
    public Licencia crearLicencia(Persona titular, String clase, String obs, Motivo motivo, int userID){
        this.eliminarClasesHeredadas(clase, titular);

        //Crear la licencia
        Licencia licencia = new Licencia();
        licencia.setClaseId(clase);
        licencia.setObservaciones(obs.toUpperCase());
        licencia.setPersonaId(titular.getId());
        licencia.setUsuarioId(userID);
        licencia.setMotivo(motivo.toString().toUpperCase());

        //Calcular vigencia
        VigenciaController vigenciaController = new VigenciaController();
        Vigencias vigencia = vigenciaController.getVigencia(motivo.toString(), titular.getFechaNac());
        licencia.setVigenciaId(vigencia.getId());
          
        licencia.setFechaEmision(new Date());
        Date fechaVencimiento=null;
              
        fechaVencimiento = this.getFechaVigencia(vigencia, titular.getFechaNac());
        licencia.setFechaVenc(fechaVencimiento);
                
        //Calcular costo
        CostoController cc = new CostoController();
        Date hoy = new Date();
        int diffAnios = getDiferenciaAnios(fechaVencimiento);
        cc.calcularCosto(clase, diffAnios);
             
        licencia.setCostoId(cc.getCostoId());
               
         LicenciaDAO.writeLicencia(licencia);
         
         return licencia;
    }
    
    public int getDiferenciaAnios(Date vencimiento){
        Calendar c = new GregorianCalendar();
        c.setTime(vencimiento);
          
        Calendar today = Calendar.getInstance();
        int diffYear = c.get(Calendar.YEAR) -today.get(Calendar.YEAR);
          
        return diffYear;
    }
    
        
    public void guardarDuplicado ( Licencia l){
        //Cambio la fecha de emision de la licencia y cambio su motivo a Duplicado
        l.setFechaEmision(new Date());
        l.setMotivo("DUPLICADO");
        LicenciaDAO.update(l);
        
    }
    
    //CONJUNTO DE MÉTODOS PARA LA IMPRESIÓN DE REPORTES
    
    //MÉTODO PARA IMPRIMIR TODAS LAS LICENCIAS VIGENTES
    public int imprimirTodasVigentes() throws IOException, JRException, ParseException{
        
        ImprimirController iController = new ImprimirController();
        iController.imprimirListadoVigentes();
        
        return 0;
    }
    
    //MÉTODO PARA IMPRIMIR TODAS LAS LICENCIAS EXPIRADAS
    public int imprimirTodasExpiradas() throws IOException, JRException, ParseException{
        
        ImprimirController iController = new ImprimirController();
        iController.imprimirListadoExpiradas();
        
        return 0;
    }
    
    //MÉTODO PARA IMPRIMIR TODAS LAS LICENCIAS VIGENTES DENTRO DE UN RANGO
    public int imprimirRangoVigentes(String fechaDesde, String fechaHasta) throws IOException, JRException, ParseException{
        
        ImprimirController iController = new ImprimirController();
        iController.imprimirRangoVigentes(fechaDesde, fechaHasta);        
        
        return 0;
    }    
    
    //MÉTODO PARA IMPRIMIR TODAS LAS LICENCIAS EXPIRADAS DENTRO DE UN RANGO
    public int imprimirRangoExpiradas(String fechaDesde, String fechaHasta) throws IOException, JRException, ParseException{
        
        ImprimirController iController = new ImprimirController();
        iController.imprimirRangoExpiradas(fechaDesde, fechaHasta);        
        
        return 0;
    }

    
}
