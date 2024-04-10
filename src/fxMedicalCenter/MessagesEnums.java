package fxMedicalCenter;

public enum MessagesEnums {
    INBOX("Inbox"),
    SENT("Sent"),
    DELETED("Deleted"),
    SENDER("Sender"),
    SUBJECT("Subject"),
    TIME_STAMP("Time Stamp"),
    REFRESH("Refresh"),
    PREVIOUS("Previous"),
    NEXT("Next"),
    MAIL_SENDER("Mail Sender"),
    MAIL_SUBJECT("Mail Subject"),
    MAIL_TIMESTAMP("Mail Timestamp"),
    
    //checkboxes
    MAIL_CHECKBOX("mailCheckbox"),
	SELECT_ALL_CHECKBOX("selectAll");
    private final String value;

    MessagesEnums(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
