package ratkovic.model;

import java.math.BigDecimal;
import java.util.List;

public class Smjestaj extends Entitet{
	
	private String naziv;
	private String vrsta;
	private BigDecimal cijena;
	private Motodogadjaj motodogadjaj;
	private List<Servis> servisi;
	
	
	public List<Servis> getServisi() {
		return servisi;
	}
	public void setServisi(List<Servis> servisi) {
		this.servisi = servisi;
	}
	public Smjestaj() {
		super();
	}

	public Smjestaj(int sifra, String naziv, String vrsta, BigDecimal cijena, Motodogadjaj motodogadjaj,
			List<Servis> servisi) {
		super(sifra);
		this.naziv = naziv;
		this.vrsta = vrsta;
		this.cijena = cijena;
		this.motodogadjaj = motodogadjaj;
		this.servisi = servisi;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getVrsta() {
		return vrsta;
	}
	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}
	public BigDecimal getCijena() {
		return cijena;
	}
	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}
	public Motodogadjaj getMotodogadjaj() {
		return motodogadjaj;
	}
	public void setMotodogadjaj(Motodogadjaj motodogadjaj) {
		this.motodogadjaj = motodogadjaj;
	}
	
		
	@Override
	public String toString() {
		return naziv + ", " +  vrsta + ", " + cijena + "€";
	
	
}
}
	
	