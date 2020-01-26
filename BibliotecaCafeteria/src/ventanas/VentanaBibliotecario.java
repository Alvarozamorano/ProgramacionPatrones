/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import PersonalUniversidad.PersonalUniversidad;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Álvaro Zamorano
 */
public class VentanaBibliotecario extends javax.swing.JFrame {

    private VentanaUsuario padre;

    private PersonalUniversidad usuario;

    /**
     * Creates new form VentanaBibliotecario
     */
    public VentanaBibliotecario(VentanaUsuario ventana, PersonalUniversidad usuario) {
        padre = ventana;
        padre.setVisible(false);
        this.setVisible(true);
        initComponents();
        this.getContentPane().setBackground(Color.orange);
        this.usuario = usuario;
        jLabelNombre.setText(usuario.getNombre());
        jLabelApellidos.setText(usuario.getApellidos());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellidos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonAltaP = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButtonBaja = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonConsulta = new javax.swing.JButton();
        jButtonConceder = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButtonAltaI = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SISTEMA CAFETERIA Y BIBLIOTECA");
        setPreferredSize(new java.awt.Dimension(550, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellidos:");

        jLabelNombre.setText("Nombre");

        jLabelApellidos.setText("Apellidos");

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jLabel3.setText("Alta Publicaciones-");

        jButtonAltaP.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAltaP.setForeground(new java.awt.Color(255, 255, 0));
        jButtonAltaP.setText("Acceder");
        jButtonAltaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltaPActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jLabel4.setText("Baja Productos-");

        jButtonBaja.setBackground(new java.awt.Color(0, 0, 0));
        jButtonBaja.setForeground(new java.awt.Color(255, 255, 0));
        jButtonBaja.setText("Acceder");
        jButtonBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBajaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jLabel5.setText("Conceder Prestamos-");

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jLabel6.setText("Consulta Prestamos-");

        jButtonConsulta.setBackground(new java.awt.Color(0, 0, 0));
        jButtonConsulta.setForeground(new java.awt.Color(255, 255, 0));
        jButtonConsulta.setText("Acceder");
        jButtonConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultaActionPerformed(evt);
            }
        });

        jButtonConceder.setBackground(new java.awt.Color(0, 0, 0));
        jButtonConceder.setForeground(new java.awt.Color(255, 255, 0));
        jButtonConceder.setText("Acceder");
        jButtonConceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcederActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jLabel7.setText("Alta Infraestructuras-");

        jButtonAltaI.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAltaI.setForeground(new java.awt.Color(255, 255, 0));
        jButtonAltaI.setText("Acceder");
        jButtonAltaI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltaIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel2)
                        .addGap(24, 24, 24)
                        .addComponent(jLabelApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(92, 92, 92)
                                .addComponent(jButtonAltaP))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonAltaI)
                                    .addComponent(jButtonBaja)
                                    .addComponent(jButtonConsulta)
                                    .addComponent(jButtonConceder))))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabelApellidos))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAltaP)
                    .addComponent(jLabel3))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAltaI)
                    .addComponent(jLabel7))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButtonBaja))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButtonConsulta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButtonConceder))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        padre.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * Se muestra la ventana de alta de publicación
     *
     * @param evt
     */
    private void jButtonAltaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAltaPActionPerformed
        VentanaAltaPublicacion vap = new VentanaAltaPublicacion(this, usuario);
    }//GEN-LAST:event_jButtonAltaPActionPerformed

    /**
     * Se muestra la ventana de baja de producto de biblioteca
     *
     * @param evt
     */
    private void jButtonBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBajaActionPerformed
        VentanaBajaProductoBiblioteca vb = new VentanaBajaProductoBiblioteca(this);
    }//GEN-LAST:event_jButtonBajaActionPerformed

    /**
     * Se muestra la ventana de consulta de prestamos
     *
     * @param evt
     */
    private void jButtonConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultaActionPerformed
        try {
            VentanaConsultarPrestamos vc = new VentanaConsultarPrestamos(this, usuario, true);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(VentanaPrestamos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonConsultaActionPerformed

    /**
     * Se muestra la ventana de conceder prestamos
     * @param evt 
     */
    private void jButtonConcederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcederActionPerformed
        try {
            VentanaConcederPrestamo vp = new VentanaConcederPrestamo(this, usuario);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(VentanaBibliotecario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonConcederActionPerformed

    /**
     * Se muestra la ventana de alta de infraestructuras.
     * @param evt 
     */
    private void jButtonAltaIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAltaIActionPerformed
        VentanaAltaInfraestructura vap = new VentanaAltaInfraestructura(this, usuario);
    }//GEN-LAST:event_jButtonAltaIActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAltaI;
    private javax.swing.JButton jButtonAltaP;
    private javax.swing.JButton jButtonBaja;
    private javax.swing.JButton jButtonConceder;
    private javax.swing.JButton jButtonConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelNombre;
    // End of variables declaration//GEN-END:variables
}
