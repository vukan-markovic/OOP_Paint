package crtanje;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.*;
import java.awt.event.*;

public class FrmCrtez extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel glavniPanel;
	private PnlCrtez centralniPanel;
	private final ButtonGroup grupaDugmica = new ButtonGroup();
	private Tacka pocetnaTackaLinije = null;
	private Color bojaIvice = Color.BLACK;
	private Color bojaUnutrasnjosti = Color.WHITE;
	private Color trenutnaBojaIvice = Color.BLACK;
	private Color trenutnaBojaUnutrasnjosti = Color.WHITE;
	private boolean zastavica;

	public static void main(String[] nizStringova) {
		EventQueue.invokeLater(new Runnable() {
			@Implements
			public void run() {
				try {
					FrmCrtez frame = new FrmCrtez();
					frame.setVisible(true);
					frame.setTitle("Markovic Vukan IT20/2016");
				} catch (Exception izuzetak) {
					izuzetak.printStackTrace();
				}
			}
		});
	}

	public FrmCrtez() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 487);
		setLocationRelativeTo(null);
		glavniPanel = new JPanel();
		glavniPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		glavniPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(glavniPanel);

		JPanel panelDugmicaZaCrtanje = new JPanel();
		panelDugmicaZaCrtanje.setBackground(Color.LIGHT_GRAY);
		JPanel panelDugmica = new JPanel();
		panelDugmica.setBackground(Color.LIGHT_GRAY);

		centralniPanel = new PnlCrtez();
		centralniPanel.setBackground(Color.WHITE);

		glavniPanel.add(panelDugmica, BorderLayout.NORTH);		
		glavniPanel.add(panelDugmicaZaCrtanje, BorderLayout.SOUTH);
		glavniPanel.add(centralniPanel, BorderLayout.CENTER);

		JToggleButton tglBtnCrtajTacku = new JToggleButton("Crtaj tačku");
		tglBtnCrtajTacku.setFont(new Font("Arial", Font.BOLD, 12));
		grupaDugmica.add(tglBtnCrtajTacku);
		tglBtnCrtajTacku.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelDugmicaZaCrtanje.add(tglBtnCrtajTacku);

		JToggleButton tglBtnCrtajKvadrat = new JToggleButton("Crtaj kvadrat");
		tglBtnCrtajKvadrat.setFont(new Font("Arial", Font.BOLD, 12));
		grupaDugmica.add(tglBtnCrtajKvadrat);
		tglBtnCrtajKvadrat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelDugmicaZaCrtanje.add(tglBtnCrtajKvadrat);

		JToggleButton tglBtnCrtajPravougaonik = new JToggleButton("Crtaj pravugaonik");
		tglBtnCrtajPravougaonik.setFont(new Font("Arial", Font.BOLD, 12));
		grupaDugmica.add(tglBtnCrtajPravougaonik);
		tglBtnCrtajPravougaonik.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelDugmicaZaCrtanje.add(tglBtnCrtajPravougaonik);

		JToggleButton tglBtnCrtajLiniju = new JToggleButton("Crtaj liniju");
		tglBtnCrtajLiniju.setFont(new Font("Arial", Font.BOLD, 12));
		grupaDugmica.add(tglBtnCrtajLiniju);
		tglBtnCrtajLiniju.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelDugmicaZaCrtanje.add(tglBtnCrtajLiniju);

		JToggleButton tglBtnCrtajKrug = new JToggleButton("Crtaj krug");
		tglBtnCrtajKrug.setFont(new Font("Arial", Font.BOLD, 12));
		grupaDugmica.add(tglBtnCrtajKrug);
		tglBtnCrtajKrug.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelDugmicaZaCrtanje.add(tglBtnCrtajKrug);

		JToggleButton tglBtnSelektuj = new JToggleButton("Selektuj");
		tglBtnSelektuj.setFont(new Font("Arial", Font.BOLD, 12));
		grupaDugmica.add(tglBtnSelektuj);
		tglBtnSelektuj.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelDugmica.add(tglBtnSelektuj);

		JButton btnModifikuj = new JButton("Modifikuj");
		btnModifikuj.setFont(new Font("Arial", Font.BOLD, 12));
		grupaDugmica.add(btnModifikuj);
		btnModifikuj.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelDugmica.add(btnModifikuj);

		JButton btnObrisi = new JButton("Obriši");
		btnObrisi.setFont(new Font("Arial", Font.BOLD, 12));
		grupaDugmica.add(btnObrisi);
		btnObrisi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelDugmica.add(btnObrisi);

		JButton btnBojaIvice = new JButton("Izaberi boju ivice");
		btnBojaIvice.setFont(new Font("Arial", Font.BOLD, 12));
		btnBojaIvice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelDugmica.add(btnBojaIvice);

		JButton btnBojaUnutrasnjosti = new JButton("Izaberi boju unutrašnjosti");
		btnBojaUnutrasnjosti.setFont(new Font("Arial", Font.BOLD, 12));
		btnBojaUnutrasnjosti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelDugmica.add(btnBojaUnutrasnjosti);

		btnBojaIvice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent klik) {
				bojaIvice = JColorChooser.showDialog(null, "Paleta boja", trenutnaBojaIvice);
				trenutnaBojaIvice = bojaIvice;
			}
		});


		btnBojaUnutrasnjosti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent klik) {
				bojaUnutrasnjosti = JColorChooser.showDialog(null, "Paleta boja", trenutnaBojaUnutrasnjosti);
				trenutnaBojaUnutrasnjosti = bojaUnutrasnjosti;
			}
		});

		centralniPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent klik) {

				Iterator<Oblik> iteratorOblika = centralniPanel.getListaOblika().iterator();
				while(iteratorOblika.hasNext()) {
					Oblik oblikZaSelekciju = iteratorOblika.next();
					if(oblikZaSelekciju.isSelektovan()) {
						oblikZaSelekciju.setSelektovan(false);
						return;
					}
				}

				if(tglBtnCrtajTacku.isSelected()) {
					centralniPanel.getListaOblika().add(new Tacka(klik.getX(),klik.getY(),bojaIvice));
				}
				else if(tglBtnCrtajLiniju.isSelected()) {

					if(pocetnaTackaLinije == null) 
						pocetnaTackaLinije = new Tacka(klik.getX(),klik.getY(),bojaIvice);
					else
					{
						Tacka krajnjaTackaLinije = new Tacka(klik.getX(),klik.getY());
						centralniPanel.getListaOblika().add(new Linija(pocetnaTackaLinije,krajnjaTackaLinije,bojaIvice));
						pocetnaTackaLinije = null;
					}
				}
				else if(tglBtnCrtajKvadrat.isSelected()) {
					DlgKvadrat kvadrat = new DlgKvadrat();
					kvadrat.upisi(klik.getX(),klik.getY());
					kvadrat.obrisiDugmice();
					kvadrat.setVisible(true);
					Kvadrat kvadratZaCrtanje = new Kvadrat(new Tacka(klik.getX(),klik.getY()),kvadrat.getDuzinaStranice(),bojaIvice,bojaUnutrasnjosti);
					centralniPanel.getListaOblika().add(kvadratZaCrtanje);
				}
				else if(tglBtnCrtajPravougaonik.isSelected()) {
					DlgPravougaonik pravougaonik = new DlgPravougaonik();
					pravougaonik.upisi(klik.getX(), klik.getY());
					pravougaonik.obrisiDugmice();
					pravougaonik.setVisible(true);
					Pravougaonik pravougaonikZaCrtanje = new Pravougaonik(new Tacka(klik.getX(),klik.getY()),pravougaonik.getSirina(),pravougaonik.getVisina(),bojaIvice,bojaUnutrasnjosti);
					centralniPanel.getListaOblika().add(pravougaonikZaCrtanje);
				}
				else if(tglBtnCrtajKrug.isSelected()) {
					DlgKrug krug = new DlgKrug();
					krug.upisi(klik.getX(), klik.getY());
					krug.obrisiDugmice();
					krug.setVisible(true);
					Krug krugZaCrtanje = new Krug(new Tacka(klik.getX(),klik.getY()),krug.getDuzinaPoluprecnika(),bojaIvice,bojaUnutrasnjosti);
					centralniPanel.getListaOblika().add(krugZaCrtanje);
				}


				if(tglBtnSelektuj.isSelected()) {
					if(centralniPanel.getListaOblika().isEmpty())
						JOptionPane.showMessageDialog(null, "Nema oblika za selekciju!", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
					Iterator <Oblik> iterator = centralniPanel.getListaOblika().iterator();	
					ArrayList<Oblik> arLista = new ArrayList<Oblik>();
					while(iterator.hasNext()) {
						Oblik oblikZaSelekciju = iterator.next();
						if(oblikZaSelekciju.sadrziKlik(klik.getX(), klik.getY())) {
							arLista.add(oblikZaSelekciju);
						}
					}
					if(arLista.size()==1) {
						arLista.get(0).setSelektovan(true);
					}
					else if(arLista.size() >= 2){
						arLista.get(arLista.size()-1).setSelektovan(true);;
					}
					return;
				}
			}
		});


		btnModifikuj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent klik) {
				if(centralniPanel.getListaOblika().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nema oblika za modifikaciju!", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				Iterator<Oblik> iterator = centralniPanel.getListaOblika().iterator();
				while(iterator.hasNext()) {
					Oblik oblikZaModifikaciju = iterator.next();
					if(oblikZaModifikaciju.isSelektovan()) {
						zastavica = true;
						if(oblikZaModifikaciju instanceof Tacka) {
							DlgTacka tacka = new DlgTacka();
							tacka.popuni((Tacka) oblikZaModifikaciju);
							tacka.setVisible(true);
							if(tacka.isPotvrdjeno()) {
								Tacka tackaZaModifikaciju = (Tacka) oblikZaModifikaciju;
								tackaZaModifikaciju.pomeriNa(tacka.getXkoordinata(), tacka.getYkoordinata());
								tackaZaModifikaciju.setBoja(tacka.getBoja());
							}
						} 
						else if(oblikZaModifikaciju instanceof Linija) {
							DlgLinija linija = new DlgLinija();
							linija.popuni((Linija) oblikZaModifikaciju);
							linija.setVisible(true);
							if(linija.isPotvrdjeno()) {
								Linija linijaZaModifikaciju = (Linija) oblikZaModifikaciju;
								linijaZaModifikaciju.getPocetna().setXkoordinata(linija.getXkoordinataPocetna());
								linijaZaModifikaciju.getPocetna().setYkoordinata(linija.getYKoordinataPocetna());
								linijaZaModifikaciju.getKrajnja().setXkoordinata(linija.getXkoordinataKrajnja());
								linijaZaModifikaciju.getKrajnja().setYkoordinata(linija.getYKoordinataKrajnja());
								linijaZaModifikaciju.setBoja(linija.getBoja());
							}
						}
						else if(oblikZaModifikaciju instanceof Pravougaonik) {
							DlgPravougaonik pravougaonik = new DlgPravougaonik();
							pravougaonik.popuni((Pravougaonik) oblikZaModifikaciju);
							pravougaonik.setVisible(true);
							if(pravougaonik.isPotvrdjeno()) {
								Pravougaonik pomocniPravougaonik = (Pravougaonik) oblikZaModifikaciju;
								pomocniPravougaonik.pomeriNa(pravougaonik.getxKoordinata(), pravougaonik.getyKoordinata());
								pomocniPravougaonik.setStranica(pravougaonik.getVisina());
								pomocniPravougaonik.setSirina(pravougaonik.getSirina());
								pomocniPravougaonik.setBoja(pravougaonik.getBojaIvice());
								pomocniPravougaonik.setBojaUnutrasnjosti(pravougaonik.getBojaUnutrasnjosti());
							}
						}
						else if(oblikZaModifikaciju instanceof Kvadrat) {
							DlgKvadrat kvadrat = new DlgKvadrat();
							kvadrat.popuni((Kvadrat) oblikZaModifikaciju);
							kvadrat.setVisible(true);
							if(kvadrat.isPotvrdjeno()) {
								Kvadrat pomocniKvadrat = (Kvadrat) oblikZaModifikaciju;
								pomocniKvadrat.pomeriNa(kvadrat.getXkoordinata(),kvadrat.getYkoordinata());
								pomocniKvadrat.setStranica(kvadrat.getDuzinaStranice());
								pomocniKvadrat.setBoja(kvadrat.getBojaIvice());
								pomocniKvadrat.setBojaUnutrasnjosti(kvadrat.getBojaUnutrasnjosti());
							}
						}
						else if(oblikZaModifikaciju instanceof Krug) {
							DlgKrug krug = new DlgKrug();
							krug.popuni((Krug) oblikZaModifikaciju);
							krug.setVisible(true);
							if(krug.isPotvrdjeno()) {
								Krug krugZaModifikaciju = (Krug) oblikZaModifikaciju;
								krugZaModifikaciju.pomeriNa(krug.getXkoordinataCentra(), krug.getYkoordinataCentra());
								krugZaModifikaciju.setPoluprecnik(krug.getDuzinaPoluprecnika());
								krugZaModifikaciju.setBoja(krug.getBojaIvice());
								krugZaModifikaciju.setBojaUnutrasnjosti(krug.getBojaUnutrasnjosti());
							}
						}
					}
				}
				if(!zastavica) {
					JOptionPane.showMessageDialog(null, "Morate selektovati oblik da bi ste ga modifikovali!", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
		});

		btnObrisi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent klik) {
				if(centralniPanel.getListaOblika().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nema oblika za brisanje!", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				Iterator<Oblik> iteratorOblika = centralniPanel.getListaOblika().iterator();
				while(iteratorOblika.hasNext()) {
					Oblik oblikZaBrisanje = iteratorOblika.next();
					if(oblikZaBrisanje.isSelektovan()) {
						int odgovor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da izbrišete selektovani oblik?", "Upozorenje!", JOptionPane.YES_NO_OPTION);
						if(odgovor == 0)
							centralniPanel.getListaOblika().remove(oblikZaBrisanje);
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Morate selektovati oblik da bi ste ga obrisali!", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		});	
	}
}