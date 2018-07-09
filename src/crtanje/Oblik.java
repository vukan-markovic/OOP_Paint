package crtanje;

import java.awt.*;

public abstract class Oblik implements Pomerljiv {
	
	private boolean selektovan;
	private Color boja = Color.BLACK;
	
	public Oblik() {
		
	}
	
	public Color getBoja() {
		return boja;
	}
	
	public void setBoja(Color boja) {
		this.boja = boja;
	}
	
	public abstract void crtajSe(Graphics g);
	public abstract void selektovan(Graphics g);
	public abstract boolean sadrziKlik(int xKoordinata, int yKoordinata);
	
	public boolean isSelektovan() {
		return selektovan;
	}
	
	public void setSelektovan(boolean selektovan) {
		this.selektovan = selektovan;
	}
}