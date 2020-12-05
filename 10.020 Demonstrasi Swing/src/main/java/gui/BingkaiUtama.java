package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BingkaiUtama extends JFrame {

	private static final long serialVersionUID = 1L;

	public BingkaiUtama() {
		super("Contoh guna Swing");

		setJMenuBar(buatMenuBarKatAtasWindow());

		setSize(800, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	private JMenuBar buatMenuBarKatAtasWindow() {
		var menuBar = new JMenuBar();
		var menuFail = new JMenu("Fail");
		var menuKeluar = new JMenuItem("Keluar dari sini");

		menuKeluar.addActionListener(e -> {
			System.out.println(e.getActionCommand());
			System.exit(0);
		});

		menuFail.add(menuKeluar);

		menuBar.add(menuFail);
		return menuBar;
	}
}
