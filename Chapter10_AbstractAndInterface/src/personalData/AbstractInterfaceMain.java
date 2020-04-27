package personalData;

public class AbstractInterfaceMain {

	public static void main(String[] args) {
//	PersonalNumberStorage storage = new PersonalNumberStorageImpl(100);
		PersonalNum storage = new PersonalNumberStorageImpl(100);
	
	storage.addPersonalInfo("920619-1011111", "김승연");
	storage.addPersonalInfo("930912-1011111", "김승헌");
	
	System.out.println(storage.searchName("920619-1011111"));
	System.out.println(storage.searchName("930912-1011111"));

	}

}
