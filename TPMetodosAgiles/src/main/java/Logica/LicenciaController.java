
package Logica;

import Persistencia.Licencia;
import Persistencia.Persona;
import Persistencia.Vigencias;
import java.io.IOException;
import java.text.ParseException;
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
    
    public List<Licencia> getLicenciasRango(String fecha1, String fecha2){
        return LicenciaDAO.readRango(fecha1, fecha2);
    }
    
    public List<Licencia> getLicenciasVigentes(Date fechaVigencia){
        return LicenciaDAO.read(fechaVigencia);
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
    
    public Date getFechaVigencia(Vigencias v,Date fechaNacimiento){
        
        PersonaController personaController = new PersonaController();
        
             
        Calendar fechaVigencia = Calendar.getInstance();
//        fechaVigencia.setTime(licencia.getFechaEmision());
        
        int edad = personaController.getEdad(fechaNacimiento);
        
        fechaVigencia.add(Calendar.YEAR, v.getDuracion());
      
        Calendar c = Calendar.getInstance();
        c.setTime(fechaNacimiento);
        
        fechaVigencia.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));
        fechaVigencia.set(Calendar.MONTH, c.get(Calendar.MONTH));
        
        return fechaVigencia.getTime();
    }
    
    public void crearLicencia(Persona titular, String clase, String obs, Motivo motivo, int userID){
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
    }
    
    public int getDiferenciaAnios(Date vencimiento){
        Calendar c = new GregorianCalendar();
        c.setTime(vencimiento);
          
        Calendar today = Calendar.getInstance();
        int diffYear = c.get(Calendar.YEAR) -today.get(Calendar.YEAR);
          
        return diffYear;
    }
    
    public int imprimirTodas() throws IOException, JRException{
        
        ImprimirController iController = new ImprimirController();
        iController.imprimirListado();
        
        return 0;
    }
    
    public int imprimirRango(String fechaDesde, String fechaHasta) throws IOException, JRException, ParseException{
        
        ImprimirController iController = new ImprimirController();
        iController.imprimirListadoRango(fechaDesde, fechaHasta);
        
        
        return 0;
    }
}
