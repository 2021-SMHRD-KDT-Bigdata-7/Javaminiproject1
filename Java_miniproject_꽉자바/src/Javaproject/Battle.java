package Javaproject;

import java.util.Scanner;

public class Battle {

	String ID;
	int exp;
	int lv;
	int hp;
	int atk;
	int def;
	int spd;
	int ene;
	int hurb;
	int food;
	int startday;
	int deadday;
	int sickday;
	DAMADAO dama = new DAMADAO();
	DAMAVO st = new DAMAVO();

	Enemy ge = new Enemy();
	Scanner sc = new Scanner(System.in);

	public void Phase() {
		
		Enemy t =ge.getEnemy();
		
		System.out.println(t.En_name + "�� ��� �տ� ����� �巯�½��ϴ�.");
		System.out.println("����� ������ �غ��մϴ�......");
		while (st.hp < 0 || ge.En_hp < 0) {
			System.out.println("[1] �����Ѵ� [2] ����ģ��");
			int choice = sc.nextInt();
			
		}

	}

}
