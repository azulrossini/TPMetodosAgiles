/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.CryptoUtils;
import Logica.GenericDAO;
import Logica.UsuarioController;
import Persistencia.Usuario;
import javax.swing.JOptionPane;
import Logica.Index;
import javax.swing.ImageIcon;

/**
 *
 * @author ayr_1
 */
public class ModificarDatosUsuario extends javax.swing.JFrame {
    private Usuario user;
    private UsuarioController usuarioController;

    /**
     * Creates new form ModificarDatosUsuario
     */
    public ModificarDatosUsuario(Usuario usuario, UsuarioController usuarioController) {
        initComponents();
        this.user = usuario;
        this.usuarioController = usuarioController;
        cargarCampos();
        setIconImage(new ImageIcon(getClass().getResource("/favicon.png")).getImage());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        Index.historial.add(this);        
    }
    
    private void cargarCampos(){
        this.username.setText(user.getUsername());
        this.pass.setText(String.valueOf(user.getPassword()));
        if(user.isPrivilegio()){
            this.superusuario.setSelected(true);
        }else{
            this.administrativo.setSelected(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        privilegios = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        botonCerrar = new javax.swing.JButton();
        botonMinimizar = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        botonActualizar = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        superusuario = new javax.swing.JRadioButton();
        administrativo = new javax.swing.JRadioButton();
        pass = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/edit - user.png"))); // NOI18N
        jLabel14.setText(" Modificar Usuario");
        jLabel14.setFocusable(false);

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator4.setOpaque(true);

        botonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cancel.png"))); // NOI18N
        botonCerrar.setBorderPainted(false);
        botonCerrar.setContentAreaFilled(false);
        botonCerrar.setFocusable(false);
        botonCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cancel rollover.png"))); // NOI18N
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        botonMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/diminish.png"))); // NOI18N
        botonMinimizar.setBorderPainted(false);
        botonMinimizar.setContentAreaFilled(false);
        botonMinimizar.setFocusable(false);
        botonMinimizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/diminish rollover.png"))); // NOI18N
        botonMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMinimizarActionPerformed(evt);
            }
        });

        botonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/left-arrow.png"))); // NOI18N
        botonAtras.setBorderPainted(false);
        botonAtras.setContentAreaFilled(false);
        botonAtras.setFocusable(false);
        botonAtras.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/left-arrow rollover.png"))); // NOI18N
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameKeyTyped(evt);
            }
        });

        botonActualizar.setBackground(new java.awt.Color(255, 255, 255));
        botonActualizar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        botonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Flecha derecha.png"))); // NOI18N
        botonActualizar.setBorderPainted(false);
        botonActualizar.setContentAreaFilled(false);
        botonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonActualizarMouseExited(evt);
            }
        });
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        botonActualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                botonActualizarKeyTyped(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(51, 51, 51));
        jLabel22.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Nombre de usuario:");

        jLabel23.setBackground(new java.awt.Color(51, 51, 51));
        jLabel23.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Contraseña:");

        jLabel24.setBackground(new java.awt.Color(51, 51, 51));
        jLabel24.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Privilegios:");

        privilegios.add(superusuario);
        superusuario.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        superusuario.setText("Superusuario");
        superusuario.setContentAreaFilled(false);
        superusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                superusuarioKeyTyped(evt);
            }
        });

        privilegios.add(administrativo);
        administrativo.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        administrativo.setText("Administrativo");
        administrativo.setContentAreaFilled(false);
        administrativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                administrativoKeyTyped(evt);
            }
        });

        pass.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(username)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(superusuario)
                        .addGap(18, 18, 18)
                        .addComponent(administrativo))
                    .addComponent(pass))
                .addGap(0, 51, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonActualizar)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(superusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(administrativo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
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

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void botonMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_botonMinimizarActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        Index.historial.get(Index.historial.size()-2).setVisible(true);
        this.dispose();
        Index.historial.remove(Index.historial.size()-1);
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyTyped
       
    }//GEN-LAST:event_usernameKeyTyped

    private void botonActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonActualizarMouseEntered
        this.botonActualizar.setBackground(this.botonActualizar.getBackground().darker());
    }//GEN-LAST:event_botonActualizarMouseEntered

    private void botonActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonActualizarMouseExited
        this.botonActualizar.setBackground(this.botonActualizar.getBackground().brighter());
    }//GEN-LAST:event_botonActualizarMouseExited

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        //Valido los datos  ingresados y dependiendo del resultado muestro el mensaje correspondiente
        switch (usuarioController.validarCampos(this.username.getText(), this.pass.getText(), this.superusuario.isSelected(), this.administrativo.isSelected())){
            case 0:
            try {
                //Actualizo el usuario existente
                user.setUsername(this.username.getText());
                user.setPassword(CryptoUtils.computeHash(this.pass.getText()));
                user.setPrivilegio(this.superusuario.isSelected());
                //Actualizo en la BD
                GenericDAO.update(user);
                //Muestro mensaje de exito
                JOptionPane.showMessageDialog(this, "Ha actualizado el usuario con éxito", "Felicidades",  JOptionPane.INFORMATION_MESSAGE);
                //Vuelvo a la pantalla de buscar usuario
                Index.historial.get(Index.historial.size()-2).setVisible(true);
                this.dispose();
                Index.historial.remove(Index.historial.size()-1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "La contraseña no es válida", "Error",  JOptionPane.ERROR_MESSAGE);
            }
            break;
            case 1:
            JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe", "Error",  JOptionPane.ERROR_MESSAGE);
            break;
            case 2:
            JOptionPane.showMessageDialog(this, "Debe insertar un nombre de usuario", "Error",  JOptionPane.ERROR_MESSAGE);
            break;
            case 3:
            JOptionPane.showMessageDialog(this, "Debe insertar una contraseña", "Error",  JOptionPane.ERROR_MESSAGE);
            break;
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonActualizarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonActualizarKeyTyped
        
    }//GEN-LAST:event_botonActualizarKeyTyped

    private void superusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_superusuarioKeyTyped
        
    }//GEN-LAST:event_superusuarioKeyTyped

    private void administrativoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_administrativoKeyTyped
        
    }//GEN-LAST:event_administrativoKeyTyped

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        
    }//GEN-LAST:event_jPanel4MouseDragged

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        
    }//GEN-LAST:event_jPanel4MousePressed

    private void jPanel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseReleased
        
    }//GEN-LAST:event_jPanel4MouseReleased

    private void passKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_passKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton administrativo;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonMinimizar;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField pass;
    private javax.swing.ButtonGroup privilegios;
    private javax.swing.JRadioButton superusuario;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
