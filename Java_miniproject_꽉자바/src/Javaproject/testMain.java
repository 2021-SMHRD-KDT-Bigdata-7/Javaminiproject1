package Javaproject;

import java.util.Scanner;

public class testMain {
	public static void main(String[] args) {
		Enemy en = new Enemy();
		DAMADAO dama = new DAMADAO();
		Face fc = new Face();
	
		Scanner sc = new Scanner(System.in);
		Battle bt = new Battle();
		int coin = 0;				// ���� ���� ���� Ȯ�� ����
		int title_menu = 0;			// ���������� �޴� ����
		int game_menu = 0;			// ��������� �޴� ���� (1.���� 2.�Ʒ� 3.���� 4.��ħ 5.����)
		int select_menu = 0;		// ���� �޴� ����
		
		String main_id = null;
		while (true) {
			if (title_menu == 0) {
				System.out.print("1. �α��� 2. ȸ������ 3. ��ŷȮ�� 4. ���� >> ");
				title_menu = sc.nextInt();
			} else if (title_menu == 1) {
				System.out.print("���̵� �Է��ϼ��� >> ");
				String ID = sc.next();
				System.out.print("��й�ȣ �Է��ϼ��� >> ");
				String PW = sc.next();
				coin = dama.login(ID, PW);
				title_menu = 0;
				if (coin == 5) {
					main_id = ID;
					break;
				}else {
					System.out.println("���̵�� ��й�ȣ�� Ȯ�����ּ���.");
				}
			} else if (title_menu == 2) {
				System.out.print("ȸ������ ���̵� �Է��ϼ��� >> ");
				String ID = sc.next();
				System.out.print("ȸ������ ��й�ȣ �Է��ϼ��� >> ");
				String PW = sc.next();
				System.out.print("�����Ͻ� �г����� �Է��ϼ��� >> ");
				String NICK = sc.next();
				coin = dama.join(ID, PW);
				dama.joinStators(ID, NICK);
				title_menu = 0;
				if (coin == 5) {
					main_id = ID;
					break;
				}else {
					System.out.println("ȸ������ ����.. �ٽ� �õ����ּ���");
				}
			} else if (title_menu == 3) {
				dama.ranksys();
				title_menu = 0;
			} else if (title_menu == 4) {
				System.out.println("���α׷��� �����մϴ�. �ٸ���ġ����������������!!!!!!");
				break;
			} else if (title_menu == 5) {
				// ���̺� ���� �޼ҵ�
				dama.table1();
				dama.table2();
				title_menu = 0;
			} else if (title_menu == 6) {
				// ���̵� ��� Ȯ���ϴ� �޼ҵ�
				dama.select();
				title_menu = 0;
			} else {
				title_menu = 0;
			}
		}
		
		 
		while (coin == 5) {
			if (game_menu == 0) {
				fc.Face_Normal(main_id);
				System.out.println("1.���� 2.�Ʒ� 3.�Ա� 4.��ħ 5.���� ");
				select_menu = sc.nextInt();
				if (select_menu == 1) {
					game_menu = 1;
				} else if (select_menu == 2) {
					game_menu = 2;
				} else if (select_menu == 3) {
					game_menu = 3;
				} else if (select_menu == 4) {
					game_menu = 4;
				} else if (select_menu == 5) {
					game_menu = 5;
				} else {
					game_menu = 0;
				}

			} else if (game_menu == 1) {
				System.out.println("������ ������.");
				game_menu = 0;
				
				
			} else if (game_menu == 2) {
				System.out.println("�Ʒ��� ������.");
				game_menu = 0;
				
				
			} else if (game_menu == 3) {
				System.out.println("�Ծ��!!");
				game_menu = 0;
					
				
				
			} else if (game_menu == 4) {
				System.out.println("��ħ�� �Ѵ�.");
				
				game_menu = 0;
				
				
			} else if (game_menu == 5) {
				System.out.println(" ���� ���� ");
				break;
			}

		}
	}
}
