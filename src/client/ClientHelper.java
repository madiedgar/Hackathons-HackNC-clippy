package client;

public final class ClientHelper {
	
	public boolean ignore; 
	public String last;
	private static ClientHelper helper;
	
	private ClientHelper(){

	}
	public static ClientHelper getHelper(){
		if (helper == null){
			helper =  new ClientHelper();
			return helper;
		} else return helper;
	}
	
	public boolean getIgnore(){
		return ignore;
	}
	public void setIg(boolean boo){
		ignore = boo;
	}
	public void setLast(String last){
		this.last = last;
	}
	public String getLast(){
		return last;
	}

}
