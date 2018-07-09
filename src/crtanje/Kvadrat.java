package crtanje;

import java.awt.*;

public class Kvadrat extends PovrsinskiOblik implements Comparable<Kvadrat>{

	protected Tacka goreLevo;
	protected int stranica;
	private String bojaIvice = "crna";
	private String unutrasnjaBoja = "bela";

	public Kvadrat () {

	}

	public Kvadrat (Tacka goreLevo, int stranica) {
		this.goreLevo = goreLevo;
		this.stranica = stranica;
	}

	public Kvadrat (Tacka goreLevo, int stranica, Color bojaIvice, Color bojaUnutrasnjosti) {
		this(goreLevo, stranica);
		setBoja(bojaIvice);
		setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}

	public Kvadrat (Tacka goreLevo, int stranica, String bojaIvice, String unutrasnjaBoja) {
		this(goreLevo, stranica);
		this.bojaIvice = bojaIvice;
		this.unutrasnjaBoja = unutrasnjaBoja;
	}
	
	@Override
	public String toString() {
		return "Tacka gore levo = " + getGoreLevo() + ", duzina stranice = " + stranica + ", boja ivice = " + bojaIvice + ", boja unutrasnjosti = " + unutrasnjaBoja;
	}

	public double povrsina() {
		return stranica * stranica;
	}

	@Implements
	public void pomeriNa(int x, int y) {
		goreLevo.pomeriNa(x, y);
	}

	public Linija dijagonala() {
		return new Linija(goreLevo, new Tacka(goreLevo.getXkoordinata() + stranica, goreLevo.getYkoordinata() + stranica));
	}

	@Implements
	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawRect(goreLevo.getXkoordinata(), goreLevo.getYkoordinata(), stranica, stranica);
		if (isSelektovan())
			selektovan(g);
	}

	@Implements
	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(goreLevo.getXkoordinata() + stranica, goreLevo.getYkoordinata())).selektovan(g);
		new Linija(goreLevo, new Tacka(goreLevo.getXkoordinata(), goreLevo.getYkoordinata() + stranica)).selektovan(g);
		new Linija(new Tacka(goreLevo.getXkoordinata() + stranica, goreLevo.getYkoordinata()), dijagonala().getKrajnja()).selektovan(g);
		new Linija(new Tacka(goreLevo.getXkoordinata(), goreLevo.getYkoordinata() + stranica), dijagonala().getKrajnja()).selektovan(g);
	}

	@Implements
	public void popuniOblik(Graphics g) {
		g.setColor(super.getBojaUnutrasnjosti());
		g.fillRect(goreLevo.getXkoordinata() + 1, goreLevo.getYkoordinata() + 1, stranica - 1, stranica - 1);
	}

	@Implements
	public boolean sadrziKlik(int x, int y) {
		if(this.getGoreLevo().getXkoordinata() <= x && x <= (this.getGoreLevo().getXkoordinata() + stranica) && this.getGoreLevo().getYkoordinata() <= y && y <= (this.getGoreLevo().getYkoordinata() + stranica))
			return true;
		return false;
	}

	@Implements
	public int compareTo(Kvadrat o) {
		if(o instanceof Kvadrat)
			return (int) (this.povrsina()-((Kvadrat) o).povrsina());
		else 
			return 0;
	}

	public Tacka getGoreLevo() {
		return goreLevo;
	}

	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}

	public int getStranica() {
		return stranica;
	}

	public void setStranica(int stranica) {
		this.stranica = stranica;
	}

	public String getBojaIvice() {
		return bojaIvice;
	}

	public void setBojaIvice(String boja) {
		this.bojaIvice = boja;
	}

	public String getUnutrasnjaBoja() {
		return unutrasnjaBoja;
	}

	public void setUnutrasnjaBoja(String unutrasnjaBoja) {
		this.unutrasnjaBoja = unutrasnjaBoja;
	}
}