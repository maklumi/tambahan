package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelUtama extends JPanel {

	private static final long serialVersionUID = 1L;
	private PemerhatiBorang pemerhatiBorang;

	public PanelUtama() {
		var labelAddPengguna = new JLabel("Tambah Pengguna");
		labelAddPengguna.setFont(new Font("Serif", Font.BOLD, 30));

		setLayout(new GridBagLayout());

		var gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weighty = 1;
		add(labelAddPengguna, gc);

		gc.weighty = 1.5;
		gc.gridy++;
		gc.anchor = GridBagConstraints.NORTH;
		add(buatSatuPanel(), gc);
	}

	public void setPemerhatiBorang(PemerhatiBorang pemerhatiBorang) {
		this.pemerhatiBorang = pemerhatiBorang;
	}

	private JPanel buatSatuPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		var etchBorder = BorderFactory.createEtchedBorder();
		var pad = 20;
		var emptyBorder = BorderFactory.createEmptyBorder(pad, pad, pad, pad);
		panel.setBorder(BorderFactory.createCompoundBorder(etchBorder, emptyBorder));

		var labelNama = new JLabel("Nama:");
		var labelPassword = new JLabel("Kata laluan");

		var tfNama = new JTextField(25);
		var tfPassword = new JTextField(25);

		var btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(e -> {
			String name = tfNama.getText();
			String pwd = tfPassword.getText();
			if (pemerhatiBorang != null) {
				pemerhatiBorang.terimaMaklumatNamaDanPassword(name, pwd);
			}
		});
		var gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy++;
		gc.weighty = .1;
		gc.gridwidth = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 10, 10);
		panel.add(labelNama, gc);
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		panel.add(tfNama, gc);

		gc.gridy++;
		gc.gridx = 0;
		gc.weighty = .1;
		gc.anchor = GridBagConstraints.LINE_END;
		panel.add(labelPassword, gc);
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		panel.add(tfPassword, gc);

		gc.gridy++;
		gc.weighty = 30;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		panel.add(btnSimpan, gc);

		return panel;
	}

}
