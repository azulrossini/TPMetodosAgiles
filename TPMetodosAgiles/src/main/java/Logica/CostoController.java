
package Logica;

import Persistencia.Costos;


public class CostoController {
    private CostoDAO costoDAO;
    private Costos costo;
    //Costo administrativo
    private float costoAdmin = 8;
    
    public CostoController(){
        this.costoDAO = new CostoDAO();
    }
    
    public float calcularCosto(String clase, int vigencia){
        this.costo = costoDAO.calcularCosto(clase , vigencia);
        float costoLicencia = costo.getPrecio();     
        return (costoAdmin + costoLicencia);
    }
    
    public void imprimirComprobanteDePago(String tipoLicencia, int aniosVigencia){
        //Creo una instancia de la clase encargada de crear e imprimir reportes
        ImprimirController ic = new ImprimirController(tipoLicencia, aniosVigencia, costoAdmin);
        //Imprimo el comprobante
        ic.imprimirComprobanteDePago();
    }
    
    public void verComprobanteDePago(String tipoLicencia, int aniosVigencia){
        //Creo una instancia de la clase encargada de crear e imprimir reportes
        ImprimirController ic = new ImprimirController(tipoLicencia, aniosVigencia, costoAdmin);        
        //Ver el comprobante
        ic.verComprobanteDePago();
    }
    
    public int getCostoId(){
        return this.costo.getId();
    }
    
    public Costos getCosto(){
        return this.costo;
    }
    
}
