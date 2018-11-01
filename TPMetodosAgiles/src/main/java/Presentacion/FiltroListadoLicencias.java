/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JIC
 */
public class FiltroListadoLicencias extends javax.swing.JFrame {

    private PersonaController personaController;
    private LicenciaController licenciaController;

    
    public FiltroListadoLicencias() {
        initComponents();
        jPanel1.setVisible(false);        
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        close = new javax.swing.JButton();
        minimize = new javax.swing.JButton();
        back = new javax.swing.JButton();
        todas = new javax.swing.JButton();
        rango = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        back1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        minimize1 = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        rango1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        close2 = new javax.swing.JButton();
        fechaDesde = new javax.swing.JFormattedTextField();
        fechaHasta = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(206, 206, 206));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true), new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true)));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cancel.png"))); // NOI18N
        close.setBorderPainted(false);
        close.setContentAreaFilled(false);
        close.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cancel rollover.png"))); // NOI18N
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
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

        todas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/completed.png"))); // NOI18N
        todas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        todas.setContentAreaFilled(false);
        todas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todasActionPerformed(evt);
            }
        });

        rango.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/calendar.png"))); // NOI18N
        rango.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        rango.setContentAreaFilled(false);
        rango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rangoActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Caviar Dreams", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Todas");

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Elija un critero por la cuál mostrar el listado:");

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Caviar Dreams", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Por rango");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rango, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(85, 85, 85)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(todas, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(rango, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(todas, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(206, 206, 206));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true), new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true)));

        back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/left-arrow.png"))); // NOI18N
        back1.setBorderPainted(false);
        back1.setContentAreaFilled(false);
        back1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/left-arrow rollover.png"))); // NOI18N
        back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back1ActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Ingrese el rango de fechas:");

        minimize1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/diminish.png"))); // NOI18N
        minimize1.setBorderPainted(false);
        minimize1.setContentAreaFilled(false);
        minimize1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/diminish rollover.png"))); // NOI18N
        minimize1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimize1ActionPerformed(evt);
            }
        });

        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Flecha derecha.png"))); // NOI18N
        siguiente.setBorderPainted(false);
        siguiente.setContentAreaFilled(false);
        siguiente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Flecha derecha rollover.png"))); // NOI18N
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        rango1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/calendar.png"))); // NOI18N
        rango1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        rango1.setContentAreaFilled(false);
        rango1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rango1ActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Caviar Dreams", 1, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Formato: dd/MM/aaaa");

        jLabel11.setBackground(new java.awt.Color(51, 51, 51));
        jLabel11.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Desde: ");

        close2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cancel.png"))); // NOI18N
        close2.setBorderPainted(false);
        close2.setContentAreaFilled(false);
        close2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cancel rollover.png"))); // NOI18N
        close2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close2ActionPerformed(evt);
            }
        });

        fechaDesde.setBackground(new java.awt.Color(206, 206, 206));
        fechaDesde.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        fechaDesde.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N

        fechaHasta.setBackground(new java.awt.Color(206, 206, 206));
        fechaHasta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        fechaHasta.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Hasta: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(back1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minimize1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(close2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(rango1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel10)))
                            .addComponent(jLabel9)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(30, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(minimize1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(close2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(rango1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minimizeActionPerformed

    private void todasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todasActionPerformed
        try {
            ListadoLicencias LL = new ListadoLicencias();
        } catch (ParseException ex) {
            Logger.getLogger(FiltroListadoLicencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_todasActionPerformed

    private void rangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rangoActionPerformed
        jPanel4.setVisible(false);
        jPanel1.setVisible(true);
    }//GEN-LAST:event_rangoActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        IndexView indexView = new IndexView();
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back1ActionPerformed
        jPanel1.setVisible(false);
        jPanel4.setVisible(true);
    }//GEN-LAST:event_back1ActionPerformed

    private void minimize1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimize1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minimize1ActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        try {
            ListadoLicencias LL = new ListadoLicencias(fechaDesde.getText(), fechaHasta.getText());
        } catch (ParseException ex) {
            Logger.getLogger(FiltroListadoLicencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_siguienteActionPerformed

    private void rango1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rango1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rango1ActionPerformed

    private void close2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_close2ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton back1;
    private javax.swing.JButton close;
    private javax.swing.JButton close2;
    private javax.swing.JFormattedTextField fechaDesde;
    private javax.swing.JFormattedTextField fechaHasta;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonGuardar1;
    private javax.swing.JButton jButtonGuardar2;
    private javax.swing.JButton jButtonGuardar3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton minimize;
    private javax.swing.JButton minimize1;
    private javax.swing.JButton rango;
    private javax.swing.JButton rango1;
    private javax.swing.JButton siguiente;
    private javax.swing.JButton todas;
    // End of variables declaration//GEN-END:variables
}