package ratkovic;

import java.util.Scanner;

import ratkovic.model.Motodogadjaj;
import ratkovic.obrada.Motodogadjaji;
import ratkovic.obrada.Motoklubovi;
import ratkovic.obrada.Servisi;
import ratkovic.obrada.Smjestaji;

public class Start {
	
	private Motoklubovi motoklubovi;
	private Servisi servisi;
	private Motodogadjaji motodogadjaji;
	private Smjestaji smjestaji;

	public Start() {
		Pomocno.ulaz = new Scanner(System.in);
		motoklubovi = new Motoklubovi(this);
		servisi = new Servisi(this);
		motodogadjaji = new Motodogadjaji(this);
		smjestaji = new Smjestaji(this);

		pozdravnaPoruka();
		glavniIzbornik();

	}

	public Motoklubovi getMotoklubovi() {
		return motoklubovi;
	}

	public void setMotoklubovi(Motoklubovi motoklubovi) {
		this.motoklubovi = motoklubovi;
	}

	public Servisi getServisi() {
		return servisi;
	}

	public void setServisi(Servisi servisi) {
		this.servisi = servisi;
	}

	public Motodogadjaji getMotodogadjaji() {
		return motodogadjaji;
	}

	public void setMotodogadjaji(Motodogadjaji motodogadjaji) {
		this.motodogadjaji = motodogadjaji;
	}

	public void glavniIzbornik() {
		System.out.println("");
		System.out.println("-- GLAVNI IZBORNIK --");
		System.out.println("  Dostupne opcije");
		System.out.println("1. Moto klubovi");
		System.out.println("2. Moto događaji");
		System.out.println("3. Smještaji");
		System.out.println("4. Servisi");
		System.out.println("5. Izlaz iz programa");
		odabirGlavnogIzbornika();

	}

	private void odabirGlavnogIzbornika() {
		switch (Pomocno.unosBrojRaspon("Odabrana opcija: ", 1, 5)) {
		case 1: 
			motoklubovi.izbornik();
			break;
		case 3:
			smjestaji.izbornik();
			break;
		case 4:
			servisi.izbornik();
			break;
		case 5: {
			glavniIzbornik();
			break;
			
		}
		
		}

	}

	private void pozdravnaPoruka() {
		System.out.println("Dobrodošli u Motovodič terminal aplikaciju");

	}

	public static void main(String[] args) {
		if (args.length == 1) {
			Pomocno.DEV = true;
		} else {
			Pomocno.DEV = false;
		}
		new Start();

	}

	
	}

