package server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerEntry {
	public static void main(String args[]) throws IOException{
		ServerSocket listener = new ServerSocket(9090);
		System.out.println("Server Started!");
		try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
	}

}
