package Javaproject;

import java.util.Scanner;

public class Battle {

	
	DAMADAO dama = new DAMADAO();
	DAMAVO st = new DAMAVO();

	Enemy ge = new Enemy();
	Scanner sc = new Scanner(System.in);

	public void Phase() {
		
		Enemy t =ge.getEnemy();
		
		System.out.println(t.getEn_name() + "�� ��� �տ� ����� �巯�½��ϴ�.");
		System.out.println("����� ������ �غ��մϴ�......");
		while (st.getHp() < 0 || ge.getEn_hp() < 0) {
			System.out.println("[1] �����Ѵ� [2] ����ģ��");
			int choice = sc.nextInt();
			if(choice == 1) {
				
			}
			
		}

	}

}
