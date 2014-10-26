package client;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.PrintWriter;

public class ClipListener extends Thread implements ClipboardOwner{
	Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
	ClipManager manager;
	PrintWriter out;
	String id;
	
	public ClipListener(PrintWriter out, String id) {
		manager = new ClipManager();
		this.out = out;
		this.id = id;
	}

	public void run() {  
		
		Transferable trans = board.getContents(this);  
		regainOwnership(trans);  
		System.out.println("Listening to board...");  
		while(true) {}  
	} 

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		Transferable content = board.getContents(this); //EXCEPTION  
		processContents(content);  
		regainOwnership(content);
	}

	private void processContents(Transferable content) {
		System.out.println("Processing: " + content);
		out.println(id + "." + manager.getClipboardContents());
	}

	private void regainOwnership(Transferable content) {
		board.setContents(content, this); 
	}

}
