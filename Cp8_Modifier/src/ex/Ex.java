package ex;

import packAndImp.Member1;

public class Ex {
	
	public static void main(String[] args) {
		
		
		SingleTon s = SingleTon.getInstance();
		s.print();
		
		Member1 member = new Member1();
		
		
		member.setName("ㄷㄷㄷㅈ");
		System.out.println(member.getName());
		member.setId("RIOT");
		System.out.println(member.getId());
		
	}

}
