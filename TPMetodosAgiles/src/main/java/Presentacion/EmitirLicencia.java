
package Presentacion;

import Logica.LicenciaController;
import Logica.LicenciaController.Motivo;
import Logica.PersonaController;
import Persistencia.*;
import java.awt.Point;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class EmitirLicencia extends javax.swing.JFrame {

    private Point mouseDownCompCoords = null;
    private Persona titular;
    private final PersonaController personaController;
    private final LicenciaController licenciaController;
    private final Motivo motivo;
    private final Usuario user;
    
//    public EmitirLicencia() {
//        initComponents();
//    }
    
    public EmitirLicencia(Persona tit, PersonaController p, LicenciaController l, Motivo m, Usuario user){
        this.titular = tit;
        this.personaController = p;
        this.licenciaController = l;
        this.motivo = m;
        initComponents();
        completarDatosTitular();
        quitarClasesNoValidas();
        this.setLocationRelativeTo(null);
        this.user = user;
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
        jScrollPane2 = new javax.swing.JScrollPane();
        areaDatosTitular = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
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
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/identity-card (2).png"))); // NOI18N
        jLabel14.setText(" Emitir Licencia");

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
        comboClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G" }));
        comboClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClaseActionPerformed(evt);
            }
        });

        areaDatosTitular.setEditable(false);
        areaDatosTitular.setBackground(new java.awt.Color(206, 206, 206));
        areaDatosTitular.setColumns(20);
        areaDatosTitular.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        areaDatosTitular.setForeground(new java.awt.Color(51, 51, 51));
        areaDatosTitular.setRows(5);
        areaDatosTitular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jScrollPane2.setViewportView(areaDatosTitular);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Flecha derecha.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Flecha derecha rollover.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboClase, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(118, 118, 118)
                                        .addComponent(jLabel14)
                                        .addGap(32, 32, 32)
                                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(113, 113, 113))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboClase, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        int seleccion = JOptionPane.showOptionDialog(this, "¿Está seguro que desea volver \n No se guardaran los datos", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
            null,    // null para icono por defecto.
            new Object[] { "Si", "No" },   // null para YES, NO y CANCEL
            "Si");
        if(seleccion == 0){
            AltaTitular at = new AltaTitular(personaController, licenciaController, "", motivo, user);
            at.setVisible(true);
            this.setVisible(false);
        }

    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Almacena el titular para poder obtener el id
        //Para almacenar como FK en la tabla Licencia
 
        String clase = (String) this.comboClase.getSelectedItem();
        //Comprobar que pueda sacar las clases
        if(licenciaController.verificarClase(clase, titular)){
            //Si no esta en la BD lo almacena, si esta no
            //Es para que no presione el boton OK muchas veces, porque se almacena muhcas veces el mismo titular
            if(personaController.buscarTitular(titular.getNroId())!=null){
                personaController.almacenarTitular(titular);
            }
            
            //Actualizo para que me devuelva el titular con el id autoincremental de la bd
            titular = personaController.getPersona(titular.getId());
            
            //Si es clase C D o E controla que tenga +21, sino no
            if(controlarCDE(clase)){
                String obs = this.observaciones.getText();
                licenciaController.crearLicencia(titular, clase, obs, motivo, user.getId());
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error \n No se puede almacenar el titular", "Error",  JOptionPane.ERROR_MESSAGE);
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

    private void comboClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboClaseActionPerformed

    
    private void completarDatosTitular(){
        //Completar los datos del titular en el textArea
        //No se pueden editar. Es el titular dado de alta anteriormente
        Calendar c = Calendar.getInstance();
        c.setTime(titular.getFechaNac());
        this.areaDatosTitular.setText("NOMBRE: "+ titular.getNombre() + "\n"
                + "APELLIDO: " + titular.getApellido() + "\n"
                + titular.getTipoId().toUpperCase() +": " + titular.getNroId() + "\n"
                + "FECHA DE NACIMIENTO: " + c.get(Calendar.DAY_OF_MONTH) +"/"+ (c.get(Calendar.MONTH)+1) +"/"+ c.get(Calendar.YEAR)+ "\n"
                + "EDAD: "+ String.valueOf(personaController.getEdad(titular.getFechaNac()))+ "\n"
                + "DOMICILIO: " + titular.getDomicilio() + "\n"
                + "GRUPO SANGUINEO: " + titular.getGrupoSanguineo() + "\n"
                + "FACTOR: " + titular.getFactor() + "\n"
                + "ES DONANTE: " + titular.isDonante());

    }
    

    
////    private void setearOriginal(){
////        switch(motivo){
////            case ORIGINAL:
////                this.labelOriginal.setText("Si");
////                break;
////            case RENOVACION:
////                this.labelOriginal.setText("No");
////                break;
////        }
//        
//    }


    private boolean controlarCDE(String clase){
        if(clase == "C" || clase == "E" || clase == "D"){
            if(personaController.getEdad(titular.getFechaNac())>=21){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }
    
    private void quitarClasesNoValidas(){
        //En caso de que el titular ya posea una licencia de una clase
        //No le da la posibilidad de que emita una nueva licencia de ese tipo
        //En ese caso el titular ya existe, pero la licencia no
        
        List<Licencia> licenciasExistentes = licenciaController.getLicenciasTitular(titular);
        
        for(int i =0; i<licenciasExistentes.size(); i++){
            if(licenciasExistentes.get(i).getFechaVenc().after(new Date())){
                quitarDeCombo(licenciasExistentes.get(i).getClaseId());
            }
        }
 
    }
    
    private void quitarDeCombo(String clase){
        //Quita las licencias que ya posee el titular del combobox
        comboClase.removeItem(clase);
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea observaciones;
    // End of variables declaration//GEN-END:variables
}
