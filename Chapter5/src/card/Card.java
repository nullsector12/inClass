package card;

public class Card {
	
	String kind;
	int number;
	static int width = 100;
	static int height = 250;
	
	
	Card(){
		
	}
	
	Card(String type, int num){
		kind = type;
		number = num;
		
	}
}
