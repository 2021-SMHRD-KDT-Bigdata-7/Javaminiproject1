package Javaproject;

import java.util.Scanner;

public class testMain {
	static int coin;	// ���� ���� ���� Ȯ�� ����
	public static void main(String[] args) {
		DAMADAO dama = new DAMADAO();
		DAMAVO st = new DAMAVO();
		Face fc = new Face();
	    Eat eat = new Eat();
		Scanner sc = new Scanner(System.in);
		Sleep sp = new Sleep();
		Training tr = new Training();
		Music mu = new Music();
		Adventure ad =new Adventure();			
		int title_menu = 0;			// ���������� �޴� ����
		int game_menu = -1;			// ��������� �޴� ���� (1.���� 2.�Ʒ� 3.���� 4.��ħ 5.����)
		int select_menu = 0;		// ���� �޴� ����
		coin=0;
		String main_id = null;
		while (true) {
			if (title_menu == 0) {
				fc.face_main();
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
				dama.joinStators1(ID, NICK);
				dama.joinStators2(ID);
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
				dama.table3();
				title_menu = 0;
			} else if (title_menu == 6) {
				// ���̵� ��� Ȯ���ϴ� �޼ҵ�
				dama.select();
				title_menu = 0;
			} else if (title_menu == 7) {
				// ���̵� ��� Ȯ���ϴ� �޼ҵ�
				dama.all_delete();
				title_menu = 0;
			}else {
				title_menu = 0;
			}
		}
		
		 
		while (coin == 5) {
			
			if (game_menu == -1) {fc.Face_Normal(main_id);game_menu=0;}
			else if (game_menu == 0) {
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
				ad.select_Adven(main_id);
				st.VO_deadly(main_id);
				game_menu = 0;
				
				
			} else if (game_menu == 2) {
				System.out.println("�Ʒ��� ������.");
				tr.training_base(main_id);
				game_menu = 0;
				
				
			} else if (game_menu == 3) {
				
				System.out.println("�Ծ��!!");
				eat.Eat_menu(main_id);
				game_menu = 0;
				
				
				
				
			} else if (game_menu == 4) {
				System.out.println("��ħ�� �Ѵ�.");
				fc.Face_Sleep(main_id);
				int cnt = sp.sleep(main_id);
				
				if(cnt > 0) {
					System.out.println("ȸ�� ����");
				}else {
					System.out.println("ȸ�� ����..");
				}
				
				game_menu = 0;
				
			} else if (game_menu == 5) {
				fc.Face_Escape(main_id);
				coin=0;
				System.out.println(" ���� ���� ");
			}

		}
		
	}	
	public void setcoin(int set){
		coin = set;
	}
	

}
