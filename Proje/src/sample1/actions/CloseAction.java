package sample1.actions;

import java.awt.Dialog;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class CloseAction extends AbstractAction {

	private final Dialog dialog;
	//vazgecme
	public CloseAction(Dialog dialog) {
		super("Iptal");
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		dialog.setVisible(false);
	}

}
