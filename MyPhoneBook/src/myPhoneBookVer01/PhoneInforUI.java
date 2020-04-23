package myPhoneBookVer01;

public class PhoneInforUI {

	 public static void main(String[] args) {
	  
	  PhoneInfor infor = new PhoneInfor("김승연","01000000004", "900000");
	  PhoneInfor infor2 = new PhoneInfor("ㄷㄷㄷㅈ", "010000005");
	  
	  infor.showBook();
	  infor2.showBook();
	  System.out.println("===============");
	  System.out.println(infor);
	  System.out.println(infor2);
	 }
	}

