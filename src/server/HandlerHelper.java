package server;

import java.util.ArrayList;
import java.util.HashMap;

public class HandlerHelper {
	 private static ArrayList<ClientGroup> groups = new ArrayList<ClientGroup>();
	 
	 public static ArrayList<ClientGroup> getGroups(){
		 return groups;
	 }
	 public static void groupAdd(ClientGroup g){
		 groups.add(g);
	 }
	 public static ClientGroup findGroup(String s){
		 for (ClientGroup g: groups){
	    		if (g.getID().equals(s)){
	    			//System.out.println(s + " and " + g.getID());
	    			return g;
	    		}
	    	}
	    	return null;
	 }
}
