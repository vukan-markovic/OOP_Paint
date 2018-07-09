package crtanje;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class DlgTacka extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel glavniPanel = new JPanel();
	private JTextField txtXkoordinata;
	private JTextField txtYkoordinata;
	private JLabel lblXkoordinata;
	private JLabel lblYkoordinata;
	private int xKoordinata;
	private int yKoordinata;
	private boolean potvrdjeno;
	private JButton btnBoja;
	private Color boja = Color.BLACK;
	private Color bojaTacke = Color.BLACK;

	public static void main(String [] nizStringova) {
		try {
			DlgTacka dijalog = new DlgTacka();
			dijalog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dijalog.setVisible(true);
		} catch (Exception izuzetak) {
			izuzetak.printStackTrace();
		}
	}

	public DlgTacka() {
		setModal(true);
		setResizable(false);
		setTitle("Vrednosti tačke");
		setBounds(100, 100, 251, 245);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		glavniPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(glavniPanel, BorderLayout.CENTER);
		GridBagLayout gbl_glavniPanel = new GridBagLayout();
		gbl_glavniPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_glavniPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_glavniPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_glavniPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		glavniPanel.setLayout(gbl_glavniPanel);
		{
			lblXkoordinata = new JLabel("X koordinata");
			GridBagConstraints gbc_lblXkoordinata = new GridBagConstraints();
			gbc_lblXkoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_lblXkoordinata.gridx = 2;
			gbc_lblXkoordinata.gridy = 1;
			glavniPanel.add(lblXkoordinata, gbc_lblXkoordinata);
		}
		lblXkoordinata.setLabelFor(txtXkoordinata);
		{
			txtXkoordinata = new JTextField();
			GridBagConstraints gbc_txtXkoordinata = new GridBagConstraints();
			gbc_txtXkoordinata.gridwidth = 4;
			gbc_txtXkoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_txtXkoordinata.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXkoordinata.gridx = 4;
			gbc_txtXkoordinata.gridy = 1;
			glavniPanel.add(txtXkoordinata, gbc_txtXkoordinata);
			txtXkoordinata.setColumns(10);
		}
		{
			lblYkoordinata = new JLabel("Y koordinata");
			GridBagConstraints gbc_lblYkoordinata = new GridBagConstraints();
			gbc_lblYkoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_lblYkoordinata.gridx = 2;
			gbc_lblYkoordinata.gridy = 3;
			glavniPanel.add(lblYkoordinata, gbc_lblYkoordinata);
		}
		lblYkoordinata.setLabelFor(txtYkoordinata);
		{
			txtYkoordinata = new JTextField();
			GridBagConstraints gbc_txtYkoordinata = new GridBagConstraints();
			gbc_txtYkoordinata.gridwidth = 4;
			gbc_txtYkoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_txtYkoordinata.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYkoordinata.gridx = 4;
			gbc_txtYkoordinata.gridy = 3;
			glavniPanel.add(txtYkoordinata, gbc_txtYkoordinata);
			txtYkoordinata.setColumns(10);
		}
		
		btnBoja = new JButton("Izaberite boju");
		btnBoja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnBoja.addActionListener(new ActionListener() {
			@Implements
			public void actionPerformed(ActionEvent klik) {
				boja = JColorChooser.showDialog(null, "Panel boja", bojaTacke);
			}
		});
		
		GridBagConstraints gbc_btnBoja = new GridBagConstraints();
		gbc_btnBoja.anchor = GridBagConstraints.NORTH;
		gbc_btnBoja.insets = new Insets(0, 0, 5, 5);
		gbc_btnBoja.gridx = 2;
		gbc_btnBoja.gridy = 5;
		glavniPanel.add(btnBoja, gbc_btnBoja);
		{
			JPanel panelDugmica = new JPanel();
			panelDugmica.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(panelDugmica, BorderLayout.SOUTH);
			{
				JButton btnPotvdi = new JButton("Potvrdi");
				btnPotvdi.setBackground(Color.GREEN);
				btnPotvdi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
				btnPotvdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent klik) {
						if (txtXkoordinata.getText().isEmpty() || txtYkoordinata.getText().isEmpty()) {
							JOptionPane.showMessageDialog(getParent(), "Vrednosti ne smeju biti prazne!", "Greška", JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							try {	
								potvrdjeno = true;
								xKoordinata = Integer.parseInt(txtXkoordinata.getText());
								yKoordinata = Integer.parseInt(txtYkoordinata.getText());
								dispose();
							} catch (NumberFormatException nfe) {
								JOptionPane.showMessageDialog(getParent(),"Koordinate tačke moraju biti celi brojevi!", "Greška", JOptionPane.ERROR_MESSAGE);
								txtXkoordinata.setText("");
								txtYkoordinata.setText("");
								return;
							} 
						}  
					}
				});
				
				btnPotvdi.setActionCommand("OK");
				panelDugmica.add(btnPotvdi);
				getRootPane().setDefaultButton(btnPotvdi);
			}
			{
				JButton btnOtkazi = new JButton("Otkaži");
				btnOtkazi.setBackground(Color.RED);
				btnOtkazi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
				btnOtkazi.addActionListener(new ActionListener() {
					@Implements
					public void actionPerformed(ActionEvent klik) {
						dispose();
					}
				});
				
				btnOtkazi.setActionCommand("Cancel");
				panelDugmica.add(btnOtkazi);
			}
		}
	}

	public void popuni(Tacka prosledjena) {
		txtXkoordinata.setText(String.valueOf(prosledjena.getXkoordinata()));
		txtYkoordinata.setText(String.valueOf(prosledjena.getYkoordinata()));
		bojaTacke = prosledjena.getBoja();
	}

	public int getXkoordinata() {
		return xKoordinata;
	}

	public int getYkoordinata() {
		return yKoordinata;
	}

	public boolean isPotvrdjeno() {
		return potvrdjeno;
	}

	public Color getBoja() {
		return boja;
	}
}