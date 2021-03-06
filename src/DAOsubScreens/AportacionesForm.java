/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOsubScreens;

import DAO.OperacionGestor;
import DAO.PortafolioGestor;
import JPAControllers.exceptions.NonexistentEntityException;
import entity.Operaciones;
import entity.Portafolios;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 60044723
 */
public class AportacionesForm extends javax.swing.JPanel {

    /**
     * Creates new form AportacionesForm
     */
    private final PortafolioGestor portafoliosGestor;
    private final OperacionGestor operacionGestor;
    private final DateFormat fecha_format;
    private Portafolios selectPortafolios;
    private Operaciones selectOperacion;
    
    public AportacionesForm(PortafolioGestor p_portafoliosGestor, OperacionGestor p_operacionGestor) {
        this.portafoliosGestor = p_portafoliosGestor;
        this.operacionGestor = p_operacionGestor;
        initComponents();
        this.fecha_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.fechatxt.setText(fecha_format.format(new Date()));
        this.cantidad.setText("$");
        this.tabla.setDragEnabled(false);
        
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
        fechatxt = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        portafoliosdropdown = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cantidad = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        tftotal = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(990, 590));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Aportaciones");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Fecha");

        fechatxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))));
        fechatxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Portafolios");

        portafoliosdropdown.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        portafoliosdropdown.setModel(this.get_portafolios());
        portafoliosdropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portafoliosdropdownActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cantidad");

        btnguardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jSeparator1.setPreferredSize(new java.awt.Dimension(1000, 300));

        tabla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabla.setModel(this.fill_table());
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        cantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤###0.0000"))));
        cantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Total");

        tftotal.setEditable(false);
        tftotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tftotal)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fechatxt, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnguardar)
                                .addGap(18, 18, 18)
                                .addComponent(btncancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(portafoliosdropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(cantidad))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portafoliosdropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tftotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void portafoliosdropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portafoliosdropdownActionPerformed

        String nombreportafolios = portafoliosdropdown.getSelectedItem().toString();
        this.selectPortafolios = this.portafoliosGestor.find_portafoliosbyname(nombreportafolios);
        try {
            this.set_aportaciones();
        } catch (ParseException ex) {
            Logger.getLogger(AportacionesForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_portafoliosdropdownActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        DefaultTableModel model = (DefaultTableModel) this.tabla.getModel();   
        this.cantidad.setText("$");
        model.setNumRows(0);
        this.tabla.setModel(model);
        this.tabla.revalidate();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        String scantidad = this.cantidad.getText();
       
        try {
            this.operacionGestor.add_operacion(this.fecha_format.parse(this.fechatxt.getText()),
                                               Double.parseDouble(scantidad.substring(1,scantidad.length())), 
                                                this.selectPortafolios.getIdportafolios(),"AP");
            this.set_aportaciones();
        } catch (ParseException ex) {
            Logger.getLogger(AportacionesForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        this.set_selectedOperacion();
  
    }//GEN-LAST:event_tablaMouseClicked

    private void set_selectedOperacion(){
         int p_id = (int) this.tabla.getValueAt(this.tabla.getSelectedRow(), 0);
        
         this.selectOperacion = this.operacionGestor.find_operacionbyid(p_id);
    }
    
    private void tablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyPressed
        String new_cantidad = ""; 
        if(evt.getKeyCode() == evt.VK_ENTER){
             Object[] options = {"Guardar Cambios",
                    "Cancelar",
                    "Borrar"};
           int respuesta = JOptionPane.showOptionDialog(this, "¿Qué desea hacer?", 
                     "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
                     null, options, options[2]);
           
           switch (respuesta){
           
               case 0: // Guardar cambios       
             {
                 try {
                     this.set_selectedOperacion();
                     new_cantidad = this.tabla.getValueAt(this.tabla.getSelectedRow(), 2).toString();
                     this.operacionGestor.update_operaciones(Double.parseDouble(new_cantidad), this.fecha_format.parse(this.fechatxt.getText()), 
                                                             this.selectOperacion.getPortafolios().getIdportafolios(), 
                                                             this.selectOperacion.getTipooperacion(),this.selectOperacion.getIdaportaciones());
                     this.set_aportaciones();
                 } catch (ParseException ex) {
                     Logger.getLogger(AportacionesForm.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (NonexistentEntityException ex) {
                     Logger.getLogger(AportacionesForm.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (Exception ex) {
                     Logger.getLogger(AportacionesForm.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
                   break;
               case 1: //Cancelar,
                break;
               case 2: {
                 try {
                     //Borrar
                     this.set_selectedOperacion();
                     this.operacionGestor.delete_operaciones(this.selectOperacion.getIdaportaciones());
                     JOptionPane.showMessageDialog(this, "Se ha borrado la operacion con ID: "+this.selectOperacion.getIdaportaciones(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                     this.set_aportaciones();
                 } catch (NonexistentEntityException ex) {
                     JOptionPane.showMessageDialog(this,"No se ha dado clic sobre la operacion!","ERROR",JOptionPane.ERROR_MESSAGE);
                     Logger.getLogger(AportacionesForm.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (ParseException ex) {
                     Logger.getLogger(AportacionesForm.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
                   break;
           
           }
           
         }
    }//GEN-LAST:event_tablaKeyPressed

    public DefaultComboBoxModel get_portafolios() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        List<Portafolios> portafolios = this.portafoliosGestor.get_portafoliosList();
        model.addElement(null);
        for (int i = 0; i < portafolios.size(); i++) {
            model.addElement(portafolios.get(i).getNombre());
        }

        return model;
    }

    public DefaultTableModel fill_table() {

        Vector<String> colnames = new Vector<String>();
        colnames.add("ID");
        colnames.add("Fecha");
        colnames.add("Cantidad");
        colnames.add("Portafolios");

        return new DefaultTableModel(colnames, 4);
    }

    private void set_aportaciones() throws ParseException {
        DefaultTableModel model = (DefaultTableModel) this.tabla.getModel();   
        
        model = this.remove_rows(model);
        model.setNumRows(0);
        List<Operaciones> aportaciones = this.operacionGestor.get_aportaciones_by_portafolios(this.selectPortafolios.getIdportafolios(),"AP");
         if(aportaciones.size()> 0){
        for(int i = 0; i < aportaciones.size();i++){
            model.addRow(new Object[]{aportaciones.get(i).getIdaportaciones(),
                                      this.fecha_format.format(aportaciones.get(i).getFecha()),
                                      aportaciones.get(i).getCantidad(),
                                      this.selectPortafolios.getNombre()
                                     }
             );
        }
        this.tftotal.setText(String.valueOf(this.operacionGestor.get_operaciones_totales(this.selectPortafolios.getIdportafolios(), 
                                             this.fecha_format.parse(this.fechatxt.getText()),"AP")));
        
        }
        this.tabla.setModel(model);
        this.tabla.revalidate();
    }
private DefaultTableModel remove_rows(DefaultTableModel p_model){
    
    for(int i=0;i<p_model.getRowCount();i++){
        p_model.removeRow(i);
        
    }
    
    return p_model;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JFormattedTextField cantidad;
    private javax.swing.JFormattedTextField fechatxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox portafoliosdropdown;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField tftotal;
    // End of variables declaration//GEN-END:variables
}
