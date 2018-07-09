package crtanje;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class DlgKrug extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel glavniPanel = new JPanel();
	private JTextField txtXkoordinataCentra;
	private JTextField txtYkoordinataCentra;
	private JTextField txtDuzinaPoluprecnika;
	private JLabel lblXkoordinataCentra;
	private JLabel lblDuzinaPoluprecnika;
	private JLabel lblYkoordinataCentra;
	private int xKoordinataCentra;
	private int yKoordinataCentra;
	private int duzinaPoluprecnika;
	private Color bojaIvice = Color.BLACK;
	private Color bojaUnutrasnjosti = Color.WHITE;
	private boolean potvrdjeno;
	private Color bojaIviceKruga = Color.BLACK;
	private Color bojaUnutrasnjostiKruga = Color.WHITE;
	private JButton btnBojaIvice;
	private JButton btnBojaUnutrasnjosti;

	public static void main(String [] nizStringova) {
		try {
			DlgKrug dijalog = new DlgKrug();
			dijalog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dijalog.setVisible(true);
		} catch (Exception izuzetak) {
			izuzetak.printStackTrace();
		}
	}

	public DlgKrug() {
		setModal(true);
		setResizable(false);
		setTitle("Vrednosti kruga");
		setBounds(100, 100, 449, 342);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		glavniPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(glavniPanel, BorderLayout.CENTER);
		GridBagLayout gbl_glavniPanel = new GridBagLayout();
		gbl_glavniPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_glavniPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_glavniPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_glavniPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};

		glavniPanel.setLayout(gbl_glavniPanel);
		{
			lblXkoordinataCentra = new JLabel("X koordinata centra");
			lblXkoordinataCentra.setFont(new Font("Arial", Font.BOLD, 12));
			GridBagConstraints gbc_lblXkoordinataCentra = new GridBagConstraints();
			gbc_lblXkoordinataCentra.insets = new Insets(0, 0, 5, 5);
			gbc_lblXkoordinataCentra.gridx = 3;
			gbc_lblXkoordinataCentra.gridy = 2;
			glavniPanel.add(lblXkoordinataCentra, gbc_lblXkoordinataCentra);
		}
		{
			txtXkoordinataCentra = new JTextField();
			lblXkoordinataCentra.setLabelFor(txtXkoordinataCentra);
			GridBagConstraints gbc_txtXkoordinataCentra = new GridBagConstraints();
			gbc_txtXkoordinataCentra.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXkoordinataCentra.insets = new Insets(0, 0, 5, 5);
			gbc_txtXkoordinataCentra.gridx = 7;
			gbc_txtXkoordinataCentra.gridy = 2;
			txtXkoordinataCentra.setColumns(10);
			glavniPanel.add(txtXkoordinataCentra, gbc_txtXkoordinataCentra);
		}
		{
			lblYkoordinataCentra = new JLabel("Y koordinata centra");
			lblYkoordinataCentra.setFont(new Font("Arial", Font.BOLD, 12));
			GridBagConstraints gbc_lblYkoordinataCentra = new GridBagConstraints();
			gbc_lblYkoordinataCentra.insets = new Insets(0, 0, 5, 5);
			gbc_lblYkoordinataCentra.gridx = 3;
			gbc_lblYkoordinataCentra.gridy = 4;
			glavniPanel.add(lblYkoordinataCentra, gbc_lblYkoordinataCentra);
		}
		{
			txtYkoordinataCentra = new JTextField();
			lblYkoordinataCentra.setLabelFor(txtYkoordinataCentra);
			GridBagConstraints gbc_txtYkoordinataCentra = new GridBagConstraints();
			gbc_txtYkoordinataCentra.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYkoordinataCentra.insets = new Insets(0, 0, 5, 5);
			gbc_txtYkoordinataCentra.gridx = 7;
			gbc_txtYkoordinataCentra.gridy = 4;
			txtYkoordinataCentra.setColumns(10);
			glavniPanel.add(txtYkoordinataCentra, gbc_txtYkoordinataCentra);
		}
		{
			lblDuzinaPoluprecnika = new JLabel("Dužina poluprečnika");
			lblDuzinaPoluprecnika.setFont(new Font("Arial", Font.BOLD, 12));
			GridBagConstraints gbc_lblDuzinaPoluprecnika = new GridBagConstraints();
			gbc_lblDuzinaPoluprecnika.insets = new Insets(0, 0, 5, 5);
			gbc_lblDuzinaPoluprecnika.gridx = 3;
			gbc_lblDuzinaPoluprecnika.gridy = 6;
			glavniPanel.add(lblDuzinaPoluprecnika, gbc_lblDuzinaPoluprecnika);
		}
		{
			txtDuzinaPoluprecnika = new JTextField();
			lblDuzinaPoluprecnika.setLabelFor(txtDuzinaPoluprecnika);
			GridBagConstraints gbc_txtDuzinaPoluprecnika = new GridBagConstraints();
			gbc_txtDuzinaPoluprecnika.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtDuzinaPoluprecnika.insets = new Insets(0, 0, 5, 5);
			gbc_txtDuzinaPoluprecnika.gridx = 7;
			gbc_txtDuzinaPoluprecnika.gridy = 6;
			glavniPanel.add(txtDuzinaPoluprecnika, gbc_txtDuzinaPoluprecnika);
			txtDuzinaPoluprecnika.setColumns(10);
		}
		
		btnBojaUnutrasnjosti = new JButton("Izaberite boju unutrašnjosti");
		btnBojaUnutrasnjosti.setFont(new Font("Arial", Font.BOLD, 12));
		btnBojaUnutrasnjosti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			@Implements
			public void actionPerformed(ActionEvent klik) {
				bojaUnutrasnjosti = JColorChooser.showDialog(null, "Paleta boja", bojaUnutrasnjostiKruga);
			}
		});
		
		btnBojaIvice = new JButton("Izaberite boju ivice");
		btnBojaIvice.setFont(new Font("Arial", Font.BOLD, 12));
		btnBojaIvice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnBojaIvice.addActionListener(new ActionListener() {
			@Implements
			public void actionPerformed(ActionEvent klik) {
				bojaIvice = JColorChooser.showDialog(null, "Paleta boja", bojaIviceKruga);
			}
		});

		GridBagConstraints gbc_btnBojaIvice = new GridBagConstraints();
		gbc_btnBojaIvice.insets = new Insets(0, 0, 5, 5);
		gbc_btnBojaIvice.gridx = 3;
		gbc_btnBojaIvice.gridy = 8;
		glavniPanel.add(btnBojaIvice, gbc_btnBojaIvice);
		btnBojaIvice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_btnBojaUnutrasnjosti = new GridBagConstraints();
		gbc_btnBojaUnutrasnjosti.anchor = GridBagConstraints.EAST;
		gbc_btnBojaUnutrasnjosti.insets = new Insets(0, 0, 5, 5);
		gbc_btnBojaUnutrasnjosti.gridx = 7;
		gbc_btnBojaUnutrasnjosti.gridy = 8;
		glavniPanel.add(btnBojaUnutrasnjosti, gbc_btnBojaUnutrasnjosti);
		{
			JPanel panelDugmica = new JPanel();
			panelDugmica.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(panelDugmica, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi= new JButton("Potvrdi");
				btnPotvrdi.setFont(new Font("Arial", Font.BOLD, 12));
				btnPotvrdi.setBackground(Color.GREEN);
				btnPotvrdi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnPotvrdi.addActionListener(new ActionListener() {
					@Implements
					public void actionPerformed(ActionEvent klik) {
						if (txtXkoordinataCentra.getText().isEmpty() || txtYkoordinataCentra.getText().isEmpty() || txtDuzinaPoluprecnika.getText().isEmpty()) {
							JOptionPane.showMessageDialog(getParent(), "Vrednosti ne smeju biti prazne!", "Greška", JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							try {	
								if(Integer.parseInt(txtDuzinaPoluprecnika.getText()) <= 0) {
									JOptionPane.showMessageDialog(getParent(), "Dužina poluprečnika mora biti veća od 0.", "Greška", JOptionPane.ERROR_MESSAGE);
									txtDuzinaPoluprecnika.setText("");
									return;
								}
								potvrdjeno = true;
								xKoordinataCentra = Integer.parseInt(txtXkoordinataCentra.getText());
								yKoordinataCentra = Integer.parseInt(txtYkoordinataCentra.getText());
								duzinaPoluprecnika = Integer.parseInt(txtDuzinaPoluprecnika.getText());
								dispose();
							} catch (NumberFormatException nfe) {
								JOptionPane.showMessageDialog(getParent(),"Koordinate centra kruga i dužina poluprečnika moraju biti celi brojevi!", "Greška", JOptionPane.ERROR_MESSAGE);
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
				btnOtkazi.setFont(new Font("Arial", Font.BOLD, 12));
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
		txtXkoordinataCentra.setText(String.valueOf(xKlika));
		txtXkoordinataCentra.setEnabled(false);
		txtYkoordinataCentra.setText(String.valueOf(yKlika));
		txtYkoordinataCentra.setEnabled(false);
	}

	public void obrisiDugmice() {
		btnBojaIvice.setVisible(false);
		btnBojaUnutrasnjosti.setVisible(false);
	}

	public void popuni(Krug prosledjen) {
		txtXkoordinataCentra.setText(String.valueOf(prosledjen.getCentar().getXkoordinata()));
		txtYkoordinataCentra.setText(String.valueOf(prosledjen.getCentar().getYkoordinata()));
		txtDuzinaPoluprecnika.setText(String.valueOf(prosledjen.getPoluprecnik()));
		bojaIviceKruga = prosledjen.getBoja();
		bojaUnutrasnjostiKruga = prosledjen.getBojaUnutrasnjosti();
	}

	public int getXkoordinataCentra() {
		return xKoordinataCentra;
	}

	public int getYkoordinataCentra() {
		return yKoordinataCentra;
	}

	public int getDuzinaPoluprecnika() {
		return duzinaPoluprecnika;
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