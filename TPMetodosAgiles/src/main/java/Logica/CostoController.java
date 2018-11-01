
package Logica;

import Persistencia.Costos;


public class CostoController {
    private CostoDAO costoDAO;
    private Costos costo;
    
    public CostoController(){
        this.costoDAO = new CostoDAO();
    }
    
    public float calcularCosto(String clase, int vigencia){
        //Costo Administrativo
        int costoAdmin = 8;
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
    
}
