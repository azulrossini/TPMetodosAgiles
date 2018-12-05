
package Logica;

import Persistencia.Persona;
import java.util.List;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class PersonaController {
    
    private PersonaDAO PersonaDAO;
    
    public enum TipoDocumento{DNI, CUIT, CUIL, LC, LE, CI, PASAPORTE}
    
    public PersonaController(){
        this.PersonaDAO = new PersonaDAO();
    }
    
    public Persona getPersona(int id){
        Persona persona = PersonaDAO.read(id);                
        return persona;   
    }

    public List<Persona> buscarTitular(String dni){
        //Este metodo busca por DNI, no por id de la persona
        //El ID de la persona es un autoincremental de la bd
        return PersonaDAO.readTitular(dni);
    }

    public void almacenarTitular(Persona p){
        PersonaDAO.writeTitular(p);
    }
    public void updateTitular(Persona p){
        PersonaDAO.updateTitular(p);
    }
    
    
    /*devuelve un arreglo de booleans, cada posicion indica si el dato es correcto o no
    0 numeroDocumento
    1 nombre
    2 apellido
    3 dia
    4 mes
    5 anio
    6 calle
    7 numero de calle
    8 piso
    9 departamento
    10 edad menor a 17
    11 existe en bd
    */
    public boolean[] validarDatos(TipoDocumento tipo, String numeroDocumento, String nombre, String apellido, String dia, 
        String mes, String anio, String calle, String numeroCalle, String piso, String depart){
        boolean[] lista= new boolean[12];
        
        lista[0]=validarDocumento(tipo, numeroDocumento);
        lista[1]=validarNombre(nombre);
        lista[2]=validarApellido(apellido);
        lista[3]=validarDia(dia);
        lista[4]=validarMes(mes);
        lista[5]=validarAnio(anio);
        lista[6]=validarCalle(calle, numeroCalle, piso, depart);
        lista[7]=validarNumeroCalle(numeroCalle);
        lista[8]=validarPiso(piso);
        lista[9]=validarDepartamento(depart);
        lista[10]=validarFecha(dia,mes,anio);
        lista[11]=validarExistencia(tipo, numeroDocumento);
        return lista;
    }
    
    //Valida los datos para modificar un titular existente y devuelve un entero que será analizado por la interfaz
    public int validarDatosMT( String nombre, String apellido, String calle, String numeroCalle, String piso, String depart){
        
        if(!validarNombre(nombre)) return 1;
        if(!validarApellido(apellido)) return 2;
        if(!validarCalle(calle, numeroCalle, piso, depart)) return 3;
        if(!validarNumeroCalle(numeroCalle)) return 4;
        if(!validarPiso(piso)) return 5;
        if(!validarDepartamento(depart)) return 6;

        return 0;
    }
    public boolean validarDocumento(TipoDocumento tipo, String numeroDocumento){
        //Segun el tipo de documento, valido la longitud de cada uno y si tienen los caracteres que correspondan
        if((tipo==TipoDocumento.DNI || tipo==TipoDocumento.LE || tipo==TipoDocumento.LC ) && numeroDocumento.matches("[0-9]{8}")) return true;
        else if((tipo==TipoDocumento.CUIT || tipo==TipoDocumento.CUIL)  && numeroDocumento.matches("[0-9]{11}")) return true;
        else if(tipo==TipoDocumento.PASAPORTE && numeroDocumento.matches("[0-9]{8}[a-zA-Z]")) return true;
        else return false; 

    }
    
    public boolean validarNombre(String nombre){
        //Valido que tenga solo espacios y/o letras
        if(nombre.matches("((\\s?)[a-zA-Z]+(\\s?))+") && nombre.length()<32) return true;
        else return false;
        
 
    }
    public boolean validarApellido(String apellido){
       //Valido que tenga solo espacios y/o letras
        if(apellido.matches("((\\s?)[a-zA-Z]+(\\s?))+") && apellido.length()<32 ) return true;
        else return false;
  
    }
    public boolean validarFecha(String dia, String mes, String anio){
        int dia1, mes1, anio1;
        //Primero valido si son numeros lo ingresado
        if(this.validarDia(dia)) dia1 = Integer.valueOf(dia);
        else return false;
        if(this.validarMes(mes)) mes1 = Integer.valueOf(mes);
        else return false;
        if(this.validarAnio(anio)) anio1 = Integer.valueOf(anio);
        else return false;
        
        //Verfico los dias del mes
        switch (mes1) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                //numDias = 31;
                if(dia1>31 || dia1<1) return false;
                break;
            case 4: case 6: case 9: case 11:
               // numDias = 30;
                if(dia1>30 || dia1<1) return false;
                break;
            case 2:
                if((anio1%4==0 && anio1%100!=0) || anio1%400==0){
                   // numDias = 29;
                   if(dia1>29 || dia1<1) return false;
                }
                else{
                    //numDias = 28;
                    if(dia1>28 || dia1<1) return false;
                }
                break;
        }
         //Verfico que la edad sea mayor a 17
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.of(anio1, mes1, dia1);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        if(periodo.getYears()<17) return false;
        else return true;

    }
    public boolean validarDia(String dia){
        //Valido que sean solo nuemros y el rango valido
        if(dia.matches("[0-9]?[0-9]")){
            if(Integer.valueOf(dia)>0 && Integer.valueOf(dia)<32)
                return true;
            else return false;
        }else return false;
        
        
    }
    public boolean validarMes(String mes){
        //Valido que sean solo nuemros y el rango valido
        if(mes.matches("[0-9]?[0-9]")){
            if(Integer.valueOf(mes)>0 && Integer.valueOf(mes)<13)
                return true;
            else return false;
        }else return false;
    }
    public boolean validarAnio(String anio){
        //Valido que sean solo nuemros y el rango valido
        if(anio.matches("[0-9][0-9][0-9][0-9]")){
            if(Integer.valueOf(anio)>1899 && Integer.valueOf(anio)<2018)
                return true;
            else return false;
        }else return false;
    }
    public boolean validarCalle(String calle, String numeroCalle, String piso, String depart){
        //Valido que tenga solo espacios y/o letras y que la longitud no sobrepase la de la BD
        if(calle.matches("((\\s?)[a-zA-Z]+(\\s?))+") && (calle.length()+numeroCalle.length()+piso.length()+depart.length())<32) return true;
        else return false;
    }
    public boolean validarNumeroCalle(String numeroCalle){
        //Valido que sean solo numeros
        if(numeroCalle.matches("[0-9][0-9][0-9]?[0-9]")) return true;
        else return false;
        
    }
    
    public boolean validarPiso(String piso){
        //Valido que sean solo numeros
        if(piso.matches("([0-9]?[0-9])?")) return true;
        else return false;
    }
    public boolean validarDepartamento(String depart){
        //Valido que sean solo numeros o solo letras
        if(depart.matches("[0-9]?") || depart.matches("[a-zA-Z]?")) return true;
        else return false;
    }
    
    public Date getFecha(String dia, String mes, String anio){
        //Obtiene una fecha a partir de strings
        int dia1 = Integer.valueOf(dia);
        int mes1 = Integer.valueOf(mes);
        int anio1 = Integer.valueOf(anio);
        LocalDate fechaNac = LocalDate.of(anio1, mes1, dia1);
        Date date = /*Date.from(fechaNac.atStartOfDay().toInstant(ZoneOffset.UTC));*/ java.sql.Date.valueOf(fechaNac);

        return date;
    }
    
    public int getEdad(Date fechaNacimiento){
        if(fechaNacimiento!=null){
            Calendar c = new GregorianCalendar();
            c.setTime(fechaNacimiento);
            
            Calendar today = Calendar.getInstance();
            int diffYear = today.get(Calendar.YEAR) - c.get(Calendar.YEAR);
            int diffMonth = today.get(Calendar.MONTH) - c.get(Calendar.MONTH);
            int diffDay = today.get(Calendar.DAY_OF_MONTH) - c.get(Calendar.DAY_OF_MONTH);
            
            // Si está en ese año pero todavía no los ha cumplido
            if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
                diffYear = diffYear - 1;
            }
            return diffYear;

        }
        else{
            return -1;
        }
    }
    
    public boolean validarExistencia(TipoDocumento tipo, String numeroDocumento){
        //Busco en la BD si el titular ya existe
        if(!numeroDocumento.equals("")){
            if(this.validarDocumento(tipo, numeroDocumento)){
                List<Persona> listaPersonas = this.buscarTitular(numeroDocumento);
                for(Persona p: listaPersonas){
                    if(p.getTipoId().equals(tipo.toString())) return false;
                }
                return true;
            }
        }else return true;
        
        return true;
    }
    public Persona PersonaExistente(TipoDocumento tipo, String numeroDocumento){
        List<Persona> listaPersonas = this.buscarTitular(numeroDocumento);
        for(Persona p: listaPersonas){
            if(p.getTipoId().equals(tipo.toString()) && p.getNroId().equals(numeroDocumento)) return p;
        }
        
        return null;
    }
    
}