package utils;

public class Message {
	private String raw;
	private String message;
	private String id;
	
	public Message(String message){
		this.raw = message;
		String[] temp = raw.split("[.]+");
		if (temp.length == 2){
			this.id = temp[0];
			this.message= temp[1];
		} else {
			System.out.println("Message Formatting Error!");
			System.out.println(raw);
		}
	}
	
	public String getMessage(){
		return message;
	}
	public String getID(){
		return id;
	}
}
