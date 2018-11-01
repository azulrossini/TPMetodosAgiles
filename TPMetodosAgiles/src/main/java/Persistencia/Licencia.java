package Persistencia;
// Generated 22/10/2018 14:13:22 by Hibernate Tools 4.3.1


import java.util.Date;

public class Licencia  implements java.io.Serializable {

    private Integer id;
    private int personaId;
    private String claseId;
    private int usuarioId;
    private int costoId;
    private int vigenciaId;
    private String motivo;
    private Date fechaEmision;
    private Date fechaVenc;
    private String observaciones;

    public Licencia() {
    }
    
    public Licencia(int personaId, String claseId, int usuarioId, int costoId, int vigenciaId, String motivo, Date fechaEmision, Date fechaVenc) {
        this.personaId = personaId;
        this.claseId = claseId;
        this.usuarioId = usuarioId;
        this.costoId = costoId;
        this.vigenciaId = vigenciaId;
        this.motivo = motivo;
        this.fechaEmision = fechaEmision;
        this.fechaVenc = fechaVenc;
    }
    
    public Licencia(int personaId, String claseId, int usuarioId, int costoId, int vigenciaId, String motivo, Date fechaEmision, Date fechaVenc, String observaciones) {
       this.personaId = personaId;
       this.claseId = claseId;
       this.usuarioId = usuarioId;
       this.costoId = costoId;
       this.vigenciaId = vigenciaId;
       this.motivo = motivo;
       this.fechaEmision = fechaEmision;
       this.fechaVenc = fechaVenc;
       this.observaciones = observaciones;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getPersonaId() {
        return this.personaId;
    }
    
    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }
    public String getClaseId() {
        return this.claseId;
    }
    
    public void setClaseId(String claseId) {
        this.claseId = claseId;
    }
    public int getUsuarioId() {
        return this.usuarioId;
    }
    
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    public int getCostoId() {
        return this.costoId;
    }
    
    public void setCostoId(int costoId) {
        this.costoId = costoId;
    }
    public int getVigenciaId() {
        return this.vigenciaId;
    }
    
    public void setVigenciaId(int vigenciaId) {
        this.vigenciaId = vigenciaId;
    }
    public String getMotivo() {
        return this.motivo;
    }
    
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public Date getFechaEmision() {
        return this.fechaEmision;
    }
    
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    public Date getFechaVenc() {
        return this.fechaVenc;
    }
    
    public void setFechaVenc(Date fechaVenc) {
        this.fechaVenc = fechaVenc;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }




}


