package controller;

import gui.BingkaiUtama;
import gui.PanelUtama;

public class Kawal {
	private BingkaiUtama mainFrame;
	private PanelUtama mainPanel;

	public Kawal() {
		mainPanel = new PanelUtama();
		mainFrame = new BingkaiUtama();
		
		mainFrame.setContentPane(mainPanel);
		
	}
}
