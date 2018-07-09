package crtanje;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class DlgPravougaonik extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel glavniPanel = new JPanel();
	private JTextField txtXkoordinata;
	private JTextField txtYkoordinata;
	private JTextField txtSirina;
	private JTextField txtVisina;
	private JLabel lblXkoordinata;
	private JLabel lblSirina;
	private JLabel lblVisina;
	private int xKoordinata;
	private int yKoordinata;
	private int sirina;
	private int visina;
	private Color bojaIvice = Color.BLACK;
	private Color bojaUnutrasnjosti = Color.WHITE;
	private Color bojaIvicePravougaonika = Color.BLACK;
	private Color bojaUnutrasnjostiPravougaonika = Color.WHITE;
	private boolean potvrdjeno;
	private JButton btnBojaIvice;
	private JButton btnBojaUnutrasnjosti;
	private JLabel lblYkoordinata;

	public static void main(String [] nizStringova) {
		try {
			DlgPravougaonik dijalog = new DlgPravougaonik();
			dijalog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dijalog.setVisible(true);
		} catch (Exception izuzetak) {
			izuzetak.printStackTrace();
		}
	}

	public DlgPravougaonik() {
		setModal(true);
		setResizable(false);
		setTitle("Vrednosti pravougaonika");
		setBounds(100, 100, 418, 386);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		glavniPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(glavniPanel, BorderLayout.CENTER);
		GridBagLayout gbl_glavniPanel = new GridBagLayout();
		gbl_glavniPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_glavniPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_glavniPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_glavniPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		glavniPanel.setLayout(gbl_glavniPanel);
		{
			lblXkoordinata = new JLabel("X koordinata");
			GridBagConstraints gbc_lblXkoordinata = new GridBagConstraints();
			gbc_lblXkoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_lblXkoordinata.gridx = 3;
			gbc_lblXkoordinata.gridy = 2;
			glavniPanel.add(lblXkoordinata, gbc_lblXkoordinata);
		}
		{
			txtXkoordinata = new JTextField();
			lblXkoordinata.setLabelFor(txtXkoordinata);
			GridBagConstraints gbc_txtXkoordinata = new GridBagConstraints();
			gbc_txtXkoordinata.anchor = GridBagConstraints.NORTH;
			gbc_txtXkoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_txtXkoordinata.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXkoordinata.gridx = 6;
			gbc_txtXkoordinata.gridy = 2;
			glavniPanel.add(txtXkoordinata, gbc_txtXkoordinata);
			txtXkoordinata.setColumns(10);
		}
		{
			lblYkoordinata = new JLabel("Y koordinata");
			GridBagConstraints gbc_lblYkoordinata = new GridBagConstraints();
			gbc_lblYkoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_lblYkoordinata.gridx = 3;
			gbc_lblYkoordinata.gridy = 4;
			glavniPanel.add(lblYkoordinata, gbc_lblYkoordinata);
		}
		{
			txtYkoordinata = new JTextField();
			lblYkoordinata.setLabelFor(txtYkoordinata);
			GridBagConstraints gbc_txtYkoordinata = new GridBagConstraints();
			gbc_txtYkoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_txtYkoordinata.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYkoordinata.gridx = 6;
			gbc_txtYkoordinata.gridy = 4;
			glavniPanel.add(txtYkoordinata, gbc_txtYkoordinata);
			txtYkoordinata.setColumns(10);
		}
		{
			lblSirina = new JLabel("\u0160irina");
			GridBagConstraints gbc_lblSirina = new GridBagConstraints();
			gbc_lblSirina.insets = new Insets(0, 0, 5, 5);
			gbc_lblSirina.gridx = 3;
			gbc_lblSirina.gridy = 6;
			glavniPanel.add(lblSirina, gbc_lblSirina);
		}
		{
			txtSirina = new JTextField();
			lblSirina.setLabelFor(txtSirina);
			GridBagConstraints gbc_txtSirina = new GridBagConstraints();
			gbc_txtSirina.insets = new Insets(0, 0, 5, 5);
			gbc_txtSirina.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtSirina.gridx = 6;
			gbc_txtSirina.gridy = 6;
			glavniPanel.add(txtSirina, gbc_txtSirina);
			txtSirina.setColumns(10);
		}
		{
			lblVisina = new JLabel("Visina");
			GridBagConstraints gbc_lblVisina = new GridBagConstraints();
			gbc_lblVisina.insets = new Insets(0, 0, 5, 5);
			gbc_lblVisina.gridx = 3;
			gbc_lblVisina.gridy = 8;
			glavniPanel.add(lblVisina, gbc_lblVisina);
		}
		{
			txtVisina = new JTextField();
			lblVisina.setLabelFor(txtVisina);
			GridBagConstraints gbc_txtVisina = new GridBagConstraints();
			gbc_txtVisina.insets = new Insets(0, 0, 5, 5);
			gbc_txtVisina.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtVisina.gridx = 6;
			gbc_txtVisina.gridy = 8;
			glavniPanel.add(txtVisina, gbc_txtVisina);
			txtVisina.setColumns(10);
		}
		{
			btnBojaUnutrasnjosti = new JButton("Izaberite boju Unutrašnjosti");
			btnBojaUnutrasnjosti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
				@Implements
				public void actionPerformed(ActionEvent klik) {
					bojaUnutrasnjosti = JColorChooser.showDialog(null, "Paleta boja", bojaUnutrasnjostiPravougaonika);
				}
			});
			
			btnBojaIvice = new JButton("Izaberite boju ivice");
			btnBojaIvice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			btnBojaIvice.addActionListener(new ActionListener() {
				@Implements
				public void actionPerformed(ActionEvent klik) {
					bojaIvice = JColorChooser.showDialog(null, "Paleta boja", bojaIvicePravougaonika);
				}
			});
			GridBagConstraints gbc_btnBojaIvice = new GridBagConstraints();
			gbc_btnBojaIvice.insets = new Insets(0, 0, 5, 5);
			gbc_btnBojaIvice.gridx = 3;
			gbc_btnBojaIvice.gridy = 10;
			glavniPanel.add(btnBojaIvice, gbc_btnBojaIvice);
			GridBagConstraints gbc_btnBojaUnutrasnjosti = new GridBagConstraints();
			gbc_btnBojaUnutrasnjosti.insets = new Insets(0, 0, 5, 5);
			gbc_btnBojaUnutrasnjosti.gridx = 6;
			gbc_btnBojaUnutrasnjosti.gridy = 10;
			glavniPanel.add(btnBojaUnutrasnjosti, gbc_btnBojaUnutrasnjosti);
		}
		{
			JPanel panelDugmica = new JPanel();
			panelDugmica.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(panelDugmica, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.setBackground(Color.GREEN);
				btnPotvrdi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
				btnPotvrdi.addActionListener(new ActionListener() {
					@Implements
					public void actionPerformed(ActionEvent klik) {
						if (txtXkoordinata.getText().isEmpty() || txtYkoordinata.getText().isEmpty() || txtSirina.getText().isEmpty() || txtVisina.getText().isEmpty()) {
							JOptionPane.showMessageDialog(getParent(), "Vrednosti ne smeju biti prazne!", "Greška",JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							try {	
								if(Integer.parseInt(txtSirina.getText()) <= 0) {
									JOptionPane.showMessageDialog(getParent(), "Dužina širine mora biti veća od 0.", "Greška", JOptionPane.ERROR_MESSAGE);
									txtSirina.setText("");
									return;
								}
								if(Integer.parseInt(txtVisina.getText()) <= 0) {
									JOptionPane.showMessageDialog(getParent(), "Dužina visine mora biti veća od 0.", "Greška", JOptionPane.ERROR_MESSAGE);
									txtVisina.setText("");
									return;
								}
								potvrdjeno = true;
								xKoordinata = Integer.parseInt(txtXkoordinata.getText());
								yKoordinata = Integer.parseInt(txtYkoordinata.getText());
								sirina = Integer.parseInt(txtSirina.getText());
								visina = Integer.parseInt(txtVisina.getText());
								dispose();
							} catch (NumberFormatException nfe) {
								JOptionPane.showMessageDialog(getParent(),"Koordinate tačke gore levo, širina i visina moraju biti celi brojevi!", "Greška", JOptionPane.ERROR_MESSAGE);
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

	public void upisi(int xKlika, int yKlika) {
		txtXkoordinata.setText(String.valueOf(xKlika));
		txtXkoordinata.setEnabled(false);
		txtYkoordinata.setText(String.valueOf(yKlika));
		txtYkoordinata.setEnabled(false);
	}

	public void popuni(Pravougaonik prosledjen) {
		txtXkoordinata.setText(String.valueOf((prosledjen.getGoreLevo().getXkoordinata())));
		txtXkoordinata.setText(String.valueOf((prosledjen.getGoreLevo().getXkoordinata())));
		txtSirina.setText(String.valueOf(prosledjen.getSirina()));
		txtVisina.setText(String.valueOf(prosledjen.getStranica()));
		bojaIvicePravougaonika = prosledjen.getBoja();
		bojaUnutrasnjostiPravougaonika = prosledjen.getBojaUnutrasnjosti();
	}

	public void obrisiDugmice() {
		btnBojaIvice.setVisible(false);
		btnBojaUnutrasnjosti.setVisible(false);
	}

	public int getxKoordinata() {
		return xKoordinata;
	}

	public int getyKoordinata() {
		return yKoordinata;
	}

	public int getSirina() {
		return sirina;
	}

	public int getVisina() {
		return visina;
	}

	public Color getBojaIvice() {
		return bojaIvice;
	}

	public Color getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public boolean isPotvrdjeno() {
		return potvrdjeno;
	}
}