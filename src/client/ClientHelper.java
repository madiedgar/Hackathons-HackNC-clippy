package client;

public final class ClientHelper {
	
	private ClientHelper(){
		ignore = false;
	}
	public static ClientHelper getHelper(){
		if (helper == null){
			helper =  new ClientHelper();
			return helper;
		} else return helper;
	}
	
	public boolean ignore;
	private static ClientHelper helper;
	
	public boolean getIgnore(){
		return ignore;
	}
	public void setIg(boolean boo){
		ignore = boo;
	}

}
