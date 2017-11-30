package Bracket;

import java.util.ArrayList;
import java.util.Scanner;

//삼성 코드그라운드 (SCPC) 예선 괄호 문제
class Solution {
	//마지막 최고 긴 올바른 괄호 길이 값을 저장하는 변수
	static int Answer;

	public static void main(String args[]) throws Exception {

		String inputString;

		// ({[처럼 열린 괄호들을  올바른 )}]을 만나기 전까지 스택처럼 저장해주는 리스트
		ArrayList<Character> checkArrays = new ArrayList<Character>();
		//위의 리스트의 괄호를 스택처럼 저장 하면 그 괄호의 위치를 저장해주는 리스트
		ArrayList<Integer> checkArraysNum = new ArrayList<Integer>();

		Scanner sc = new Scanner(System.in);
		// Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			Answer = 0;

			inputString = sc.next();

			char[] arrays = inputString.toCharArray();
			//괄호들이 올바른 괄호면 1 저장 그렇제 않으면 0 저장하는 배열
			int[] arraysNum = new int[arrays.length];

			for (int i = 0; i < arraysNum.length; i++)
				arraysNum[i] = 0;;

			//괄호의 길이만큼 괄호 하나하나를 탐색
			for (int i = 0; i < arrays.length; i++) {
				//리스트에 ({[ 열린 괄호들이 쌓여있지 않을 때 
				if (checkArrays.isEmpty()) {
					switch (arrays[i]) {
					case '(':
						//열린 괄호면 스택처럼 증가
						checkArrays.add(arrays[i]);
						checkArraysNum.add(i);
						break;
					case '{':
						checkArrays.add(arrays[i]);
						checkArraysNum.add(i);
						break;
					case '[':
						checkArrays.add(arrays[i]);
						checkArraysNum.add(i);
						break;
					case ')':
						break;
					case '}':
						break;
					case ']':
						break;
					}
				}
				//리스트에 ({[ 열린 괄호들이 쌓여있지 않을 때
				else {
					switch (arrays[i]) {
					case '(':
						checkArrays.add(arrays[i]);
						checkArraysNum.add(i);
						break;
					case '{':
						checkArrays.add(arrays[i]);
						checkArraysNum.add(i);
						break;
					case '[':
						checkArrays.add(arrays[i]);
						checkArraysNum.add(i);
						break;
					case ')':
						//리스트의 쌓인 열린 괄호 중에 마지막에 저장된 괄호가 올바르게 닫히는 괄호를 만나는 경우
						if (checkArrays.get(checkArrays.size() - 1).equals('(')) {
							//올바른 괄호 이므로 (와)두개 모두 1을 저장해준다
							arraysNum[checkArraysNum.get(checkArraysNum.size() - 1)] = 1;
							arraysNum[i] = 1;

							//스택의 pop처럼 마지막 괄호가 올바른 괄호이므로 제거해준다
							checkArrays.remove(checkArrays.size() - 1);
							//마지막 괄호가 빠지므로 마지막 괄호의 위치를 나타내는 리스트도 제개해준다
							checkArraysNum.remove(checkArraysNum.size() - 1);
						} else {
							//올바른 닫힌 괄호를 만나지 못하면 그 앞전에 쌓였던 괄호들은 모두 올바르지 않은 괄호가
							//되므로 리스트를 모두 제거해준다.
							checkArrays.removeAll(checkArrays);
							checkArraysNum.removeAll(checkArraysNum);
						}
						break;
					case '}':
						if (checkArrays.get(checkArrays.size() - 1).equals('{')) {
							arraysNum[checkArraysNum.get(checkArraysNum.size() - 1)] = 1;
							arraysNum[i] = 1;

							checkArrays.remove(checkArrays.size() - 1);
							checkArraysNum.remove(checkArraysNum.size() - 1);
						} else {
							checkArrays.removeAll(checkArrays);
							checkArraysNum.removeAll(checkArraysNum);
						}
						break;
					case ']':
						if (checkArrays.get(checkArrays.size() - 1).equals('[')) {
							arraysNum[checkArraysNum.get(checkArraysNum.size() - 1)] = 1;
							arraysNum[i] = 1;

							checkArrays.remove(checkArrays.size() - 1);
							checkArraysNum.remove(checkArraysNum.size() - 1);
						} else {
							checkArrays.removeAll(checkArrays);
							checkArraysNum.removeAll(checkArraysNum);
						}
						break;
					}
				}
			}
			//반복문이 끝났으므로 초기화
			checkArrays.removeAll(checkArrays);
			checkArraysNum.removeAll(checkArraysNum);

			//배열에 인덱스가 1(올바른 괄호)로 최대 얼마나 연속되는지 체크
			int check = 0;
			for (int i = 0; i < arraysNum.length; i++) {
				// System.out.print(arraysNum[i] + " ");
				if (arraysNum[i] == 0) {
					if (check != 0) {
						if (Answer < check)
							Answer = check;
						check = 0;
					}
				} else {
					check++;
				}
			}
			//배열의 마지막 부분까지 1(올바른 괄호)이면 마지막을 저장하지 못하므로
			//반복문이 끝나고 한 번더 체크해주어야한다.
			if (Answer < check)
				Answer = check;

			// System.out.println();

			System.out.println("Case #" + (test_case + 1));
			System.out.println(Answer);

		}
	}
}
