package methodExam;

public class PrimeNumSerch {
	
//	전달되는 값이 소수(prime number)인지 아닌지를 판단하여, 
//	소수인경우 true를, 소수가 아닌 경우 false를 반환하는 메서드를 정의하고, 
//	이를 이용해서 1이상 100 이하의 소수를 전부 출력할 수 있도록 main 메서드를 정의하자.
	
	// 속성 : 숫자
	// 기능 : 숫자 전달, 소수 판단, 소수로 판단되면 True 반환, 1~100이하 소수 판별
	 int count;
	 boolean check;
	 
	 boolean CheckCount(boolean check) { // true false의 체크와 반환
	  if(count == 0) { // count가 0이면 true를 반환, 소수
	   check = true;
	  }else {
	   check = false; // count가 0 이외엔 false를 반환, 소수가 아님
	  }
	  return check;
	 }

	 void ThisNum(int num, int end) {
		 
	  for (; num < end; num++) { // UI에서 num,end 값을 받아서 num부터 end까지 반복 
	   count = 0; // count값 초기화
	   for(int i = 2; i < num; i++) { // i 값이 num보다 작을 때 1씩 증가하며
	    if(num%i == 0) { // num에서 i를 나눈 나머지가 하나라도 0이 되면 소수가 아니다.
	     count +=1; // 나머지 0인 수가 나온다면 count가 증가한다.
	    }
	   } // num에서 i를 나눈 나머지가 0이 아닐경우 for문을 빠져나가고 소수 판별
	   
	   if (CheckCount(check)) { // check에 반환된 값에 따라 소수판별 true일 경우 소수
	    System.out.println(num + " 소수");
	   }
	  }
	 }
	}
