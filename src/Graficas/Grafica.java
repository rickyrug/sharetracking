/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficas;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;
import com.xeiam.xchart.SwingWrapper;

/**
 *
 * @author 60044723
 */
public class Grafica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      double[] xData = new double[] { 0.0, 1.0, 2.0 };
    double[] yData = new double[] { 2.0, 1.0, 0.0 };
 
    // Create Chart
    Chart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);
 
    // Show it
    new SwingWrapper(chart).displayChart();
    }
    
}
