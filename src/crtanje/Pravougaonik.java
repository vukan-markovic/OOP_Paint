package crtanje;

import java.awt.*;

public class Pravougaonik extends Kvadrat{

	private int sirina;

	public Pravougaonik() {

	}

	public Pravougaonik(Tacka goreLevo, int sirina, int visina, Color bojaIvice, Color bojaUnutrasnjosti) {
		this.goreLevo = goreLevo;
		this.sirina = sirina;
		super.stranica = visina;
		setBoja(bojaIvice);
		setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}
	
	@Override
	public Linija dijagonala() {
		return new Linija(goreLevo, new Tacka(goreLevo.getXkoordinata() + stranica, goreLevo.getYkoordinata() + sirina));
	}

	@Override
	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawRect(goreLevo.getXkoordinata(), goreLevo.getYkoordinata(), stranica, sirina);
		if(isSelektovan())
			selektovan(g);
	}

	@Override
	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(goreLevo.getXkoordinata() + super.stranica, goreLevo.getYkoordinata())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(goreLevo.getXkoordinata(), goreLevo.getYkoordinata() + sirina)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getXkoordinata() + super.stranica, goreLevo.getYkoordinata()), dijagonala().getKrajnja()).selektovan(g);
		new Linija(new Tacka(goreLevo.getXkoordinata(), goreLevo.getYkoordinata() + sirina), dijagonala().getKrajnja()).selektovan(g);
	}

	@Override
	public void popuniOblik(Graphics g) {
		g.setColor(getBojaUnutrasnjosti());
	    g.fillRect(goreLevo.getXkoordinata() + 1, goreLevo.getYkoordinata() + 1, super.stranica - 1, sirina - 1);
	}

	@Override
	public boolean sadrziKlik(int xKoordinata, int yKoordinata) {
		if(goreLevo.getXkoordinata() <= xKoordinata && xKoordinata <= (goreLevo.getXkoordinata() + sirina) && goreLevo.getYkoordinata() <= yKoordinata && yKoordinata <= goreLevo.getYkoordinata() + stranica)
			return true;
		return false;
	}

	public int getSirina() {
		return sirina;
	}

	public void setSirina(int sirina) {
		this.sirina = sirina;
	}
}