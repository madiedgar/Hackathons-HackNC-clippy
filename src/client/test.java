package client;

import java.awt.*;  
import java.awt.datatransfer.*;  
   
public class test extends Thread implements ClipboardOwner {  
  Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
  static ClipManager manager;
   
  public void run() {  
    Transferable trans = sysClip.getContents(this);  
    regainOwnership(trans);  
    System.out.println("Listening to board...");  
    while(true) {}  
  }  
   
  public void lostOwnership(Clipboard c, Transferable t) {  
    Transferable contents = sysClip.getContents(this); //EXCEPTION  
    processContents(contents);  
    regainOwnership(contents);  
  }  
   
  void processContents(Transferable t) {  
    System.out.println("Processing: " + t);  
    System.out.println(manager.getClipboardContents());
  }  
   
  void regainOwnership(Transferable t) {  
    sysClip.setContents(t, this);  
  }  
   
  public static void main(String[] args) { 
	manager = new ClipManager();
    test b = new test();  
    b.start();  
  }  
} 