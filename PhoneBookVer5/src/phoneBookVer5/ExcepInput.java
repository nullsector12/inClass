package phoneBookVer5;

import java.util.Scanner;

import excepClass.BadNumberException;

public class ExcepInput  {
	static Scanner input = new Scanner(System.in);
	
	 public static void excepInput() {
			int checkNum = 0;

		try {
			checkNum = input.nextInt();

			if( !(checkNum >= MenuNumInterface.SELECTUNIV && checkNum <= MenuNumInterface.SELECTFAMILY) ) {
				BadNumberException e = new BadNumberException("잘못된 그룹 선택");
				throw e;
			}

		}catch (NumberFormatException e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("그룹을 다시 입력해주세요.");
			
		}catch (BadNumberException e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("그룹을 다시 입력해주세요.");
			
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("그룹을 다시 입력해주세요.");
		}finally {
			input.nextLine();
		}
		
	}

}
