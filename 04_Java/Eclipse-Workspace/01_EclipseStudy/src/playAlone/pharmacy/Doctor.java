package playAlone.pharmacy;

import java.util.ArrayList;

public class Doctor {
	public String docName;
	public Hospital workHospital;
	private int docNum;
	private ArrayList<Patient> patientInCharge = new ArrayList<>();
	
	Doctor (String docName, Hospital workHospital, int docNum){
		this.docName = docName;
		this.workHospital = workHospital;
		workHospital.hiredDoc.add(this);
		this.docNum = docNum;
	}
	
	public void registerPatient(Patient patient) {
		patientInCharge.add(patient);
	}
}
