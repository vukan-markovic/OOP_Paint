package crtanje;

import java.awt.*;

public class Tacka extends Oblik {

	private int xKoordinata;
	private int yKoordinata;

	public Tacka() {

	}

	public Tacka(int xKoordinata, int yKoordinata) {
		this.xKoordinata = xKoordinata;
		this.yKoordinata= yKoordinata;
	}

	public Tacka(int xKoordinata, int yKoordinata, Color boja) {
		this(xKoordinata, yKoordinata);
		setBoja(boja);
	}
	
	public double udaljenost(Tacka prosledjenaTacka) {
		return Math.sqrt(Math.pow(xKoordinata - prosledjenaTacka.xKoordinata, 2) + Math.pow(yKoordinata - prosledjenaTacka.yKoordinata, 2));
	}

	@Override
	public String toString() {
		return "(" + xKoordinata + "," + yKoordinata + ")";
	}

	@Implements
	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawLine(xKoordinata - 2, yKoordinata, xKoordinata + 2, yKoordinata);
		g.drawLine(xKoordinata, yKoordinata + 2, xKoordinata, yKoordinata - 2);
		if(isSelektovan())
			selektovan(g);
	}

	@Implements
	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(xKoordinata - 3, yKoordinata - 3, 6, 6);
	}

	@Implements
	public boolean sadrziKlik(int xKoordinata, int yKoordinata) {
		if(new Tacka(xKoordinata, yKoordinata).udaljenost(this) <= 2)
			return true;
		return false;
	}

	@Implements
	public void pomeriNa(int xKoordinata, int yKoordinata) {
		this.xKoordinata = xKoordinata;
		this.yKoordinata = yKoordinata;
	}

	public int getXkoordinata() {
		return xKoordinata;
	}

	public void setXkoordinata(int xKoordinata) {
		this.xKoordinata = xKoordinata;
	}

	public int getYkoordinata() {
		return yKoordinata;
	}

	public void setYkoordinata(int yKoordinata) {
		this.yKoordinata = yKoordinata;
	}
}