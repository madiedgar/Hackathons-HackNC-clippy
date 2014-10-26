package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Trivial client for the date server.
 */
public class SocClient {
	
//	private static ClipManager manager;
//	private static PrintWriter out;
//	private static String id;
	//manager.getClipboardContents()
	//manager.setClipboardContents()
    /**
     * Runs the client as an application.  First it displays a dialog
     * box asking for the IP address or hostname of a host running
     * the date server, then connects to it and displays the date that
     * it serves.
     */
    public static void main(String[] args) throws IOException {
    	String name = "clippy";
    	ClipManager manager = new ClipManager();
        String serverAddress = "clippy.redspin.net";
        String id = JOptionPane.showInputDialog("Pick an id number");
        Socket s = new Socket(serverAddress, 9090);
        
        BufferedReader input =
            new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        System.out.println("[" + System.currentTimeMillis() / 1000l + "] Client connected to " + name + " as " + id);
        out.println(id+".auth");
        ClipListener cl = new ClipListener(out, id);
        cl.start();
        while (true) {
            String line = input.readLine();
            System.out.println("[" + System.currentTimeMillis() / 1000l + "] " + line);
            manager.setClipboardContents(line);
        }
    }
    
    
}