package ratkovic.obrada;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ratkovic.Pomocno;
import ratkovic.Start;
import ratkovic.model.Motodogadjaj;
import ratkovic.model.Motoklub;
import ratkovic.model.Smjestaj;

public class Smjestaji {
	
	private List<Smjestaj> smjestaji;
	private Start start;
	
	public Smjestaji(Start start) {
		super();
		this.start = start;
		smjestaji = new ArrayList<>();
		testPodaci();
		
	}

	private void testPodaci() {
		smjestaji.add(new Smjestaj(1, "Garten", "Hotel", null, new Motodogadjaj(1, "Mega bikers susreti", "Poloj", new Date(2000, 11, 21), "Mario Karaš", new Motoklub(1, "MK Brod", "Slavonski Brod", 30, true ))));
		smjestaji.add(new Smjestaj(2, "Guest House Ana", "Apartmani", null, new Motodogadjaj(2, "21. Moto susreti", "Tvrđa-katakombe", new Date(2000, 11, 21), "Zdravko Bošnjak")));
		smjestaji.add(new Smjestaj(3, "Vila Rosa", "Apartmani", null, new Motodogadjaj(3, "15. Moto party", "Dunavska šetnica", new Date(2000, 11, 21), "Damir Kožul")));
		
	}
	public Smjestaji(Start start, List<Smjestaj> smjestaji) {
		super();
		this.smjestaji = smjestaji;
		this.start = start;
		testPodaci();
}

	public void izbornik() {
		System.out.println("");
		System.out.println("-- Izbornik Smještaji --");
		System.out.println("1. Pregled svih smještaja");
		System.out.println("2. Unos novog smještaja");
		System.out.println("3. Promjena postojećeg smještaja");
		System.out.println("4. Brisanje smještaja");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();
	}

	private void odabirIzbornika() {
		switch(Pomocno.unosBrojRaspon("Odaberi opciju za smještaj: ", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovog();
			break;
		case 3:
			if(smjestaji.size()==0) {
				System.out.println("Nema smještaja kojeg bi mjenjali");
				izbornik();
				}else {
					promjena();
				}
		case 4: 
			if (smjestaji.size()==0) {
				System.out.println("Nema smještaja kojeg bi brisali");
				izbornik();
			}else {
				brisanje();
			}
		case 5: 
			start.glavniIzbornik();
		}
		
	}
	private void brisanje() {
		int rb = Pomocno.unosBrojRaspon("Odaberite smještaj koji želite brisati", 0, Integer.MAX_VALUE);
		smjestaji.remove(rb-1);
		izbornik();
	}
	
	private void promjena() {
		pregled(false);
		int rb = Pomocno.unosBrojRaspon("Odaberite smještaj koji želite promjeniti: ", 1, Integer.MAX_VALUE);
		Smjestaj sm = smjestaji.get(rb-1);
		sm.setNaziv("Unesite naziv smještaja: ");
		sm.setVrsta("Unesite vrstu smještaja: ");
		sm.setCijena(null);
		izbornik();
		
	}
	
	private void unosNovog() {
		smjestaji.add(unesiNoviSmjestaj());
		izbornik();
	}

	private Smjestaj unesiNoviSmjestaj() {
		Smjestaj sm = new Smjestaj();
		sm.setSifra(Pomocno.unosBrojRaspon("Unesite šifru smještaja", 0, Integer.MAX_VALUE));
		sm.setNaziv(Pomocno.unosTeksta("Unesite naziv smještaja: "));
		sm.setVrsta(Pomocno.unosTeksta("Unesite vrstu smještaja: "));
		
		return sm;
	}
	private void pregled(boolean prikaziIzbornik) {
		System.out.println("Smještaji u aplikaciji");
		int rb = 1;
		for(Smjestaj sm : smjestaji) {
			System.out.println(rb++ + ". " + sm);
		}
		if (prikaziIzbornik) {
			izbornik();
		}
	}
}