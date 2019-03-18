package sample1.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;

import charts.Chart;
import chartsFunctions.Bar3D;
import chartsFunctions.BarChart;
import chartsFunctions.PaintStrategy;
import chartsFunctions.Pie3D;
import chartsFunctions.PieChart;

@SuppressWarnings("serial")
public class Actiondegis extends AbstractAction {

	private final Chart chart;
	private final JComboBox<String> box;
	//chart tiplerinin fonksiyonları bir diziye atılıyor
	private static PaintStrategy[] STRATEGIES = new PaintStrategy[] {null, new BarChart(), new PieChart(), new Bar3D(), new Pie3D()};
	
	public Actiondegis(Chart chart, JComboBox<String> box) {
		this.chart = chart;
		this.box = box;
	}
	
	public void actionPerformed(ActionEvent e) {
		int index = box.getSelectedIndex();
		chart.setPaintStrategy(STRATEGIES[index]);
	}

}
