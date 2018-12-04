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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
    private final Map<String, Object> parametersListado = new HashMap();
    private List listado;
    
    public ImprimirController() throws IOException{
        persona = null;
        lic = null;
    }
    
    public ImprimirController(Persona p, Licencia l) throws IOException{
        persona = p;
        lic = l;
        this.cargarParametros();
    }
    
    public ImprimirController(Persona p, Licencia l, List lista) throws IOException{
        persona = p;
        lic = l;
    }

    private void cargarParametros() throws IOException{
        parameters.put("nro_id",persona.getNroId());
        parameters.put("apellido",persona.getApellido());
        parameters.put("nombre",persona.getNombre());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(sdf.format(persona.getFechaNac()));
        parameters.put("fecha_nacimiento",sdf.format(persona.getFechaNac()));
        parameters.put("domicilio",persona.getDomicilio());
        parameters.put("grupo_sanguineo",persona.getGrupoSanguineo());
        parameters.put("factor",persona.getFactor());
        parameters.put("clase",lic.getClaseId());
        parameters.put("observaciones",lic.getObservaciones());
        parameters.put("fecha_venc",sdf.format(lic.getFechaVenc()));
        if (persona.isDonante())
            parameters.put("donante", "Sí");
        else
            parameters.put("donante", "No");
        parameters.put("bordeArriba", ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("Presentacion/bordeArriba.png")));
        parameters.put("bordeAbajo", ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("Presentacion/bordeAbajo.png")));
    }
    
    private void cargarParametrosListado(String fecha1, String fecha2) throws IOException, ParseException{
        
        //ARMO LOS STRING PARA LA CONSULTA        
        String fechaDesdeFormat = "'" + fecha1 + "'";
        String fechaHastaFormat = "'" + fecha2 + "'";
        
        //PASO LOS PARAMETROS PARA LUEGO USARLO EN JASPERREPORT
        parametersListado.put("fecha_desde", fechaDesdeFormat);
        parametersListado.put("fecha_hasta", fechaHastaFormat);      
        
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
    
    //MÉTODOS PARA LA IMPRESIÓN DE REPORTES
    
    //REPORTE DE TODAS LAS LICENCIAS VIGENTES
    public void imprimirListadoVigentes() throws JRException, IOException, IOException, ParseException{
        
        Session SS = util.getSessionFactory().openSession();
        SS.doWork(new Work(){
            @Override
            public void execute(Connection cnctn) throws SQLException {
                InputStream archivo = this.getClass().getClassLoader().getResourceAsStream("Reporte/ListadoVigentes.jasper");
                JasperPrint jp = null;
                try{
                    JasperReport jr = (JasperReport) JRLoader.loadObject(archivo);
                    jp = JasperFillManager.fillReport(jr, null,cnctn);
                } catch (JRException ex) {
                    Logger.getLogger(ImprimirController.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    try {
                        JasperPrintManager.printReport(jp, true); 
                        //MUESTRO UN MENSAJE LUEGO DE QUE SE GENERÓ EL PDF
                        JOptionPane.showMessageDialog(null,"IMPRESIÓN CORRECTA");   
                    } catch (JRException ex) {
                        Logger.getLogger(ImprimirController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
   //REPORTE DE TODAS LAS LICENCIAS EXPIRADAS
    public void imprimirListadoExpiradas() throws JRException, IOException, IOException, ParseException{
        
        Session SS = util.getSessionFactory().openSession();
        SS.doWork(new Work(){
            @Override
            public void execute(Connection cnctn) throws SQLException {
                InputStream archivo = this.getClass().getClassLoader().getResourceAsStream("Reporte/ListadoExpiradas.jasper");
                JasperPrint jp = null;
                try{
                    JasperReport jr = (JasperReport) JRLoader.loadObject(archivo);
                    jp = JasperFillManager.fillReport(jr, null,cnctn);
                } catch (JRException ex) {
                    Logger.getLogger(ImprimirController.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    try {
                        JasperPrintManager.printReport(jp, true);                        
                        JOptionPane.showMessageDialog(null,"IMPRESIÓN CORRECTA");   
                    } catch (JRException ex) {
                        Logger.getLogger(ImprimirController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
    //REPORTE DE TODAS LAS LICENCIAS VIGENTES DENTRO DE UN RANGO    
    public void imprimirRangoVigentes(String fechaDesde, String fechaHasta) throws JRException, IOException, ParseException{
       
        this.cargarParametrosListado(fechaDesde, fechaHasta);        
        
        Session SS = util.getSessionFactory().openSession();
        SS.doWork(new Work(){
            @Override
            public void execute(Connection cnctn) throws SQLException {
                InputStream archivo = this.getClass().getClassLoader().getResourceAsStream("Reporte/ListadoRangoVigentes.jasper");
                JasperPrint jp = null;
                try{
                    JasperReport jr = (JasperReport) JRLoader.loadObject(archivo);
                    jp = JasperFillManager.fillReport(jr,parametersListado,cnctn);
                } catch (JRException ex) {
                    Logger.getLogger(ImprimirController.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    try {
                        JasperPrintManager.printReport(jp, true);                        
                        JOptionPane.showMessageDialog(null,"IMPRESIÓN CORRECTA");   
                    } catch (JRException ex) {
                        Logger.getLogger(ImprimirController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });           
    }    
    
    //REPORTE DE TODAS LAS LICENCIAS EXPIRADAS DENTRO DE UN RANGO
    public void imprimirRangoExpiradas(String fechaDesde, String fechaHasta) throws JRException, IOException, ParseException{

        this.cargarParametrosListado(fechaDesde, fechaHasta);        

        Session SS = util.getSessionFactory().openSession();
        SS.doWork(new Work(){
            @Override
            public void execute(Connection cnctn) throws SQLException {
                InputStream archivo = this.getClass().getClassLoader().getResourceAsStream("Reporte/ListadoRangoExpiradas.jasper");
                JasperPrint jp = null;
                try{
                    JasperReport jr = (JasperReport) JRLoader.loadObject(archivo);
                    jp = JasperFillManager.fillReport(jr,parametersListado,cnctn);
                } catch (JRException ex) {
                    Logger.getLogger(ImprimirController.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    try {
                        JasperPrintManager.printReport(jp, true);                        
                        JOptionPane.showMessageDialog(null,"IMPRESIÓN CORRECTA");   
                    } catch (JRException ex) {
                        Logger.getLogger(ImprimirController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });           
    } 
    
}
