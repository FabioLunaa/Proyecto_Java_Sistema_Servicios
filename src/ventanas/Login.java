package ventanas;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.*;
import clases.Conexion;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
//creamos la 1° var. para enviar datos entre interfaces
    public static String user = "";
    String pass = "";//esta var. contendrá el pass temporal q se usará por los usuarios.
    
    public Login() {
        initComponents();
        setSize(400,550);
        setResizable(false);
        setTitle("Acceso al Sistema");
        setLocationRelativeTo(null);
        
        

        // Placeholder for txt_user
        txt_user.setText("Usuario");
        txt_user.setForeground(Color.darkGray);
        txt_user.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txt_user.getText().equals("Usuario")) {
                    txt_user.setText("");
                    txt_user.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txt_user.getText().isEmpty()) {
                    txt_user.setText("Usuario");
                    txt_user.setForeground(Color.GRAY);
                }
            }
        });

        // Placeholder for txt_pass
        txt_pass.setText("Contraseña");
        txt_pass.setForeground(Color.darkGray);
        txt_pass.setEchoChar((char) 0);

        txt_pass.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(txt_pass.getPassword()).equals("Contraseña")) {
                    txt_pass.setText("");
                    txt_pass.setForeground(Color.BLACK);
                    txt_pass.setEchoChar('●');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(txt_pass.getPassword()).isEmpty()) {
                    txt_pass.setText("Contraseña");
                    txt_pass.setForeground(Color.GRAY);
                    txt_pass.setEchoChar((char) 0);
                }
            }
        });
        
//creamos un ob. y buscamos la ruta de la imagen a ocupar
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
//creamos un ob. y le asignamos la distribucion y la escala de la imagen q ocupará toda la gráfica.
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_wallpaper.getWidth(), 
                jLabel_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_wallpaper.setIcon(icono);//le asignamos la escala al JLabel_w...
        this.repaint();//metodo para asegurar la acción.
        
        ImageIcon wallpaper_logg = new ImageIcon("src/images/DS.png");
        Icon icono_logo = new ImageIcon(wallpaper_logg.getImage().getScaledInstance(jLabel_logg.getWidth(), 
                jLabel_logg.getHeight(), Image.SCALE_DEFAULT ));
        jLabel_logg.setIcon(icono_logo);
        this.repaint();
    }
    
    @Override
    public Image getIconImage(){
//luego de crear el metodo lo programamos, creamos un ob. y obtenemos la imagen del icono a colocar en interfaz.
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;//si o si hay q hacer el retorno del objeto.
/*de igual forma debemos ir a JFrame, clic derecho y propiedades, IconImage clic en ..., value from existing component,
        property, Iconimage, ok*/
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_user = new javax.swing.JTextField();
        txt_pass = new javax.swing.JPasswordField();
        jLabel_logg = new javax.swing.JLabel();
        jButton_acceder = new javax.swing.JButton();
        jLabel_creador = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_user.setBackground(new java.awt.Color(153, 153, 255));
        txt_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_user.setForeground(new java.awt.Color(255, 255, 255));
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_user.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_user.setDisabledTextColor(new java.awt.Color(51, 0, 51));
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 190, -1));

        txt_pass.setBackground(new java.awt.Color(153, 153, 255));
        txt_pass.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_pass.setForeground(new java.awt.Color(255, 255, 255));
        txt_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pass.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 190, -1));

        jLabel_logg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel_logg, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 250, 240));

        jButton_acceder.setBackground(new java.awt.Color(153, 153, 255));
        jButton_acceder.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jButton_acceder.setForeground(new java.awt.Color(0,0,0));
        jButton_acceder.setText("Acceder");
        jButton_acceder.setBorder(null);
        jButton_acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_accederActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 190, 40));

        jLabel_creador.setText("Creado por Luna Fabio Mario ");
        getContentPane().add(jLabel_creador, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, -1, -1));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_accederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_accederActionPerformed
        
        user = txt_user.getText().trim();//guardamos en las var. lo q venga de los txtfiled.
        pass = txt_pass.getText().trim();
        
        if (!user.equals("") || !pass.equals("")) {
            
            try {

                Connection cn = Conexion.conectar();//invocamos el metodo conectar de la interfaz anterior realizada.
                PreparedStatement pst = cn.prepareStatement(
                    "select tipo_nivel, estatus from usuarios where username = '" + user
                            + "' and password = '" + pass + "'");
                
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
    //guardamos en nuevas var. lo que encontramos en "tipo_nivel" y "estatus" de la bd.
                    String tipo_nivel = rs.getString("tipo_nivel");
                    String estatus = rs.getString("estatus");
                    
                    if (tipo_nivel.equalsIgnoreCase("Administrador") && estatus.equalsIgnoreCase("Activo")) {
    /*este metodo hace q el JFrame sea limpiado o destruido por el sistema op. cierra la interfaz de login y abre la
     que indicammos a continuacion.*/
                        dispose();
                        new Administrador().setVisible(true); 
                        
                    } else if (tipo_nivel.equalsIgnoreCase("Capturista") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Capturista().setVisible(true);
                    
                    } else if (tipo_nivel.equalsIgnoreCase("Tecnico") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Tecnico().setVisible(true);
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos.");
                    txt_user.setText("");//limpiamos los campos
                    txt_pass.setText("");
                }
            } catch (SQLException e) {
                System.err.println("ERROR en el botón acceder." + e);
                JOptionPane.showMessageDialog(null, "ERROR al acceder, contacte al administrador.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
        }
    }//GEN-LAST:event_jButton_accederActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_acceder;
    private javax.swing.JLabel jLabel_creador;
    private javax.swing.JLabel jLabel_logg;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
