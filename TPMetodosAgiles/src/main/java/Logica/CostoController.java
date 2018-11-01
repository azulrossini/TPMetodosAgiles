
package Logica;


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
