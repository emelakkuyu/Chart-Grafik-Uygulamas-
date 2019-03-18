package sample1;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;

import sample1.actions.renkSec;
import sample1.actions.CloseAction;
import sample1.model.Renkutusu;

@SuppressWarnings("serial")
public class ColorDialog extends JDialog {
	
	private final JColorChooser chooser = new JColorChooser();//renk seçimi
	private final Renkutusu box;
	
	public ColorDialog(Dialog dialog, Renkutusu box) {
		super(dialog, true);
		this.box = box;
		setResizable(false);
		setTitle("Renk Secimi");
		createContent();
		pack();
	}
	
	private void createContent() {//seçilen rengin eklenmesi
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(chooser, BorderLayout.CENTER);
		panel.add(createButtonsPanel(), BorderLayout.SOUTH);
		setContentPane(panel);
	}
	
	private JPanel createButtonsPanel() {//renk seçiminde kapatma ve açma butonu ekleme
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 8));
		JButton ok = new JButton(new renkSec(this, chooser, box));
		JButton close = new JButton(new CloseAction(this));
		panel.add(ok);
		panel.add(close);
		return panel;
	}

}
