/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.LicenciaController;
import Logica.LicenciaController.Motivo;
import Logica.PersonaController;
import Persistencia.*;
import java.awt.Point;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmitirLicencia extends javax.swing.JFrame {

    private Point mouseDownCompCoords = null;
    private Persona titular;
    private PersonaController personaController;
    private LicenciaController licenciaController;
    
    public EmitirLicencia() {
        initComponents();
    }
    
    public EmitirLicencia(Persona tit, PersonaController p, LicenciaController l){
        this.titular = tit;
        this.personaController = p;
        this.licenciaController = l;
        initComponents();
        completarDatosTitular();
        setearEdad();
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboClase = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaDatosTitular = new javax.swing.JTextArea();
        labelEdad = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabelRegistroDeTitular = new javax.swing.JLabel();
        observaciones = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jLabel1.setText("Ingrese el DNI el titular para el que desea emitir una licencia");

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
        jLabel14.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/id-card grande.png"))); // NOI18N

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

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Datos del titular:");

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Observaciones:");

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Clase:");

        comboClase.setBackground(new java.awt.Color(178, 176, 176));
        comboClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clase A", "Clase B", "Clase C", "Clase D", "Clase E", "Clase F", "Clase G" }));

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Edad:");

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Primera vez:");

        areaDatosTitular.setEditable(false);
        areaDatosTitular.setBackground(new java.awt.Color(206, 206, 206));
        areaDatosTitular.setColumns(20);
        areaDatosTitular.setForeground(new java.awt.Color(51, 51, 51));
        areaDatosTitular.setRows(5);
        areaDatosTitular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jScrollPane2.setViewportView(areaDatosTitular);

        labelEdad.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        labelEdad.setForeground(new java.awt.Color(51, 51, 51));
        labelEdad.setText("Edad");

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Si o No");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Flecha derecha.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Flecha derecha rollover.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabelRegistroDeTitular.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 36)); // NOI18N
        jLabelRegistroDeTitular.setForeground(new java.awt.Color(51, 51, 51));
        jLabelRegistroDeTitular.setText("Emitir Licencia");

        observaciones.setBackground(new java.awt.Color(206, 206, 206));
        observaciones.setColumns(20);
        observaciones.setForeground(new java.awt.Color(51, 51, 51));
        observaciones.setRows(5);
        observaciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelEdad)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(291, 291, 291))
                                    .addComponent(jScrollPane2)
                                    .addComponent(observaciones)
                                    .addComponent(comboClase, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, 12)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel14))
                            .addComponent(jLabelRegistroDeTitular)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 451, Short.MAX_VALUE)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelRegistroDeTitular)
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboClase, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(labelEdad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        AltaTitular at = new AltaTitular(personaController, licenciaController, "");
        at.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        String clase = (String) this.comboClase.getSelectedItem();
        //Comprobar que pueda sacar las clases
        if(verificarClase(clase)){
            //Sigue
        }
        else{
            //Tira un error
        }
        
        String obs = this.observaciones.getText();

        
        System.out.println(titular.getFechaNac());
        
        Licencia licencia = new Licencia();
        licencia.setFechaEmision(new Date());
        licencia.setMotivo(Motivo.ORIGINAL.toString());
        try {
            Date fechaVencimiento = licenciaController.getVigencia(licencia, titular.getFechaNac());
            licencia.setFechaVenc(fechaVencimiento);
        } catch (ParseException ex) {
            Logger.getLogger(EmitirLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        mouseDownCompCoords = evt.getPoint();
    }//GEN-LAST:event_jPanel4MousePressed

    private void jPanel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseReleased
        mouseDownCompCoords = null;
    }//GEN-LAST:event_jPanel4MouseReleased

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        Point currCoords = evt.getLocationOnScreen();
        this.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }//GEN-LAST:event_jPanel4MouseDragged
    
    private boolean verificarClase(String clase){
            switch (clase){
                case "A": 
                    return true;
                case "B":
                    return true;
                case "C": 
//                    if(licenciaController.getEdad(titular.getFechaNac())>=21
//                            && licenciaController.getPersona(titular.getId()))
//                    
                    break;
                case "D": break;
                case "E": break;
                case "F": 
                    return true;
                case "G": 
                    return true;
            } 
        
        return false;
    }
    
    
    
    private void completarDatosTitular(){
        //Completar los datos del titular en el textArea
        //No se pueden editar. Es el titular dado de alta anteriormente
        Calendar c = Calendar.getInstance();
        c.setTime(titular.getFechaNac());
        this.areaDatosTitular.setText("NOMBRE: "+ titular.getNombre() + "\n"
                + "APELLIDO: " + titular.getApellido() + "\n"
                + titular.getTipoId().toUpperCase() +": " + titular.getNroId() + "\n"
                + "FECHA DE NACIMIENTO: " + c.get(Calendar.DAY_OF_MONTH) +"/"+ (c.get(Calendar.MONTH)+1) +"/"+ c.get(Calendar.YEAR)+ "\n"
                + "DOMICILIO: " + titular.getDomicilio() + "\n"
                + "GRUPO SANGUINEO: " + titular.getGrupoSanguineo() + "\n"
                + "FACTOR: " + titular.getFactor() + "\n"
                + "ES DONANTE: " + titular.esDonante());
    }
    
    private void setearEdad(){
        this.labelEdad.setText(String.valueOf(personaController.getEdad(titular.getFechaNac())));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDatosTitular;
    private javax.swing.JComboBox<String> comboClase;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelRegistroDeTitular;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelEdad;
    private javax.swing.JTextArea observaciones;
    // End of variables declaration//GEN-END:variables
}
