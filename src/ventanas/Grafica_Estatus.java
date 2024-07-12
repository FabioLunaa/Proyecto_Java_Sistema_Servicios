package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Grafica_Estatus extends javax.swing.JFrame {

    String user;
    int NuevoIngreso, NoReparado, EnRevision, Reparado, Entregado;

    String[] vector_grafica_estatus = new String[5];//creamos 5 vectores q contendran estados
    int[] vector_grafica_cantidad = new int[5];//creamos 5 vectores q contendran cantidades.

    public Grafica_Estatus() {
        initComponents();
        user = Login.user;

        setTitle("Tecnico - Sesión de " + user);
        setSize(440,400);
        setResizable(true);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_wallpaper.getWidth(),
                jLabel_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    //selecccionar estatus, contar (estatus) como cantidad de la tabla equipos, agrupando por estatus.
                    "Select estatus, count(estatus) as Cantidad from equipos group by estatus");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int posicion = 0;//var con la q iniciaremos las posiciones de los vectores.
                do {
                    //obtendremos de la bd lo q contenga la columna 1 y se guardará en el vector.
                    vector_grafica_estatus[posicion] = rs.getString(1);
                    //obtendremos de la bd lo q contenga la columna 2 y se guardará en el vector.
                    vector_grafica_cantidad[posicion] = rs.getInt(2);
                    //si lo q se consulta a la bd es igual al estatus "Nuevo ingreso", entonces guardaremos en la var NuevoIngreso la 
                    //cantidad de veces q aparece este estatus. puede ser 1,2, o más cantidades. esto nos sirve para poder graficar
                    //más adelante.
                    if (vector_grafica_estatus[posicion].equalsIgnoreCase("Nuevo ingreso")) {
                        NuevoIngreso = vector_grafica_cantidad[posicion];
                    } else if (vector_grafica_estatus[posicion].equalsIgnoreCase("No reparado")) {
                        NoReparado = vector_grafica_cantidad[posicion];
                    } else if (vector_grafica_estatus[posicion].equalsIgnoreCase("En revisión")) {
                        EnRevision = vector_grafica_cantidad[posicion];
                    } else if (vector_grafica_estatus[posicion].equalsIgnoreCase("Reparado")) {
                        Reparado = vector_grafica_cantidad[posicion];
                    } else if (vector_grafica_estatus[posicion].equalsIgnoreCase("Entregado")) {
                        Entregado = vector_grafica_cantidad[posicion];
                    }
                    posicion++;

                } while (rs.next());
            } 
        } catch (SQLException e) {
            System.err.println("ERROR al conectar a Base de datos." + e);
            JOptionPane.showMessageDialog(null, "¡ERROR! contacte al administrador.");
        }
        repaint();//invocamos a este metodo ya q contiene la clase paint para dibujar sobre el JFrame.   
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

        jLabel_Titulo = new javax.swing.JLabel();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Grafica de estatus");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 20));

        jLabel_footer.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel_footer.setText("Creado por Luna Fabio");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 442, 400));

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
            java.util.logging.Logger.getLogger(Grafica_Estatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grafica_Estatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grafica_Estatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grafica_Estatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grafica_Estatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_wallpaper;
    // End of variables declaration//GEN-END:variables
//creamos este metod. para tener un orden de las dimensiones en tamaño de cada var y  retorne esa var.
    public int EstatusMasRepetido(int NuevoIngreso, int NoReparado, int EnRevision,int Reparado,int Entregado){
        if (NuevoIngreso > NoReparado && NuevoIngreso > EnRevision && NuevoIngreso > Reparado && NuevoIngreso > Entregado) {
            return NuevoIngreso;
        } else if ( NoReparado > EnRevision && NoReparado > Reparado && NoReparado > Entregado ) {
            return NoReparado;
        } else if (EnRevision > Reparado && EnRevision > Entregado) {
            return EnRevision;
        } else if (Reparado > Entregado) {
            return Reparado;
        } return Entregado;   
    }
    @Override//sobreescribimos el metod. paint()
public void paint(Graphics g ){
    super.paint(g);//la palab reservada super nos permite hacer uso de toda la clase paint
     //guardamos en este ver el estatus que más se repitió de estos 5. esto lo sabemos gracias al metodo EstatusMasRepetido().
    int Estatus_mas_repetido = EstatusMasRepetido (NuevoIngreso, NoReparado, EnRevision, Reparado, Entregado);

      int largo_NuevoIngreso = NuevoIngreso * 200 / Estatus_mas_repetido; 
      int largo_NoReparado = NoReparado * 200 / Estatus_mas_repetido; 
      int largo_EnRevision = EnRevision * 200 / Estatus_mas_repetido; 
      int largo_Reparado = Reparado * 200 / Estatus_mas_repetido; 
      int largo_Entregado = Entregado * 200 / Estatus_mas_repetido; 
      
      g.setColor(new Color(255,0,0));
      g.fillRect(100, 90, largo_NuevoIngreso, 20);
      g.drawString("Nuevo Ingreso", 10, 100);
      g.drawString("Cantidad: " + NuevoIngreso, 10, 110);
      
      g.setColor(new Color(0,255,0));
      g.fillRect(100, 140, largo_NoReparado, 20);
      g.drawString("No Reparado", 10, 150);
      g.drawString("Cantidad: " + NoReparado, 10, 160);

      g.setColor(new Color(0,0,255));
      g.fillRect(100, 190, largo_EnRevision, 20);
      g.drawString("En revision", 10, 200);
      g.drawString("Cantidad: " + EnRevision, 10, 210);
      
      g.setColor(new Color(0,0,0));
      g.fillRect(100, 240, largo_Reparado, 20);
      g.drawString("Reparado", 10, 250);
      g.drawString("Cantidad: " + Reparado, 10, 260);
      
      g.setColor(new Color(255,255,255));
      g.fillRect(100, 290, largo_Entregado, 20);
      g.drawString("Entregado", 10, 300);
      g.drawString("Cantidad: " + Entregado, 10, 310);
}
}
