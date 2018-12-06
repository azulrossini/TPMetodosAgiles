
package Logica;

import Persistencia.Costos;


public class CostoController {
    private CostoDAO costoDAO;
    private Costos costo;
    //Costo administrativo
    private final float costoAdmin = 8;
    
    public CostoController(){
        this.costoDAO = new CostoDAO();
    }
    
    public float calcularCosto(String clase, int vigencia){
        this.costo = costoDAO.calcularCosto(clase , vigencia);
        float costoLicencia = costo.getPrecio();
        return (costoAdmin + costoLicencia);
    }
    
    public int getCostoId(){
        return this.costo.getId();
    }
    
    public Costos getCosto(){
        return this.costo;
    }

    public float getCostoAdmin() {
        return costoAdmin;
    }
    
}
