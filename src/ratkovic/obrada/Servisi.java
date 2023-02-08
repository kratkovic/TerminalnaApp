package ratkovic.obrada;

import java.util.ArrayList;
import java.util.List;

import ratkovic.Pomocno;
import ratkovic.Start;
import ratkovic.model.Servis;

public class Servisi {

	private List<Servis> servisi;
	private Start start;

	public Servisi(Start start) {
		super();
		this.start = start;
		servisi = new ArrayList<>();
		testPodaci();
	}

	private void testPodaci() {
		servisi.add(new Servis(1, "Big bike", "Trg žrtava 1, Slavonski Brod", "08-17h"));
		servisi.add(new Servis(2, "Škaromoto", "Josipa Jurja Strossmayera 132, Osijek", "08-17h"));
		servisi.add(new Servis(3, "Mant Moto", "Nova ulica 96, Vukovar", "10-18h"));
		
	}
	
	public Servisi(Start start, List<Servis> servisi) {
		super();
		this.servisi = servisi;
		this.start = start;
		testPodaci();
	}
	
	public void izbornik() {
		System.out.println("");
		System.out.println("-- Izbornik Servisi --");
		System.out.println("1. Pregled svih servisa");
		System.out.println("2. Unos novog servisa");
		System.out.println("3. Promjena postojećeg servisa");
		System.out.println("4. Brisanje servisa");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();
	}

	private void odabirIzbornika() {
		switch(Pomocno.unosBrojRaspon("Odaberi opciju za servis: ", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovog();
			break;
		case 3:
			if(servisi.size()==0) {
				System.out.println("Nema servisa kojeg bi mjenjali");
				izbornik();
				}else {
					promjena();
				}
		case 4: 
			if (servisi.size()==0) {
				System.out.println("Nema servisa kojeg bi brisali");
				izbornik();
			}else {
				brisanje();
			}
		case 5: 
			start.glavniIzbornik();
		}

	
	}
	
	private void brisanje() {
		int rb = Pomocno.unosBrojRaspon("Odaberite servis koji želite brisati", 0, Integer.MAX_VALUE);
		servisi.remove(rb-1);
		izbornik();
	}

	private void promjena() {
		pregled(false);
		int rb = Pomocno.unosBrojRaspon("Odaberite servis koji želite promjeniti: ", 1, Integer.MAX_VALUE);
		Servis s = servisi.get(rb-1);
		s.setNaziv("Unesite naziv servisa: ");
		s.setMjesto("Unesite mjesto servisa: ");
		s.setRadnoVrijeme("Unesite radno vrijeme servisa: ");
		izbornik();
		
		
	}
	
			
	private void unosNovog() {
		servisi.add(unesiNoviServis());
		izbornik();
	}

	private Servis unesiNoviServis() {
		Servis s = new Servis();
		s.setSifra(Pomocno.unosBrojRaspon("Unesite šifru servisa", 0, Integer.MAX_VALUE));
		s.setNaziv(Pomocno.unosTeksta("Unesite naziv servisa: "));
		s.setMjesto(Pomocno.unosTeksta("Unesite mjesto servisa: "));
		s.setRadnoVrijeme("Unesite radno vijeme servisa: ");
		return null;
	}
	
	private void pregled(boolean prikaziIzbornik) {
        System.out.println("Servisi u aplikaciji");
        int rb = 1;
        for(Servis s : servisi) {
        	System.out.println(rb++ + ". " + s);
        }
        if(prikaziIzbornik) {
        	izbornik();
}
	}
}