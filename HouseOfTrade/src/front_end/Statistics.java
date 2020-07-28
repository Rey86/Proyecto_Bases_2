package front_end;

import java.text.DecimalFormat;
import javax.swing.JDialog;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Statistics extends javax.swing.JDialog {
    JFreeChart chart;
    DefaultPieDataset dataset = new DefaultPieDataset();
    DefaultCategoryDataset data = new DefaultCategoryDataset();
    
    public Statistics(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonProductPercentagePerCategory = new javax.swing.JButton();
        jButtonTotalUsersPerAgePerGender = new javax.swing.JButton();
        jButtonSalesPercentagePerGender = new javax.swing.JButton();
        jButtonPurchaseAmountPercentagePerGender = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Queries for the statistics");

        jButtonProductPercentagePerCategory.setText("Total and percentage of products per category");
        jButtonProductPercentagePerCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductPercentagePerCategoryActionPerformed(evt);
            }
        });

        jButtonTotalUsersPerAgePerGender.setText("Total and percentage of salesmen per gender and age range");
        jButtonTotalUsersPerAgePerGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTotalUsersPerAgePerGenderActionPerformed(evt);
            }
        });

        jButtonSalesPercentagePerGender.setText("Total and percentage of sales per gender");
        jButtonSalesPercentagePerGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalesPercentagePerGenderActionPerformed(evt);
            }
        });

        jButtonPurchaseAmountPercentagePerGender.setText("Total and percentage of purchase price per gender");
        jButtonPurchaseAmountPercentagePerGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPurchaseAmountPercentagePerGenderActionPerformed(evt);
            }
        });

        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jButtonProductPercentagePerCategory)
                    .addComponent(jButtonTotalUsersPerAgePerGender)
                    .addComponent(jButtonSalesPercentagePerGender)
                    .addComponent(jButtonPurchaseAmountPercentagePerGender)
                    .addComponent(jButtonClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonProductPercentagePerCategory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonTotalUsersPerAgePerGender)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSalesPercentagePerGender)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonPurchaseAmountPercentagePerGender)
                .addGap(18, 18, 18)
                .addComponent(jButtonClose)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonProductPercentagePerCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductPercentagePerCategoryActionPerformed
        try {
            ResultSet r = logic_connection.DataBaseConnection.getProductPercentagePerCategory();
            while(r.next()){
                dataset.setValue(r.getString("category"), r.getInt("percentage"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        chart = ChartFactory.createPieChart("Percentage and total of products per category", dataset, 
                true, true, false);
        
        PieSectionLabelGenerator labelGenerator = new  StandardPieSectionLabelGenerator(
            "Tipo {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
        
        ChartPanel Panel = new ChartPanel(chart);
        JDialog dialog = new JDialog(new javax.swing.JFrame(), true);
        dialog.getContentPane().add(Panel);
        dialog.pack();
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonProductPercentagePerCategoryActionPerformed

    private void jButtonTotalUsersPerAgePerGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTotalUsersPerAgePerGenderActionPerformed
        Statistics_GenderFilter dialog = new Statistics_GenderFilter(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonTotalUsersPerAgePerGenderActionPerformed

    private void jButtonSalesPercentagePerGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalesPercentagePerGenderActionPerformed
        try {
            ResultSet r = logic_connection.DataBaseConnection.getSalesPercentagePerGender();
            while(r.next()){
                dataset.setValue(r.getString("gender"), r.getInt("percentage"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        chart = ChartFactory.createPieChart("Percentage and total of sales per gender", dataset, 
                true, true, false);
        
        PieSectionLabelGenerator labelGenerator = new  StandardPieSectionLabelGenerator(
            "Tipo {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
        
        ChartPanel Panel = new ChartPanel(chart);
        JDialog dialog = new JDialog(new javax.swing.JFrame(), true);
        dialog.getContentPane().add(Panel);
        dialog.pack();
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonSalesPercentagePerGenderActionPerformed

    private void jButtonPurchaseAmountPercentagePerGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPurchaseAmountPercentagePerGenderActionPerformed
        try {
            ResultSet r = logic_connection.DataBaseConnection.getPurchaseAmountPercentagePerGender();
            while(r.next()){
                dataset.setValue(r.getString("gender"), r.getInt("percentage"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        chart = ChartFactory.createPieChart("Percentage and total of purchase price per gender", dataset, 
                true, true, false);
        
        PieSectionLabelGenerator labelGenerator = new  StandardPieSectionLabelGenerator(
            "Tipo {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
        
        ChartPanel Panel = new ChartPanel(chart);
        JDialog dialog = new JDialog(new javax.swing.JFrame(), true);
        dialog.getContentPane().add(Panel);
        dialog.pack();
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonPurchaseAmountPercentagePerGenderActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonProductPercentagePerCategory;
    private javax.swing.JButton jButtonPurchaseAmountPercentagePerGender;
    private javax.swing.JButton jButtonSalesPercentagePerGender;
    private javax.swing.JButton jButtonTotalUsersPerAgePerGender;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
