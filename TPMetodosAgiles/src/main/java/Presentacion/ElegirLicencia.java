
package Presentacion;

import Logica.*;
import Persistencia.*;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class ElegirLicencia extends javax.swing.JFrame {
    private final Persona titular;
    private final PersonaController personaController;
    private final LicenciaController licenciaController;
    private final Usuario usuario;
    private Point mouseDownCompCoords = null;
    private List<Licencia> licencias;

    public ElegirLicencia(Persona tit, PersonaController p, LicenciaController l, Usuario u) {
        this.titular = tit;
        this.personaController = p;
        this.licenciaController = l;
        this.usuario = u;
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/favicon.png")).getImage());
        cargarTabla();
        Index.historial.add(this);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabelRegistroDeTitular = new javax.swing.JLabel();
        jButtonDuplicar = new javax.swing.JButton();
        jButtonRenovar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(206, 206, 206));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true), new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true)));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel4MouseDragged(evt);
            }
        });
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel4MouseReleased(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(51, 51, 51));
        jLabel14.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 30)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/loupe.png"))); // NOI18N
        jLabel14.setText(" ");

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cancel.png"))); // NOI18N
        jButton16.setBorderPainted(false);
        jButton16.setContentAreaFilled(false);
        jButton16.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cancel rollover.png"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/diminish.png"))); // NOI18N
        jButton17.setBorderPainted(false);
        jButton17.setContentAreaFilled(false);
        jButton17.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/diminish rollover.png"))); // NOI18N
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/left-arrow.png"))); // NOI18N
        jButton18.setBorderPainted(false);
        jButton18.setContentAreaFilled(false);
        jButton18.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/left-arrow rollover.png"))); // NOI18N
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Seleccione la licencia del titular que desea renovar o duplicar");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Tipo de licencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabelRegistroDeTitular.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 36)); // NOI18N
        jLabelRegistroDeTitular.setForeground(new java.awt.Color(51, 51, 51));
        jLabelRegistroDeTitular.setText("Buscar Licencia");

        jButtonDuplicar.setBackground(new java.awt.Color(230, 230, 230));
        jButtonDuplicar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 11)); // NOI18N
        jButtonDuplicar.setForeground(new java.awt.Color(51, 51, 51));
        jButtonDuplicar.setText("Duplicar");
        jButtonDuplicar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jButtonDuplicar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonDuplicarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonDuplicarMouseExited(evt);
            }
        });
        jButtonDuplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDuplicarActionPerformed(evt);
            }
        });

        jButtonRenovar.setBackground(new java.awt.Color(230, 230, 230));
        jButtonRenovar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 11)); // NOI18N
        jButtonRenovar.setForeground(new java.awt.Color(51, 51, 51));
        jButtonRenovar.setText("Renovar");
        jButtonRenovar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jButtonRenovar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonRenovarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonRenovarMouseExited(evt);
            }
        });
        jButtonRenovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRenovarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jButtonDuplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonRenovar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(133, 133, 133)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabelRegistroDeTitular)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRegistroDeTitular)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDuplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRenovar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        Index.historial.get(Index.historial.size()-2).setVisible(true);
        this.dispose();
        Index.historial.remove(Index.historial.size()-1);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        Point currCoords = evt.getLocationOnScreen();
        this.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }//GEN-LAST:event_jPanel4MouseDragged

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        mouseDownCompCoords = evt.getPoint();
    }//GEN-LAST:event_jPanel4MousePressed

    private void jPanel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseReleased
        mouseDownCompCoords = null;
    }//GEN-LAST:event_jPanel4MouseReleased

    private void jButtonDuplicarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDuplicarMouseEntered
        this.jButtonDuplicar.setBackground(this.jButtonDuplicar.getBackground().darker());
    }//GEN-LAST:event_jButtonDuplicarMouseEntered

    private void jButtonDuplicarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDuplicarMouseExited
        this.jButtonDuplicar.setBackground(this.jButtonDuplicar.getBackground().brighter());
    }//GEN-LAST:event_jButtonDuplicarMouseExited

    private void jButtonDuplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDuplicarActionPerformed
        ImprimirLicencia il;
        Licencia licencia = licencias.get(tabla.getSelectedRow());
        this.licenciaController.guardarDuplicado(licencia);
                try {
                    il = new ImprimirLicencia(titular, licencia);
                    il.setVisible(true);
                    this.setEnabled(false);
                    ElegirLicencia este = this;
                    il.addWindowListener(new WindowAdapter(){
                        @Override
                        public void windowClosed(WindowEvent we) {
                            este.setEnabled(true);
                            este.setAlwaysOnTop(false);
                        }
                    });
                } catch (IOException ex) {
                    Logger.getLogger(EmitirLicencia.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_jButtonDuplicarActionPerformed

    private void jButtonRenovarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRenovarMouseEntered
        this.jButtonRenovar.setBackground(this.jButtonRenovar.getBackground().darker());
    }//GEN-LAST:event_jButtonRenovarMouseEntered

    private void jButtonRenovarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRenovarMouseExited
        this.jButtonRenovar.setBackground(this.jButtonRenovar.getBackground().brighter());
    }//GEN-LAST:event_jButtonRenovarMouseExited

    private void jButtonRenovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRenovarActionPerformed
        RenovarLicencia rl = new RenovarLicencia(licencias.get(tabla.getSelectedRow()), titular, personaController, licenciaController, usuario);
        rl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonRenovarActionPerformed
    
    private void cargarTabla(){
        //Setea la tabla con los valores de las liencias de los titulares obtenidos
        DefaultTableModel dtm = (DefaultTableModel) this.tabla.getModel();
        dtm.setRowCount(0);   
        licencias = licenciaController.getLicencias();
        List<Licencia> aux = new ArrayList<>();
        for(Licencia l : licencias){
            if(titular.getId()==l.getPersonaId()){
                if(l.getFechaVenc().after(new Date())){
                    aux.add(l);
                }
                
            } //Considero solo las licencias del titular seleccionado
        }
        verificarVigencias();
        for(int i = 0; i<aux.size(); i++){
            String datos[] = new String[3];                 
                /*datos[0] = String.valueOf(personaController.getPersona(licencias.get(i).getPersonaId()));
                datos[1] = String.valueOf(licencias.get(i).getFechaEmision());
                datos[2] = String.valueOf(licencias.get(i).getFechaVenc());*/
                datos[0] = personaController.getPersona(aux.get(i).getPersonaId()).getNombre();
                datos[1] = personaController.getPersona(aux.get(i).getPersonaId()).getApellido();
                datos[2]= aux.get(i).getClaseId();
                

                dtm.addRow(datos);
        }  
    }
    
    private void verificarVigencias(){
        Date hoy = new Date();
        for(int i=0; i<licencias.size(); i++){
            if(licencias.get(i).getFechaVenc().before(hoy)){
                licencias.remove(i);
            } 
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButtonDuplicar;
    private javax.swing.JButton jButtonRenovar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabelRegistroDeTitular;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
