package server;

import java.io.PrintWriter;
import java.util.List;

public class ClientGroup {
	
	private List<PrintWriter> writers;
	private String id;
	
	public ClientGroup(String id){
		this.id = id;
	}

	public List<PrintWriter> getWriters() {
		// TODO Auto-generated method stub
		return writers;
	}

	public void add(PrintWriter out) {
		writers.add(out);
	}

}
