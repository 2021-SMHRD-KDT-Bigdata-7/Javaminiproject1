package Javaproject;

import java.util.Scanner;

public class Eat {
	// ������ �Դ� Ŭ�����Դϴ�.
	
	Scanner sc = new Scanner(System.in);
	DAMADAO dama = new DAMADAO();
	Face fa = new Face();
	DAMAVO st = new DAMAVO();

	
	private int her;
	private int bob;
	private int hp;
	private int ene;
	
	public void Eat_menu(String id) {
		st=dama.vo_loding(id);
		 her = st.getHurbs();
		 bob = st.getFood();
		 hp = st.getHp();
		 ene = st.getEne();
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
	
	public void Eat_save(String id) {
		
		st=dama.vo_loding(id);
		her = st.getHurbs();
		 bob = st.getFood();
		 hp = st.getHp();
		 ene = st.getEne();
		 
		 System.out.println("1. �� " + st.getFood() + " 2. ���� " + st.getHurbs());
		 int s = sc.nextInt();
		 if(s == 1) {
			 if(bob >=0) {
				 System.out.println("���� ���Ѵ�.");
				 bob++;
				 st.setFood(bob);
				 st.Alldate(id);
			 }
		 }else if(s == 2) {
			 if(her>=0) {
				 System.out.println("���ʸ� ���Ѵ�.");
				her++; 
				st.setHurbs(her);
				st.Alldate(id);
			 }
		 }
		
	}
}
