package stek;

import java.util.Stack;
import javax.swing.border.EmptyBorder;
import crtanje.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrmStek extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel glavniPanel;
	private Stack <Kvadrat> stekKvadrata = new Stack<Kvadrat>();
	private static DefaultListModel <Kvadrat> dlmLista = new DefaultListModel<Kvadrat>();

	public static void main(String [] nizStringova) {
		EventQueue.invokeLater(new Runnable() {
			@Implements
			public void run() {
				try {
					FrmStek frame = new FrmStek();
					frame.setVisible(true);
				} catch (Exception izuzetak) {
					izuzetak.printStackTrace();
				}
			}
		});
	}

	public FrmStek() {
		setTitle("Markovic Vukan IT20/2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 463);
		setLocationRelativeTo(null);
		glavniPanel = new JPanel();
		glavniPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		glavniPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(glavniPanel);

		JButton btnDodajNaStek = new JButton("Dodaj na stek");
		btnDodajNaStek.setFont(new Font("Arial", Font.BOLD, 12));
		btnDodajNaStek.setBackground(Color.GREEN);
		btnDodajNaStek.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnDodajNaStek.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent klik) {
				DlgKvadrat dodajKvadrat = new DlgKvadrat();
				dodajKvadrat.setVisible(true);	
				if(dodajKvadrat.isPotvrdjeno()) {
					stekKvadrata.push(new Kvadrat(new Tacka(dodajKvadrat.getXkoordinata(),dodajKvadrat.getYkoordinata()),dodajKvadrat.getDuzinaStranice(),dodajKvadrat.getBojaIvice(),dodajKvadrat.getBojaUnutrasnjosti()));
					azurirajListu();
				}
			}
		});

		JButton btnIzuzmiSaSteka = new JButton("Izuzmi sa steka");
		btnIzuzmiSaSteka.setFont(new Font("Arial", Font.BOLD, 12));
		btnIzuzmiSaSteka.setBackground(Color.RED);
		btnIzuzmiSaSteka.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnIzuzmiSaSteka.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent klik) {
				if(!stekKvadrata.isEmpty()) {
					DlgKvadrat izuzmiKvadrat = new DlgKvadrat();
					izuzmiKvadrat.popuniPolja(stekKvadrata.peek());
					izuzmiKvadrat.zamrzniPolja();
					izuzmiKvadrat.setVisible(true);
					if(izuzmiKvadrat.isPotvrdjeno()) {
						stekKvadrata.pop();
						azurirajListu();
					}
				}
				else
					JOptionPane.showMessageDialog(null,"Stek je trenutno prazan, nema elemenata za brisanje!", "Greška!",JOptionPane.ERROR_MESSAGE);
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		glavniPanel.add(scrollPane, BorderLayout.CENTER);

		JList <Kvadrat> listaKvadrata = new JList<Kvadrat>();
		listaKvadrata.setBackground(Color.ORANGE);
		listaKvadrata.setFont(new Font("Arial", Font.BOLD, 12));
		scrollPane.setViewportView(listaKvadrata);
		listaKvadrata.setModel(dlmLista);

		JPanel panelDugmica = new JPanel();
		panelDugmica.setBackground(Color.LIGHT_GRAY);
		panelDugmica.add(btnDodajNaStek);
		panelDugmica.add(btnIzuzmiSaSteka);
		glavniPanel.add(panelDugmica, BorderLayout.NORTH);
	}

	public void azurirajListu() {
		dlmLista.removeAllElements();
		for (int i = stekKvadrata.size() - 1; i >= 0; i--) {
			dlmLista.addElement(stekKvadrata.get(i));
		}
	}
}