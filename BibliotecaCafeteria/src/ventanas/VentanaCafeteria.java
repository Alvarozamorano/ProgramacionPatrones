package ventanas;

import FactProductosCafeteria.Bebida;
import FactProductosCafeteria.Comida;
import FactProductosCafeteria.Menu;
import FactProductosCafeteria.Postre;
import FactProductosCafeteria.ProductoCafeteria;
import PersonalUniversidad.PersonalUniversidad;
import SingletonProxyServidor.SingletonProxyServidor;
import SingletonProxyServidor.TipoArchivo;
import StateComanda.Comanda;
import bibliotecacafeteria.Cafeteria;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class VentanaCafeteria extends javax.swing.JFrame {

    private VentanaUsuario padre;

    private PersonalUniversidad usuario;

    /**
     * Creates new form VentanaPrestamos
     */
    public VentanaCafeteria(VentanaUsuario ventana, PersonalUniversidad usuario) throws IOException, ClassNotFoundException {
        padre = ventana;
        padre.setVisible(false);
        this.setVisible(true);
        initComponents();
        this.getContentPane().setBackground(Color.orange);
        this.usuario = (PersonalUniversidad) SingletonProxyServidor.getInstancia().cargar_archivo(TipoArchivo.PERSONAL_UNIVERSIDAD, usuario.getDni());
        jLabelNombre.setText(usuario.getNombre());
        jLabelApellidos.setText(usuario.getApellidos());
        
        actualizarListProductosCafeteria();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jListComidas = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListPostres = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListBebidas = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListMenus = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jButtonEntregarComanda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SISTEMA CAFETERIA Y BIBLIOTECA");
        setPreferredSize(new java.awt.Dimension(574, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellidos:");

        jLabelNombre.setText("Nombre");

        jLabelApellidos.setText("Apellidos");

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel3.setText("Comidas");

        jScrollPane2.setViewportView(jListComidas);

        jScrollPane3.setViewportView(jListPostres);

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel4.setText("Postres");

        jScrollPane4.setViewportView(jListBebidas);

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel5.setText("Bebidas");

        jScrollPane5.setViewportView(jListMenus);

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 14)); // NOI18N
        jLabel6.setText("Menús");

        jButtonEntregarComanda.setBackground(new java.awt.Color(0, 0, 0));
        jButtonEntregarComanda.setForeground(new java.awt.Color(255, 255, 0));
        jButtonEntregarComanda.setText("Entregar Comanda");
        jButtonEntregarComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntregarComandaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(395, 395, 395)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57)
                        .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(52, 52, 52)
                        .addComponent(jLabelApellidos))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel3)
                        .addGap(84, 84, 84)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(33, 33, 33))))
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jButtonEntregarComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNombre))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabelApellidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane5))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jButtonEntregarComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        padre.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void jButtonEntregarComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntregarComandaActionPerformed
        try {                                                       
            String nombre_cafeteria = usuario.getRolCamarero().getNombre_cafeteria();
            Cafeteria cafeteria = null;
            if(nombre_cafeteria==""){
                //No es camarero, obtengo la cafeteria por defecto.
                cafeteria = (Cafeteria) SingletonProxyServidor.getInstancia().cargar_archivo(TipoArchivo.CAFETERIA, "Politecnica");
            }else{
                cafeteria = (Cafeteria) SingletonProxyServidor.getInstancia().cargar_archivo(TipoArchivo.CAFETERIA, nombre_cafeteria);
            }
            
            //Obtengo los productos seleccionados de todas las listas
            List<String> listaComidasSeleccionadas = jListComidas.getSelectedValuesList();
            List<String> listaBebidasSeleccionadas = jListPostres.getSelectedValuesList();
            List<String> listaPostresSeleccionados = jListPostres.getSelectedValuesList();
            List<String> listaMenusSeleccionados = jListMenus.getSelectedValuesList();
            
            //Concentro todos los productos en un solo arraylist
            ArrayList<String> listaProductosCafeteriaSeleccionadosString = new ArrayList<>();
            listaProductosCafeteriaSeleccionadosString.addAll(listaComidasSeleccionadas);
            listaProductosCafeteriaSeleccionadosString.addAll(listaBebidasSeleccionadas);
            listaProductosCafeteriaSeleccionadosString.addAll(listaPostresSeleccionados);
            listaProductosCafeteriaSeleccionadosString.addAll(listaMenusSeleccionados);
            
            //Obtengo el objeto ProductoCafeteria correspondiente
            ArrayList<ProductoCafeteria> listaProductosCafeteriaSeleccionados = new ArrayList<>();
            for(int i = 0; i < listaProductosCafeteriaSeleccionadosString.size();i++){
                listaProductosCafeteriaSeleccionados.add(cafeteria.getProductoConcreto(listaProductosCafeteriaSeleccionadosString.get(i)));
            }
            
            //Creo y solicito la comanda
            Comanda comanda = new Comanda(usuario, listaProductosCafeteriaSeleccionados);
            cafeteria.getComandas().add(comanda);
            comanda.solicitarComanda();
             JOptionPane.showMessageDialog(this, "Comanda pendiente",
                                "Mensaje informativo", JOptionPane.INFORMATION_MESSAGE);
            //Guardamos el usuario actualizado
            try {
                SingletonProxyServidor proxy = SingletonProxyServidor.getInstancia();
                proxy.guardar_archivo(cafeteria);
            } catch (IOException ex) {
                Logger.getLogger(VentanaCafeteria.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(VentanaCafeteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEntregarComandaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntregarComanda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JList<String> jListBebidas;
    private javax.swing.JList<String> jListComidas;
    private javax.swing.JList<String> jListMenus;
    private javax.swing.JList<String> jListPostres;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables

    private void actualizarListProductosCafeteria() throws IOException, ClassNotFoundException {
        String nombre_cafeteria = usuario.getRolCamarero().getNombre_cafeteria();
        Cafeteria cafeteria = null;
        if(nombre_cafeteria.equals("")){
            //No es camarero, obtengo la cafeteria por defecto.
            cafeteria = (Cafeteria) SingletonProxyServidor.getInstancia().cargar_archivo(TipoArchivo.CAFETERIA, "Politecnica");
        }else{
            cafeteria = (Cafeteria) SingletonProxyServidor.getInstancia().cargar_archivo(TipoArchivo.CAFETERIA, nombre_cafeteria);
        }
        
        ArrayList<ProductoCafeteria> listaProductos = cafeteria.getProductos();
        DefaultListModel modelComidas = new DefaultListModel<>();
        DefaultListModel modelPostres = new DefaultListModel<>();
        DefaultListModel modelBebidas = new DefaultListModel<>();
        DefaultListModel modelMenus = new DefaultListModel<>();
        for(int i = 0; i< listaProductos.size(); i++){
            if(listaProductos.get(i) instanceof Comida){
                modelComidas.addElement(listaProductos.get(i).getIdentificador());
            }else if(listaProductos.get(i) instanceof Postre){
                modelPostres.addElement(listaProductos.get(i).getIdentificador());
            }else if(listaProductos.get(i) instanceof Bebida){
                modelBebidas.addElement(listaProductos.get(i).getIdentificador());
            }else if(listaProductos.get(i) instanceof Menu){
                modelMenus.addElement(listaProductos.get(i).getIdentificador());
            }
        }

        jListComidas.setModel(modelComidas);
        jListPostres.setModel(modelPostres);
        jListBebidas.setModel(modelBebidas);
        jListMenus.setModel(modelMenus);
    }
}
