package charts;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import chartsFunctions.PaintStrategy;//Boya stratejisi ekleme

@SuppressWarnings("serial")
public class Chart extends Component implements ChartStatListener {
	
	public static final Dimension DEFAULT_SIZE = new Dimension(500, 500);

	private final ChartStats stats;
	private PaintStrategy paintStrategy;
	
	public Chart(ChartStats stats, PaintStrategy paintStrategy) {
		this(stats, paintStrategy, DEFAULT_SIZE);
	}
	
	public Chart(ChartStats stats, PaintStrategy paintStrategy, Dimension preferredSize) {
		this.stats = stats;
		this.paintStrategy = paintStrategy;
		stats.addCharStatListener(this);
		setPreferredSize(preferredSize);
	}
	
	public void paint(Graphics g) {//grafik çizimi
		g.drawImage(getImage(), 0, 0, this);
	}
	
	private BufferedImage createClearImage() {//grafiği temizleme
		BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics imageGraphics = image.createGraphics();
		imageGraphics.setColor(Color.WHITE);
		imageGraphics.fillRect(0, 0, image.getWidth(), image.getHeight());
		return image;
	}
	
	public BufferedImage getImage() {
		BufferedImage image = createClearImage();
		if (paintStrategy == null) {//grafik çizimi yok ise ekran boş
			
		} else {
			if (!stats.isEmpty())//bir grafik seçili ise grafiği ekrana basar
				paintStrategy.paint(image.createGraphics(), stats, image.getHeight(), image.getWidth());
		}
		return image;
	}
	
	public void saveChart(String format, String path) throws IOException {
		File out = new File(path);
		ImageIO.write(getImage(), format, out);
	}
	
	public void setPaintStrategy(PaintStrategy paintStrategy) {
		this.paintStrategy = paintStrategy;
		repaint();
	}
	
	public void chartStatChanged() {//combobox da hangi grafik seçili ise onu ekrana cizer değiştirildiğinde tekrar seçilen grfafik çizilir.
		repaint();
	}
	
}
