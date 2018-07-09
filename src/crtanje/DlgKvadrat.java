package crtanje;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class DlgKvadrat extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel glavniPanel = new JPanel();
	private JTextField txtXkoordinata;
	private JTextField txtYkoordinata;
	private JTextField txtDuzinaStranice;
	private JLabel lblXkoordinata;
	private JLabel lblDuzinaStranice;
	private int xKoordinata;
	private int yKoordinata;
	private int duzinaStranice;
	private Color bojaIviceKvadrata = Color.BLACK;
	private Color bojaUnutrasnjostiKvadrata = Color.WHITE;
	private Color bojaIvice = Color.BLACK;
	private Color bojaUnutrasnjosti = Color.WHITE;
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

	public DlgKvadrat() {
		setModal(true);
		setResizable(false);
		setTitle("Vrednosti kvadrata");
		setBounds(100, 100, 440, 320);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		glavniPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(glavniPanel, BorderLayout.CENTER);
		GridBagLayout gbl_glavniPanel = new GridBagLayout();
		gbl_glavniPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_glavniPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_glavniPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_glavniPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		glavniPanel.setLayout(gbl_glavniPanel);
		{
			lblXkoordinata = new JLabel("X koordinata");
			GridBagConstraints gbc_lblXkoordinata = new GridBagConstraints();
			gbc_lblXkoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_lblXkoordinata.gridx = 2;
			gbc_lblXkoordinata.gridy = 3;
			glavniPanel.add(lblXkoordinata, gbc_lblXkoordinata);
		}
		{
			txtXkoordinata = new JTextField();
			lblXkoordinata.setLabelFor(txtXkoordinata);
			GridBagConstraints gbc_txtXkoordinata = new GridBagConstraints();
			gbc_txtXkoordinata.anchor = GridBagConstraints.NORTH;
			gbc_txtXkoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_txtXkoordinata.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXkoordinata.gridx = 7;
			gbc_txtXkoordinata.gridy = 3;
			glavniPanel.add(txtXkoordinata, gbc_txtXkoordinata);
			txtXkoordinata.setColumns(10);
		}
		{
			lblYkoordinata = new JLabel("Y koordinata");
			GridBagConstraints gbc_lblYkoordinata = new GridBagConstraints();
			gbc_lblYkoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_lblYkoordinata.gridx = 2;
			gbc_lblYkoordinata.gridy = 5;
			glavniPanel.add(lblYkoordinata, gbc_lblYkoordinata);
		}
		{
			txtYkoordinata = new JTextField();
			lblYkoordinata.setLabelFor(txtYkoordinata);
			GridBagConstraints gbc_txtYkoordinata = new GridBagConstraints();
			gbc_txtYkoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_txtYkoordinata.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYkoordinata.gridx = 7;
			gbc_txtYkoordinata.gridy = 5;
			glavniPanel.add(txtYkoordinata, gbc_txtYkoordinata);
			txtYkoordinata.setColumns(10);
		}
		{
			lblDuzinaStranice = new JLabel("Dužina stranice");
			GridBagConstraints gbc_lblDuzinaStranice = new GridBagConstraints();
			gbc_lblDuzinaStranice.insets = new Insets(0, 0, 5, 5);
			gbc_lblDuzinaStranice.gridx = 2;
			gbc_lblDuzinaStranice.gridy = 7;
			glavniPanel.add(lblDuzinaStranice, gbc_lblDuzinaStranice);
		}
		{
			txtDuzinaStranice = new JTextField();
			lblDuzinaStranice.setLabelFor(txtDuzinaStranice);
			GridBagConstraints gbc_txtDuzinaStranice = new GridBagConstraints();
			gbc_txtDuzinaStranice.insets = new Insets(0, 0, 5, 5);
			gbc_txtDuzinaStranice.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtDuzinaStranice.gridx = 7;
			gbc_txtDuzinaStranice.gridy = 7;
			glavniPanel.add(txtDuzinaStranice, gbc_txtDuzinaStranice);
			txtDuzinaStranice.setColumns(10);
		}
		
		GridBagConstraints gbc_btnBojaIvice = new GridBagConstraints();
		gbc_btnBojaIvice.insets = new Insets(0, 0, 5, 5);
		gbc_btnBojaIvice.gridx = 2;
		gbc_btnBojaIvice.gridy = 9;

		btnBojaIvice = new JButton("Izaberite boju ivice");
		btnBojaIvice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBojaIvice.addActionListener(new ActionListener() {
			@Implements
			public void actionPerformed(ActionEvent klik) {
				bojaIvice = JColorChooser.showDialog(null, "Paleta boja", bojaIviceKvadrata);
			}
		});

		glavniPanel.add(btnBojaIvice, gbc_btnBojaIvice);

		GridBagConstraints gbc_btnBojaUnutrasnjosti = new GridBagConstraints();
		gbc_btnBojaUnutrasnjosti.insets = new Insets(0, 0, 5, 5);
		gbc_btnBojaUnutrasnjosti.gridx = 7;
		gbc_btnBojaUnutrasnjosti.gridy = 9;

		btnBojaUnutrasnjosti = new JButton("Izaberite boju unutrašnjosti");
		btnBojaUnutrasnjosti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			@Implements
			public void actionPerformed(ActionEvent klik) {
				bojaUnutrasnjosti = JColorChooser.showDialog(null, "Paleta boja", bojaUnutrasnjostiKvadrata);
			}
		});

		glavniPanel.add(btnBojaUnutrasnjosti, gbc_btnBojaUnutrasnjosti);
		{
			JPanel panelDugmica = new JPanel();
			panelDugmica.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(panelDugmica, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.setBackground(Color.GREEN);
				btnPotvrdi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
				btnPotvrdi.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent klik) {
						if (txtXkoordinata.getText().isEmpty() || txtYkoordinata.getText().isEmpty() || txtDuzinaStranice.getText().isEmpty()) {
							JOptionPane.showMessageDialog(getParent(), "Vrednosti ne smeju biti prazne!", "Greška", JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							try {	
								if(Integer.parseInt(txtDuzinaStranice.getText()) <= 0) {
									JOptionPane.showMessageDialog(getParent(), "Dužina stranice mora biti veća od 0.", "Greška", JOptionPane.ERROR_MESSAGE);
									txtDuzinaStranice.setText("");
									return;
								}
								potvrdjeno = true;
								xKoordinata = Integer.parseInt(txtXkoordinata.getText());
								yKoordinata = Integer.parseInt(txtYkoordinata.getText());
								duzinaStranice = Integer.parseInt(txtDuzinaStranice.getText());

								dispose();
							} catch (NumberFormatException izuzetak) {
								JOptionPane.showMessageDialog(getParent(),"Koordinate tačke gore levo i dužina stranice moraju biti celi brojevi!", "Greška", JOptionPane.ERROR_MESSAGE);
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
				
				btnOtkazi.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent klik) {
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

	public void popuni(Kvadrat prosledjen) {
		txtXkoordinata.setText(String.valueOf(prosledjen.getGoreLevo().getXkoordinata()));
		txtYkoordinata.setText(String.valueOf(prosledjen.getGoreLevo().getYkoordinata()));
		txtDuzinaStranice.setText(String.valueOf(prosledjen.getStranica()));
		bojaIviceKvadrata = prosledjen.getBoja();
		bojaUnutrasnjostiKvadrata = prosledjen.getBojaUnutrasnjosti();
	}

	public void obrisiDugmice() {
		btnBojaIvice.setVisible(false);
		btnBojaUnutrasnjosti.setVisible(false);
	}

	public int getXkoordinata() {
		return xKoordinata;
	}

	public int getYkoordinata() {
		return yKoordinata;
	}

	public int getDuzinaStranice() {
		return duzinaStranice;
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