package Javaproject;

import java.util.Scanner;

public class testMain {
	public static void main(String[] args) {
		DAMADAO dama = new DAMADAO();
		Scanner sc = new Scanner(System.in);
		int coin = 0;
		int menu = 0;
		while (true) {
			if (menu == 0) {
				System.out.print("1. �α��� 2. ȸ������ 3. ȯ�漳�� 4. ���� >> ");
				menu = sc.nextInt();
			} else if (menu == 1) {
				System.out.print("���̵� �Է��ϼ��� >> ");
				String ID = sc.next();
				System.out.print("��й�ȣ �Է��ϼ��� >> ");
				String PW = sc.next();
				coin = dama.login(ID, PW);
				menu = 0;
				if (coin == 5) {
					break;
				}
			} else if (menu == 2) {
				System.out.print("ȸ������ ���̵� �Է��ϼ��� >> ");
				String ID = sc.next();
				System.out.print("ȸ������ ��й�ȣ �Է��ϼ��� >> ");
				String PW = sc.next();
				coin = dama.join(ID, PW);
				menu = 0;
				if (coin == 5) {
					break;
				}
			} else if (menu == 3) {
				System.out.println("���� ���� �������� ȯ�漳�� ����� �������� �ʾҽ��ϴ�.");
				menu = 0;
			} else if (menu == 4) {
				System.out.println("���α׷��� �����մϴ�. �ٸ���ġ����������������!!!!!!");
				break;
			} else if (menu == 5) {
				// ���̺� ���� �޼ҵ�
				dama.table1();
				dama.table2();
				menu = 0;
			} else if (menu == 6) {
				// ���̵� ��� Ȯ���ϴ� �޼ҵ�
				dama.select();
				menu = 0;
			} else {
				menu = 0;
			}
		}
		while (coin == 5) {
		}
	}
}
