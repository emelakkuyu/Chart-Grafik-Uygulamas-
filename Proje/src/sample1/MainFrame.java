package sample1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import sample1.actions.Actiondegis;
import sample1.actions.NewAction;
import sample1.actions.RemoveAction;
import sample1.model.Renk;
import sample1.model.Tablo;
import charts.Chart;
import charts.ChartStats;
import charts.Stat;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	private final ChartStats stats = new ChartStats();
	private final Chart chart = new Chart(stats, null);//boş chart nesnesi türetildi
	
	public MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Chart Grafik Uygulaması");
		createContent();
		pack(); //Pencerenin eklenen swing bileşenlerine göre otomatik boyutlandırılması
	}
	
	private void createContent() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(createStatsPanel(), BorderLayout.NORTH);
		panel.add(createContentPanel(), BorderLayout.CENTER);
		setContentPane(panel);
	}
	
	private JPanel createContentPanel() {//seçilen chart grafiğini panele ekleme
		JPanel panel = new JPanel(new BorderLayout());
		
		initializeDefaultStats(stats);
		panel.add(createSettingsPanel(), BorderLayout.NORTH);
		panel.add(chart, BorderLayout.CENTER);
		
		return panel;
	}
	
	private JPanel createSettingsPanel() {//chart tipi seçimi
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
		
		JComboBox<String> box = new JComboBox<String>(new String[] {"yok", "Column", "Pie", "Column 3D", "Pie 3D"});
		box.addActionListener(new Actiondegis (chart, box));
		
		
		
		panel.add(new JLabel("Chart tipi: "));
		panel.add(box);
		
		
		return panel;
	}
	
	private void initializeDefaultStats(ChartStats stats) {//başlangıç değerleri
		stats.addStat(new Stat("Matematik", 54, Color.PINK));
		stats.addStat(new Stat("Fizik", 11, Color.BLUE));
		stats.addStat(new Stat("Kimya", 35, Color.GRAY));
	}
	
	private JPanel createStatsPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		
		Tablo model = new Tablo(stats);
		stats.addCharStatListener(model);
		
		JTable table = new JTable(model);
		table.getColumnModel().getColumn(0).setMaxWidth(40);
		table.setDefaultRenderer(Color.class, new Renk());
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(600, 100));
		
		panel.add(createButtonsPanel(table), BorderLayout.NORTH);
		panel.add(scroll, BorderLayout.WEST);
		
		return panel;
	}
	
	private JPanel createButtonsPanel(JTable table) {//grafik ekleme ve silme butonlarını panele ekleme
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
		
		StatDialog dialog = new StatDialog(this, stats);
		
		JButton add = new JButton(new NewAction(dialog));
		JButton remove = new JButton(new RemoveAction(stats, table));
		
		panel.add(add);
		panel.add(remove);
		
		return panel;
	}

}
