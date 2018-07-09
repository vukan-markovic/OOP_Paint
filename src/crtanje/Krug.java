package crtanje;

import java.awt.Color;
import java.awt.Graphics;

public class Krug extends PovrsinskiOblik{

	private Tacka centar;
	private int poluprecnik;

	public Krug() {

	}

	public Krug(Tacka centar, int r, Color bojaIvice, Color bojaUnutrasnjosti) {
		this.centar = centar;
		this.poluprecnik = r;
		setBoja(bojaIvice);
		setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}
	
	@Implements
	public void pomeriNa(int xKoordinata, int yKoordinata) {
		centar.pomeriNa(xKoordinata, yKoordinata);
	}

	@Implements
	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawOval(centar.getXkoordinata() - poluprecnik, centar.getYkoordinata() - poluprecnik, 2 * poluprecnik, 2 * poluprecnik);
		if(isSelektovan())
			selektovan(g);
	}

	@Implements
	public void selektovan(Graphics g) {
		new Linija(new Tacka(centar.getXkoordinata(), centar.getYkoordinata() - poluprecnik), new Tacka(centar.getXkoordinata(), centar.getYkoordinata() + poluprecnik)).selektovan(g);
		new Linija(new Tacka(centar.getXkoordinata() - poluprecnik, centar.getYkoordinata()), new Tacka(centar.getXkoordinata() + poluprecnik, centar.getYkoordinata())).selektovan(g);
	}

	@Implements
	public void popuniOblik(Graphics g) {
		g.setColor(getBojaUnutrasnjosti());
		g.fillOval(centar.getXkoordinata() - poluprecnik + 1, centar.getYkoordinata() - poluprecnik + 1, 2 * poluprecnik - 2, 2 * poluprecnik - 2);
	}

	@Implements
	public boolean sadrziKlik(int xKoordinata, int yKoordinata) {
		if(new Tacka(xKoordinata, yKoordinata).udaljenost(getCentar()) <= poluprecnik)
			return true;
		return false;
	}

	public Tacka getCentar() {
		return centar;
	}

	public void setCentar(Tacka centar) {
		this.centar = centar;
	}

	public int getPoluprecnik() {
		return poluprecnik;
	}

	public void setPoluprecnik(int r) {
		poluprecnik = r;
	}
}