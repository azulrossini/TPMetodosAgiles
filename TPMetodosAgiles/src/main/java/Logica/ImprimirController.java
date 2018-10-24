/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Licencia;
import Persistencia.Persona;
import Presentacion.ImprimirLicencia;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import lic_sf_bd.util;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

/**
 *
 * @author Fausto
 */
public class ImprimirController {
    
    private final Persona persona;
    private final Licencia lic;
    private final Map<String, Object> parameters = new HashMap();
    
    public ImprimirController(Persona p, Licencia l){
        persona = p;
        lic = l;
        this.cargarParametros();
    }

    private void cargarParametros(){
        parameters.put("nro_id",persona.getNroId());
        parameters.put("apellido",persona.getApellido());
        parameters.put("nombre",persona.getNombre());
        parameters.put("fecha_nacimiento",persona.getFechaNac());
        parameters.put("domicilio",persona.getDomicilio());
        parameters.put("grupo_sanguineo",persona.getGrupoSanguineo());
        parameters.put("factor",persona.getFactor());
        parameters.put("clase",lic.getClaseId());
        parameters.put("observaciones",lic.getObservaciones());
        parameters.put("fecha_venc",lic.getFechaVenc());
        if (persona.getDonante())
            parameters.put("donante", "Sí");
        else
            parameters.put("donante", "No");
    }
    
    public void verReporte(){
        Session SS = util.getSessionFactory().openSession();
        SS.doWork(new Work(){
            @Override
            public void execute(Connection cnctn) throws SQLException {
                InputStream archivo = this.getClass().getClassLoader().getResourceAsStream("Reporte/licencia.jasper");
                try{
                    JasperReport jr = (JasperReport) JRLoader.loadObject(archivo);
                    JasperPrint jp = JasperFillManager.fillReport(jr,parameters,cnctn);
                    JasperViewer.viewReport(jp, false);
                    
                } catch (JRException ex) {
                    Logger.getLogger(ImprimirLicencia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }
    
    public void cargarFoto(){
        JFileChooser jfc = new JFileChooser();
        jfc.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "jpeg"));
        jfc.showDialog(null,"Selecciona la foto");
        jfc.setVisible(true);
        File filename = jfc.getSelectedFile();
        try {
            parameters.put("image", ImageIO.read(filename));
        } catch (IOException ex) {
            Logger.getLogger(ImprimirLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void imprimirReporte() throws JRException{
        Session SS = util.getSessionFactory().openSession();
        SS.doWork(new Work(){
            @Override
            public void execute(Connection cnctn) throws SQLException {
                InputStream archivo = this.getClass().getClassLoader().getResourceAsStream("Reporte/licencia.jasper");
                JasperPrint jp = null;
                try{
                    JasperReport jr = (JasperReport) JRLoader.loadObject(archivo);
                    jp = JasperFillManager.fillReport(jr,parameters,cnctn);
                } catch (JRException ex) {
                    Logger.getLogger(ImprimirController.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    try {
                        JasperPrintManager.printReport(jp, true);
                    } catch (JRException ex) {
                        Logger.getLogger(ImprimirController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
}
