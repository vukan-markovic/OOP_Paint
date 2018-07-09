package crtanje;

import java.awt.*;

public abstract class PovrsinskiOblik extends Oblik {
	
	private Color bojaUnutrasnjosti = Color.WHITE;

	public abstract void popuniOblik(Graphics oblikZaPopunjavanje);

	public Color getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(Color bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}
}