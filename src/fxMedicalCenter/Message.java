package fxMedicalCenter;

public class Message {
	private int messageID;
	private String from;
	private String to;
	private int date;
	private String text;
	
	public Message() {
		
	}
	
	public Message(String sender,String recipient, String message) {
		
	}
	
	public Message(int id) {
		
	}
	
	private boolean queryMessage() {
		return false;
	}
	
	public String getFrom() {
		return from;
	}
	
	public String getTo() {
		return to;
	}
	
	public int getDate() {
		return date;
	}
	
	public String getText() {
		return text;
	}

}