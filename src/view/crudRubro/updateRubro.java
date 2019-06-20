/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.crudRubro;

import conectorBD.JavaConnectDb;
import controller.rubro.CrudRubro;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.LoginUser;
import model.Rubro.Rubro;
import oracle.jdbc.OracleResultSet;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import static view.crudOferta.updateOferta.cbxTiendaOfertaMod;

/**
 *
 * @author fernandacancinoreyes
 */
public class updateRubro extends javax.swing.JFrame {

    LoginUser mod;
    
    /*llamo a la clase que contiene la conexion*/
    JavaConnectDb obj = new JavaConnectDb();
    OracleResultSet rs = null;
    
    /**
     * Creates new form updateRubro
     */
    public updateRubro() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        initComponents();
        
        /*Para dejar la pantalla centrada*/
        this.setLocationRelativeTo(null);
        
        txtIdRubroMod.setVisible(false);
        
         /*Cargar cmbx*/
        cbxCategoriaRubroMod.setModel(getValuesCategoria());
        
         //este codigo sirve para que al momento de elegir la crapeta la interface se vea bonita
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        AutoCompleteDecorator.decorate(cbxCategoriaRubroMod);
        
    }
   public updateRubro(LoginUser mod) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        this.mod=mod;
        
        initComponents();
        
        /*Para dejar la pantalla centrada*/
        this.setLocationRelativeTo(null);
        
        txtIdRubroMod.setVisible(false);
        
         /*Cargar cmbx*/
        cbxCategoriaRubroMod.setModel(getValuesCategoria());
        
         //este codigo sirve para que al momento de elegir la crapeta la interface se vea bonita
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        AutoCompleteDecorator.decorate(cbxCategoriaRubroMod);
        
    }
     
    
    private DefaultComboBoxModel getValuesCategoria(){
        
        DefaultComboBoxModel cbModelRubro = new DefaultComboBoxModel();
        
        String[] registros = new String[2];
        
        try {
            Connection cn = obj.ConnectBd();
            String sql = "select idcategoria, nombrecategoria from CATEGORIA";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) { 
                
                registros[0] = rs.getNString("idcategoria");
                registros[1] = rs.getString("nombrecategoria");
               cbModelRubro.addElement(registros[1]);
            }
            
            cn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return cbModelRubro;
    }

    private void limpiarDatos(){
        txtNombreRubroMod.setText("");
        cbxCategoriaRubroMod.setModel(getValuesCategoria());
    }
    
    
    private void verificaDatos() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        if(    txtNombreRubroMod.getText().trim().length() != 0 
           ) {
            //si los datos son correctamente insertados se ejecuta funcion para que guarde
            //agregaDesucento()
            try {
                modificaRubro();
            } catch (SQLException ex) {
                Logger.getLogger(createRubro.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
        else {
            JOptionPane.showMessageDialog(null, "Debe insertar todos los datos");
        }
    }
    
    private void modificaRubro() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        
        CrudRubro cRubro = new CrudRubro();
        Rubro rub = new Rubro();
        
        /*para obtener id de producto*/
        int idCategoria =  cbxCategoriaRubroMod.getSelectedIndex();
        idCategoria = idCategoria + 1;
        String idRubroString = String.valueOf(idCategoria);
        
        rub.setIdrubro(parseInt(txtIdRubroMod.getText()));
        rub.setNombreRubro(txtNombreRubroMod.getText());
        rub.setIdCategoria(idCategoria);
                
        cRubro.modificarRubro(rub);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxCategoriaRubroMod = new javax.swing.JComboBox<>();
        btnGuardarRubroMod = new javax.swing.JButton();
        txtNombreRubroMod = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdRubroMod = new javax.swing.JTextField();
        btnVolverRubro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Nombre  ");
        jLabel3.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Categoria");
        jLabel4.setMaximumSize(new java.awt.Dimension(100, 100));

        cbxCategoriaRubroMod.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxCategoriaRubroMod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCategoriaRubroMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaRubroModActionPerformed(evt);
            }
        });

        btnGuardarRubroMod.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnGuardarRubroMod.setText("Guardar");
        btnGuardarRubroMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarRubroModActionPerformed(evt);
            }
        });

        txtNombreRubroMod.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(208, 211, 212));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rubro.png"))); // NOI18N
        jLabel1.setText(" Modificar Rubro");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tiendas Retail Mis Ofertas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtIdRubroMod.setText("jTextField1");
        txtIdRubroMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdRubroModActionPerformed(evt);
            }
        });

        btnVolverRubro.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnVolverRubro.setText("Volver");
        btnVolverRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverRubroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCategoriaRubroMod, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreRubroMod, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btnGuardarRubroMod, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btnVolverRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(txtIdRubroMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(txtIdRubroMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreRubroMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCategoriaRubroMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarRubroMod, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolverRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCategoriaRubroModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaRubroModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoriaRubroModActionPerformed

    private void btnGuardarRubroModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRubroModActionPerformed

       
            
        
       
        try {
            verificaDatos();
            this.setVisible(false);
            readRubro rb = null;
            rb = new readRubro(mod);
            rb.setVisible(true);
            rb.pack();
           } catch (ClassNotFoundException ex) {
            Logger.getLogger(updateRubro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(updateRubro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(updateRubro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(updateRubro.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }//GEN-LAST:event_btnGuardarRubroModActionPerformed

    private void txtIdRubroModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdRubroModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdRubroModActionPerformed

    private void btnVolverRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverRubroActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        readRubro rb = null;
        try {
            rb = new readRubro(mod);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(createRubro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(createRubro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(createRubro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(createRubro.class.getName()).log(Level.SEVERE, null, ex);
        }
        rb.setVisible(true);
        rb.pack();
    }//GEN-LAST:event_btnVolverRubroActionPerformed

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
            java.util.logging.Logger.getLogger(updateRubro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateRubro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateRubro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateRubro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new updateRubro().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(updateRubro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(updateRubro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(updateRubro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(updateRubro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarRubroMod;
    private javax.swing.JButton btnVolverRubro;
    public static javax.swing.JComboBox<String> cbxCategoriaRubroMod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField txtIdRubroMod;
    public static javax.swing.JTextField txtNombreRubroMod;
    // End of variables declaration//GEN-END:variables
}
