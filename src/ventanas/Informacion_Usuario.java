package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Informacion_Usuario extends javax.swing.JFrame {
//creamos estas var. para darles new utilidades en esta new interfaz

    String user = "", user_update = "";
    int ID;//esta var. la utilizaremos en la proxima clase.

    public Informacion_Usuario() {
        initComponents();
        setSize(630, 450);
        user = Login.user;//lo q hacemos con esta var. tamb lo hacemos con la var. de abajo.
        user_update = Gestion_Usuario.user_update;
        setTitle("Informacion del Usuario " + user_update + "  - Sesion de " + user);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        jLabel_titulo.setText("Informacion del Usuario " + user_update);
//usamos el try catch ya q trabajaremos con bd.
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "Select * from usuarios where username = '" + user_update + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
//guardamos la info del id_usuario en la nueva var. ID
                ID = rs.getInt("id_usuario");
//cargamos los jTextField con la info q tenemos en la bd.
                jTextField_nombre.setText(rs.getString("nombre_usuario"));
                jTextField_email.setText(rs.getString("email"));
                jTextField_telefono.setText(rs.getString("telefono"));
                jTextField_registradoPor.setText(rs.getString("registrado_por"));
                jTextField_username.setText(rs.getString("username"));

                cmb_estatus.setSelectedItem(rs.getString("estatus"));
                cmb_niveles.setSelectedItem(rs.getString("tipo_nivel"));

            }

        } catch (SQLException e) {
            System.err.println("ERROR al cargar usuario.");
            JOptionPane.showMessageDialog(null, "ERROR con la carga del susuario. ¡Contacte al Administrador!");
        }
    }

    @Override
    public Image getIconImage() {
//luego de crear el metodo lo programamos, creamos un ob. y obtenemos la imagen del icono a colocar en interfaz.
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;//se o si hay q hacer el retorno del objeto.
/*de igual forma debemos ir a JFrame, clic derecho y propiedades, IconImage clic en ..., value from existing component,
        property, Iconimage, ok ok*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_Nombre1 = new javax.swing.JLabel();
        jLabel_Nombre2 = new javax.swing.JLabel();
        jLabel_Nombre3 = new javax.swing.JLabel();
        jLabel_Nombre4 = new javax.swing.JLabel();
        jLabel_Nombre5 = new javax.swing.JLabel();
        jLabel_Nombre6 = new javax.swing.JLabel();
        jTextField_nombre = new javax.swing.JTextField();
        jTextField_email = new javax.swing.JTextField();
        jTextField_telefono = new javax.swing.JTextField();
        jTextField_username = new javax.swing.JTextField();
        jTextField_registradoPor = new javax.swing.JTextField();
        cmb_niveles = new javax.swing.JComboBox<>();
        cmb_estatus = new javax.swing.JComboBox<>();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_RestaurarPassword = new javax.swing.JButton();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setBackground(new java.awt.Color(153, 153, 255));
        jLabel_titulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Informacion del Usuario");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel_Nombre.setBackground(new java.awt.Color(153, 153, 255));
        jLabel_Nombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel_Nombre1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel_Nombre1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre1.setText("em@il:\n");
        getContentPane().add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel_Nombre2.setBackground(new java.awt.Color(153, 153, 255));
        jLabel_Nombre2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Telefono:\n");
        getContentPane().add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel_Nombre3.setBackground(new java.awt.Color(153, 153, 255));
        jLabel_Nombre3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setText("Permisos de:\n");
        getContentPane().add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel_Nombre4.setBackground(new java.awt.Color(153, 153, 255));
        jLabel_Nombre4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Username:");
        getContentPane().add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        jLabel_Nombre5.setBackground(new java.awt.Color(153, 153, 255));
        jLabel_Nombre5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_Nombre5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre5.setText("Estatus:");
        getContentPane().add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        jLabel_Nombre6.setBackground(new java.awt.Color(153, 153, 255));
        jLabel_Nombre6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_Nombre6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre6.setText("Registrado por:");
        getContentPane().add(jLabel_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, -1, -1));

        jTextField_nombre.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_nombre.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 250, 30));

        jTextField_email.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_email.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 250, 30));

        jTextField_telefono.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_telefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_telefono.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 250, 30));

        jTextField_username.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_username.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 250, 30));

        jTextField_registradoPor.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_registradoPor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_registradoPor.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_registradoPor.setEnabled(false);
        getContentPane().add(jTextField_registradoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 250, 30));

        cmb_niveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Tecnico" }));
        getContentPane().add(cmb_niveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, -1));

        jButton_Actualizar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setText("Actualizar Usuario");
        jButton_Actualizar.setBorder(null);
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 250, 40));

        jButton_RestaurarPassword.setBackground(new java.awt.Color(153, 153, 255));
        jButton_RestaurarPassword.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jButton_RestaurarPassword.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RestaurarPassword.setText("Restaurar Password");
        jButton_RestaurarPassword.setBorder(null);
        jButton_RestaurarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RestaurarPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RestaurarPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 250, 40));

        jLabel_footer.setText("Creado por Luna Fabio");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed
//en las 2 primeras var. vamos selecc los valores de los cmb y los guardamos en las 2 var. permisos_string y estatus_s.
        int permisos_cmb, estatus_cmb, validacion = 0;
//las 2 ultimas var. nos servirán para guardar los valores q estarán en los cmb.
        String nombre, email, telefono, username, pass, permisos_string = "", estatus_string = "";

        email = jTextField_email.getText().trim();//guardamos en la new var. lo q esta en el jTextField
        nombre = jTextField_nombre.getText().trim();
        telefono = jTextField_telefono.getText().trim();
        username = jTextField_username.getText().trim();
        permisos_cmb = cmb_niveles.getSelectedIndex();
        estatus_cmb = cmb_estatus.getSelectedIndex();

        if (email.equals("")) {
            jTextField_email.setBackground(Color.red);
            validacion++;
        }
        if (nombre.equals("")) {
            jTextField_nombre.setBackground(Color.red);
            validacion++;
        }
        if (telefono.equals("")) {
            jTextField_telefono.setBackground(Color.red);
            validacion++;
        }
        if (username.equals("")) {
            jTextField_username.setBackground(Color.red);
            validacion++;
        }
//cuando la valaidacion sea 0 ejecutará las sig lineas de codigo        
        if (validacion == 0) {

            if (permisos_cmb == 1) {
                permisos_string = "Administrador";
            } else if (permisos_cmb == 2) {
                permisos_string = "Capturista";
            } else if (permisos_cmb == 3) {
                permisos_string = "Tecnico";
            }
            if (estatus_cmb == 1) {
                estatus_string = "Activo";
            } else if (estatus_cmb == 2) {
                estatus_string = "Inactivo";
            }
            
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select username from usuarios where username = '" + username + "' and not id_usuario = '" + ID +"'");
//en caso de q username de la bd sea = a la de la interfaz entrará en el siguiente if
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    jTextField_username.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "ERROR username no disponible.");
                    cn.close();
                } else {
                Connection cn2 = Conexion.conectar();
                PreparedStatement pst2 = cn2.prepareStatement(
//acá actualizamos la bd, los ? significa q no se sabe q datos guardará el usuario.
//ID es la seleccion q hace el usuario dentro de la tabla de la bd. 
                       "update usuarios set nombre_usuario=?, email=?, telefono=?, username=?, tipo_nivel=?, estatus=?"
                               + " where id_usuario = '" +ID+"'");
//lo q esta dentro de cada var. y en su orden, se guardará en ese mismo orden dentro de la tabla de la bd.
                pst2.setString(1, nombre);
                pst2.setString(2, email);
                pst2.setString(3, telefono);
                pst2.setString(4, username);
                pst2.setString(5, estatus_string);
                pst2.setString(6, permisos_string);

                pst2.executeUpdate();
                cn2.close();

                JOptionPane.showMessageDialog(null, "Actualizacion Exitosa.");
                }
            } catch (SQLException e) {
                System.err.println("ERROR al actualizar usuario." + e);
                System.out.println("ERROR al actualizar, ¡Contacte al Administrador!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
        }
    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void jButton_RestaurarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RestaurarPasswordActionPerformed
        
          Restaurar_Password restaurarPasword = new Restaurar_Password();
          restaurarPasword.setVisible(true);
                  
    }//GEN-LAST:event_jButton_RestaurarPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(Informacion_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion_Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JComboBox<String> cmb_niveles;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_RestaurarPassword;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre1;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JLabel jLabel_Nombre6;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_nombre;
    private javax.swing.JTextField jTextField_registradoPor;
    private javax.swing.JTextField jTextField_telefono;
    private javax.swing.JTextField jTextField_username;
    // End of variables declaration//GEN-END:variables
}
