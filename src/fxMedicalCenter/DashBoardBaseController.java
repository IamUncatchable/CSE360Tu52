package fxMedicalCenter;

import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


//controls actions of static dashboard items as well as the Dashboard home page



public class DashBoardBaseController {
	private nurseNotesEntry nurseNotes;
	private MyAccount myAccount;
	private MyAppointments appointments;
	private MessagesView messagesView;
	private DashboardBase dashboardBase;
	private DashboardView dashboardView;
//	Map<String, PaneProvider> providers = new HashMap<>();
	// Constructor
	public DashBoardBaseController(DashboardBase dashboardBase, MessagesView messagesview, MyAppointments appointments, MyAccount myAccount, nurseNotesEntry nurseNotes) {
		this.nurseNotes = nurseNotes;
		this.myAccount = myAccount;
		this.appointments = appointments;
		this.messagesView = messagesview;
		this.dashboardBase = dashboardBase;
//		this.providers.putAll(providers);
		this.dashboardView = new DashboardView();
		setupActionHandlers();
	}


	
	

	private void setupActionHandlers() {
		dashboardBase.getDashboardButton().setOnAction(e -> {
			switchScene(DashboardEnums.DASHBOARD.get());
		});

		dashboardBase.getMyAccountButton().setOnAction(e -> {
			switchScene(DashboardEnums.MY_ACCOUNT.get());
		});

		dashboardBase.getMessagesButton().setOnAction(e -> {
			switchScene(DashboardEnums.MESSAGES.get());
		});

		dashboardBase.getMedicalRecordsButton().setOnAction(e -> {
			switchScene(DashboardEnums.MEDICAL_RECORDS.get());
		});

		dashboardBase.getAppointmentsButton().setOnAction(e -> {
			switchScene(DashboardEnums.APPOINTMENTS.get());
		});

		dashboardBase.getHomeButton().setOnAction(e -> {
			switchScene(DashboardEnums.DASHBOARD.get());
		});
		

		dashboardBase.getSignOutButton().setOnAction(e -> {
			

			//new LoginScreen(dashboardBase.getPrimaryStage(), this);

			// switchScene(DashboardEnumsRefactored.DASHBOARD.get());
			// FIXME how to exit to the sign in screen?
		});
		
		
		
		///more buttons and actions go here
		//
/*
		dashboardView.getCurrentMedViewButton().setOnAction(event -> {
			
		});
		dashboardView.getCurrentMedRefillButton().setOnAction(event -> {
			
		});
		dashboardView.getRequestRecordsButton().setOnAction(event -> {
			
		});
		dashboardView.getRecentVisitsViewButton().setOnAction(event -> {
			
		});
		dashboardView.getMessagesReadButton().setOnAction(event -> {
			
		});
		dashboardView.getMessagesComposeButton().setOnAction(event -> {
			
		});
*/
	}
	
//    private void setupSignOutHandler() {
//        dashboardBase.setSignOutAction(e -> handleSignOut());
//    }

//    private void handleSignOut() {
//    	currentStage.close();
//        new LoginScreen(new Stage()).loginScreenDisplay();
//    }


	// Method to switch scenes or update the dashboard view based on user
	// interactions
	private void switchScene(String sceneName) {

		switch (sceneName) {
		case "Dashboard":
			dashboardBase.setRightArt(RightBarImage.RIGHT_BAR_1.get());
			dashboardBase.setBannerText(DashboardEnums.DASHBOARD.get());
			dashboardBase.setCenter(dashboardView.getCenterView());

			break;
		case "My Account":
			dashboardBase.setRightArt(RightBarImage.RIGHT_BAR_2.get());
			dashboardBase.setBannerText(DashboardEnums.MY_ACCOUNT.get());
			dashboardBase.setCenter(myAccount.getView());
			break;
		case "Messages":
			dashboardBase.setRightArt(RightBarImage.RIGHT_BAR_3.get());
			dashboardBase.setBannerText(DashboardEnums.MESSAGES.get());
			dashboardBase.setCenter(messagesView.getCenterContent());
			break;
		case "Medical Records":
			dashboardBase.setRightArt(RightBarImage.RIGHT_BAR_4.get());
			dashboardBase.setBannerText(DashboardEnums.MEDICAL_RECORDS.get());
			break;
		case "Appointments":
			dashboardBase.setRightArt(RightBarImage.RIGHT_BAR_5.get());
			dashboardBase.setBannerText(DashboardEnums.APPOINTMENTS.get());
			dashboardBase.setCenter(appointments.getView());
			break;

		default:
			dashboardBase.setCenter(dashboardView.getCenterView());
			dashboardBase.setRightArt(RightBarImage.RIGHT_BAR_1.get());
			dashboardBase.setBannerText("Oopsy Daisy");
			break;
		}
	}

}
