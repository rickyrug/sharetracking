/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOsubScreens;

import DAO.OperacionGestor;
import DAO.PortafolioGestor;
import DAO.ResultadosGestor;
import JPAControllers.exceptions.NonexistentEntityException;
import entity.Operaciones;
import entity.Portafolios;
import entity.Resultados;
import java.text.DateFormat;
import java.text.DecimalFormat;
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
public class ResultadosForm extends javax.swing.JPanel {

    /**
     * Creates new form ResultadosForm
     */
    private final PortafolioGestor portafoliosGestor;
    private final ResultadosGestor resultadosGestor;
    private double rendimiento;
    private double profit;
    private Resultados selectedResultado;
    
    private final DateFormat fecha_format;
    public ResultadosForm(PortafolioGestor p_portafoliosGestor, 
                          ResultadosGestor p_resultadosGestor
                          ) {
        this.portafoliosGestor = p_portafoliosGestor;
        this.resultadosGestor  = p_resultadosGestor;
        
        initComponents();
        this.fecha_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.tffecha.setText(fecha_format.format(new Date()));
        this.profit = 0.0;
        this.rendimiento = 0.0;
        
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
        cbxportafolios = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        tffecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfvalor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfprofit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfrendimiento = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnrefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Resultados");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Portafolios");

        cbxportafolios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxportafolios.setModel(this.get_portafolios());
        cbxportafolios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbxportafoliosFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Fecha");

        tffecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Valor");

        tfvalor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfvalor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfvalorFocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Utilidades $");

        tfprofit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfprofit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfprofitFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Rendimiento %");

        tfrendimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfrendimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfrendimientoFocusLost(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btncancelar.setText("Cancelar");

        btnrefresh.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        btnrefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/refresh.png"))); // NOI18N
        btnrefresh.setToolTipText("refresh");
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(cbxportafolios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(tffecha))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnguardar)
                                .addGap(18, 18, 18)
                                .addComponent(btncancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(tfvalor))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(tfprofit))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(tfrendimiento))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnrefresh))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxportafolios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tffecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfprofit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfrendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
       this.cbxportafolios.setModel(this.get_portafolios());
    }//GEN-LAST:event_btnrefreshActionPerformed

    private void tfvalorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfvalorFocusLost
        
        Portafolios selectedPortafolios;
        if(!this.tfvalor.getText().isEmpty()){
            try {
                selectedPortafolios = this.portafoliosGestor.find_portafoliosbyname(this.cbxportafolios.getSelectedItem().toString());
                this.profit =  this.resultadosGestor.calculate_profit(Double.parseDouble(this.tfvalor.getText()),
                          selectedPortafolios.getIdportafolios(),
                          this.fecha_format.parse(this.tffecha.getText()));
                this.rendimiento = this.resultadosGestor.calculate_rendimiento(selectedPortafolios.getIdportafolios(), 
                                                                          profit, this.fecha_format.parse(this.tffecha.getText()));
                               
                this.tfprofit.setText(new DecimalFormat("#.##").format(profit));
                this.tfrendimiento.setText(new DecimalFormat("#.##").format(rendimiento * 100));
            } catch (ParseException ex) {
                Logger.getLogger(ResultadosForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tfvalorFocusLost

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        Portafolios selectedPortafolios;
        selectedPortafolios = this.portafoliosGestor.find_portafoliosbyname(this.cbxportafolios.getSelectedItem().toString());
        try {
            this.resultadosGestor.add_resultados(this.fecha_format.parse(this.tffecha.getText()), 
                                                                         selectedPortafolios.getIdportafolios(),
                                                                         Double.parseDouble(this.tfvalor.getText()), 
                                                                         this.profit, this.rendimiento);
            JOptionPane.showMessageDialog(this, "Se ha guardado resultado del portafolios "+selectedPortafolios.getNombre());
            this.set_resultados();
        } catch (ParseException ex) {
            Logger.getLogger(ResultadosForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void tfprofitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfprofitFocusLost
        this.profit = Double.parseDouble(this.tfprofit.getText());
    }//GEN-LAST:event_tfprofitFocusLost

    private void tfrendimientoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfrendimientoFocusLost
       this.rendimiento = Double.parseDouble(this.tfrendimiento.getText());
    }//GEN-LAST:event_tfrendimientoFocusLost

    private void cbxportafoliosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxportafoliosFocusLost
        try {
            this.set_resultados();
        } catch (ParseException ex) {
            Logger.getLogger(ResultadosForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbxportafoliosFocusLost

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
       this.set_selectedResultado();
    }//GEN-LAST:event_tablaMouseClicked

    private void tablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyPressed
        String new_valor = ""; 
        String new_profit = "";
        String new_rendimiento = "";
        String new_fecha       = "";
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
                     this.set_selectedResultado();
                     
                     new_valor = this.tabla.getValueAt(this.tabla.getSelectedRow(), 3).toString();
                     new_rendimiento = this.tabla.getValueAt(this.tabla.getSelectedRow(), 5).toString();
                     new_profit = this.tabla.getValueAt(this.tabla.getSelectedRow(), 4).toString();
                     new_fecha  = this.tabla.getValueAt(this.tabla.getSelectedRow(), 1).toString();
                     
                     this.selectedResultado.setProfit(Double.parseDouble(new_profit));
                     this.selectedResultado.setRendimiento(Double.parseDouble(new_rendimiento));
                     this.selectedResultado.setValor(Double.parseDouble(new_valor));
                     this.selectedResultado.setFecha(this.fecha_format.parse(new_fecha));
                     
                     this.resultadosGestor.update_resultado(selectedResultado);
                     this.set_resultados();
                 } catch (ParseException ex) {
                     JOptionPane.showMessageDialog(this, "ERROR EN EL GUARDADO","ERROR",JOptionPane.ERROR_MESSAGE);
                     Logger.getLogger(RetirosForms.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (NonexistentEntityException ex) {
                     Logger.getLogger(RetirosForms.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (Exception ex) {
                      JOptionPane.showMessageDialog(this, "ERROR EN EL GUARDADO","ERROR",JOptionPane.ERROR_MESSAGE);
                     Logger.getLogger(RetirosForms.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
                   break;
               case 1: //Cancelar,
                break;
               case 2: {
                 try {
                     //Borrar
                     this.set_selectedResultado();
                     this.resultadosGestor.delete_aportaciones(this.selectedResultado.getIdresultados());
                     JOptionPane.showMessageDialog(this, "Se ha borrado la operacion con ID: "+this.selectedResultado.getIdresultados(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                     this.set_resultados();
                 } catch (NonexistentEntityException ex) {
                     JOptionPane.showMessageDialog(this,"No se ha dado clic sobre la operacion!","ERROR",JOptionPane.ERROR_MESSAGE);
                     Logger.getLogger(RetirosForms.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (ParseException ex) {
                     Logger.getLogger(RetirosForms.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
                   break;
           
           }
           
         }
    }//GEN-LAST:event_tablaKeyPressed

     private void set_selectedResultado() {
        String var_idresultado = this.tabla.getValueAt(this.tabla.getSelectedRow(), 0).toString();
        this.selectedResultado = this.resultadosGestor.get_resultadobyid(Integer.parseInt(var_idresultado));
    }
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
        colnames.add("Portafolios");
        colnames.add("Valor");
        colnames.add("Utilidad");
        colnames.add("Rendimiento");

        return new DefaultTableModel(colnames, 4);
    }
     
     private void set_resultados() throws ParseException {

        DefaultTableModel model = (DefaultTableModel) this.tabla.getModel();
        Portafolios selectedPortafolios = this.portafoliosGestor.find_portafoliosbyname(this.cbxportafolios.getSelectedItem().toString());
        model = this.remove_rows(model);
        model.setNumRows(0);
        List<Resultados> resultados = this.resultadosGestor.get_aportacionesList(selectedPortafolios.getIdportafolios());
        if (resultados.size() > 0) {
            for (int i = 0; i < resultados.size(); i++) {
                model.addRow(new Object[]{resultados.get(i).getIdresultados(),
                    this.fecha_format.format(resultados.get(i).getFecha()),
                    selectedPortafolios.getNombre(),
                    new DecimalFormat("$#.##").format(resultados.get(i).getValor()),
                    new DecimalFormat("$#.##").format(resultados.get(i).getProfit()),
                    new DecimalFormat("#.##%").format(resultados.get(i).getRendimiento()),}
                );
            }

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
    private javax.swing.JButton btnrefresh;
    private javax.swing.JComboBox cbxportafolios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField tffecha;
    private javax.swing.JTextField tfprofit;
    private javax.swing.JTextField tfrendimiento;
    private javax.swing.JTextField tfvalor;
    // End of variables declaration//GEN-END:variables
}
