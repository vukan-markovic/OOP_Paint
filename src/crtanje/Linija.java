package crtanje;

import java.awt.*;

public class Linija extends Oblik {

	private Tacka pocetna;
	private Tacka krajnja;

	public Linija() {

	}

	public Linija(Tacka pocetna, Tacka krajnja) {
		this.pocetna = pocetna;
		this.krajnja = krajnja;
	}

	public Linija(Tacka pocetna, Tacka krajnja, Color boja) {
		this(pocetna, krajnja);	
		setBoja(boja);
	}
	
	@Implements
	public void pomeriNa(int x, int y) {
	}

	public double duzina() {
		return pocetna.udaljenost(krajnja);
	}

	public Tacka sredinaLinije(){
		return new Tacka((pocetna.getXkoordinata() + krajnja.getXkoordinata())/2, (pocetna.getYkoordinata() + krajnja.getYkoordinata()) / 2);
	}

	@Implements
	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawLine(pocetna.getXkoordinata(), pocetna.getYkoordinata(), krajnja.getXkoordinata(), krajnja.getYkoordinata());
		if(isSelektovan())
			selektovan(g);
	}

	@Implements
	public void selektovan(Graphics g){
		g.setColor(Color.BLUE);
		pocetna.selektovan(g);
		krajnja.selektovan(g);
		sredinaLinije().selektovan(g);
	}

	@Implements
	public boolean sadrziKlik(int xKoordinata, int yKoordinata){
		if((pocetna.udaljenost(new Tacka(xKoordinata, yKoordinata)) + krajnja.udaljenost(new Tacka(xKoordinata, yKoordinata))) - duzina() <= 1)
			return true;
		return false;
	}

	public Tacka getPocetna() {
		return pocetna;
	}

	public void setPocetna(Tacka pocetna) {
		this.pocetna = pocetna;
	}

	public Tacka getKrajnja() {
		return krajnja;
	}

	public void setKrajnja(Tacka krajnja) {
		this.krajnja = krajnja;
	}
}