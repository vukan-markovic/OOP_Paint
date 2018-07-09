package sortiranje;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import crtanje.*;

public class FrmSortiranje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel glavniPanel;
	private DefaultListModel<Kvadrat> dlmLista = new DefaultListModel<Kvadrat>();
	private ArrayList<Kvadrat> arLista = new ArrayList<Kvadrat>();
	private JScrollPane scrollPane;

	public static void main(String [] nizStringova) {
		EventQueue.invokeLater(new Runnable() {
			@Implements
			public void run() {
				try {
					FrmSortiranje frame = new FrmSortiranje();
					frame.setVisible(true);
				} catch (Exception izuzetak) {
					izuzetak.printStackTrace();
				}
			}
		});
	}

	public FrmSortiranje() {
		setTitle("Markovic Vukan IT20/2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 466);
		setLocationRelativeTo(null);
		glavniPanel = new JPanel();
		glavniPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		glavniPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(glavniPanel);

		JButton btnSortirajListu = new JButton("Sortiraj sadržaj liste");
		btnSortirajListu.setFont(new Font("Arial", Font.BOLD, 12));
		btnSortirajListu.setBackground(Color.CYAN);
		btnSortirajListu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnSortirajListu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent klik) {
				if(!dlmLista.isEmpty()) {
					ArrayList <Kvadrat> sortiranaLista = new ArrayList<Kvadrat>(arLista);
					sortiranaLista.sort(null);
					dlmLista.removeAllElements();
					Iterator<Kvadrat> iterator = sortiranaLista.iterator();
					while(iterator.hasNext())
						dlmLista.addElement(iterator.next());
				}
				else
					JOptionPane.showMessageDialog(null,"Lista je trenutno prazna, nema elemenata za sortiranje!", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		scrollPane = new JScrollPane();
		glavniPanel.add(scrollPane, BorderLayout.CENTER);

		JList <Kvadrat> listaKvadrata = new JList<Kvadrat>();
		listaKvadrata.setBackground(new Color(255, 255, 0));
		scrollPane.setViewportView(listaKvadrata);
		listaKvadrata.setModel(dlmLista);

		JButton btnDodajKvadratUListu = new JButton("Dodaj kvadrat u listu");
		btnDodajKvadratUListu.setFont(new Font("Arial", Font.BOLD, 12));
		btnDodajKvadratUListu.setBackground(Color.GREEN);
		btnDodajKvadratUListu .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnDodajKvadratUListu .addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent klik) {
				stek.DlgKvadrat dodaj = new stek.DlgKvadrat();
				dodaj.setVisible(true);	
				if(dodaj.isPotvrdjeno()) {
					dlmLista.addElement(new Kvadrat(new Tacka(dodaj.getXkoordinata(),dodaj.getYkoordinata()),dodaj.getDuzinaStranice(),dodaj.getBojaIvice(),dodaj.getBojaUnutrasnjosti()));
					arLista.add(new Kvadrat(new Tacka(dodaj.getXkoordinata(),dodaj.getYkoordinata()),dodaj.getDuzinaStranice(),dodaj.getBojaIvice(),dodaj.getBojaUnutrasnjosti()));
				}
			}
		});

		JPanel panelDugmica = new JPanel();
		panelDugmica.setBackground(Color.LIGHT_GRAY);
		panelDugmica.add(btnDodajKvadratUListu);
		panelDugmica.add(btnSortirajListu);

		glavniPanel.add(panelDugmica, BorderLayout.NORTH);
	}
}