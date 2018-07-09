package stek;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import crtanje.Kvadrat;

public class DlgKvadrat extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel glavniPanel = new JPanel();
	private JTextField txtXkoordinata;
	private JTextField txtYkoordinata;
	private JTextField txtDuzinaStranice;
	private JComboBox <String> cbxBojaIvice;
	private JComboBox <String> cbxBojaUnutrasnjosti;
	private int xKoordinata;
	private int yKoordinata;
	private int duzinaStranice;
	private String bojaIvice;
	private String bojaUnutrasnjosti;
	private boolean potvrdjeno;
	private JLabel lblXkoordinata;
	private JLabel lblYkoordinata;
	private JLabel lblDuzinaStranice;
	private JLabel lblBojaIvice;
	private JLabel lblBojaUnutrasnjosti;

	public static void main(String [] nizStringova) {
		try {
			DlgKvadrat dijalog = new DlgKvadrat();
			dijalog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dijalog.setVisible(true);

		} catch (Exception izuzetak) {
			izuzetak.printStackTrace();
		}
	}

	public DlgKvadrat() {
		setTitle("Vrednosti kvadrata");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 412, 367);
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{437, 0};
		gridBagLayout.rowHeights = new int[]{297, 33, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(new BorderLayout());
		glavniPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(glavniPanel, BorderLayout.CENTER);
		GridBagConstraints gbc_glavniPanel = new GridBagConstraints();
		gbc_glavniPanel.fill = GridBagConstraints.BOTH;
		gbc_glavniPanel.insets = new Insets(0, 0, 5, 0);
		gbc_glavniPanel.gridx = 0;
		gbc_glavniPanel.gridy = 0;
		GridBagLayout gbl_glavniPanel = new GridBagLayout();
		gbl_glavniPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 77, 0};
		gbl_glavniPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_glavniPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_glavniPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};

		glavniPanel.setLayout(gbl_glavniPanel);
		{
			lblXkoordinata = new JLabel("X koordinata");
			GridBagConstraints gbc_lblXkoordinata = new GridBagConstraints();
			gbc_lblXkoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_lblXkoordinata.gridx = 2;
			gbc_lblXkoordinata.gridy = 1;
			glavniPanel.add(lblXkoordinata, gbc_lblXkoordinata);
		}
		{
			txtXkoordinata = new JTextField();
			lblXkoordinata.setLabelFor(txtXkoordinata);
			txtXkoordinata.setFont(new Font("Arial", Font.BOLD, 12));
			GridBagConstraints gbc_xKoordinata = new GridBagConstraints();
			gbc_xKoordinata.fill = GridBagConstraints.HORIZONTAL;
			gbc_xKoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_xKoordinata.gridx = 7;
			gbc_xKoordinata.gridy = 1;
			txtXkoordinata.setColumns(10);
			glavniPanel.add(txtXkoordinata, gbc_xKoordinata);
		}
		{
			lblYkoordinata = new JLabel("Y koordinata");
			GridBagConstraints gbc_lblYkoordinata = new GridBagConstraints();
			gbc_lblYkoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_lblYkoordinata.gridx = 2;
			gbc_lblYkoordinata.gridy = 3;
			glavniPanel.add(lblYkoordinata, gbc_lblYkoordinata);
		}
		{
			txtYkoordinata = new JTextField();
			txtYkoordinata.setFont(new Font("Arial", Font.BOLD, 12));
			lblYkoordinata.setLabelFor(txtYkoordinata);
			GridBagConstraints gbc_yKoordinata = new GridBagConstraints();
			gbc_yKoordinata.fill = GridBagConstraints.BOTH;
			gbc_yKoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_yKoordinata.gridx = 7;
			gbc_yKoordinata.gridy = 3;
			txtYkoordinata.setColumns(10);
			glavniPanel.add(txtYkoordinata, gbc_yKoordinata);
		}
		{
			lblDuzinaStranice = new JLabel("Dužina stranice");
			GridBagConstraints gbc_lblDuzinaStranice = new GridBagConstraints();
			gbc_lblDuzinaStranice.insets = new Insets(0, 0, 5, 5);
			gbc_lblDuzinaStranice.gridx = 2;
			gbc_lblDuzinaStranice.gridy = 5;
			glavniPanel.add(lblDuzinaStranice, gbc_lblDuzinaStranice);
		}
		{
			txtDuzinaStranice = new JTextField();
			txtDuzinaStranice.setFont(new Font("Arial", Font.BOLD, 12));
			lblDuzinaStranice.setLabelFor(txtDuzinaStranice);
			GridBagConstraints gbc_duzinaStranice = new GridBagConstraints();
			gbc_duzinaStranice.fill = GridBagConstraints.BOTH;
			gbc_duzinaStranice.insets = new Insets(0, 0, 5, 5);
			gbc_duzinaStranice.gridx = 7;
			gbc_duzinaStranice.gridy = 5;
			txtDuzinaStranice.setColumns(10);
			glavniPanel.add(txtDuzinaStranice, gbc_duzinaStranice);	
		}
		{
			lblBojaIvice = new JLabel("Boja ivice");
			GridBagConstraints gbc_lblBojaIvice = new GridBagConstraints();
			gbc_lblBojaIvice.insets = new Insets(0, 0, 5, 5);
			gbc_lblBojaIvice.gridx = 2;
			gbc_lblBojaIvice.gridy = 7;
			glavniPanel.add(lblBojaIvice, gbc_lblBojaIvice);
		}
		{
			cbxBojaIvice = new JComboBox<String>();
			cbxBojaIvice.setFont(new Font("Arial", Font.BOLD, 12));
			lblBojaIvice.setLabelFor(cbxBojaIvice);
			cbxBojaIvice.setModel(new DefaultComboBoxModel<String>(new String[] {"bela", "plava", "crvena", "zelena", "žuta", "roze", "siva", "narandžasta"}));
			GridBagConstraints gbc_bojaIvice = new GridBagConstraints();
			gbc_bojaIvice.insets = new Insets(0, 0, 5, 5);
			gbc_bojaIvice.gridx = 7;
			gbc_bojaIvice.gridy = 7;
			glavniPanel.add(cbxBojaIvice, gbc_bojaIvice);
		}
		{
			lblBojaUnutrasnjosti = new JLabel("Boja unutrašnjosti");
			GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
			gbc_lblBojaUnutrasnjosti.anchor = GridBagConstraints.EAST;
			gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 5, 5);
			gbc_lblBojaUnutrasnjosti.gridx = 2;
			gbc_lblBojaUnutrasnjosti.gridy = 9;
			glavniPanel.add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);
		}
		{
			cbxBojaUnutrasnjosti = new JComboBox<String>();
			cbxBojaUnutrasnjosti.setFont(new Font("Arial", Font.BOLD, 12));
			lblBojaUnutrasnjosti.setLabelFor(cbxBojaUnutrasnjosti);
			cbxBojaUnutrasnjosti.setModel(new DefaultComboBoxModel<String>(new String[] {"bela", "plava", "crvena", "zelena", "žuta", "roze", "siva", "narandžasta"}));
			GridBagConstraints gbc_bojaUnutrasnjosti = new GridBagConstraints();
			gbc_bojaUnutrasnjosti.insets = new Insets(0, 0, 5, 5);
			gbc_bojaUnutrasnjosti.gridx = 7;
			gbc_bojaUnutrasnjosti.gridy = 9;
			glavniPanel.add(cbxBojaUnutrasnjosti, gbc_bojaUnutrasnjosti);
		}
		{
			JPanel panelDugmica = new JPanel();
			panelDugmica.setLayout(new FlowLayout(FlowLayout.RIGHT));
			GridBagConstraints gbc_panelDugmica = new GridBagConstraints();
			gbc_panelDugmica.anchor = GridBagConstraints.NORTH;
			gbc_panelDugmica.fill = GridBagConstraints.HORIZONTAL;
			gbc_panelDugmica.gridx = 0;
			gbc_panelDugmica.gridy = 1;
			getContentPane().add(panelDugmica, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.setFont(new Font("Arial", Font.BOLD, 12));
				btnPotvrdi.setBackground(Color.GREEN);
				btnPotvrdi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnPotvrdi.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent klik) {
						if (txtXkoordinata.getText().isEmpty() || txtYkoordinata.getText().isEmpty() || txtDuzinaStranice.getText().isEmpty()) {
							JOptionPane.showMessageDialog(getParent(), "Tekstualna polja ne smeju biti prazna!", "Greška", JOptionPane.ERROR_MESSAGE);
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
								bojaIvice = cbxBojaIvice.getSelectedItem().toString();
								bojaUnutrasnjosti = cbxBojaUnutrasnjosti.getSelectedItem().toString();
								dispose();
							} catch (NumberFormatException izuzetak) {
								JOptionPane.showMessageDialog(getParent(),"Koordinate tačke gore levo i dužina stranice moraju biti celi brojevi!", "Greška", JOptionPane.ERROR_MESSAGE);
								txtXkoordinata.setText("");
								txtYkoordinata.setText("");
								txtDuzinaStranice.setText("");
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

	public void popuniPolja(Kvadrat vrhSteka) {
		txtXkoordinata.setText(String.valueOf(vrhSteka.getGoreLevo().getXkoordinata()));
		txtYkoordinata.setText(String.valueOf(vrhSteka.getGoreLevo().getYkoordinata()));
		txtDuzinaStranice.setText(String.valueOf(vrhSteka.getStranica()));
		cbxBojaIvice.setSelectedItem(vrhSteka.getBojaIvice());
		cbxBojaUnutrasnjosti.setSelectedItem(vrhSteka.getUnutrasnjaBoja());
	}

	public void zamrzniPolja() {
		txtXkoordinata.setEnabled(false);
		txtYkoordinata.setEnabled(false);
		txtDuzinaStranice.setEnabled(false);
		cbxBojaIvice.setEnabled(false);
		cbxBojaUnutrasnjosti.setEnabled(false);
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

	public String getBojaIvice() {
		return bojaIvice;
	}

	public String getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public boolean isPotvrdjeno() {
		return potvrdjeno;
	}
}