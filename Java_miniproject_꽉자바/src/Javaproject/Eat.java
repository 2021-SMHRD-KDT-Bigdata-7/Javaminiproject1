package Javaproject;

import java.util.Scanner;

public class Eat {
	// ������ �Դ� Ŭ�����Դϴ�.
	
	Scanner sc = new Scanner(System.in);
	DAMADAO dama = new DAMADAO();
	Face fa = new Face();
	DAMAVO st = new DAMAVO();

	public void Eat_menu(String id) {
		st=dama.vo_loding(id);
		int her = st.getHurbs();
		int bob = st.getFood();
		int hp = st.getHp();
		int ene = st.getEne();
		System.out.println("1. �� " + st.getFood() + " 2. ���� " + st.getHurbs());
		int eat_choice = sc.nextInt();

		if (eat_choice == 1) {
			
			System.out.println("���� �Դ´�.");
			if (bob > 0) {
				bob--;
				ene+=10;
//				System.out.println(bob);
				st.setFood(bob);
				st.setEne(ene);
				
				fa.Face_Fishing(id);
				st.Alldate(id);
			}else {
				System.out.println("���� ����.");
			}

		} else if (eat_choice == 2) {
			
			System.out.println("���ʸ� �Դ´�.");
			if (her > 0) {
				her--;
				hp+=10;
				st.setHurbs(her);
				st.setHp(hp);
				
				fa.Face_Eat_Fish(id);
				st.Alldate(id);
				}
			else {
				System.out.println("���ʰ� ����.");
			}
				
		}
		
	}
}
