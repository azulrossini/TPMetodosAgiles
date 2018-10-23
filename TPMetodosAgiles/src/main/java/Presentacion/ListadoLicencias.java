/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.LicenciaController;
import Logica.PersonaController;
import Persistencia.Licencia;
import Persistencia.Persona;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



import static java.util.Collections.list;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author JIC
 */
public class ListadoLicencias extends javax.swing.JFrame {

    LicenciaController lController = new LicenciaController();
    PersonaController PersonaC;
    
    private TableRowSorter trsFiltro;
    
    public ListadoLicencias() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        //CONFIGURO EL ANCHO DE LAS COLUMNAS
        tabla.getColumnModel().getColumn(0).setPreferredWidth(27);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(5);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(5);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(10);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(10);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        //CARGO LAS LICENCIAS
        getLicencias();
        
    }

    private void getLicencias(){   
        List<Licencia> listaLicencia = lController.getLicencias();
        LicenciaController licenciaController = new LicenciaController();
        
        if(listaLicencia.isEmpty()){
            
            JOptionPane.showMessageDialog(null,"No hay licencias para mostrar");
            
        }else{
            
            DefaultTableModel dtm = (DefaultTableModel) this.tabla.getModel();
            dtm.setRowCount(0);
        
            for (int i=0; i<listaLicencia.size(); i++){
                Object datos[] = new Object[7];
                
                
                Persona persona = licenciaController.getPersona(listaLicencia.get(i).getPersonaId());
                Licencia licencia = listaLicencia.get(i);
                
                datos[0] = licencia.getId();
                datos[1] = licencia.getClaseId();
//                datos[2] = licenciaController.getVigencia(licencia); //CALCULO LA VIGENCIA
                datos[3] = persona.getApellido(); //Apellido
                datos[4] = persona.getNombre(); //Nombre
                datos[5] = persona.getGrupoSanguineo(); //GrupoSanguineo
                datos[6] = this.isDonante(persona);
                
                dtm.addRow(datos);
            }
            
        } 
    }
    
    public String isDonante(Persona persona){
        
        if(persona.isDonante()){
            return "SI";
        }
        else{
            return "NO";
        }
        
    }
    
    public void filtro() {
        
        trsFiltro.setRowFilter(RowFilter.regexFilter(tFiltro.getText(), jComboFiltro.getSelectedIndex()+3));
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        print = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tFiltro = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jComboFiltro = new javax.swing.JComboBox<>();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true)));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        jLabel1.setText("Filtros");

        tabla.setBackground(new java.awt.Color(102, 102, 102));
        tabla.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Licencia", "Clase", "Vigencia", "Apellido", "Nombre", "Grupo +/-", "Donante"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabla.setIntercellSpacing(new java.awt.Dimension(4, 4));
        jScrollPane1.setViewportView(tabla);

        print.setBackground(new java.awt.Color(102, 102, 102));
        print.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 11)); // NOI18N
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

        jComboFiltro.setBackground(new java.awt.Color(102, 102, 102));
        jComboFiltro.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jComboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Apellido", "Nombre", "Grupo", "Donante" }));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cancel.png"))); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cancel rollover.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/diminish.png"))); // NOI18N
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/diminish rollover.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/left-arrow.png"))); // NOI18N
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/left-arrow rollover.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(print))
                    .addComponent(jSeparator3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 365, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_printActionPerformed

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

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        IndexView indexView = new IndexView();
        this.dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListadoLicencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoLicencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoLicencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoLicencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoLicencias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JComboBox<String> jComboFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton print;
    private javax.swing.JTextField tFiltro;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
