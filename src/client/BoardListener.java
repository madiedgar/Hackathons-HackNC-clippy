package client;

import java.awt.*;
import java.awt.datatransfer.*;

public class BoardListener extends ClipboardHandler{

	public static void main(String[] args)  {
		Toolkit.getDefaultToolkit().getSystemClipboard()
		.addFlavorListener(new FlavorListener() {
			@Override
			public void flavorsChanged(FlavorEvent e) {
				System.out.println("changed!!! " + e.getSource() + " "
						+ e.toString());
			}
		}
		);
		try {
			Thread.sleep(1000000L);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}


}
