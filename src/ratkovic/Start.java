package ratkovic;

import java.util.Scanner;

import ratkovic.obrada.Motoklubovi;

public class Start {
	
	private Motoklubovi motoklubovi;

	public Start() {
		Pomocno.ulaz = new Scanner(System.in);
		motoklubovi = new Motoklubovi(this);

		pozdravnaPoruka();
		glavniIzbornik();

	}

	public void glavniIzbornik() {
		System.out.println("");
		System.out.println("-- GLAVNI IZBORNIK --");
		System.out.println("   Dostupne opcije");
		System.out.println("1. Motoklubovi");
		System.out.println("2. Motodogađaji");
		System.out.println("3. Smještaji");
		System.out.println("4. Servisi");
		System.out.println("5. Izlaz iz programa");
		odabirGlavnogIzbornika();

	}

	private void odabirGlavnogIzbornika() {
		switch (Pomocno.unosBrojRaspon("Odabrana opcija", 1, 5)) {
		case 1: 
			motoklubovi.izbornik();
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
