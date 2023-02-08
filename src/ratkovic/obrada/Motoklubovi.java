package ratkovic.obrada;

import java.util.ArrayList;
import java.util.List;

import ratkovic.Pomocno;
import ratkovic.Start;
import ratkovic.model.Motoklub;

public class Motoklubovi {

	private List<Motoklub> motoklubovi;
	private Start start;

	public Motoklubovi(Start start) {
		super();
		this.start = start;
		motoklubovi = new ArrayList<>();
		testPodaci();

	}

	private void testPodaci() {
		
		motoklubovi.add(new Motoklub(1, "MK Brod", "Slavonski Brod", 40, true));
		motoklubovi.add(new Motoklub(2, "MK Osijek", "Osijek", 50, true));
		motoklubovi.add(new Motoklub(3, "Vukovar", "Vukovar", 40, true));
		
		
		
	}

	public Motoklubovi(Start start, List<Motoklub> motoklubovi) {
		super();
		this.motoklubovi = motoklubovi;
		this.start = start;
		testPodaci();

	}

	public void izbornik() {
		System.out.println("");
		System.out.println("-- Izbornik Moto klubovi --");
		System.out.println("1. Pregled svih moto klubova");
		System.out.println("2. Unos novog moto kluba");
		System.out.println("3. Promjena postojećeg moto kluba");
		System.out.println("4. Brisanje moto kluba");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();

	}

	private void odabirIzbornika() {
		switch (Pomocno.unosBrojRaspon("Odaberi opciju za moto klub: ", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovog();
			break;
		case 3:
			if (motoklubovi.size() == 0) {
				System.out.println("Nema moto kluba kojeg bi mjenjali");
				izbornik();
			} else {
				promjena();
			}
		case 4:
			if(motoklubovi.size()==0) {
				System.out.println("Nema moto kluba kojeg bi brisali");
				izbornik();
			}else {
				brisanje();
			}
			
		case 5 : 
			start.glavniIzbornik();
		}

	}

	private void brisanje() {
		int rb = Pomocno.unosBrojRaspon("Odaberite moto klub koji želite obrisati: ", 1, motoklubovi.size());
		motoklubovi.remove(rb-1);
		izbornik();
		
	}

	private void promjena() {
		pregled(false);
		int rb = Pomocno.unosBrojRaspon("Odaberite moto klub koji želite promjeniti: " , 1, motoklubovi.size());
		Motoklub m = motoklubovi.get(rb-1);
		m.setNaziv(Pomocno.unosTeksta("Unesite naziv moto kluba: "));
		m.setMjesto(Pomocno.unosTeksta("Unesite mjesto moto kluba: "));
		m.setBrojClanova(rb);
		
		izbornik();
		
	}

	private void unosNovog() {
	motoklubovi.add(unesiNoviMotoKlub());
	izbornik();
	
		
	}

	private Motoklub unesiNoviMotoKlub() {
		Motoklub m = new Motoklub();
		m.setSifra(Pomocno.unosBrojRaspon("Unesi šifru moto kluba: ", 0, Integer.MAX_VALUE));
		m.setNaziv(Pomocno.unosTeksta("Unesite naziv moto kluba: "));
		m.setMjesto(Pomocno.unosTeksta("Unesite mjesto moto kluba: " ));
		m.setBrojClanova(Pomocno.unosBrojRaspon("Unesite broj članova moto kluba: ", 0, Integer.MAX_VALUE));
		m.setRegistracija(true);
		return m;
	}

	private void pregled(boolean prikaziIzbornik) {
        System.out.println("\nMoto klubovi u aplikaciji");
        int rb = 1;
        for(Motoklub m : motoklubovi) {
        	System.out.println(rb++ + ". " + m);
        }
        if(prikaziIzbornik) {
        	izbornik();
        }

		
	}
}