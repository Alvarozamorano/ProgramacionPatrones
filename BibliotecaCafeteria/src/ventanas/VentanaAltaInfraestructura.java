/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import AdapterTemplateMethod_SingletonProxyServidor.AdaptadorServidor;
import AdapterTemplateMethod_SingletonProxyServidor.AdaptadorServidorProductoBiblioteca;
import FactPublicaciones.Infraestructura;
import FactPublicaciones.Sala;
import bibliotecacafeteria.Biblioteca;
import PersonalUniversidad.PersonalUniversidad;
import SingletonProxyServidor.SingletonProxyServidor;
import SingletonProxyServidor.TipoArchivo;
import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Álvaro Zamorano
 */
public class VentanaAltaInfraestructura extends javax.swing.JFrame {

    private VentanaBibliotecario padre;

    private PersonalUniversidad usuario;

    private AdaptadorServidor adaptadorServidorPublicacion;

    private HashMap mapProductosBiblioteca;

    /**
     * Creates new form VentanaAltaInfraestructura
     */
    public VentanaAltaInfraestructura(VentanaBibliotecario ventana, PersonalUniversidad usuario) {
        padre = ventana;
        padre.setVisible(false);
        this.setVisible(true);
        initComponents();
        this.getContentPane().setBackground(Color.orange);
        this.usuario = usuario;
        adaptadorServidorPublicacion = new AdaptadorServidorProductoBiblioteca();
        mapProductosBiblioteca = adaptadorServidorPublicacion.obtener_todo_dato();
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
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextFieldCapacidad = new javax.swing.JTextField();
        jTextFieldAforo = new javax.swing.JTextField();
        jTextFieldID = new javax.swing.JTextField();
        jButtonAlta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SISTEMA CAFETERIA Y BIBLIOTECA");
        setPreferredSize(new java.awt.Dimension(550, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jLabel1.setText("Capacidad:");

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jLabel2.setText("Aforo:");

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jLabel3.setText("Identificador:");

        jComboBox1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sala" }));

        jButtonAlta.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAlta.setForeground(new java.awt.Color(255, 255, 0));
        jButtonAlta.setText("Añadir");
        jButtonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldAforo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(71, 71, 71)
                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAlta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAforo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        padre.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * Da de alta una nueva infraestructura
     * @param evt 
     */
    private void jButtonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAltaActionPerformed
        if (mapProductosBiblioteca.containsKey(jTextFieldID.getText())) {
            JOptionPane.showMessageDialog(this, "ERROR: La publicacion ya se encuentra registrada");
        } else if ((jTextFieldID.getText().isEmpty()) || (jTextFieldAforo.getText().isEmpty())
                || (jTextFieldCapacidad.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "ERROR: Debe rellenar todos los campos");
        } else {
            try {
                int seleccion = jComboBox1.getSelectedIndex();
                Infraestructura infraestructura;
                Biblioteca biblioteca = (Biblioteca) 
                        SingletonProxyServidor.getInstancia().cargar_archivo(TipoArchivo.BIBLIOTECA, usuario.getRolBibliotecario().getBiblioteca());
                switch (seleccion) {
                    case 0:
                        //sala
                        String aforoString = jTextFieldAforo.getText();
                        int aforo = Integer.parseInt(aforoString);
                        String capacidadString = jTextFieldCapacidad.getText();
                        int capacidad = Integer.parseInt(capacidadString);

                        infraestructura = new Sala(capacidad, aforo, jTextFieldID.getText(),
                                biblioteca);
                        break;
                    default:
                        infraestructura = null;
                        break;
                }

                JOptionPane.showMessageDialog(this, "Publicacion " + jTextFieldID.getText() + " registrada correctamente");
                SingletonProxyServidor.getInstancia().guardar_archivo(usuario);
                SingletonProxyServidor.getInstancia().guardar_archivo(infraestructura);
                SingletonProxyServidor.getInstancia().guardar_archivo(biblioteca);
                mapProductosBiblioteca = adaptadorServidorPublicacion.obtener_todo_dato();
            } catch (IOException ex) {
                Logger.getLogger(VentanaAltaPublicacion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VentanaAltaInfraestructura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonAltaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlta;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldAforo;
    private javax.swing.JTextField jTextFieldCapacidad;
    private javax.swing.JTextField jTextFieldID;
    // End of variables declaration//GEN-END:variables
}
