/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;



/**
 *
 * @author ayr_1
 */
public class CostoController {
    private CostoDAO costoDAO;
    
    public CostoController(){
        this.costoDAO = new CostoDAO();
    }
    
    public float calcularCosto(String clase, int vigencia){
        //Costo Administrativo
        int costoAdmin = 8;
        float costoLicencia = costoDAO.calcularCosto(clase , vigencia);
        
        return (costoAdmin + costoLicencia);
    }
    
}
