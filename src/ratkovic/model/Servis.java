package ratkovic.model;

public class Servis extends Entitet {
	
	private String naziv;
	private String mjesto;
	private String radnoVrijeme;
	
		
	public Servis() {
		super();
	}
	public Servis(int sifra, String naziv, String mjesto, String radnoVrijeme) {
		super(sifra);
		this.naziv = naziv;
		this.mjesto = mjesto;
		this.radnoVrijeme = radnoVrijeme;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getMjesto() {
		return mjesto;
	}
	public void setMjesto(String mjesto) {
		this.mjesto = mjesto;
	}
	public String getRadnoVrijeme() {
		return radnoVrijeme;
	}
	public void setRadnoVrijeme(String radnoVrijeme) {
		this.radnoVrijeme = radnoVrijeme;
	}
	
	@Override
	public String toString() {
		return naziv + ", " +  mjesto + ", " + radnoVrijeme;
}
}