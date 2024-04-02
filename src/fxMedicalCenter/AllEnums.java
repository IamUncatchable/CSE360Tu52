package fxMedicalCenter;

public enum AllEnums {
	GENDER("gender"),
	ADDRESS("address"),
	CITY("city"),
	STATE("state"),
	ZIP("zip"),
	PHONE("phone"),
	EMAIL("email"),
	INSURANCE_NUMBER("insurance_id"),
	INSURANCE_PROVIDER("insurance_provider"),
	PATIENT_ID("patient_id"),
	HISTORY("history"),
	PHARMACY_DB("pharmacies"),
	PATIENT_DB("patients");

	private final String columnName;

	AllEnums(String columnName) {
		this.columnName = columnName;
	}
	
	public String getColumnName() {
		return columnName;
	}
}