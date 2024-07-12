package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;//la utilizaremos cuando manipulemos nuestra tabla
import java.awt.event.MouseEvent;//
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

public class Gestion_Usuario extends javax.swing.JFrame {
    
    String user;
//esta var. permite enviar datos entre interf. permite saber qué usuario queremos consultar en la tabla.  
    public static String user_update = "";
/*creamos un ob. de la clase DTM nos permite acceso a todos los metod necesarios para mod. datos en su interior
    añadir filas, columnas y darle el nomb q querramos a las F y C.*/
    DefaultTableModel model = new DefaultTableModel();
   
    public Gestion_Usuario() {
        initComponents();
        user = Login.user;
        
        setSize(630,330);
        setTitle("Usuarios Registrados - sesion de " + user);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), 
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint(); 
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select id_usuario, nombre_usuario, username, tipo_nivel, estatus from usuarios");
            ResultSet rs = pst.executeQuery();
//guardamos en JTable el objeto creado al inicio.
            jTable_Usuarios = new JTable(model);
//la tabla estará dentro del jScroll y esta se adaptará a esta.
            jScrollPane.setViewportView(jTable_Usuarios);
//como el obj. model sirve para hacer modif, entonces agregaremos columnas a nuestra tabla.
            model.addColumn(" ");
            model.addColumn("Nombre");
            model.addColumn("Username");
            model.addColumn("Permisos");
            model.addColumn("Estatus");
//si se da correctament lo q buscamos en la bd, entonces con la estruct condicional haremos lo sig.
            while (rs.next()) {
/*creamos un vector de tipo Object[], Object xq en la tabla aparece de tipo Object, q nos servirá 
para ir vaciando las filas de la  bd y cargand a la new tabla, creamos un vector llamado fila q será 
igual a un Objet con [5] xq son 5 columnas*/
                Object[] fila = new Object[5];
//en esta E.R. decimos q i va a recorrer hasta 5 q son el num de columnas.
                for (int i = 0; i < 5; i++) {
//vamos a ir obteniendo los Object de rs o sea de la bd, y lo vamos a ir guardand en la fila.
                    fila[i] = rs.getObject(i + 1);
                }
//con el ob. model y junto al metodo vamos a ir agregando las filas a nuestra tabla.
                model.addRow(fila);
            }
            cn.close();//cerramos nuestra conexion.
            
        } catch (SQLException e) {
            System.err.println("ERROR al llenar tabla" + e);
            System.out.println("ERROR, al mostrar informacion. ¡Contacte a su administrador.!" + e);
        }
//invocamos la interfaz MouseListener con la clase MouseAdapter.
        jTable_Usuarios.addMouseListener(new MouseAdapter() {
            
            @Override//sobreescribimos el metodo siguiente, es decir redefinimos el metodo.
            //lo debemos escribir manualmete nosotros.
            public void mouseClicked(MouseEvent e){//creamos el evento q luego tendremos con el metodo.
/*obtenemos el punto cuando activamos el evento o sea cuando damos el clic, este punto en la fila de la 
tabla lo guardamos en la var. fila_point*/ 
                int fila_point = jTable_Usuarios.rowAtPoint(e.getPoint());
//colocamos 2 xq queremos seleccionar esta columna.
                int columna_point = 2;
//cuando se haya obtenido la fila y la columna emepzaremos a hacer lo siguiente.
//la fila_point siempre será mayor a -1 o sea a menos de eso no va a recorrer a mayor de eso, si.
                if (fila_point > -1) {
/*hacemos un casting de tipo string, ya q con model cambiaremos el tipo de dato a string.
 *obtendremos el valor de fila y columna, lo transformaremos a otro tipo de dato y lo guardaremos 
  en la var. usuer_update */
                    user_update = (String)model.getValueAt(fila_point, columna_point);
//creamos un obj. de la clase Informacion_Usuario, esto nos ayudará a crear una nueva interfaz.
                    Informacion_Usuario informacion_Usuario = new Informacion_Usuario();
                    informacion_Usuario.setVisible(true);
                }
            }
});
        
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTable_Usuarios = new javax.swing.JTable();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuarios Registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        jTable_Usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane.setViewportView(jTable_Usuarios);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 180));

        jLabel_footer.setText("Creado por Luna Fabio M.");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Gestion_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion_Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable_Usuarios;
    // End of variables declaration//GEN-END:variables
}
