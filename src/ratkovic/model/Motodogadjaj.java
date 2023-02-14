package ratkovic.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Motodogadjaj extends Entitet {
	
	private String naziv;
	private String mjestoOdrzavanja;
	private Date datumPocetka;
	private String odgovorniClan;
	private Motoklub motoklub;
	
	public Motodogadjaj() {
		super();
	}
	public Motodogadjaj(int sifra, String naziv, String mjestoOdrzavanja, Date datumPocetka, String odgovorniClan,
			Motoklub motoklub) {
		super(sifra);
		this.naziv = naziv;
		this.mjestoOdrzavanja = mjestoOdrzavanja;
		this.datumPocetka = datumPocetka;
		this.odgovorniClan = odgovorniClan;
		this.motoklub = motoklub;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getMjestoOdrzavanja() {
		return mjestoOdrzavanja;
	}
	public void setMjestoOdrzavanja(String mjestoOdrzavanja) {
		this.mjestoOdrzavanja = mjestoOdrzavanja;
	}
	public Date getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	public String getOdgovorniClan() {
		return odgovorniClan;
	}
	public void setOdgovorniClan(String odgovorniClan) {
		this.odgovorniClan = odgovorniClan;
	}
	public Motoklub getMotoklub() {
		return motoklub;
	}
	public void setMotoklub(Motoklub motoklub) {
		this.motoklub = motoklub;
	}
	
	
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	    String formatiraniDatum = dateFormat.format(datumPocetka);
	    return naziv + ", " +  mjestoOdrzavanja + ", " + formatiraniDatum;
	
	
	}

}
