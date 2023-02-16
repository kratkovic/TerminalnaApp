package ratkovic.obrada;

import java.util.ArrayList;
import java.util.List;

import ratkovic.Pomocno;
import ratkovic.Start;
import ratkovic.model.Motodogadjaj;
import ratkovic.model.Servis;
import ratkovic.model.Smjestaj;

public class Smjestaji {
	
	private List<Smjestaj> smjestaji;
	private List<Servis> servisi;
	private List<Motodogadjaj> motodogadjaji;
	private Start start;
	
	public Smjestaji(Start start) {
		super();
		this.start = start;
		smjestaji = new ArrayList<>();
		
		
	}

	public Smjestaji(Start start, List<Smjestaj> smjestaji) {
		super();
		this.smjestaji = smjestaji;
		this.start = start;
	
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
			unesiNoviSmjestaj();
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
		izbornik();
		
	}
	
	


	private void unesiNoviSmjestaj() {
		
		List<Smjestaj> smjestaji = new ArrayList<>();
		boolean unosNovogSmjestaja = true;
		while (unosNovogSmjestaja) {
		    Smjestaj sm = new Smjestaj();
		    sm.setSifra(Pomocno.unosBrojRaspon("Unesite šifru smještaja: ", 0, Integer.MAX_VALUE));
		    sm.setNaziv(Pomocno.unosTeksta("Unesite naziv smještaja: "));
		    sm.setVrsta(Pomocno.unosTeksta("Unesite vrstu smještaja: "));
		    sm.setCijena(Pomocno.unosCijene("Unesite cijenu smještaja: "));
		    int j = Pomocno.unosBrojRaspon("Odaberite moto događaj: ", 1, start.getMotodogadjaji().getMotodogadjaji().size());
		    sm.setMotodogadjaj(start.getMotodogadjaji().getMotodogadjaji().get(j-1));

		    
		    List<Servis> servisi = new ArrayList<>();
		    boolean unosNovogServisa = true;
		    while (unosNovogServisa) {
		        Servis servis = new Servis();
		        servis.setSifra(Pomocno.unosBrojRaspon("Unesite šifru servisa: ", 0, Integer.MAX_VALUE));
		        servis.setNaziv(Pomocno.unosTeksta("Unesite naziv servisa: "));
		        servis.setMjesto(Pomocno.unosTeksta("Unesite mjesto servisa: "));
		        servis.setRadnoVrijeme(Pomocno.unosTeksta("Unesite radno vrijeme: "));
		        servisi.add(servis);

		        String odgovor = Pomocno.unosTeksta("Želite li unijeti još servisa za ovaj smještaj? (da/ne)");
		        unosNovogServisa = odgovor.equalsIgnoreCase("da");
		    }
		    sm.setServisi(servisi);

		    smjestaji.add(sm);

		    String odgovor = Pomocno.unosTeksta("Želite li unijeti još smještaja? (da/ne)");
		    unosNovogSmjestaja = odgovor.equalsIgnoreCase("da");
		}

		izbornik();
		
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


	public List<Servis> getServisi() {
		return servisi;
	}


	public void setServisi(List<Servis> servisi) {
		this.servisi = servisi;
	}


	public List<Motodogadjaj> getMotodogadjaji() {
		return motodogadjaji;
	}


	public void setMotodogadjaji(List<Motodogadjaj> motodogadjaji) {
		this.motodogadjaji = motodogadjaji;
	}
}