package fxMedicalCenter;

public enum Datatables {
	VISIT("visit"),
	MESSAGE("message"),
	USERS("users"),
	PRESCRIPTION("prescription"),
	PATIENT("patient");
	
	
	private final String dataTableName;

	 Datatables(String dataTableName) {
			this.dataTableName = dataTableName;
		}
		
		public String get() {
			return dataTableName;
		}
}
