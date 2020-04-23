package myPhoneBookVer01;

public class PhoneInfor {
	 
	 String name;
	 String phoneNumber;
	 String birthDay;
	 
	 PhoneInfor (String name, String phoneNumber, String birthDay){
	  this.name = name;
	  this.phoneNumber = phoneNumber;
	  this.birthDay = birthDay;
	 }
	 
	 PhoneInfor (String name, String phoneNumber){
	  this.name = name;
	  this.phoneNumber = phoneNumber;
	 }
	 
	 void showBook(){
	  System.out.println("이름 : " + name);
	  System.out.println("전화번호 : " + phoneNumber);
	  System.out.println("생년월일 : " + this.birthDay);
	  }

	 @Override
	 public String toString() {
	  return "PhoneInfor [name=" + name + ", phoneNumber=" + phoneNumber + ", birthDay=" + birthDay + "]";
	 }
}
