package chartsFunctions;

import java.awt.Color;
import java.awt.Graphics;

import charts.ChartStats;
public interface PaintStrategy {//boya stratejisi
	
	Color FONT_COLOR = Color.BLACK;
	
	void paint(Graphics g, ChartStats stats, int height, int width);

}
