/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Licencia;
import Persistencia.Persona;
import Persistencia.Vigencias;
import Presentacion.Cargando;
import Persistencia.Costos;
import Presentacion.IndexView;
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
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import lic_sf_bd.util;
import net.sf.jasperreports.engine.JREmptyDataSource;
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
    private final Map<String, Object> parametrosComprobanteDePago = new HashMap();
    private final float costoAdmin = 8;
    
    
    public ImprimirController() throws IOException{
        persona = null;
        lic = null;
    }
    
    public ImprimirController(Persona p, Licencia l) throws IOException{
        persona = p;
        lic = l;
        //Se pasan todos los datos de la persona y licencia necesarios para el reporte
        this.cargarParametros();
        cargarParametrosComprobante();
    }
    
    public ImprimirController(Persona p, Licencia l, List lista) throws IOException{
        persona = p;
        lic = l;
    }

     public ImprimirController(String tipoLicencia, int aniosVigencia, float costoAdmin){
        persona = null;
        lic = null;
        cargarParametrosComprobante();
    }
    
    private void cargarParametrosComprobante(){
        //Cargo los parametros del comprobante
        parametrosComprobanteDePago.put("costoAdm",costoAdmin);
        float cost = ((Costos)GenericDAO.read(new Costos(), lic.getCostoId())).getPrecio();
        parametrosComprobanteDePago.put("costo", cost);
        Vigencias vig = (Vigencias) GenericDAO.read(new Vigencias(), lic.getVigenciaId());
        parametrosComprobanteDePago.put("duracion", vig.getDuracion());
        parametrosComprobanteDePago.put("clase", lic.getClaseId());
        parametrosComprobanteDePago.put("nombre", persona.getNombre());
        parametrosComprobanteDePago.put("apellido", persona.getApellido());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        parametrosComprobanteDePago.put("fechanac", sdf.format(persona.getFechaNac()));
        parametrosComprobanteDePago.put("tipodoc", persona.getTipoId());
        parametrosComprobanteDePago.put("nrodoc", persona.getNroId());
        parametrosComprobanteDePago.put("dom", persona.getDomicilio());
        parametrosComprobanteDePago.put("numfactura", ThreadLocalRandom.current().nextInt(1, 99999 + 1));
        parametrosComprobanteDePago.put("costototal",costoAdmin+cost);
    }

    //Se pasan los datos de variables al reporte para ser impresos
    private void cargarParametros() throws IOException{
        parameters.put("nro_id",persona.getNroId());
        parameters.put("apellido",persona.getApellido());
        parameters.put("nombre",persona.getNombre());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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
        //Se obtiene la conexión establecida por Hibernate a la base de datos
        Session SS = util.getSessionFactory().openSession();
        SS.doWork(new Work(){
            @Override
            public void execute(Connection cnctn) throws SQLException {
                //Se carga el archivo a memoria a partir del recurso correspondiente en la carpeta del sistema
                InputStream archivo = this.getClass().getClassLoader().getResourceAsStream("Reporte/licencia.jasper");
                //Se arma el documento imprimible
                try{
                    JasperReport jr = (JasperReport) JRLoader.loadObject(archivo);
                    JasperPrint jp = JasperFillManager.fillReport(jr,parameters,cnctn);
                    //Se presenta una ventana con una vista previa del mismo
                    JasperViewer.viewReport(jp, false);
                    
                } catch (JRException ex) {
                    Logger.getLogger(ImprimirLicencia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }
    
    public void verComprobanteDePago(){        
        //Se carga el archivo a memoria a partir del recurso correspondiente en la carpeta del sistema
        InputStream archivo = this.getClass().getClassLoader().getResourceAsStream("Reporte/comprobantelicencia.jasper");
        //Se arma el documento imprimible
        try{
            JasperReport jr = (JasperReport) JRLoader.loadObject(archivo);
                                                           //conección a un data source vacío (no utilizo la bd)
            JasperPrint jp = JasperFillManager.fillReport(jr,parametrosComprobanteDePago,new JREmptyDataSource());
            //Se presenta una ventana con una vista previa del mismo
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(ImprimirLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargarFoto(){
        //Se abre una ventana interactiva para permitirle al usuario buscar el archivo correspondiente a la foto
        JFileChooser jfc = new JFileChooser();
        //Se limitan los formatos de archivo seleccionable
        jfc.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "jpeg"));
        jfc.showDialog(null,"Selecciona la foto");
        jfc.setVisible(true);
        File filename = jfc.getSelectedFile();
        //Se pasa el puntero del archivo al reporte
        try {
            parameters.put("image", ImageIO.read(filename));
        } catch (IOException ex) {
            Logger.getLogger(ImprimirLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void imprimirReporte() throws JRException{
        Session SS = util.getSessionFactory().openSession();
        //Se obtiene la conexión establecida por Hibernate a la base de datos
        SS.doWork(new Work(){
            @Override
            public void execute(Connection cnctn) throws SQLException {
                //Se busca el recurso correspondiente al reporte construido
                InputStream archivo = this.getClass().getClassLoader().getResourceAsStream("Reporte/licencia.jasper");
                JasperPrint jp = null;
                //Se carga el objeto JasperPrint que arma el documento a imprimir en base al recurso buscado anteriormente
                try{
                    JasperReport jr = (JasperReport) JRLoader.loadObject(archivo);
                    jp = JasperFillManager.fillReport(jr,parameters,cnctn);
                } catch (JRException ex) {
                    Logger.getLogger(ImprimirController.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    //Se imprime el reporte
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
    
    public Integer getDuracionLicencia(){
        Vigencias vig = (Vigencias) GenericDAO.read(new Vigencias(), lic.getVigenciaId());
        return vig.getDuracion();
    }
    
    public void imprimirComprobanteDePago(){
        //Se carga el archivo a memoria a partir del recurso correspondiente en la carpeta del sistema
        InputStream archivo = this.getClass().getClassLoader().getResourceAsStream("Reporte/comprobantelicencia.jasper");
        //Se arma el documento imprimible
        try{
            JasperReport jr = (JasperReport) JRLoader.loadObject(archivo);
            //conección a un data source vacío (no utilizo la bd)
            JasperPrint jp = JasperFillManager.fillReport(jr,parametrosComprobanteDePago,new JREmptyDataSource());
            //Se imprime el comprobante
            JasperPrintManager.printReport(jp, true);
            JOptionPane.showMessageDialog(null,"IMPRESIÓN CORRECTA"); 
        } catch (JRException ex) {
            Logger.getLogger(ImprimirLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                        Cargando load = new Cargando();
                        JasperPrintManager.printReport(jp, true); 
                        System.out.println("Despues del printReport");
                        load.dispose();                        
                        IndexView index = new IndexView(null);
                    } catch (JRException ex) {
                        JOptionPane.showMessageDialog(null,"Impresión cancelada"); 
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
                        Cargando load = new Cargando();
                        JasperPrintManager.printReport(jp, true); 
                        System.out.println("Despues del printReport");
                        load.dispose();                        
                        IndexView index = new IndexView(null);
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
                        Cargando load = new Cargando();
                        JasperPrintManager.printReport(jp, true); 
                        JOptionPane.showMessageDialog(null,"Impresión correcta");
                        load.dispose();                        
                        IndexView index = new IndexView(null);  
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
                        Cargando load = new Cargando();
                        JasperPrintManager.printReport(jp, true);
                        JOptionPane.showMessageDialog(null,"Impresión correcta");
                        load.dispose();                        
                        IndexView index = new IndexView(null); 
                    } catch (JRException ex) {
                        Logger.getLogger(ImprimirController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });           
    } 
    
}
