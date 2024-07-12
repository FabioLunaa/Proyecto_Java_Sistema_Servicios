package ventanas;

import java.sql.*;
import clases.Conexion;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Paragraph;
import java.awt.Color;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystemException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


public class Informacion_Cliente extends javax.swing.JFrame {

    int IDcliente_update = 0;//var para traer datos de otra interdaz.
    public static int IDequipos = 0;//var creada para enviar datos a otras interfaz.
    String user = ""; //var para traer datos de otra interdaz.
    //el ob de esta clase nos sirve para modif la tabla.
    DefaultTableModel model = new DefaultTableModel();

    public Informacion_Cliente() {
        initComponents();
        user = Login.user;
        IDcliente_update = Gestionar_Clientes.IDcliente_update;//var q traemos de otra interfaz.

        setSize(650, 450);
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
                    "select * from cliente where id_cliente = '" + IDcliente_update + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                //obteniendo la info de la bd obtenemos el nombre del cliente q pondremos en la interfaz.
                setTitle("Informacion del cliente " + rs.getString("nombre_cliente") + " - Sesion de " + user);
                jLabel_titulo_info_cliente.setText("Informacion del cliente " + rs.getString("nombre_cliente"));
                //llenamos los jtxtField con la info y consulta q hacemos en la bd.
                txt_nombre.setText(rs.getString("nombre_cliente"));
                txt_email.setText(rs.getString("email_cliente"));
                txt_telefono.setText(rs.getString("tel_cliente"));
                txt_direccion.setText(rs.getString("dir_cliente"));
                txt_ultimaModificacion.setText(rs.getString("ultima_modificacion"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar usuario." + e);
            JOptionPane.showMessageDialog(null, "Error al cargar. !Contacte al Admisnistrador.¡");
        }
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    //ponemos solo lo q queremos consultar, para luego con esta info llenar la tabla en forma de fila.
                    "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" + IDcliente_update + "'");
            ResultSet rs = pst.executeQuery();
            //colocamos la tabla dentro del jscroolpane.
            jTable_equipos = new JTable(model);
            jScrollPane_equipos.setViewportView(jTable_equipos);

            model.addColumn("ID equipos ");//nombres de las clumnas.
            model.addColumn("Nombre equipo");
            model.addColumn("Marca");
            model.addColumn("Estatus");

            while (rs.next()) {
                //cremos nuestro Objet o vector, serán 4.
                Object[] fila = new Object[4];
                //con el for completamos las filas, simpre gracias a la consulta a la bd - rs. -
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                model.addRow(fila);//agregamos con el objeto model. las filas.
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error en el llenado de la tabla equipos." + e);

        }
        //creamos el evento del  mouse.
        jTable_equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_equipos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    //la obtencion d los valores lo guardamos en la var IDequipos. ya q es la info
                    //q se mostrará cuando el usuario haga clic y quiera consultar algun equipo
                    IDequipos = (int) model.getValueAt(fila_point, columna_point);
                    Informacion_Equipo informacionEquipo = new Informacion_Equipo();
                    informacionEquipo.setVisible(true);
                }
            }
        });
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

        jLabel_titulo_info_cliente = new javax.swing.JLabel();
        jScrollPane_equipos = new javax.swing.JScrollPane();
        jTable_equipos = new javax.swing.JTable();
        jLabel_nombre = new javax.swing.JLabel();
        jLabel_email = new javax.swing.JLabel();
        jLabel_telefono = new javax.swing.JLabel();
        jLabel_direccion = new javax.swing.JLabel();
        jLabel_ultimaModif = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_ultimaModificacion = new javax.swing.JTextField();
        jLabel_footer = new javax.swing.JLabel();
        jButton_imprimirCliente = new javax.swing.JButton();
        jButton_RegistrarEquipo = new javax.swing.JButton();
        jButton_ActualizarCliente1 = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo_info_cliente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo_info_cliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo_info_cliente.setText("Información del Cliente");
        getContentPane().add(jLabel_titulo_info_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTable_equipos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane_equipos.setViewportView(jTable_equipos);

        getContentPane().add(jScrollPane_equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 380, 180));

        jLabel_nombre.setBackground(new java.awt.Color(153, 153, 255));
        jLabel_nombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nombre.setText("Nombre:");
        getContentPane().add(jLabel_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel_email.setBackground(new java.awt.Color(153, 153, 255));
        jLabel_email.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_email.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_email.setText("Email:");
        getContentPane().add(jLabel_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel_telefono.setBackground(new java.awt.Color(153, 153, 255));
        jLabel_telefono.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_telefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_telefono.setText("Telefono");
        getContentPane().add(jLabel_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel_direccion.setBackground(new java.awt.Color(153, 153, 255));
        jLabel_direccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_direccion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_direccion.setText("Dirección:");
        getContentPane().add(jLabel_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel_ultimaModif.setBackground(new java.awt.Color(153, 153, 255));
        jLabel_ultimaModif.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_ultimaModif.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ultimaModif.setText("Ultima modificación por:");
        getContentPane().add(jLabel_ultimaModif, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 200, 30));

        txt_email.setBackground(new java.awt.Color(153, 153, 255));
        txt_email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_email.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 200, 30));

        txt_telefono.setBackground(new java.awt.Color(153, 153, 255));
        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 200, 30));

        txt_direccion.setBackground(new java.awt.Color(153, 153, 255));
        txt_direccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(255, 255, 255));
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 200, 30));

        txt_ultimaModificacion.setBackground(new java.awt.Color(153, 153, 255));
        txt_ultimaModificacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_ultimaModificacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_ultimaModificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ultimaModificacion.setEnabled(false);
        getContentPane().add(txt_ultimaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 200, 30));

        jLabel_footer.setText("Creado por Luna Fabio");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, -1, -1));

        jButton_imprimirCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        jButton_imprimirCliente.setBorder(null);
        jButton_imprimirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_imprimirClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_imprimirCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 120, 100));

        jButton_RegistrarEquipo.setBackground(new java.awt.Color(153, 153, 255));
        jButton_RegistrarEquipo.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jButton_RegistrarEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RegistrarEquipo.setText("Registrar Equipo");
        jButton_RegistrarEquipo.setBorder(null);
        jButton_RegistrarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RegistrarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 230, 35));

        jButton_ActualizarCliente1.setBackground(new java.awt.Color(153, 153, 255));
        jButton_ActualizarCliente1.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jButton_ActualizarCliente1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ActualizarCliente1.setText("Actualizar Cliente");
        jButton_ActualizarCliente1.setBorder(null);
        jButton_ActualizarCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarCliente1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ActualizarCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 230, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RegistrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarEquipoActionPerformed
        Registro_Equipo registroEquipo = new Registro_Equipo();
        registroEquipo.setVisible(true);
    }//GEN-LAST:event_jButton_RegistrarEquipoActionPerformed

    private void jButton_ActualizarCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarCliente1ActionPerformed
        //creamos 2 var, una bandera y otras para guardar lo q contengan los textfield.
        int validacion = 0;
        String nombre, email, telefono, direccion;

        nombre = txt_nombre.getText().trim();
        email = txt_email.getText().trim();
        telefono = txt_telefono.getText().trim();
        direccion = txt_direccion.getText().trim();

        //si las var q recien creamos estan vacias, entonces su textfield se pondra en rojo.
        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;
            //en este caso la validacion sera !0
        }
        if (email.equals("")) {
            txt_email.setBackground(Color.red);
            validacion++;
        }
        if (telefono.equals("")) {
            txt_telefono.setBackground(Color.red);
            validacion++;
        }
        if (direccion.equals("")) {
            txt_direccion.setBackground(Color.red);
            validacion++;
        }

        if (validacion == 0) {

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        //decimos lo siguiente a la bd.
                        "update cliente set nombre_cliente=?, email_cliente=?, tel_cliente=?, dir_cliente=?, ultima_modificacion=?"
                        + "where id_cliente = '" + IDcliente_update + "'");
                //guardamos en la bd estos parametros.
                pst.setString(1, nombre);
                pst.setString(2, email);
                pst.setString(3, telefono);
                pst.setString(4, direccion);
                pst.setString(5, user);

                pst.executeUpdate();
                cn.close();

                Limpiar();//creamos el metodo limpiar, sus codigo está al final de todo.

                txt_nombre.setBackground(Color.green);
                txt_email.setBackground(Color.green);
                txt_telefono.setBackground(Color.green);
                txt_direccion.setBackground(Color.green);
                txt_ultimaModificacion.setText(user);
                //en caso de q todo este ok, se ponnen los textfield de color verde y se da el sig. mensaje.
                JOptionPane.showMessageDialog(null, "Modificacion Exitosa.");
                this.dispose();//metodo para q se vaya la actual interfaz y quede la anterior.

            } catch (SQLException e) {
                System.err.println("ERROR al cargar cliente." + e);
                JOptionPane.showMessageDialog(null, "ERROR al actualizar cliente. ¡Contacte al Administrador!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos.");
        }
    }//GEN-LAST:event_jButton_ActualizarCliente1ActionPerformed

    private void jButton_imprimirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_imprimirClienteActionPerformed
        //Creamos un ob a la clase Document q es la q nos deja crear los pdf.
        Document documento = new Document();
        //siempre q trabajemos con pdf debemos usar try-catch.
        try {
            //en esta var. guardamos la ruta en dnd estará nuestro pdf.        
            String ruta = System.getProperty("user.home");
            //lugar dnd guardaremos el archivo pdf, con su nombre y la extencion .pdf
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + txt_nombre.getText().trim() + ".pdf"));
            /*como en los import no pueden estar dos bibliotec o librerias Image(xq crea conflicto), lo q hacemos es pegar ese 
            import acá abajo, le colocamos a lo ultimo la palabra Image, le creamos un ob y obtenemos la instancia de dnd
            sacaremos el imagen para el pdf */
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);//Chunk solo en imagenes.
            //cramos un ob a la clase Paragraph.
            Paragraph parrafo = new Paragraph();
            parrafo.add("Información del Cliente \n \n ");
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);//Paragraph en parrafos.
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();//siempre abrimos el doc.
            documento.add(header);//agregamos el encabezado.
            documento.add(parrafo);//agregamos el párrafo.
            //creamos un ob a la clase PdfPTable, esta clase nos ayuda a crear tablas.
            PdfPTable tablacliente = new PdfPTable(5);
            tablacliente.addCell("ID");//agregamos celdas con el nomb q deseamos.
            tablacliente.addCell("Nombre");
            tablacliente.addCell("Email");
            tablacliente.addCell("Telefono");
            tablacliente.addCell("Dirección");

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from cliente where id_cliente = '" + IDcliente_update + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        //agregamos en este orden los datos q traemos de la bd. y se van colocando en la tabla creada anteriorment.
                        tablacliente.addCell(rs.getString(1));
                        tablacliente.addCell(rs.getString(2));
                        tablacliente.addCell(rs.getString(3));
                        tablacliente.addCell(rs.getString(4));
                        tablacliente.addCell(rs.getString(5));

                    } while (rs.next());
                    documento.add(tablacliente);//agregamos la tabla
                }

                Paragraph parrafo2 = new Paragraph();
                parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo2.add("\n \n Equipo del cliente \n \n");
                parrafo2.setFont(FontFactory.getFont("Tohama", 14, Font.BOLD, BaseColor.DARK_GRAY));

                documento.add(parrafo2);

                PdfPTable tablaequipo = new PdfPTable(4);
                tablaequipo.addCell("ID Equipo");
                tablaequipo.addCell("Tipo");
                tablaequipo.addCell("Marca");
                tablaequipo.addCell("Estatus");

                try {
                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" + IDcliente_update + "'");
                    ResultSet rs2 = pst2.executeQuery();
                    if (rs2.next()) {
                        do {
                            tablaequipo.addCell(rs2.getString(1));
                            tablaequipo.addCell(rs2.getString(2));
                            tablaequipo.addCell(rs2.getString(3));
                            tablaequipo.addCell(rs2.getString(4));

                        } while (rs2.next());
                        documento.add(tablaequipo);
                    }

                } catch (SQLException e) {
                    System.err.println("Error al cargar equipo del cliente." + e);
                }

            } catch (SQLException e) {
                System.err.println("ERROR al obtener datos del cliente." + e);
            }
            documento.close();//cerramos el documento.
            JOptionPane.showMessageDialog(null, "Archivo PDF guardado correctamente.");
            //este catch es el encargado de q no haya ningun error cuando se genere este documento pdf.
            //con estos dos controlamos la creacion de nuestro Doc. pdf y la Imput-Ouput de datos.
        } catch (DocumentException | IOException e) {
            System.err.println("ERROR en crear PDF o en Ruta de Imagen.");
            JOptionPane.showMessageDialog(null, "ERROR en generar PDF, contacte al administrado.");
        }
    }//GEN-LAST:event_jButton_imprimirClienteActionPerformed

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
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ActualizarCliente1;
    private javax.swing.JButton jButton_RegistrarEquipo;
    private javax.swing.JButton jButton_imprimirCliente;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_direccion;
    private javax.swing.JLabel jLabel_email;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_nombre;
    private javax.swing.JLabel jLabel_telefono;
    private javax.swing.JLabel jLabel_titulo_info_cliente;
    private javax.swing.JLabel jLabel_ultimaModif;
    private javax.swing.JScrollPane jScrollPane_equipos;
    private javax.swing.JTable jTable_equipos;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_ultimaModificacion;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        txt_nombre.setText("");
        txt_email.setText("");
        txt_telefono.setText("");
        txt_direccion.setText("");
        
    }

}
