
package Presentacion;

import Logica.UsuarioController;
import Persistencia.Usuario;
import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Fausto
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form ImprimirLicencia
     */
    
    private final UsuarioController uc;
    //Se define un objeto para manejar el desplazamiento cuando el usuario mantenga pulsado el clic sobre el frame y arrastre el puntero
    private Point mouseDownCompCoords = null;
    
    public Login(){
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/favicon.png")).getImage());
        this.uc = new UsuarioController();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.error.setVisible(false);
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
        exit = new javax.swing.JButton();
        min = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        ingresar = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        jLabel21 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();

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

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cancel.png"))); // NOI18N
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setFocusable(false);
        exit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cancel rollover.png"))); // NOI18N
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/diminish.png"))); // NOI18N
        min.setBorderPainted(false);
        min.setContentAreaFilled(false);
        min.setFocusable(false);
        min.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/diminish rollover.png"))); // NOI18N
        min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameKeyTyped(evt);
            }
        });

        ingresar.setBackground(new java.awt.Color(255, 255, 255));
        ingresar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        ingresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Flecha derecha.png"))); // NOI18N
        ingresar.setToolTipText("");
        ingresar.setBorderPainted(false);
        ingresar.setContentAreaFilled(false);
        ingresar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Flecha derecha rollover.png"))); // NOI18N
        ingresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Flecha derecha rollover.png"))); // NOI18N
        ingresar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Flecha derecha.png"))); // NOI18N
        ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ingresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ingresarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ingresarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ingresarMouseReleased(evt);
            }
        });
        ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarActionPerformed(evt);
            }
        });
        ingresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ingresarKeyTyped(evt);
            }
        });

        error.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        error.setForeground(new java.awt.Color(204, 51, 0));
        error.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/round-error-symbol.png"))); // NOI18N
        error.setText("Error. Usuario o contraseña incorrectos");
        error.setFocusable(false);

        pass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passKeyTyped(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(51, 51, 51));
        jLabel21.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Usuario:");

        jLabel30.setBackground(new java.awt.Color(51, 51, 51));
        jLabel30.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Contraseña:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/logo santa fe.png"))); // NOI18N

        jLabel22.setBackground(new java.awt.Color(51, 51, 51));
        jLabel22.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Licencias Santa Fe Ciudad");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(error)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ingresar))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(username)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pass)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseReleased
        //Cuando el clic se deja de presionar, se libera el espacio en memoria de las coordenadas que registran la ubicación del puntero
        mouseDownCompCoords = null;
    }//GEN-LAST:event_jPanel4MouseReleased

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        //Cuando se presiona un clic sobre el panel del frame, se obtienen las coordenadas donde fue realizado y se guardan en memoria
        mouseDownCompCoords = evt.getPoint();
    }//GEN-LAST:event_jPanel4MousePressed

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        //A medida que se arrastra el puntero, también se mueve el frame
        Point currCoords = evt.getLocationOnScreen();
        this.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }//GEN-LAST:event_jPanel4MouseDragged

    private void passKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyTyped
        //Se verifica que la contraseña ingresado no sobrepase los 32 caracteres, si lo hace se omite el tipeo realizado
        if (this.pass.getText().length()>=32){
            evt.consume();
        }
        this.error.setVisible(false);
        //Se detecta el botón Enter/Intro pulsado y se emite una pulsación del botón ingresar
        if (evt.getKeyChar()==KeyEvent.VK_ENTER){
            this.ingresar.doClick();
        }
    }//GEN-LAST:event_passKeyTyped

    private void ingresarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ingresarKeyTyped
        //Se detecta el botón Enter/Intro pulsado y se emite una pulsación del botón ingresar
        if (evt.getKeyChar()==KeyEvent.VK_ENTER){
            this.ingresar.doClick();
        }
    }//GEN-LAST:event_ingresarKeyTyped

    private void ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarActionPerformed
        Usuario user;
        try {
            user = this.uc.validarAcc(this.username.getText(), this.pass.getText());
            if (user!=null){
                IndexView iv = new IndexView(user);
                this.dispose();
            }
        } catch (Exception ex) {

        }
        this.error.setVisible(true);
    }//GEN-LAST:event_ingresarActionPerformed

    private void ingresarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarMouseReleased

    }//GEN-LAST:event_ingresarMouseReleased

    private void ingresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarMousePressed

    }//GEN-LAST:event_ingresarMousePressed

    private void ingresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarMouseExited
        this.ingresar.setPressedIcon(this.ingresar.getRolloverIcon());
    }//GEN-LAST:event_ingresarMouseExited

    private void ingresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarMouseEntered
        this.ingresar.setPressedIcon(this.ingresar.getIcon());
    }//GEN-LAST:event_ingresarMouseEntered

    private void usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyTyped
        //Se verifica que el nombre de usuario ingresado no sobrepase los 32 caracteres, si lo hace se omite el tipeo realizado
        if (this.username.getText().length()>=32){
            evt.consume();
        }
        this.error.setVisible(false);
        //Se detecta el botón Enter/Intro pulsado y se emite una pulsación del botón ingresar
        if (evt.getKeyChar()==KeyEvent.VK_ENTER){
            this.ingresar.doClick();
        }
    }//GEN-LAST:event_usernameKeyTyped

    private void minActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ImprimirLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ImprimirLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ImprimirLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ImprimirLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new ImprimirLicencia(null, null).setVisible(true);
//                } catch (IOException ex) {
//                    Logger.getLogger(ImprimirLicencia.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel error;
    private javax.swing.JButton exit;
    private javax.swing.JButton ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton min;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
