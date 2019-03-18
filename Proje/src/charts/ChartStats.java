package charts;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

public class ChartStats implements Iterable<Stat> {
	
	private final List<Stat> stats = new ArrayList<Stat>();//grafiği çizmek için girilen değerleri bir listede tutuyor.
	private final List<ChartStatListener> listeners = new ArrayList<ChartStatListener>();
	
	public void addCharStatListener(ChartStatListener listener) {
		listeners.add(listener);//butona tıklandığında listener ile kontrol ediliyor. 
	}
	
	public void removeCharStatListener(ChartStatListener listener) {
		listeners.remove(listener);//seçili olan veriyi silmek
	}
	
	public void addStat(Stat stat) {//yeni bir veri eklemek
		stats.add(stat);
		fireStatsChanged();
	}
	
	public void removeStat(int index) {//seçili olan veriyi silmek
		stats.remove(index);
		fireStatsChanged();
	}
	
	private void fireStatsChanged() {
		for(ChartStatListener listener: listeners)
			listener.chartStatChanged();
	}

	public Iterator<Stat> iterator() {
		return stats.iterator();
	}
	
	public int getSize() {
		return stats.size();
	}
	
	public Stat getStat(int index) {
		return stats.get(index);
	}
	
	public boolean isEmpty() {//boş ise tüm değerler 0
		return stats.size() == 0;
	}

}
