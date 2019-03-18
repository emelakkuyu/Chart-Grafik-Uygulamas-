package sample1.actions;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

import sample1.model.Renkutusu;

@SuppressWarnings("serial")
public class renkSec extends AbstractAction {
	
	private final Dialog dialog;
	private final JColorChooser chooser;
	private final Renkutusu box;

	//renk seçimini onaylama
	public renkSec(Dialog dialog, JColorChooser chooser, Renkutusu box) {
		super("Tamam");
		this.dialog = dialog;
		this.chooser = chooser;
		this.box = box;
	}

	public void actionPerformed(ActionEvent e) {
		Color color = chooser.getColor();
		box.setColor(color);
		dialog.setVisible(false);
	}

}
