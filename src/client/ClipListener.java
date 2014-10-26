package client;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.PrintWriter;

public class ClipListener extends Thread implements ClipboardOwner{
	Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
	ClipManager manager;
	PrintWriter out;
	String id;
	String last;
	static Boolean ignore;
	
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

//	@Override
//	public void lostOwnership(Clipboard clipboard, Transferable contents) {
//		Transferable content = board.getContents(this); //EXCEPTION  
//		processContents(content);
//		regainOwnership(content);
//	}
	
	public void lostOwnership(Clipboard c, Transferable t) {  
		  try {  
		    this.sleep(20);  
		  } catch(Exception e) {  
		    System.out.println("Exception: " + e);  
		  }  
		  Transferable contents = board.getContents(this);  
		  processContents(contents);  
		  regainOwnership(contents);  
		}

	private void processContents(Transferable content) {
		if (!manager.getClipboardContents().equals(last) || ignore == false){
		out.println(id + "." + manager.getClipboardContents());
		last = manager.getClipboardContents();
		} else ignore = false;
	}

	private void regainOwnership(Transferable content) {
		board.setContents(content, this); 
	}

	public static void setIgnore() {
		ignore = true;
	}

}
