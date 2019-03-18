package sample1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sample1.actions.AddAction;
import sample1.actions.CloseAction;
import sample1.actions.renkSecici;
import sample1.model.Renkutusu;
import charts.ChartStats;

@SuppressWarnings("serial")
public class StatDialog extends JDialog {
	
	private final ChartStats stats;
	
	private final JTextField title = new JTextField(15);
	private final JFormattedTextField value = new JFormattedTextField(new DecimalFormat());
	private final Renkutusu box= new Renkutusu(Color.LIGHT_GRAY);
	
	public StatDialog(Frame frame, ChartStats stats) {//chart grafiğine yeni deger eklenmesi
		super(frame, true);
		this.stats = stats;
		setTitle("yeni veri");
		setResizable(false);
		createContent();
		pack(); // Pencerenin eklenen swing bileşenlerine göre otomatik boyutlandırılması
	}
	
	private void createContent() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(createFieldsPanel(), BorderLayout.CENTER);
		panel.add(createButtonsPanel(), BorderLayout.SOUTH);
		setContentPane(panel);
	}
	
	private JPanel createFieldsPanel() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
		
		value.setPreferredSize(new Dimension(100, 20));
		
		box.setPreferredSize(new Dimension(100, 20));
		ColorDialog chooser = new ColorDialog(this, box);//renk kutusu
		
		JButton showChooser = new JButton(new renkSecici(chooser));
		//ekran görünümü
		panel.add(new JLabel("Başlık: "));
		panel.add(title);
		panel.add(new JLabel("Değer: "));
		panel.add(value);
		panel.add(new JLabel("Renk: "));
		panel.add(box);
		panel.add(showChooser);
		
		return panel;
	}
	
	private JPanel createButtonsPanel() {//butonların panele eklenmesi
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 8));
		JButton ok = new JButton(new AddAction(this, stats, title, value, box));
		JButton close = new JButton(new CloseAction(this));
		panel.add(ok);
		panel.add(close);
		return panel;
	}
}
