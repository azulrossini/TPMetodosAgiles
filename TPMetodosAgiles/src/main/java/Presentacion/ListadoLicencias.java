/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.*;
import Logica.PersonaController;
import Persistencia.Licencia;
import Persistencia.Persona;
import Persistencia.Usuario;
import Persistencia.Vigencias;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;



import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author JIC
 */
public class ListadoLicencias extends javax.swing.JFrame {

    LicenciaController lController = new LicenciaController();
    PersonaController PersonaC;
    
    private ImprimirController ic;
    private TableRowSorter trsFiltro;
    //FLAG PARA MANEJAR SI SON TODAS O POR RANGO
    private boolean flagTodas;
    //FLAG PARA MANEJAR SI SON VIGENTES O EXPIRADAS
    private boolean flagTipo;
    private final Usuario user;    
    String fecha1, fecha2;
    private Point mouseDownCompCoords = null;
    
    public ListadoLicencias(boolean tipo, String fechaDesde, String fechaHasta, Usuario user) throws ParseException {
        initComponents();
        //SETEO DEL ICONO
        setIconImage(new ImageIcon(getClass().getResource("/favicon.png")).getImage());
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        Index.historial.add(this);
        
        
        flagTodas = false;
        flagTipo = tipo;        
        
        this.user = user;
        
        //CARGO TODAS LAS LICENCIAS DENTRO DEL RANGO
        getLicenciasRango(fechaDesde, fechaHasta);        
    }
    
    public ListadoLicencias(boolean tipo, Usuario user) throws ParseException {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/favicon.png")).getImage());
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        Index.historial.add(this);
        
        flagTodas = true;
        flagTipo = tipo;
        
        this.user = user;
        
        //CARGO TODAS LAS LICENCIAS
        getLicencias();        
    }
    
    //MÉTODO QUE TRAE LAS LICENCIAS DETERMINANDO UN RANGO Y SI SE QUIERE
    //LAS EXPIRADAS O LAS VIGENTES
    private void getLicenciasRango(String fechaDesde, String fechaHasta) throws ParseException{       
        
        //INSTANCIO EL CONTROLADOR
        LicenciaController lController = new LicenciaController();
        
        //FORMATEO LA FECHA PARA UNA MEJOR VISUALIZACIÓN
        SimpleDateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDesde = sourceFormat.parse(fechaDesde);
        Date dateHasta = sourceFormat.parse(fechaHasta);
        fecha1 = targetFormat.format(dateDesde);
        fecha2 = targetFormat.format(dateHasta);
        
        List<Licencia> listaLicencia;
        VigenciaController vigenciaController = new VigenciaController();
        
        //TRAIGO TODAS LAS LICENCIAS DEPENDIENDO SI SON VIGENTES O EXPIRADAS
        if(flagTipo){
            listaLicencia = lController.getLicenciasRangoVigentes(fecha1, fecha2); 
        }else{
            listaLicencia = lController.getLicenciasRangoExpiradas(fecha1, fecha2); 
        }
        
        //SI NO EXISTEN LICENCIAS, MUESTRO UN JOPTIONPANE
        if(listaLicencia.isEmpty()){
            
            JOptionPane.showMessageDialog(null,"No hay licencias para mostrar que cumplan con los criterios");
            Index.historial.get(Index.historial.size()-2).setVisible(true);
            this.dispose();
            Index.historial.remove(Index.historial.size()-1);
        
        //SI EXISTEN, CARGO LA JTABLE
        }else{
            
            DefaultTableModel dtm = (DefaultTableModel) this.tabla.getModel();
            dtm.setRowCount(0);
        
            for (int i=0; i<listaLicencia.size(); i++){
                Object datos[] = new Object[8];                              
                
                Persona persona = lController.getPersona(listaLicencia.get(i).getPersonaId());
                Licencia licencia = listaLicencia.get(i);
                Vigencias vigencia = vigenciaController.getVigencia(licencia.getMotivo(), persona.getFechaNac());
                
                datos[0] = licencia.getId(); //ID
                datos[1] = licencia.getClaseId(); //ClaseID
                datos[2] = parseoFechaVigencia(licencia.getFechaVenc()); //CALCULO LA VIGENCIA
                //datos[2] = parseoFechaVigencia(lController.getFechaVigencia(vigencia, persona.getFechaNac())); //CALCULO LA VIGENCIA
                datos[3] = persona.getApellido(); //Apellido
                datos[4] = persona.getNombre(); //Nombre
                datos[5] = persona.getGrupoSanguineo(); //GrupoSanguineo
                datos[6] = persona.getFactor();
                datos[7] = this.isDonante(persona); //SI O NO
                
                dtm.addRow(datos);
            }
            
        } 
        
    }
    
    //MÉTODO QUE TRAE TODAS LAS LICENCIAS Y SI SE QUIERE
    //LAS EXPIRADAS O LAS VIGENTES
    private void getLicencias() throws ParseException{   
        
        List<Licencia> listaLicencia;
        VigenciaController vigenciaController = new VigenciaController();
        
        //TRAIGO TODAS LAS LICENCIAS DEPENDIENDO SI SON VIGENTES O EXPIRADAS
        if(flagTipo){
            listaLicencia = lController.getLicenciasVigentes(); 
        }else{
            listaLicencia = lController.getLicenciasExpiradas(); 
        }        
        
        if(listaLicencia.isEmpty()){
            
            JOptionPane.showMessageDialog(null,"No hay licencias para mostrar que cumplan con los criterios");
            Index.historial.get(Index.historial.size()-2).setVisible(true);
            this.dispose();
            Index.historial.remove(Index.historial.size()-1);
            
        }else{
            
            DefaultTableModel dtm = (DefaultTableModel) this.tabla.getModel();
            dtm.setRowCount(0);
        
            for (int i=0; i<listaLicencia.size(); i++){
                Object datos[] = new Object[8];                              
                
                Persona persona = lController.getPersona(listaLicencia.get(i).getPersonaId());
                Licencia licencia = listaLicencia.get(i);
                Vigencias vigencia = vigenciaController.getVigencia(licencia.getMotivo(), persona.getFechaNac());
                
                datos[0] = licencia.getId(); //ID
                datos[1] = licencia.getClaseId(); //ClaseID
                //datos[2] = parseoFechaVigencia(lController.getFechaVigencia(vigencia, persona.getFechaNac())); //CALCULO LA VIGENCIA
                datos[2] = parseoFechaVigencia(licencia.getFechaVenc()); //CALCULO LA VIGENCIA
                datos[3] = persona.getApellido(); //Apellido
                datos[4] = persona.getNombre(); //Nombre
                datos[5] = persona.getGrupoSanguineo(); //GrupoSanguineo
                datos[6] = persona.getFactor(); //Factor
                datos[7] = this.isDonante(persona); //SI O NO
                
                dtm.addRow(datos);
            }
            
        } 
    }
    
    //CAMBIO EL FORMATO DE LA FECHA
    //PARA MEJOR VISUALIZACIÓN
    public String parseoFechaVigencia(Date fechaVigencia){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(fechaVigencia); 
        return fecha;
    }
    
    //MÉTODO PARA CAMBIAR TRUE O FALSE A "SI" O "NO"
    public String isDonante(Persona persona){
        
        if(persona.isDonante()){
            return "SI";
        }
        else{
            return "NO";
        }
        
    }
    
    //MÉTODO PARA EL FILTRO PARA LA BUSQUEDA
    public void filtro() {
        
        trsFiltro.setRowFilter(RowFilter.regexFilter(tFiltro.getText(), jComboFiltro.getSelectedIndex()+3));
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        print = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tFiltro = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jComboFiltro = new javax.swing.JComboBox<>();
        exit = new javax.swing.JButton();
        minimize = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(206, 206, 206));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true)));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        jLabel1.setText("Filtros");

        print.setBackground(new java.awt.Color(204, 204, 204));
        print.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        print.setText("IMPRIMIR");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 36)); // NOI18N
        jLabel2.setText("Listado de licencias");

        tFiltro.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        tFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tFiltroKeyTyped(evt);
            }
        });

        jComboFiltro.setBackground(new java.awt.Color(204, 204, 204));
        jComboFiltro.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jComboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Apellido", "Nombre", "Grupo", "Factor", "Donante" }));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cancel.png"))); // NOI18N
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cancel rollover.png"))); // NOI18N
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/diminish.png"))); // NOI18N
        minimize.setBorderPainted(false);
        minimize.setContentAreaFilled(false);
        minimize.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/diminish rollover.png"))); // NOI18N
        minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeActionPerformed(evt);
            }
        });

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/left-arrow.png"))); // NOI18N
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/left-arrow rollover.png"))); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        tabla.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Licencia", "Clase", "Vigencia", "Apellido", "Nombre", "Grupo Sanguineo", "Factor", "Donante"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(tabla);

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Imprimir listado sin filtros aplicados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 365, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //EVENTO DEL BOTÓN "IMPRIMIR"
    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        //VERIFICO QUE TIPO DE LICENCIA Y SI SON TODAS O RANGO
        //TAMBIEN SI SON EXPIRADAS O VIGENTES
        
        Index.historial.get(Index.historial.size()-2).setVisible(true);
        this.dispose();
        Index.historial.remove(Index.historial.size()-1);
        
        try {
            if(flagTodas){
                if(flagTipo){                
                    lController.imprimirTodasVigentes();                
                }else{
                    lController.imprimirTodasExpiradas();
                }
            }else{
                if(flagTipo){
                    lController.imprimirRangoVigentes(fecha1, fecha2);
                }else{
                    lController.imprimirRangoExpiradas(fecha1, fecha2);
                }        
            }
        }catch (Exception ex) {
                    Logger.getLogger(ListadoLicencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printActionPerformed

    //MÉTODO QUE CAPTURA EL EVENTO CUANDO PRESIONO UNA TECLA
    //PARA ACTUALIZAR EL FILTRO DEL BUSCADOR
    private void tFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tFiltroKeyTyped
        tFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = (tFiltro.getText().toUpperCase());
                tFiltro.setText(cadena);
                repaint();
                filtro();
            }
        });
        trsFiltro = new TableRowSorter(tabla.getModel());
        tabla.setRowSorter(trsFiltro);
    }//GEN-LAST:event_tFiltroKeyTyped

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minimizeActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Index.historial.get(Index.historial.size()-2).setVisible(true);
        this.dispose();
        Index.historial.remove(Index.historial.size()-1);
    }//GEN-LAST:event_backActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        mouseDownCompCoords = evt.getPoint();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        mouseDownCompCoords = null;
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        Point currCoords = evt.getLocationOnScreen();
        this.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }//GEN-LAST:event_jPanel1MouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton exit;
    private javax.swing.JComboBox<String> jComboFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton minimize;
    private javax.swing.JButton print;
    private javax.swing.JTextField tFiltro;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
