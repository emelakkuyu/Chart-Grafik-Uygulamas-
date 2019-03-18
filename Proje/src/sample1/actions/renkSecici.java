package sample1.actions;

import java.awt.Dialog;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class renkSecici extends AbstractAction {

	private final Dialog chooser;
	//renk seçmek için chooser nesnesini çagırıyor.
	public renkSecici(Dialog chooser) {
		super("renk seç");
		this.chooser = chooser;
	}
	
	public void actionPerformed(ActionEvent e) {
		chooser.setVisible(true);
	}

}
