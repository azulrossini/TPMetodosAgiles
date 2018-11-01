
package Presentacion;

import Logica.*;
import Logica.LicenciaController.Motivo;
import Persistencia.*;
import java.awt.Color;
import java.awt.Point;
import static java.lang.System.exit;
import java.util.Date;


public class AltaTitular extends javax.swing.JFrame {

    private Point mouseDownCompCoords = null;
    private PersonaController personaController;
    private LicenciaController licenciaController;
    private String pantallaAnterior;
    private Motivo motivo;
    
    public AltaTitular(PersonaController p, LicenciaController l, String pantAnterior, Motivo m) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.personaController = p;
        this.pantallaAnterior = pantAnterior;
        this.licenciaController = l;
        this.motivo = m;
        
        this.jLabelErrorNumDocumento.setVisible(false);
        this.jLabelErrorNombre.setVisible(false);
        this.jLabelErrorApellido.setVisible(false);
        this.jLabelErrorCalle.setVisible(false);
        this.jLabelErrorPiso.setVisible(false);
        this.jLabelErrorNumeroCalle.setVisible(false);
        this.jLabelErrorDepartamento.setVisible(false);
        this.jLabelErrorFecha.setVisible(false);
        
        this.buttonGroupDoanate.add(this.jRadioButtonDonanteSi);
        this.buttonGroupDoanate.add(this.jRadioButtonDonanteNo);
    }

    private AltaTitular() { //sirve solo para iniciar alta titular sola (sin venir del menu principal)
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        PersonaController p = new PersonaController();
        this.personaController = p;
        this.jLabelErrorNumDocumento.setVisible(false);
        this.jLabelErrorNombre.setVisible(false);
        this.jLabelErrorApellido.setVisible(false);
        this.jLabelErrorCalle.setVisible(false);
        this.jLabelErrorPiso.setVisible(false);
        this.jLabelErrorNumeroCalle.setVisible(false);
        this.jLabelErrorDepartamento.setVisible(false);
        this.jLabelErrorFecha.setVisible(false);
        this.jLabelErrorDonante.setVisible(false);
        
        this.buttonGroupDoanate.add(this.jRadioButtonDonanteSi);
        this.buttonGroupDoanate.add(this.jRadioButtonDonanteNo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupDoanate = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabelRegistroDeTitular = new javax.swing.JLabel();
        jLabelDocumento = new javax.swing.JLabel();
        jLabelTipoDocumento = new javax.swing.JLabel();
        jComboBoxTipoDocumento = new javax.swing.JComboBox<>();
        jLabelNumeroDocumento = new javax.swing.JLabel();
        jTextFieldNumeroDocumento = new javax.swing.JTextField();
        jLabelNombreTitular = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelApellidoTitular = new javax.swing.JLabel();
        jTextFieldApellido = new javax.swing.JTextField();
        jLabelFechaNacimiento = new javax.swing.JLabel();
        jTextFieldDiaNacimiento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldMesNacimiento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldAnioNacimiento = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelCalle = new javax.swing.JLabel();
        jTextFieldCalle = new javax.swing.JTextField();
        jLabelNumeroDireccion = new javax.swing.JLabel();
        jTextFieldNumeroCalle = new javax.swing.JTextField();
        jLabelPiso = new javax.swing.JLabel();
        jTextFieldPiso = new javax.swing.JTextField();
        jLabelDepartamento = new javax.swing.JLabel();
        jTextFieldDepartamento = new javax.swing.JTextField();
        jLabelGrupoSanguineo = new javax.swing.JLabel();
        jLabelRH = new javax.swing.JLabel();
        jLabelDonante = new javax.swing.JLabel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonMinimizar = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();
        jButtonAtras = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxRH = new javax.swing.JComboBox<>();
        jComboBoxGrupoSanguineo = new javax.swing.JComboBox<>();
        jLabelErrorNumDocumento = new javax.swing.JLabel();
        jLabelErrorNombre = new javax.swing.JLabel();
        jLabelErrorApellido = new javax.swing.JLabel();
        jLabelErrorFecha = new javax.swing.JLabel();
        jLabelErrorCalle = new javax.swing.JLabel();
        jLabelErrorNumeroCalle = new javax.swing.JLabel();
        jLabelErrorPiso = new javax.swing.JLabel();
        jLabelErrorDepartamento = new javax.swing.JLabel();
        jRadioButtonDonanteSi = new javax.swing.JRadioButton();
        jRadioButtonDonanteNo = new javax.swing.JRadioButton();
        jLabelErrorDonante = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(206, 206, 206));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true), new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true)));
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

        jLabelRegistroDeTitular.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 36)); // NOI18N
        jLabelRegistroDeTitular.setForeground(new java.awt.Color(51, 51, 51));
        jLabelRegistroDeTitular.setText("Registro de Titular");

        jLabelDocumento.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelDocumento.setForeground(new java.awt.Color(51, 51, 51));
        jLabelDocumento.setText("Documento");

        jLabelTipoDocumento.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelTipoDocumento.setForeground(new java.awt.Color(51, 51, 51));
        jLabelTipoDocumento.setText("Tipo");

        jComboBoxTipoDocumento.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jComboBoxTipoDocumento.setForeground(new java.awt.Color(51, 51, 51));
        jComboBoxTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "CUIT", "CUIL", "LC", "LE", "CI", "PASAPORTE" }));
        jComboBoxTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoDocumentoActionPerformed(evt);
            }
        });

        jLabelNumeroDocumento.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelNumeroDocumento.setForeground(new java.awt.Color(51, 51, 51));
        jLabelNumeroDocumento.setText("Número");

        jTextFieldNumeroDocumento.setToolTipText("Sin guiones ni espacios");

        jLabelNombreTitular.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelNombreTitular.setForeground(new java.awt.Color(51, 51, 51));
        jLabelNombreTitular.setText("Nombre");

        jTextFieldNombre.setToolTipText("32 caracteres como maximo");
        jTextFieldNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelApellidoTitular.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelApellidoTitular.setForeground(new java.awt.Color(51, 51, 51));
        jLabelApellidoTitular.setText("Apellido");

        jTextFieldApellido.setToolTipText("32 caracteres como maximo");

        jLabelFechaNacimiento.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelFechaNacimiento.setForeground(new java.awt.Color(51, 51, 51));
        jLabelFechaNacimiento.setText("Fecha de nacimiento (dd/mm/aaaa)");

        jTextFieldDiaNacimiento.setToolTipText("01");
        jTextFieldDiaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDiaNacimientoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("/");

        jTextFieldMesNacimiento.setToolTipText("01");
        jTextFieldMesNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMesNacimientoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("/");

        jTextFieldAnioNacimiento.setToolTipText("1990");
        jTextFieldAnioNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAnioNacimientoActionPerformed(evt);
            }
        });

        jLabelDireccion.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelDireccion.setForeground(new java.awt.Color(51, 51, 51));
        jLabelDireccion.setText("Dirección");

        jLabelCalle.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelCalle.setForeground(new java.awt.Color(51, 51, 51));
        jLabelCalle.setText("Calle");

        jTextFieldCalle.setToolTipText("");

        jLabelNumeroDireccion.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelNumeroDireccion.setForeground(new java.awt.Color(51, 51, 51));
        jLabelNumeroDireccion.setText("Número");

        jLabelPiso.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelPiso.setForeground(new java.awt.Color(51, 51, 51));
        jLabelPiso.setText("Piso");

        jTextFieldPiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPisoActionPerformed(evt);
            }
        });

        jLabelDepartamento.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelDepartamento.setForeground(new java.awt.Color(51, 51, 51));
        jLabelDepartamento.setText("Departamento");

        jTextFieldDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDepartamentoActionPerformed(evt);
            }
        });

        jLabelGrupoSanguineo.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelGrupoSanguineo.setForeground(new java.awt.Color(51, 51, 51));
        jLabelGrupoSanguineo.setText("Grupo sanguíneo");

        jLabelRH.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelRH.setForeground(new java.awt.Color(51, 51, 51));
        jLabelRH.setText("RH");

        jLabelDonante.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabelDonante.setForeground(new java.awt.Color(51, 51, 51));
        jLabelDonante.setText("Donante");

        jButtonGuardar.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 11)); // NOI18N
        jButtonGuardar.setForeground(new java.awt.Color(51, 51, 51));
        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Flecha derecha.png"))); // NOI18N
        jButtonGuardar.setBorderPainted(false);
        jButtonGuardar.setContentAreaFilled(false);
        jButtonGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Flecha derecha rollover.png"))); // NOI18N
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/diminish.png"))); // NOI18N
        jButtonMinimizar.setBorderPainted(false);
        jButtonMinimizar.setContentAreaFilled(false);
        jButtonMinimizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/diminish rollover.png"))); // NOI18N
        jButtonMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinimizarActionPerformed(evt);
            }
        });

        jButtonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cancel.png"))); // NOI18N
        jButtonCerrar.setBorderPainted(false);
        jButtonCerrar.setContentAreaFilled(false);
        jButtonCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cancel rollover.png"))); // NOI18N
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jButtonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/left-arrow.png"))); // NOI18N
        jButtonAtras.setBorderPainted(false);
        jButtonAtras.setContentAreaFilled(false);
        jButtonAtras.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/left-arrow rollover.png"))); // NOI18N
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/AltaTitularGrande.png"))); // NOI18N

        jComboBoxRH.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 11)); // NOI18N
        jComboBoxRH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+", "-" }));

        jComboBoxGrupoSanguineo.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 11)); // NOI18N
        jComboBoxGrupoSanguineo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "O", "A", "B", "AB" }));

        jLabelErrorNumDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/atencion.png"))); // NOI18N

        jLabelErrorNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/atencion.png"))); // NOI18N

        jLabelErrorApellido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/atencion.png"))); // NOI18N

        jLabelErrorFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/atencion.png"))); // NOI18N

        jLabelErrorCalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/atencion.png"))); // NOI18N

        jLabelErrorNumeroCalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/atencion.png"))); // NOI18N

        jLabelErrorPiso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/atencion.png"))); // NOI18N

        jLabelErrorDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/atencion.png"))); // NOI18N

        jRadioButtonDonanteSi.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 10)); // NOI18N
        jRadioButtonDonanteSi.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButtonDonanteSi.setText("Si");

        jRadioButtonDonanteNo.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 10)); // NOI18N
        jRadioButtonDonanteNo.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButtonDonanteNo.setText("No");

        jLabelErrorDonante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/atencion.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(jLabelRegistroDeTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabelNombreTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelErrorNombre)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelApellidoTitular)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabelTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBoxTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelErrorNumDocumento)))
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabelErrorApellido)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabelDonante, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jRadioButtonDonanteSi)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButtonDonanteNo)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelErrorDonante))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabelPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextFieldPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelErrorPiso)
                                                .addGap(26, 26, 26)
                                                .addComponent(jLabelDepartamento)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextFieldDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelErrorDepartamento))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelErrorCalle)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelNumeroDireccion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldNumeroCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelErrorNumeroCalle))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelGrupoSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxGrupoSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelRH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxRH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(jTextFieldDiaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(jTextFieldMesNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldAnioNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelErrorFecha)
                                .addGap(35, 35, 35)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(196, 196, 196))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelRegistroDeTitular)
                        .addGap(11, 11, 11)))
                .addComponent(jLabelDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBoxTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldNumeroDocumento)
                                        .addComponent(jLabelTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelErrorNumDocumento))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelNombreTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabelErrorNombre))
                                        .addGap(1, 1, 1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelErrorApellido))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelApellidoTitular)
                                .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDiaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldMesNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAnioNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelErrorFecha))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jButtonGuardar)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelErrorDonante)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelDireccion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelErrorNumeroCalle)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelErrorCalle)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNumeroDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldNumeroCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelDepartamento)
                                        .addComponent(jTextFieldDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelErrorDepartamento, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelPiso)
                                        .addComponent(jLabelErrorPiso)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelGrupoSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxGrupoSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelRH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxRH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelDonante, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButtonDonanteSi)
                                    .addComponent(jRadioButtonDonanteNo))))
                        .addContainerGap(63, Short.MAX_VALUE))))
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

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        // TODO add your handling code here:
        switch(pantallaAnterior){
            case "index": 
                IndexView i = new IndexView();
                i.setVisible(true);
                this.setVisible(false);
                break;
            case "eleccion": 
                EleccionTipoEmision e = new EleccionTipoEmision(personaController, licenciaController);
                e.setVisible(true);
                this.setVisible(false);
                break;
        }
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        exit(0);
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinimizarActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButtonMinimizarActionPerformed

    private void jTextFieldDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDepartamentoActionPerformed

    private void jTextFieldPisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPisoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPisoActionPerformed

    private void jTextFieldAnioNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAnioNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAnioNacimientoActionPerformed

    private void jTextFieldMesNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMesNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMesNacimientoActionPerformed

    private void jTextFieldDiaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDiaNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDiaNacimientoActionPerformed

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

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        
        //tomando los datos de la pantalla
        String nombre = this.jTextFieldNombre.getText();
        String apellido = this.jTextFieldApellido.getText();
        String dia = this.jTextFieldDiaNacimiento.getText();
        String mes = this.jTextFieldMesNacimiento.getText();
        String anio = this.jTextFieldAnioNacimiento.getText();
        String calle = this.jTextFieldCalle.getText();
        String numeroDocumento = this.jTextFieldNumeroDocumento.getText();
        String piso = this.jTextFieldPiso.getText();
        String depart = this.jTextFieldDepartamento.getText();
        String numeroCalle = this.jTextFieldNumeroCalle.getText();
        PersonaController.TipoDocumento tipo=null;
         String tipo1 = null;
        switch (this.jComboBoxTipoDocumento.getSelectedIndex()){
            case 0: tipo = PersonaController.TipoDocumento.DNI; tipo1="DNI"; break;
            case 1: tipo = PersonaController.TipoDocumento.CUIT; tipo1="CUIT";break;
            case 2: tipo = PersonaController.TipoDocumento.CUIL; tipo1="CUIL";break;
            case 3: tipo = PersonaController.TipoDocumento.LC;tipo1="LC"; break;
            case 4: tipo = PersonaController.TipoDocumento.LE;tipo1="LE"; break;
            case 5: tipo = PersonaController.TipoDocumento.CI;tipo1="CI"; break;
            case 6: tipo = PersonaController.TipoDocumento.PASAPORTE;tipo1="PASAPORTE"; break;
        }
        
        //valido datos
        boolean[] lista = new boolean[11];
        boolean errorEnDonante = (!this.jRadioButtonDonanteSi.isSelected() && !this.jRadioButtonDonanteNo.isSelected());
        lista = personaController.validarDatos(tipo, numeroDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart);
        
        this.jLabelErrorNumDocumento.setVisible(!lista[0]);
        this.jLabelErrorNombre.setVisible(!lista[1]);
        this.jLabelErrorApellido.setVisible(!lista[2]);
        this.jLabelErrorFecha.setVisible(!(lista[3] && lista[4] && lista[5] && lista[10]));
        this.jLabelErrorCalle.setVisible(!lista[6]);
        this.jLabelErrorNumeroCalle.setVisible(!lista[7]);
        this.jLabelErrorPiso.setVisible(!lista[8]);
        this.jLabelErrorDepartamento.setVisible(!lista[9]);
        this.jLabelErrorDonante.setVisible(errorEnDonante);
        //System.out.println(lista[12]);
        //cambio color de los jtexfield
        if(!lista[0]){
            this.jTextFieldNumeroDocumento.setForeground(Color.red);
        }else this.jTextFieldNumeroDocumento.setForeground(Color.black);
        if(!lista[1]){
            this.jTextFieldNombre.setForeground(Color.red);
        }else this.jTextFieldNombre.setForeground(Color.black);
        if(!lista[2]){
            this.jTextFieldApellido.setForeground(Color.red);
        }else this.jTextFieldApellido.setForeground(Color.black);
        if(!lista[10]){
           this.jTextFieldDiaNacimiento.setForeground(Color.red);
           this.jTextFieldMesNacimiento.setForeground(Color.red);
           this.jTextFieldAnioNacimiento.setForeground(Color.red);
        }else{
            this.jTextFieldDiaNacimiento.setForeground(Color.black);
            this.jTextFieldMesNacimiento.setForeground(Color.black);
            this.jTextFieldAnioNacimiento.setForeground(Color.black);
        }
        if(!lista[3]) this.jTextFieldDiaNacimiento.setForeground(Color.red);
        else this.jTextFieldDiaNacimiento.setForeground(Color.black);
        if(!lista[4]) this.jTextFieldMesNacimiento.setForeground(Color.red);
        else this.jTextFieldMesNacimiento.setForeground(Color.black);
        if(!lista[5]) this.jTextFieldAnioNacimiento.setForeground(Color.red);
        else this.jTextFieldAnioNacimiento.setForeground(Color.black);
        if(!lista[6]){
            this.jTextFieldCalle.setForeground(Color.red);
        }else this.jTextFieldCalle.setForeground(Color.black);
        if(!lista[7]){
            this.jTextFieldNumeroCalle.setForeground(Color.red);
        }else this.jTextFieldNumeroCalle.setForeground(Color.black);
        if(!lista[8]){
            this.jTextFieldPiso.setForeground(Color.red);
        }else this.jTextFieldPiso.setForeground(Color.black);
        if(!lista[9]){
            this.jTextFieldDepartamento.setForeground(Color.red);
        }else this.jTextFieldDepartamento.setForeground(Color.black);
        
        
        
        //verifico y creo un nuevo titular
        boolean estado=true;
        if(errorEnDonante) estado=false;
        for(int i=0;i<11;i++)
            if(lista[i]==false ) estado=false;
        if(estado){
            Date fechaNac = personaController.getFecha(dia, mes, anio);
            String domicilio = calle+" "+numeroCalle+" "+piso+" "+depart;
            String grupoSang="";
            String rh="";
            switch (this.jComboBoxGrupoSanguineo.getSelectedIndex()){
            case 0: grupoSang="O"; break;
            case 1:  grupoSang="A";break;
            case 2:  grupoSang="B"; break;
            case 3:  grupoSang="AB";break;
        }
             switch (this.jComboBoxRH.getSelectedIndex()){
            case 0: rh="+"; break;
            case 1: rh="-";break;
           
        }
            boolean donante = this.jRadioButtonDonanteSi.isSelected();
            int numDocu = Integer.valueOf(numeroDocumento);
            Persona nuevoTitular = new Persona(tipo1,numDocu, apellido, nombre, fechaNac, domicilio, grupoSang, rh, donante );
            //System.out.println(nuevoTitular.isDonante()+"   "+ nuevoTitular.getFechaNac());
            
            
            //Llama para emitir una licencia con el titular creado
            EmitirLicencia el = new EmitirLicencia(nuevoTitular, personaController, licenciaController, motivo);
            el.setVisible(true);
            this.setVisible(false);
        }
       
        
        
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jComboBoxTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoDocumentoActionPerformed

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
            java.util.logging.Logger.getLogger(AltaTitular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaTitular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaTitular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaTitular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaTitular().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupDoanate;
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JComboBox<String> jComboBoxGrupoSanguineo;
    private javax.swing.JComboBox<String> jComboBoxRH;
    private javax.swing.JComboBox<String> jComboBoxTipoDocumento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelApellidoTitular;
    private javax.swing.JLabel jLabelCalle;
    private javax.swing.JLabel jLabelDepartamento;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelDocumento;
    private javax.swing.JLabel jLabelDonante;
    private javax.swing.JLabel jLabelErrorApellido;
    private javax.swing.JLabel jLabelErrorCalle;
    private javax.swing.JLabel jLabelErrorDepartamento;
    private javax.swing.JLabel jLabelErrorDonante;
    private javax.swing.JLabel jLabelErrorFecha;
    private javax.swing.JLabel jLabelErrorNombre;
    private javax.swing.JLabel jLabelErrorNumDocumento;
    private javax.swing.JLabel jLabelErrorNumeroCalle;
    private javax.swing.JLabel jLabelErrorPiso;
    private javax.swing.JLabel jLabelFechaNacimiento;
    private javax.swing.JLabel jLabelGrupoSanguineo;
    private javax.swing.JLabel jLabelNombreTitular;
    private javax.swing.JLabel jLabelNumeroDireccion;
    private javax.swing.JLabel jLabelNumeroDocumento;
    private javax.swing.JLabel jLabelPiso;
    private javax.swing.JLabel jLabelRH;
    private javax.swing.JLabel jLabelRegistroDeTitular;
    private javax.swing.JLabel jLabelTipoDocumento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonDonanteNo;
    private javax.swing.JRadioButton jRadioButtonDonanteSi;
    private javax.swing.JTextField jTextFieldAnioNacimiento;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldCalle;
    private javax.swing.JTextField jTextFieldDepartamento;
    private javax.swing.JTextField jTextFieldDiaNacimiento;
    private javax.swing.JTextField jTextFieldMesNacimiento;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNumeroCalle;
    private javax.swing.JTextField jTextFieldNumeroDocumento;
    private javax.swing.JTextField jTextFieldPiso;
    // End of variables declaration//GEN-END:variables
}
