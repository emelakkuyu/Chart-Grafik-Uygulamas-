package charts;

import java.awt.Color;

public class Stat {
	
	private static final Color DEFAULT_COLOR = Color.LIGHT_GRAY;
	//ekran görüntüsü
	private final String baslik;
	private final Number deger;
	private final Color renk;
	
	public Stat(String baslik, Number deger, Color renk) {
		this.baslik = baslik;
		this.deger = deger;
		this.renk = renk;
	}
	
	public Stat(String baslik, Number deger) {
		this(baslik, deger, DEFAULT_COLOR);
	}

	public String getbaslik() {
		return baslik;
	}

	public Number getdeger() {
		return deger;
	}

	public Color getrenk() {
		return renk;
	}

}
