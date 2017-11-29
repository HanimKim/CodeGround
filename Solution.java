package StarBugs;

import java.util.Scanner;

class Solution {
	static char Answer;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		int people = 0;
		int coffee = 0;
		int money = 0;
		int sum = 0;

		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {

			people = sc.nextInt();
			coffee = sc.nextInt();
			money = sc.nextInt();
			
			int[] preferencedCoffee = new int[people];
			int[] coffeePrice = new int[coffee];
			
			for(int i=0; i < preferencedCoffee.length; i++) {
				preferencedCoffee[i] = (sc.nextInt() - 1);
			}
			
			for(int i = 0; i < coffeePrice.length; i++) {
				coffeePrice[i] = sc.nextInt();
			}
			
			sum = 0;
			for(int i =0; i < people; i++) {
				sum += coffeePrice[preferencedCoffee[i]];
			}
			
			if(money >= sum) {
				Answer = 'Y';
			}else {
				Answer = 'N';
			}
			
			
			// Print the answer to standard output(screen).
			System.out.println("Case #" + (test_case + 1));
			System.out.println(Answer);
		}
	}
}