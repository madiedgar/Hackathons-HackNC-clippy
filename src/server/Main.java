package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
	public static void main(String args[]) throws IOException{
		ServerSocket listener = new ServerSocket(9090);
		try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
	}

}
