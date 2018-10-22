package Persistencia;
// Generated 21/10/2018 23:41:00 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Persona generated by hbm2java
 */
public class Persona  implements java.io.Serializable {


     private Integer id;
     private String tipoId;
     private int nroId;
     private String apellido;
     private String nombre;
     private Date fechaNac;
     private String domicilio;
     private String grupoSanguineo;
     private String factor;
     private boolean donante;

    public Persona() {
    }

    public Persona(String tipoId, int nroId, String apellido, String nombre, Date fechaNac, String domicilio, String grupoSanguineo, String factor, boolean donante) {
       this.tipoId = tipoId;
       this.nroId = nroId;
       this.apellido = apellido;
       this.nombre = nombre;
       this.fechaNac = fechaNac;
       this.domicilio = domicilio;
       this.grupoSanguineo = grupoSanguineo;
       this.factor = factor;
       this.donante = donante;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTipoId() {
        return this.tipoId;
    }
    
    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }
    public int getNroId() {
        return this.nroId;
    }
    
    public void setNroId(int nroId) {
        this.nroId = nroId;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFechaNac() {
        return this.fechaNac;
    }
    
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    public String getDomicilio() {
        return this.domicilio;
    }
    
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public String getGrupoSanguineo() {
        return this.grupoSanguineo;
    }
    
    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
    public String getFactor() {
        return this.factor;
    }
    
    public void setFactor(String factor) {
        this.factor = factor;
    }
    public boolean isDonante() {
        return this.donante;
    }
    
    public void setDonante(boolean donante) {
        this.donante = donante;
    }




}


