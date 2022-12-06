package playAlone.pharmacy;

import java.util.HashMap;

public class Patient {
	public String patientName;
	public String patientBirthday;
	private boolean isEnsurence = true;
	private HashMap<Medicine, Double[]> perscription = new HashMap<>();
	private Doctor chargedDoc;
	
	Patient(String patientName, String patientBirthday, Doctor doctor){
		this.patientName = patientName;
		this.patientBirthday = patientBirthday;
		this.chargedDoc = doctor;
		doctor.workHospital.registerPatient(this);
	}
}
