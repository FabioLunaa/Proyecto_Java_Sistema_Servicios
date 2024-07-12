
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

public class Administrador extends javax.swing.JFrame {

   String user, nombre_usuario;//creamos dos var. para usarlas en esta ventana. 
   public static int sesion_usuario;//var. bandera para usarla con otras clases.
   
    public Administrador() {
        initComponents();
        user = Login.user;
        sesion_usuario = 1;
        
        setSize(622,467);
        setResizable(false);
        setTitle("Administrador - sesión de " + user );//asi aparecerá en el titulo.
        setLocationRelativeTo(null);
//este metod. sirve para q cuando esta interfaz sea cerrada se cierre en su totalidad.
//metodo evita q la interfaz se siga ejecutando en 2do plano auqnue la interfaz haya sido cerrada.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_wallpaper.getWidth(), 
                jLabel_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "select nombre_usuario from usuarios where username = '" + user + "'");
            
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombre_usuario = rs.getString("nombre_usuario");
                jLabel_NombreUsuario.setText(nombre_usuario);
                
            } 
            
        } catch (Exception e) {
            System.err.println("Error de conexion desde la red admisnitrador.");
        }
        
    }
     @Override
    public Image getIconImage(){
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

        jLabel_NombreUsuario = new javax.swing.JLabel();
        jButton_usuario = new javax.swing.JButton();
        jButton_gestionUsuario = new javax.swing.JButton();
        jButton_creatividad = new javax.swing.JButton();
        jButton_capturista = new javax.swing.JButton();
        jButton_tecnico = new javax.swing.JButton();
        jButton_acerca = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_NombreUsuario.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_NombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreUsuario.setText("JLabel");
        getContentPane().add(jLabel_NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 20));

        jButton_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addUser.png"))); // NOI18N
        jButton_usuario.setBorder(null);
        jButton_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_usuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 120, 100));

        jButton_gestionUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informationuser.png"))); // NOI18N
        jButton_gestionUsuario.setBorder(null);
        jButton_gestionUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gestionUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_gestionUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 120, 100));

        jButton_creatividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/creatividad.png"))); // NOI18N
        jButton_creatividad.setBorder(null);
        getContentPane().add(jButton_creatividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 120, 100));

        jButton_capturista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/capturista.png"))); // NOI18N
        jButton_capturista.setBorder(null);
        jButton_capturista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_capturistaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_capturista, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 120, 100));

        jButton_tecnico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tecnico.png"))); // NOI18N
        jButton_tecnico.setBorder(null);
        jButton_tecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_tecnicoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_tecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 120, 100));

        jButton_acerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/geekipedia.png"))); // NOI18N
        jButton_acerca.setBorder(null);
        jButton_acerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_acercaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_acerca, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 120, 100));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0,0,0));
        jLabel1.setText("Registrar Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0,0,0));
        jLabel2.setText("Gestionar Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0,0,0));
        jLabel3.setText("Creatividad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0,0,0));
        jLabel4.setText("Panel vista capturista");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 360, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0,0,0));
        jLabel5.setText("Panel vista técnico");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 360, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0,0,0));
        jLabel6.setText("Acerca de");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Creado por Luna Fabio");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, -1, -1));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_usuarioActionPerformed
        Registro_Usuario registroUsuario = new Registro_Usuario();
        registroUsuario.setVisible(true);
    }//GEN-LAST:event_jButton_usuarioActionPerformed

    private void jButton_gestionUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_gestionUsuarioActionPerformed
        Gestion_Usuario gestionUsuario = new Gestion_Usuario();
        gestionUsuario.setVisible(true);
    }//GEN-LAST:event_jButton_gestionUsuarioActionPerformed

    private void jButton_capturistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_capturistaActionPerformed
        Capturista capturista = new Capturista();
        capturista.setVisible(true);
    }//GEN-LAST:event_jButton_capturistaActionPerformed

    private void jButton_tecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_tecnicoActionPerformed
       
        Tecnico tecnico = new Tecnico();
        tecnico.setVisible(true);
                
    }//GEN-LAST:event_jButton_tecnicoActionPerformed

    private void jButton_acercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_acercaActionPerformed
        
        AcercaDe acercaDe = new AcercaDe();
        acercaDe.setVisible(true);
    }//GEN-LAST:event_jButton_acercaActionPerformed

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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_acerca;
    private javax.swing.JButton jButton_capturista;
    private javax.swing.JButton jButton_creatividad;
    private javax.swing.JButton jButton_gestionUsuario;
    private javax.swing.JButton jButton_tecnico;
    private javax.swing.JButton jButton_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_NombreUsuario;
    private javax.swing.JLabel jLabel_wallpaper;
    // End of variables declaration//GEN-END:variables
}
