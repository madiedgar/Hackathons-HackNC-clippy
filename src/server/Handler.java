package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.HashMap;

import utils.*;

class Handler extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Message message;
    private HashMap<String, ClientGroup> clientMap = new HashMap<String, ClientGroup>(); 
    public Handler(Socket socket) {
        this.socket = socket;
    }
    public List<PrintWriter> writers;

    /**
     * Services this thread's client by repeatedly requesting a
     * screen name until a unique one has been submitted, then
     * acknowledges the name and registers the output stream for
     * the client in a global set, then repeatedly gets inputs and
     * broadcasts them.
     */
    public void run() {
        try {

            // Create character streams for the socket.
            in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            //this is a thread for the client.
            //do things here for a new client connection;

            // Accept messages from this client and handle
            while (true) {
                String input = in.readLine();
                if (input == null) {
                    return;
                }
                message = new Message(input);
                //do this when a message is received
                if (message.getMessage().equals("auth")){
                	if (clientMap.containsKey(message.getID())){
                		clientMap.get(message.getID()).add(out);
                	} else {
                		clientMap.put(message.getID(),new ClientGroup(message.getID()));
                		System.out.println("New Client!");
                	}
                } else if (clientMap.containsKey(message.getID())){
                	writers = clientMap.get(message.getID()).getWriters();
                    //get all the client writers and distribute the clip
                	DBwrangler.getWrangler().dbPut(message.getMessage(), message.getID());
                    for (PrintWriter writer : writers) {
                    	//this will write a duplicate back to the sender.
                    	//fix this later :P
                        writer.println(message.getMessage());
                    }
                } else {
                	
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            //Do things at the end?
        	
        	//remove the client from the clientlist
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }
}
