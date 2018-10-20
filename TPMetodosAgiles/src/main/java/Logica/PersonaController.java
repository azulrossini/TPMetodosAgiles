/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Licencia;
import Persistencia.Persona;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author JIC
 */
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
    */
    public boolean[] validarDatos(TipoDocumento tipo, String numeroDocumento, String nombre, String apellido, String dia, 
                                    String mes, String anio, String calle, String numeroCalle, String piso, String depart){
        boolean[] lista= new boolean[11];
        
        lista[0]=validarDocumento(tipo, numeroDocumento);
        lista[1]=validarNombre(nombre);
        lista[2]=validarApellido(apellido);
        lista[3]=validarDia(dia);
        lista[4]=validarMes(mes);
        lista[5]=validarAnio(anio);
        lista[6]=validarCalle(calle);
        lista[7]=validarNumeroCalle(numeroCalle);
        lista[8]=validarPiso(piso);
        lista[9]=validarDepartamento(depart);
        lista[10]=validarFecha(dia,mes,anio);
        
        return lista;
    }
    
    public boolean validarDocumento(TipoDocumento tipo, String numeroDocumento){
        
        
        if((tipo==TipoDocumento.DNI || tipo==TipoDocumento.LE || tipo==TipoDocumento.LC ) && numeroDocumento.matches("[0-9]{8}")) return true;
        else if((tipo==TipoDocumento.CUIT || tipo==TipoDocumento.CUIL)  && numeroDocumento.matches("[0-9]{11}")) return true;
        else if(tipo==TipoDocumento.PASAPORTE && numeroDocumento.matches("[0-9]{8}[a-zA-Z]")) return true;
        else return false; 

        
    }
    
    public boolean validarNombre(String nombre){
        
        
        
        if(nombre.matches("((\\s?)[a-zA-Z]+(\\s?))+")) return true;
        else return false;
        
 
    }
    public boolean validarApellido(String apellido){
       
        if(apellido.matches("((\\s?)[a-zA-Z]+(\\s?))+") ) return true;
        else return false;
        
        
    }
    public boolean validarFecha(String dia, String mes, String anio){
        int dia1, mes1, anio1;
        if(this.validarDia(dia)) dia1 = Integer.valueOf(dia);
        else return false;
        if(this.validarMes(mes)) mes1 = Integer.valueOf(mes);
        else return false;
        if(this.validarAnio(anio)) anio1 = Integer.valueOf(anio);
        else return false;
        
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
        
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.of(anio1, mes1, dia1);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        if(periodo.getYears()<17) return false;
        else return true;
        
        
        
    }
    public boolean validarDia(String dia){
        
        
        if(dia.matches("[0-9]?[0-9]")){
            if(Integer.valueOf(dia)>0 && Integer.valueOf(dia)<32)
                return true;
            else return false;
        }else return false;
        
        
    }
    public boolean validarMes(String mes){
        if(mes.matches("[0-9]?[0-9]")){
            if(Integer.valueOf(mes)>0 && Integer.valueOf(mes)<13)
                return true;
            else return false;
        }else return false;
    }
    public boolean validarAnio(String anio){
        if(anio.matches("[0-9][0-9][0-9][0-9]")){
            if(Integer.valueOf(anio)>1899 && Integer.valueOf(anio)<2018)
                return true;
            else return false;
        }else return false;
    }
    public boolean validarCalle(String calle){
        if(calle.matches("((\\s?)[a-zA-Z]+(\\s?))+")) return true;
        else return false;
    }
    public boolean validarNumeroCalle(String numeroCalle){
        
        if(numeroCalle.matches("[0-9][0-9][0-9]?[0-9]")) return true;
        else return false;
        
    }
    
    public boolean validarPiso(String piso){
        if(piso.matches("([0-9]?[0-9])?")) return true;
        else return false;
    }
    public boolean validarDepartamento(String depart){
        if(depart.matches("[0-9]?") || depart.matches("[a-zA-Z]?")) return true;
        else return false;
    }
    
    public Date getFecha(String dia, String mes, String anio){
        int dia1 = Integer.valueOf(dia);
        int mes1 = Integer.valueOf(mes);
        int anio1 = Integer.valueOf(anio);
        LocalDate fechaNac = LocalDate.of(anio1, mes1, dia1);
        Date date = Date.from(fechaNac.atStartOfDay().toInstant(ZoneOffset.UTC));
        return date;
    }
       
}
