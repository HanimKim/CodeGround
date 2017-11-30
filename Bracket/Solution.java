package Bracket;

import java.util.ArrayList;
import java.util.Scanner;

//�Ｚ �ڵ�׶��� (SCPC) ���� ��ȣ ����
class Solution {
	//������ �ְ� �� �ùٸ� ��ȣ ���� ���� �����ϴ� ����
	static int Answer;

	public static void main(String args[]) throws Exception {

		String inputString;

		// ({[ó�� ���� ��ȣ����  �ùٸ� )}]�� ������ ������ ����ó�� �������ִ� ����Ʈ
		ArrayList<Character> checkArrays = new ArrayList<Character>();
		//���� ����Ʈ�� ��ȣ�� ����ó�� ���� �ϸ� �� ��ȣ�� ��ġ�� �������ִ� ����Ʈ
		ArrayList<Integer> checkArraysNum = new ArrayList<Integer>();

		Scanner sc = new Scanner(System.in);
		// Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			Answer = 0;

			inputString = sc.next();

			char[] arrays = inputString.toCharArray();
			//��ȣ���� �ùٸ� ��ȣ�� 1 ���� �׷��� ������ 0 �����ϴ� �迭
			int[] arraysNum = new int[arrays.length];

			for (int i = 0; i < arraysNum.length; i++)
				arraysNum[i] = 0;;

			//��ȣ�� ���̸�ŭ ��ȣ �ϳ��ϳ��� Ž��
			for (int i = 0; i < arrays.length; i++) {
				//����Ʈ�� ({[ ���� ��ȣ���� �׿����� ���� �� 
				if (checkArrays.isEmpty()) {
					switch (arrays[i]) {
					case '(':
						//���� ��ȣ�� ����ó�� ����
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
				//����Ʈ�� ({[ ���� ��ȣ���� �׿����� ���� ��
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
						//����Ʈ�� ���� ���� ��ȣ �߿� �������� ����� ��ȣ�� �ùٸ��� ������ ��ȣ�� ������ ���
						if (checkArrays.get(checkArrays.size() - 1).equals('(')) {
							//�ùٸ� ��ȣ �̹Ƿ� (��)�ΰ� ��� 1�� �������ش�
							arraysNum[checkArraysNum.get(checkArraysNum.size() - 1)] = 1;
							arraysNum[i] = 1;

							//������ popó�� ������ ��ȣ�� �ùٸ� ��ȣ�̹Ƿ� �������ش�
							checkArrays.remove(checkArrays.size() - 1);
							//������ ��ȣ�� �����Ƿ� ������ ��ȣ�� ��ġ�� ��Ÿ���� ����Ʈ�� �������ش�
							checkArraysNum.remove(checkArraysNum.size() - 1);
						} else {
							//�ùٸ� ���� ��ȣ�� ������ ���ϸ� �� ������ �׿��� ��ȣ���� ��� �ùٸ��� ���� ��ȣ��
							//�ǹǷ� ����Ʈ�� ��� �������ش�.
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
			//�ݺ����� �������Ƿ� �ʱ�ȭ
			checkArrays.removeAll(checkArrays);
			checkArraysNum.removeAll(checkArraysNum);

			//�迭�� �ε����� 1(�ùٸ� ��ȣ)�� �ִ� �󸶳� ���ӵǴ��� üũ
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
			//�迭�� ������ �κб��� 1(�ùٸ� ��ȣ)�̸� �������� �������� ���ϹǷ�
			//�ݺ����� ������ �� ���� üũ���־���Ѵ�.
			if (Answer < check)
				Answer = check;

			// System.out.println();

			System.out.println("Case #" + (test_case + 1));
			System.out.println(Answer);

		}
	}
}
