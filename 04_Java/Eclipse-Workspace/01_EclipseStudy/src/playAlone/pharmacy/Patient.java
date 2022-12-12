package playAlone.pharmacy;

import java.util.ArrayList;
import java.util.HashMap;

public class Patient {
	public String patientName;
	public String patientBirthday;
	private boolean isEnsurence = true;
	private HashMap<Medicine, String> meds = new HashMap<>();
	private ArrayList<HashMap<Medicine, String>> perscription = new ArrayList<>();
	private Doctor chargedDoc;
	
	Patient(String patientName, String patientBirthday, Doctor doctor){
		this.patientName = patientName;
		this.patientBirthday = patientBirthday;
		this.chargedDoc = doctor;
		doctor.workHospital.registerPatient(this);
	}
		
	public void setMeds(Medicine meds, String does) {
		this.meds.put(meds, does);
	}
	public void setPerscription() {
		this.perscription.add(meds);
		meds.clear();
	}

	public boolean isEnsurence() {
		return isEnsurence;
	}

	public void setEnsurence(boolean isEnsurence) {
		this.isEnsurence = isEnsurence;
	}

	public HashMap<Medicine, String> getMeds() {
		return meds;
	}


	public ArrayList<HashMap<Medicine, String>> getPerscription() {
		return perscription;
	}


	public Doctor getChargedDoc() {
		return chargedDoc;
	}

	public void setChargedDoc(Doctor chargedDoc) {
		this.chargedDoc = chargedDoc;
	}
	
	
}
