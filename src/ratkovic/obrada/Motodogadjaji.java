package ratkovic.obrada;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ratkovic.Pomocno;
import ratkovic.Start;
import ratkovic.model.Motodogadjaj;
import ratkovic.model.Motoklub;

public class Motodogadjaji {

	private List<Motodogadjaj> motodogadjaji;
	private Start start;

	public Motodogadjaji(Start start) {
		super();
		this.start = start;
		motodogadjaji = new ArrayList<>();
		testPodaci();
	}

	private void testPodaci() {

		motodogadjaji.add(new Motodogadjaj(1, "Mega bikers susreti", "Poloj", Date, "Mario Karaš", null));
		motodogadjaji.add(new Motodogadjaj(2, "21. Moto susreti", "Tvrđa-katakombe", Date, "Zdravko Bošnjak", null));
		motodogadjaji.add(new Motodogadjaj(3, "15. Moto party", "Dunavska šetnica", Date, "Damir Kožul", null));

	}

	public Motodogadjaji(Start start, List<Motodogadjaj> motodogadjaji) {
		super();
      this.motodogadjaji = motodogadjaji;
      this.start = start;
      testPodaci();
      
      
	}
	
	public void izbornik() {
		System.out.println("");
		System.out.println("-- Izbornik Moto događaja --");
		System.out.println("1. Pregled svih moto događaja");
		System.out.println("2. Unos novog moto događaja");
		System.out.println("3. Promjena postojećeg moto događaja");
		System.out.println("4. Brisanje moto moto događaja");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();

	}
	private void odabirIzbornika() {
		switch (Pomocno.unosBrojRaspon("Odaberi opciju za moto događaj: ", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovog();
			break;
		case 3:
			if (motodogadjaji.size() == 0) {
				System.out.println("Nema moto događaja kojeg bi mjenjali");
				izbornik();
			} else {
				promjena();
			}
		case 4:
			if(motodogadjaji.size()==0) {
				System.out.println("Nema moto događaja kojeg bi brisali");
				izbornik();
			}else {
				brisanje();
			}
			
		case 5 : 
			start.glavniIzbornik();
		}

	}

	
		
	

	private void brisanje() {
		int rb = Pomocno.unosBrojRaspon("Odaberite moto događaj koji želite obrisati: ", 1, motodogadjaji.size());
		motodogadjaji.remove(rb-1);
		izbornik();
}

	private void promjena() {
		pregled(false);
		int rb = Pomocno.unosBrojRaspon("Odaberite moto događaj koji želite promjeniti", 1, motodogadjaji.size());
		Motodogadjaj d = motodogadjaji.get(rb-1);
		d.setNaziv(Pomocno.unosTeksta("Unesite naziv moto događaja: "));
		d.setMjestoOdrzavanja(Pomocno.unosTeksta("Unesite mjesto održavanja moto događaja: " ));
		d.setOdgovorniClan(Pomocno.unosTeksta("Unesite odgovornog člana za moto događaj: "));
		izbornik();
		
		
		
	}
	
	private void unosNovog() {
		motodogadjaji.add(unesiNoviMotoDogadjaj());
		izbornik();
	}
	

	private Motodogadjaj unesiNoviMotoDogadjaj() {
		Motodogadjaj d = new Motodogadjaj();
		d.setSifra(Pomocno.unosBrojRaspon("Unesite šifru moto događaja: ", 0, Integer.MAX_VALUE));
		d.setNaziv(Pomocno.unosTeksta("Unesite naziv moto događaja: "));
		d.setMjestoOdrzavanja(Pomocno.unosTeksta("Unesite mjesto održavanja moto događaja: "));
		return d;
	}

	private void pregled(boolean prikaziIzbornik) {
		 System.out.println("Moto događaji u aplikaciji");
	        int rb = 1;
	        for(Motodogadjaj d : motodogadjaji) {
	        	System.out.println(rb++ + ". " + d);
	        }
	        if(prikaziIzbornik) {
	        	izbornik();
		
	}

	}
}

	