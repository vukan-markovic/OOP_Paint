package crtanje;

import java.awt.Graphics;
import java.util.*;
import javax.swing.JPanel;

public class PnlCrtez extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Oblik> listaOblika = new ArrayList<Oblik>();

	public PnlCrtez() {
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Oblik> iteratorOblika = listaOblika.iterator();
		while(iteratorOblika.hasNext()) {
			Oblik oblikZaCrtanje = iteratorOblika.next();
			if(oblikZaCrtanje instanceof PovrsinskiOblik)
				((PovrsinskiOblik) oblikZaCrtanje).popuniOblik(g);
			oblikZaCrtanje.crtajSe(g);
		}
		repaint();
	}
	
	public ArrayList<Oblik> getListaOblika () {
		return listaOblika;
	}
}