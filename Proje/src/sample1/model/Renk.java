package sample1.model;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class Renk implements TableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, final Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if (!(value instanceof Color)) throw new RuntimeException("Yanlış sütun türü");
		Color color = (Color)value;
		return new Renkutusu(color);
	}

}
