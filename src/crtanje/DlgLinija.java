package crtanje;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class DlgLinija extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel glavniPanel = new JPanel();
	private JTextField txtXkoordinataPocetna;
	private JTextField txtYkoordinataPocetna;
	private JLabel lblXkoordinataPocetna;
	private JLabel lblYkoordinataPocetna;
	private boolean potvrdjeno;
	private JButton btnBoja;
	private Color boja = Color.BLACK;
	private Color bojaLinije = Color.BLACK;
	private JLabel lblXkoordinataKrajnja;
	private JLabel lblYkoordinataKrajnja;
	private JTextField txtXkoordinataKrajnja;
	private JTextField txtYkoordinataKrajnja;
	private int xKoordinataPocetna;
	private int yKoordinataPocetna;
	private int xKoordinataKrajnja;
	private int yKoordinataKrajnja;

	public static void main(String[] nizStringova) {
		try {
			DlgLinija dijalog = new DlgLinija();
			dijalog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dijalog.setVisible(true);
		} catch (Exception izuzetak) {
			izuzetak.printStackTrace();
		}
	}

	public DlgLinija() {
		setModal(true);
		setResizable(false);
		setTitle("Vrednosti linije");
		setBounds(100, 100, 325, 373);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		glavniPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(glavniPanel, BorderLayout.CENTER);
		GridBagLayout gbl_glavniPanel = new GridBagLayout();
		gbl_glavniPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_glavniPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_glavniPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_glavniPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		glavniPanel.setLayout(gbl_glavniPanel);
		{
			lblXkoordinataPocetna = new JLabel("X koordinata po\u010Detne ta\u010Dke ");
			lblXkoordinataPocetna.setFont(new Font("Arial", Font.BOLD, 12));
			GridBagConstraints gbc_lblXkoordinataPocetna = new GridBagConstraints();
			gbc_lblXkoordinataPocetna.insets = new Insets(0, 0, 5, 5);
			gbc_lblXkoordinataPocetna.gridx = 1;
			gbc_lblXkoordinataPocetna.gridy = 2;
			glavniPanel.add(lblXkoordinataPocetna, gbc_lblXkoordinataPocetna);
		}
		{
			txtXkoordinataPocetna = new JTextField();
			lblXkoordinataPocetna.setLabelFor(txtXkoordinataPocetna);
			txtXkoordinataPocetna.setFont(new Font("Arial", Font.BOLD, 12));
			GridBagConstraints gbc_txtXkoordinataPocetna = new GridBagConstraints();
			gbc_txtXkoordinataPocetna.gridwidth = 3;
			gbc_txtXkoordinataPocetna.insets = new Insets(0, 0, 5, 5);
			gbc_txtXkoordinataPocetna.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXkoordinataPocetna.gridx = 3;
			gbc_txtXkoordinataPocetna.gridy = 2;
			glavniPanel.add(txtXkoordinataPocetna, gbc_txtXkoordinataPocetna);
			txtXkoordinataPocetna.setColumns(10);
		}
		{
			lblYkoordinataPocetna = new JLabel("Y koordinata po\u010Detne ta\u010Dke");
			lblYkoordinataPocetna.setFont(new Font("Arial", Font.BOLD, 12));
			GridBagConstraints gbc_lblYkoordinataPocetna = new GridBagConstraints();
			gbc_lblYkoordinataPocetna.insets = new Insets(0, 0, 5, 5);
			gbc_lblYkoordinataPocetna.gridx = 1;
			gbc_lblYkoordinataPocetna.gridy = 4;
			glavniPanel.add(lblYkoordinataPocetna, gbc_lblYkoordinataPocetna);
		}
		{
			txtYkoordinataPocetna = new JTextField();
			lblYkoordinataPocetna.setLabelFor(txtYkoordinataPocetna);
			txtYkoordinataPocetna.setFont(new Font("Arial", Font.BOLD, 12));
			GridBagConstraints gbc_txtYkoordinataPocetna = new GridBagConstraints();
			gbc_txtYkoordinataPocetna.gridwidth = 3;
			gbc_txtYkoordinataPocetna.insets = new Insets(0, 0, 5, 5);
			gbc_txtYkoordinataPocetna.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYkoordinataPocetna.gridx = 3;
			gbc_txtYkoordinataPocetna.gridy = 4;
			glavniPanel.add(txtYkoordinataPocetna, gbc_txtYkoordinataPocetna);
			txtYkoordinataPocetna.setColumns(10);
		}
		{
			lblXkoordinataKrajnja = new JLabel("X koordinata krajnje ta\u010Dke");
			lblXkoordinataKrajnja.setFont(new Font("Arial", Font.BOLD, 12));
			GridBagConstraints gbc_lblXkoordinataKrajnja = new GridBagConstraints();
			gbc_lblXkoordinataKrajnja.insets = new Insets(0, 0, 5, 5);
			gbc_lblXkoordinataKrajnja.gridx = 1;
			gbc_lblXkoordinataKrajnja.gridy = 6;
			glavniPanel.add(lblXkoordinataKrajnja, gbc_lblXkoordinataKrajnja);
		}
		{
			txtXkoordinataKrajnja = new JTextField();
			lblXkoordinataKrajnja.setLabelFor(txtXkoordinataKrajnja);
			GridBagConstraints gbc_txtXkoordinataKrajnja = new GridBagConstraints();
			gbc_txtXkoordinataKrajnja.gridwidth = 3;
			gbc_txtXkoordinataKrajnja.insets = new Insets(0, 0, 5, 5);
			gbc_txtXkoordinataKrajnja.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXkoordinataKrajnja.gridx = 3;
			gbc_txtXkoordinataKrajnja.gridy = 6;
			glavniPanel.add(txtXkoordinataKrajnja, gbc_txtXkoordinataKrajnja);
			txtXkoordinataKrajnja.setColumns(10);
		}
		{
			lblYkoordinataKrajnja = new JLabel("Y koordinata krajnje ta\u010Dke");
			lblYkoordinataKrajnja.setFont(new Font("Arial", Font.BOLD, 12));
			GridBagConstraints gbc_lblYkoordinataKrajnja = new GridBagConstraints();
			gbc_lblYkoordinataKrajnja.insets = new Insets(0, 0, 5, 5);
			gbc_lblYkoordinataKrajnja.gridx = 1;
			gbc_lblYkoordinataKrajnja.gridy = 8;
			glavniPanel.add(lblYkoordinataKrajnja, gbc_lblYkoordinataKrajnja);
		}
		{
			txtYkoordinataKrajnja = new JTextField();
			lblYkoordinataKrajnja.setLabelFor(txtYkoordinataKrajnja);
			GridBagConstraints gbc_txtYkoordinataKrajnja = new GridBagConstraints();
			gbc_txtYkoordinataKrajnja.gridwidth = 3;
			gbc_txtYkoordinataKrajnja.insets = new Insets(0, 0, 5, 5);
			gbc_txtYkoordinataKrajnja.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYkoordinataKrajnja.gridx = 3;
			gbc_txtYkoordinataKrajnja.gridy = 8;
			glavniPanel.add(txtYkoordinataKrajnja, gbc_txtYkoordinataKrajnja);
			txtYkoordinataKrajnja.setColumns(10);
		}
		
		btnBoja = new JButton("Izaberite boju");
		btnBoja.setFont(new Font("Arial", Font.BOLD, 12));
		btnBoja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnBoja.addActionListener(new ActionListener() {
			@Implements
			public void actionPerformed(ActionEvent klik) {
				boja = JColorChooser.showDialog(null, "Paleta boja", bojaLinije);
			}
		});
	
		GridBagConstraints gbc_btnBoja = new GridBagConstraints();
		gbc_btnBoja.insets = new Insets(0, 0, 5, 5);
		gbc_btnBoja.gridx = 1;
		gbc_btnBoja.gridy = 10;
		glavniPanel.add(btnBoja, gbc_btnBoja);
		{
			JPanel panelDugmica = new JPanel();
			panelDugmica.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(panelDugmica, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.setBackground(Color.GREEN);
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent klik) {
						if (txtXkoordinataPocetna.getText().isEmpty() || txtYkoordinataPocetna.getText().isEmpty()  || txtXkoordinataKrajnja.getText().isEmpty() || txtYkoordinataKrajnja.getText().isEmpty()) {
							JOptionPane.showMessageDialog(getParent(), "Vrednosti ne smeju biti prazne!", "Greška", JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							try {	
								potvrdjeno = true;
								xKoordinataPocetna = Integer.parseInt(txtXkoordinataPocetna.getText());
								yKoordinataPocetna = Integer.parseInt(txtYkoordinataPocetna.getText());
								xKoordinataKrajnja = Integer.parseInt(txtXkoordinataKrajnja.getText());
								yKoordinataKrajnja = Integer.parseInt(txtYkoordinataKrajnja.getText());
								dispose();
							} catch (NumberFormatException nfe) {
								JOptionPane.showMessageDialog(getParent(),"Koordinate početne i krajnje tačke moraju biti celi brojevi!", "Greška", JOptionPane.ERROR_MESSAGE);
								txtXkoordinataPocetna.setText("");
								txtYkoordinataPocetna.setText("");
								txtXkoordinataKrajnja.setText("");
								txtYkoordinataKrajnja.setText("");
								return;
							} 
						}  
					}
				});
				btnPotvrdi.setActionCommand("OK");
				panelDugmica.add(btnPotvrdi);
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			{
				JButton btnOtkazi = new JButton("Otkaži");
				btnOtkazi.setBackground(Color.RED);
				
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

	public void popuni(Linija prosledjena) {
		txtXkoordinataPocetna.setText(String.valueOf(prosledjena.getPocetna().getXkoordinata()));
		txtYkoordinataPocetna.setText(String.valueOf(prosledjena.getPocetna().getYkoordinata()));
		txtXkoordinataKrajnja.setText(String.valueOf(prosledjena.getKrajnja().getXkoordinata()));
		txtYkoordinataKrajnja.setText(String.valueOf(prosledjena.getKrajnja().getYkoordinata()));
		bojaLinije = prosledjena.getBoja();
	}

	public Color getBoja() {
		return boja;
	}

	public int getXkoordinataPocetna() {
		return xKoordinataPocetna;
	}

	public int getYKoordinataPocetna() {
		return yKoordinataPocetna;
	}

	public int getXkoordinataKrajnja() {
		return xKoordinataKrajnja;
	}

	public int getYKoordinataKrajnja() {
		return yKoordinataKrajnja;
	}

	public boolean isPotvrdjeno() {
		return potvrdjeno;
	}
}