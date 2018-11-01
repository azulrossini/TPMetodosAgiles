
package Logica;

import Persistencia.Licencia;
import Persistencia.Persona;
import Persistencia.Vigencias;
import Presentacion.EmitirLicencia;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LicenciaController {
    
    private LicenciaDAO LicenciaDAO;
    
    public enum Motivo{ORIGINAL, RENOVACION}
    
    public LicenciaController(){
        this.LicenciaDAO = new LicenciaDAO();
    }
    
    public List<Licencia> getLicencias(){
        return LicenciaDAO.readAll();
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
    
    public Date getVigencia(Licencia licencia,Date fechaNacimiento) throws ParseException{
        
        PersonaController personaController = new PersonaController();
        VigenciaController vigenciaController = new VigenciaController();

        List<Vigencias> listaVigencias = vigenciaController.getVigencias();
             
        Calendar fechaVigencia = Calendar.getInstance();
        fechaVigencia.setTime(licencia.getFechaEmision());
        
        int edad = personaController.getEdad(fechaNacimiento);
        
        if(edad < 21){
            if(licencia.getMotivo().equals(Motivo.ORIGINAL.toString())){
                
                fechaVigencia.add(Calendar.YEAR, listaVigencias.get(0).getDuracion());
                
            }
            if(licencia.getMotivo().equals(Motivo.RENOVACION.toString())){
                
                fechaVigencia.add(Calendar.YEAR, listaVigencias.get(1).getDuracion()); 
                
            }
        }
        if(edad >=21 && edad <= 46){
            
            fechaVigencia.add(Calendar.YEAR, listaVigencias.get(2).getDuracion()); 
            
        }
        if(edad>46 && edad <= 60){
            
            fechaVigencia.add(Calendar.YEAR, listaVigencias.get(3).getDuracion());
            
        }
        if(edad >60 && edad <= 70){
            
            fechaVigencia.add(Calendar.YEAR, listaVigencias.get(4).getDuracion());
            
        }
        if(edad > 70){
           
           fechaVigencia.add(Calendar.YEAR, listaVigencias.get(5).getDuracion());
           
        }
        
        Calendar c = Calendar.getInstance();
        c.setTime(fechaNacimiento);
        fechaVigencia.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));
        fechaVigencia.set(Calendar.MONTH, c.get(Calendar.MONTH));
        
        return fechaVigencia.getTime();
    }
    
    public void crearLicencia(Persona titular, String clase, String obs, Motivo motivo){

                this.eliminarClasesHeredadas(clase, titular);

                
                //Crear la licencia
                Licencia licencia = new Licencia();
                licencia.setClaseId(clase);
                licencia.setObservaciones(obs);
                licencia.setPersonaId(titular.getId());
                licencia.setUsuarioId(00);
                licencia.setMotivo(motivo);

                //SETAR!!!!
                licencia.setVigenciaId(0);
 
                //Calcular vigencia
                licencia.setFechaEmision(new Date());
                Date fechaVencimiento=null;
                try {
                    fechaVencimiento = fechaVencimiento = this.getVigencia(licencia, titular.getFechaNac());
                } 
                catch (ParseException ex) {
                    Logger.getLogger(EmitirLicencia.class.getName()).log(Level.SEVERE, null, ex);
                }
                licencia.setFechaVenc(fechaVencimiento);
                System.out.println(fechaVencimiento);
                
                //Calcular costo
                CostoController cc = new CostoController();
                Date hoy = new Date();
                
                int diffAnios = getDiferenciaAnios(fechaVencimiento);

                System.out.println(diffAnios);
                cc.calcularCosto(clase, diffAnios);
                
                licencia.setCostoId(cc.getCostoId());
                System.out.println(cc.getCostoId());
                
                LicenciaDAO.writeLicencia(licencia);
    }
    
    public int getDiferenciaAnios(Date vencimiento){
            Calendar c = new GregorianCalendar();
            c.setTime(vencimiento);
            
            Calendar today = Calendar.getInstance();
            int diffYear = c.get(Calendar.YEAR) -today.get(Calendar.YEAR);
            
            return diffYear;
    }
}
