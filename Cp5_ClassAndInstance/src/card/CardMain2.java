package card;

public class CardMain2 {

	public static void main(String[] args) {
		
		
		Card c1 = new Card();
		
		for(int i = 0; i<4; i++) {
			for(int j=1; j <14; j++) {
				
				String kind = "";
				
				switch(i) {
				
				case 0:
					kind = "spade";
					break;
				case 1:
					kind = "clover";
					break;
				case 2:
					kind = "Heart";
					break;
				case 3: 
					kind = "diamond";
					break;
				}c1.kind = kind;
				c1.number = j;
				System.out.println(c1.kind);
				System.out.println(c1.number);
				System.out.println("==========");
			}
		}
	}

}
