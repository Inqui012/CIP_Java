package playAlone.pharmacy;

import java.util.ArrayList;

public class Hospital {
	public String hospitalName;
	public ArrayList<Doctor> hiredDoc = new ArrayList<>();
	private ArrayList<Patient> patientList = new ArrayList<>();
	
	Hospital(String hospitalName){
		this.hospitalName = hospitalName;
	}
	
	public void hireingDoc(Doctor doctor) {
		hiredDoc.add(doctor);
	}
	
	public void registerPatient (Patient patient) {
		patientList.add(patient);
	}
	
}
