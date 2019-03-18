package charts;

import java.awt.Dimension;

import chartsFunctions.Bar3D;
import chartsFunctions.BarChart;
import chartsFunctions.Pie3D;
import chartsFunctions.PieChart;
public class Chart1 {
	
	public static final int BAR_CHART = 1;
	public static final int BAR_CHART_3D = 2;
	public static final int PIE_CHART = 3;
	public static final int PIE_CHART_3D = 4;
	
	public static Chart createChart(int type, ChartStats stats, Dimension preferredSize) {
		switch(type) {
			case BAR_CHART: 	return new Chart(stats, new BarChart(), 	preferredSize);//barchart
			case BAR_CHART_3D: 	return new Chart(stats, new Bar3D(), 	preferredSize);// 3 boyutlu barchart
			case PIE_CHART: 	return new Chart(stats, new PieChart(), 	preferredSize);//line chart
			case PIE_CHART_3D: 	return new Chart(stats, new Pie3D(), 	preferredSize);// 3 boyutlu line chart
			default: throw new RuntimeException("Bilinmeyen Grafik Türü");
		}
	}
	
	public static Chart createChart(int type, ChartStats stats) {//grafiği oluştur.
		return createChart(type, stats, Chart.DEFAULT_SIZE);
	}

}
