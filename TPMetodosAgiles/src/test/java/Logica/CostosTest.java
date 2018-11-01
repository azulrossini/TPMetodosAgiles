/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;




import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author ayr_1
 */
public class CostosTest {
    
    CostoController cc = new CostoController();
    
    @Test
    public void calcularCostoTest(){
        //Costo administrativo
        float costoAdmin = 8;
        //Costo de una licencia clase A y vigencia de 1 años
        float costo = cc.calcularCosto("A",1);         
                                        //valor del delta
        assertEquals(20+costoAdmin ,costo,0.02);
        assertEquals(1,cc.getCostoId());
        //Costo de una licencia clase A y vigencia de 3 años
        costo = cc.calcularCosto("A",3); 
        assertEquals(25+costoAdmin ,costo,0.02);
        assertEquals(2,cc.getCostoId());
        //Costo de una licencia clase A y vigencia de 4 años
        costo = cc.calcularCosto("A",4); 
        assertEquals(30+costoAdmin ,costo,0.02);
        assertEquals(3,cc.getCostoId());
        //Costo de una licencia clase A y vigencia de 5 años
        costo = cc.calcularCosto("A",5); 
        assertEquals(40+costoAdmin ,costo,0.02);
        assertEquals(4,cc.getCostoId());
        
        
        //Costo de una licencia clase B y vigencia de 1 años
        costo = cc.calcularCosto("B",1); 
        assertEquals(20+costoAdmin ,costo,0.02);
        assertEquals(5,cc.getCostoId());
        //Costo de una licencia clase B y vigencia de 3 años
        costo = cc.calcularCosto("B",3); 
        assertEquals(25+costoAdmin ,costo,0.02);
        assertEquals(6,cc.getCostoId());
        //Costo de una licencia clase B y vigencia de 4 años
        costo = cc.calcularCosto("B",4);         
        assertEquals(30+costoAdmin ,costo,0.02);
        assertEquals(7,cc.getCostoId());
        //Costo de una licencia clase B y vigencia de 5 años
        costo = cc.calcularCosto("B",5); 
        assertEquals(40+costoAdmin ,costo,0.02);
        assertEquals(8,cc.getCostoId());
        
        //Costo de una licencia clase C y vigencia de 1 años
        costo = cc.calcularCosto("C",1); 
        assertEquals(23+costoAdmin ,costo,0.02);
        assertEquals(9,cc.getCostoId());
        //Costo de una licencia clase C y vigencia de 3 años
        costo = cc.calcularCosto("C",3); 
        assertEquals(30+costoAdmin ,costo,0.02);
        assertEquals(10,cc.getCostoId());
        //Costo de una licencia clase C y vigencia de 4 años
        costo = cc.calcularCosto("C",4); 
        assertEquals(35+costoAdmin ,costo,0.02);
        assertEquals(11,cc.getCostoId());
        //Costo de una licencia clase C y vigencia de 5 años
        costo = cc.calcularCosto("C",5); 
        assertEquals(47+costoAdmin ,costo,0.02);
        assertEquals(12,cc.getCostoId());
        
        //Costo de una licencia clase D y vigencia de 1 años
        costo = cc.calcularCosto("D",1);
        System.out.println("Costo: "+costo);
        assertEquals(29+costoAdmin ,costo,0.02);
        assertEquals(13,cc.getCostoId());
        //Costo de una licencia clase D y vigencia de 3 años
        costo = cc.calcularCosto("D",3); 
        assertEquals(39+costoAdmin ,costo,0.02);
        assertEquals(14,cc.getCostoId());
        //Costo de una licencia clase D y vigencia de 4 años
        costo = cc.calcularCosto("D",4); 
        assertEquals(44+costoAdmin ,costo,0.02);
        assertEquals(15,cc.getCostoId());
        //Costo de una licencia clase D y vigencia de 5 años
        costo = cc.calcularCosto("D",5); 
        assertEquals(59+costoAdmin ,costo,0.02);
        assertEquals(16,cc.getCostoId());
        
        //Costo de una licencia clase E y vigencia de 1 años
        costo = cc.calcularCosto("E",1); 
        assertEquals(29+costoAdmin ,costo,0.02);
        assertEquals(17,cc.getCostoId());
        //Costo de una licencia clase E y vigencia de 3 años
        costo = cc.calcularCosto("E",3); 
        assertEquals(39+costoAdmin ,costo,0.02);
        assertEquals(18,cc.getCostoId());
        //Costo de una licencia clase E y vigencia de 4 años
        costo = cc.calcularCosto("E",4); 
        assertEquals(44+costoAdmin ,costo,0.02);
        assertEquals(19,cc.getCostoId());
        //Costo de una licencia clase E y vigencia de 5 años
        costo = cc.calcularCosto("E",5); 
        assertEquals(59+costoAdmin ,costo,0.02);
        assertEquals(20,cc.getCostoId());
        
        //Costo de una licencia clase F y vigencia de 1 años
        costo = cc.calcularCosto("F",1); 
        assertEquals(20+costoAdmin ,costo,0.02);
        assertEquals(21,cc.getCostoId());
        //Costo de una licencia clase F y vigencia de 3 años
        costo = cc.calcularCosto("F",3); 
        assertEquals(25+costoAdmin ,costo,0.02);
        assertEquals(22,cc.getCostoId());
        //Costo de una licencia clase F y vigencia de 4 años
        costo = cc.calcularCosto("F",4); 
        assertEquals(30+costoAdmin ,costo,0.02);
        assertEquals(23,cc.getCostoId());
        //Costo de una licencia clase F y vigencia de 5 años
        costo = cc.calcularCosto("F",5); 
        assertEquals(40+costoAdmin ,costo,0.02);
        assertEquals(24,cc.getCostoId());
        
        //Costo de una licencia clase G y vigencia de 1 años
        costo = cc.calcularCosto("G",1); 
        assertEquals(20+costoAdmin ,costo,0.02);
        assertEquals(25,cc.getCostoId());
        //Costo de una licencia clase G y vigencia de 3 años
        costo = cc.calcularCosto("G",3); 
        assertEquals(25+costoAdmin ,costo,0.02);
        assertEquals(26,cc.getCostoId());
        //Costo de una licencia clase G y vigencia de 4 años
        costo = cc.calcularCosto("G",4);         
        assertEquals(30+costoAdmin ,costo,0.02);
        assertEquals(27,cc.getCostoId());
        //Costo de una licencia clase G y vigencia de 5 años
        costo = cc.calcularCosto("G",5); 
        assertEquals(40+costoAdmin ,costo,0.02);
        assertEquals(28,cc.getCostoId());
    }
}
