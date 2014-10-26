package server;

import java.io.PrintWriter;
import java.util.ArrayList;

public class ClientGroup {
	
	private ArrayList<PrintWriter> writers;
	private String id;
	
	public ClientGroup(String id){
		this.id = id;
		writers = new ArrayList<PrintWriter>();
	}

	public ArrayList<PrintWriter> getWriters() {
		// TODO Auto-generated method stub
		return writers;
	}

	public void add(PrintWriter out) {
		writers.add(out);
	}
	public String getID(){
		return id;
	}

}
