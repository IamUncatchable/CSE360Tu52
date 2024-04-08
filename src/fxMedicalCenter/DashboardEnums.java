package fxMedicalCenter;

public enum DashboardEnums {

		DASHBOARD("Dashboard"), 
		MY_ACCOUNT("My Account"), 
		MESSAGES("Messages"), 
		MEDICAL_RECORDS("Medical Records"),
		APPOINTMENTS("Appointments");

		private final String displayName;

		DashboardEnums(String displayName) {
			this.displayName = displayName;
		}

		public String get() {
			return displayName;
		}
	}





