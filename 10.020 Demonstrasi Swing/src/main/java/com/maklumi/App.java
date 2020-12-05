package com.maklumi;

import javax.swing.SwingUtilities;

import controller.Kawal;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Kawal::new);
		
	}

}
