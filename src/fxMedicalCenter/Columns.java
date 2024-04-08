package fxMedicalCenter;

public enum Columns {
	MESSAGE_ID("message_id"),
	FROM("from"),
	TO("to"),
	DATE("date"),
	TEXT("text"),
	PATIENT_ID("patient_id"),
	GENDER("gender"),
	ADDRESS("address"),
	CITY("city"),
	STATE("state"),
	ZIP("zip"),
	PHONE_NUMBER("phone_number"),
	EMAIL("email"),
	INSURANCE_PROVIDER("insurance_provider"),
	INSURANCE_ID("insurance_id"),
	HISTORY("history"),
	FIRST_NAME("first_name"),
	LAST_NAME("last_name"),
	PRESCRIPTION_ID("prescription_id"),
	REFILLS("refills"),
	PRESCRIBED("prescribed"),
	USERNAME("username"),
	BIRTHDAY("birthday"),
	PASSWORD("password"),
	ACCOUNT_TYPE("account_type"),
	VISIT_ID("visit_id"),
	HEIGHT("height"),
	WEIGHT("weight"),
	TEMP("temp"),
	BLOOD_PRESSURE("blood_pressure"),
	NURSE_NOTES("nurse_notes"),
	DR_NOTES("dr_notes");
	
	private final String columnName;

	 Columns(String columnName) {
			this.columnName = columnName;
		}
		
		public String get() {
			return columnName;
		}
}
