package sample1.actions;

import java.awt.Dialog;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class NewAction extends AbstractAction {

	private final Dialog dialog;
	//yeni değer ekleme
	public NewAction(Dialog dialog) {
		super("Ekle");
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		dialog.setVisible(true);
	}

}
