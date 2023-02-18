package ratkovic.obrada;

import java.util.ArrayList;
import java.util.List;

import ratkovic.Pomocno;
import ratkovic.Start;
import ratkovic.model.Motodogadjaj;
import ratkovic.model.Motoklub;

public class Motodogadjaji {

	private List<Motodogadjaj> motodogadjaji;
	private Start start;


	public List<Motodogadjaj> getMotodogadjaji() {
		return motodogadjaji;
	}

	public void setMotodogadjaji(List<Motodogadjaj> motodogadjaji) {
		this.motodogadjaji = motodogadjaji;
	}

	public Motodogadjaji(Start start) {
		super();
		this.start = start;
		motodogadjaji = new ArrayList<>();
		testPodaci();
	}

	
	private void testPodaci() {

		motodogadjaji.add(new Motodogadjaj(1, "Mega bikers susreti", "Poloj", Pomocno.kreirajDatum(14, 5, 2023), "Mario Karaš", new Motoklub(1, "MK Brod", "Slavonski Brod", 40, true)));
		motodogadjaji.add(new Motodogadjaj(2, "21. Moto susreti", "Tvrđa-katakombe", Pomocno.kreirajDatum(26, 6, 2023), "Zdravko Bošnjak", new Motoklub(2, "MK Osijek", "Osijek", 50, true)));
		motodogadjaji.add(new Motodogadjaj(3, "15. Moto party", "Dunavska šetnica", Pomocno.kreirajDatum(28, 8, 2023), "Damir Kožul", new Motoklub(3, "MK Vukovar", "Vukovar", 40, true)));

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

	public void pregled(boolean prikaziIzbornik) {
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

	
