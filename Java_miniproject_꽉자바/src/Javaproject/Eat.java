package Javaproject;

import java.util.Scanner;

public class Eat {
	//������ �Դ� Ŭ�����Դϴ�.
	Scanner sc = new Scanner(System.in);

	
       
		DAMADAO dama = new DAMADAO();
		Face fa = new Face();
		DAMAVO st;
		
		public void Eat_menu(String id) {
		st = dama.dama_loding(id);
		System.out.println("1. �� "+st.getFood() + " 2. ����"+st.getHurbs() );
		int eat_choice = sc.nextInt();
		
		if(eat_choice == 1) {
			System.out.println("���� �Դ´�.");
			System.out.println();
			Eat_Bob(id);
			System.out.println();
			
		}else if(eat_choice == 2) {
			System.out.println("���ʸ� �Դ´�.");
			System.out.println();
			Eat_Medic(id);
			System.out.println();
			
		}
		}
		
		
		public void Eat_Bob(String id) {
			st = dama.dama_loding(id);
			int bob = st.getFood();
			if (bob>0) {
				bob--;
				System.out.println(bob);
				st.setFood(bob);
				fa.Face_Eat_Fish(id);
			}
		}
		public void Eat_Medic(String id) {
			st = dama.dama_loding(id);
			int her = st.getHurbs();
			if (her>0) {
				her--;
				st.setFood(--her);
				fa.Face_Eat_Medi(id);
			}
		}
		
}

