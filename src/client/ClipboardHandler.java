package client;

import java.awt.*;
import java.awt.datatransfer.*;

public class ClipboardHandler implements ClipboardOwner{
	Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();

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
	}

	private void regainOwnership(Transferable content) {
		board.setContents(content, this); 
	}

	public static void main(String[] args) {  
	    BoardListener b = new BoardListener();  
	    b.start();  
	  } 

}
