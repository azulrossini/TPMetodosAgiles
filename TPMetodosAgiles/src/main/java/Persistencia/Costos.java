package Persistencia;
// Generated 18/10/2018 19:24:53 by Hibernate Tools 4.3.1



/**
 * Costos generated by hbm2java
 */
public class Costos  implements java.io.Serializable {


     private String id;
     private int unAnio;
     private int tresAnios;
     private int cuatroAnios;
     private int cincoAnios;

    public Costos() {
    }

    public Costos(String id, int unAnio, int tresAnios, int cuatroAnios, int cincoAnios) {
       this.id = id;
       this.unAnio = unAnio;
       this.tresAnios = tresAnios;
       this.cuatroAnios = cuatroAnios;
       this.cincoAnios = cincoAnios;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public int getUnAnio() {
        return this.unAnio;
    }
    
    public void setUnAnio(int unAnio) {
        this.unAnio = unAnio;
    }
    public int getTresAnios() {
        return this.tresAnios;
    }
    
    public void setTresAnios(int tresAnios) {
        this.tresAnios = tresAnios;
    }
    public int getCuatroAnios() {
        return this.cuatroAnios;
    }
    
    public void setCuatroAnios(int cuatroAnios) {
        this.cuatroAnios = cuatroAnios;
    }
    public int getCincoAnios() {
        return this.cincoAnios;
    }
    
    public void setCincoAnios(int cincoAnios) {
        this.cincoAnios = cincoAnios;
    }




}


