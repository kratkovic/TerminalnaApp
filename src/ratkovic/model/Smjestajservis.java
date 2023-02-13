package ratkovic.model;

import java.util.ArrayList;
import java.util.List;

public class Smjestajservis extends Entitet {

	private Smjestaj smjestaj;
	private List<Servis> servisi;

	public Smjestajservis() {
		super();
		servisi = new ArrayList<>();
	}

	public Smjestajservis(int sifra, Smjestaj smjestaj, List<Servis> servisi) {
		super(sifra);
		this.smjestaj = smjestaj;
		this.servisi = servisi;

	}

	public Smjestaj getSmjestaj() {
		return smjestaj;
	}

	public void setSmjestaj(Smjestaj smjestaj) {
		this.smjestaj = smjestaj;
	}

	public List<Servis> getServisi() {
		return servisi;
	}

	public void setServisi(List<Servis> servisi) {
		this.servisi = servisi;
	}
}
