package utils;

public class Message {
	private String raw;
	private String message;
	private String id;
	
	public Message(String message){
		int splitdex = message.indexOf('.', 0);
		
		this.id = message.substring(0,splitdex);
		this.message = message.substring(splitdex + 1, message.length());
		
	}
	
	public String getMessage(){
		return message;
	}
	public String getID(){
		return id;
	}
}
