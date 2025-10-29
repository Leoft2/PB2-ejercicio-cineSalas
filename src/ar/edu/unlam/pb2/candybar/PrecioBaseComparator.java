package ar.edu.unlam.pb2.candybar;

import java.util.Comparator;

public class PrecioBaseComparator implements Comparator<Bebida> {

	@Override
	public int compare(Bebida o1, Bebida o2) {
		return o1.getPrecioBase().compareTo(o2.getPrecioBase());
	}

}
