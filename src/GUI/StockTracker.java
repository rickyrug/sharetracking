/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.OperacionGestor;
import DAO.PortafolioGestor;
import DAO.ResultadosGestor;
import DAOsubScreens.*;
import java.awt.FlowLayout;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JPanel;

/**
 *
 * @author 60044723
 */
public class StockTracker extends javax.swing.JFrame {

    private final PortafolioGestor portafoliosGestor;
    private final OperacionGestor  operacionGestor;
    private final ResultadosGestor resultadosGestor;
    private final EntityManagerFactory emf;
    private final AportacionesForm aportacionespanel;
    private final RetirosForms     retirospanel;
    private final PortafoliosForm  portafoliospanel;
    private final ResultadosForm   resultadospanel;
    
    public StockTracker() {
        initComponents();
        this.emf = Persistence.createEntityManagerFactory("StockTrackerPU");
        this.portafoliosGestor = new PortafolioGestor(emf);
        this.operacionGestor   = new OperacionGestor(emf);
        this.resultadosGestor  = new ResultadosGestor(emf);
        this.main.setLayout(new FlowLayout());
        this.aportacionespanel =  new AportacionesForm(this.portafoliosGestor,this.operacionGestor);
        this.retirospanel      =  new RetirosForms(this.portafoliosGestor, this.operacionGestor);
        this.portafoliospanel  = new PortafoliosForm(this.portafoliosGestor);
        this.resultadospanel   = new ResultadosForm(this.portafoliosGestor,this.resultadosGestor);
       }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        menubar = new javax.swing.JMenuBar();
        operaciones = new javax.swing.JMenu();
        aportaciones = new javax.swing.JMenuItem();
        retiros = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnitmportafolios = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miagregar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("StockTracker");
        setPreferredSize(new java.awt.Dimension(990, 600));

        main.setPreferredSize(new java.awt.Dimension(990, 600));

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 257, Short.MAX_VALUE)
        );

        operaciones.setText("Operaciones");

        aportaciones.setText("Aportaciones");
        aportaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aportacionesActionPerformed(evt);
            }
        });
        operaciones.add(aportaciones);

        retiros.setText("Retiro");
        retiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retirosActionPerformed(evt);
            }
        });
        operaciones.add(retiros);

        menubar.add(operaciones);

        jMenu2.setText("Portafolios");

        mnitmportafolios.setText("Gestionar");
        mnitmportafolios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnitmportafoliosActionPerformed(evt);
            }
        });
        jMenu2.add(mnitmportafolios);

        menubar.add(jMenu2);

        jMenu3.setText("Resultados");

        miagregar.setText("Agregar");
        miagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miagregarActionPerformed(evt);
            }
        });
        jMenu3.add(miagregar);

        menubar.add(jMenu3);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aportacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aportacionesActionPerformed
        
        this.change_layout(this.aportacionespanel);
       
    }//GEN-LAST:event_aportacionesActionPerformed

    private void retirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retirosActionPerformed
      this.change_layout(this.retirospanel);
    }//GEN-LAST:event_retirosActionPerformed

    private void mnitmportafoliosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnitmportafoliosActionPerformed
         this.change_layout(this.portafoliospanel);
    }//GEN-LAST:event_mnitmportafoliosActionPerformed

    private void miagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miagregarActionPerformed
       this.change_layout(this.resultadospanel);
    }//GEN-LAST:event_miagregarActionPerformed

    private void change_layout(JPanel new_panel){
        new_panel.repaint();
        main.removeAll();
      
        main.add(new_panel);
        main.repaint();
        main.updateUI();
    }
    
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
            java.util.logging.Logger.getLogger(StockTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockTracker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aportaciones;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel main;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JMenuItem miagregar;
    private javax.swing.JMenuItem mnitmportafolios;
    private javax.swing.JMenu operaciones;
    private javax.swing.JMenuItem retiros;
    // End of variables declaration//GEN-END:variables
}
