package fxMedicalCenter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Random;

public class Message {
	private int messageID;
	private String from;
	private String to;
	private LocalDate date;
	private String text;
	
	public Message() {
		
	}
	
	public Message(String sender,String recipient, String message) {
		date.now();
		createID();
		from = sender;
		to = recipient;
		text = message;
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
	
	private void createID() {
		Random rand = new Random();
		boolean uniqueID = false;
		int newID;
		Database db = new Database();

		do {
			newID = rand.nextInt(1,100000000);
			db.setQuery(Datatables.MESSAGE.get(), Columns.MESSAGE_ID.get(), newID);
			db.query();
			if(db.next()) {
				uniqueID = false;
			} else {
				uniqueID = true;
				messageID = newID;
			}
		} while (uniqueID == false);
	}

}
