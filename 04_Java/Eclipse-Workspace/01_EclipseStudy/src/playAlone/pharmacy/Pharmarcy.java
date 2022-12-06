package playAlone.pharmacy;


public class Pharmarcy {
	public static void main(String[] args) {
		Hospital hos01 = new Hospital("01_Hopital");
		Hospital hos02 = new Hospital("02_Hopital");
		
		Doctor doc01 = new Doctor("doc01", hos01, 55248);
		Doctor doc02 = new Doctor("doc02", hos01, 11208);
		Doctor doc03 = new Doctor("doc03", hos01, 56848);
		Doctor doc04 = new Doctor("doc04", hos01, 13885);
		Doctor doc05 = new Doctor("doc05", hos02, 24852);
		Doctor doc06 = new Doctor("doc06", hos02, 34852);
		
		Patient pat01 = new Patient("pat01", "931111", doc01);
		Patient pat02 = new Patient("pat02", "157332", doc01);
		Patient pat03 = new Patient("pat03", "202458", doc02);
		
		for(Doctor doc : hos01.hiredDoc) {
			System.out.println(doc.docName);
		}
		for(Doctor doc : hos02.hiredDoc) {
			System.out.println(doc.docName);
		}
	}
}
