package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
	public static void main(String args[]) throws IOException{
		ServerSocket listener = new ServerSocket(9090);
		try {
			Handler s = new Handler(listener.accept());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
