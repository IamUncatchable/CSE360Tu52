package fxMedicalCenter;

import java.time.LocalDate;

public class Message {
	private int messageID;
	private String from;
	private String to;
	private LocalDate date;
	private String text;
	
	public Message() {
		
	}
	
	public Message(String sender,String recipient, String message) {
		Database db = new Database();
		db.createMessage(messageID, from, to, text, date.toString());
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
	
	public LocalDate getDate() {
		return date;
	}
	
	public String getText() {
		return text;
	}

}
