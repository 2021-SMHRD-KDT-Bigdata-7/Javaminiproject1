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
		st = dama.vo_loding(id);
		her = st.getHurbs();
		bob = st.getFood();
		hp = st.getHp();
		ene = st.getEne();
		System.out.println("1. ��" + "(" + st.getFood() + "��)" + " 2. ����" + "(" + st.getHurbs() + "��)" + " 3. �ڷΰ���");
		int eat_choice = sc.nextInt();

		if (eat_choice == 1) {

			if (bob > 0) {
				System.out.println("���� �Դ´�.");
				bob--;
				ene += 50;
//				System.out.println(bob);
				st.setFood(bob);
				st.setEne(ene);

				st.Alldate(id);
				fa.Face_Eat_Fish(id);
			} else {
				System.out.println("���� ����.");
			}

		} else if (eat_choice == 2) {

			if (her > 0) {
				System.out.println("���ʸ� �Դ´�.");
				her--;
				hp += 50;
				st.setHurbs(her);
				st.setHp(hp);

				st.Alldate(id);
				fa.Face_Eat_Medi(id);
			} else {
				System.out.println("���ʰ� ����.");
			}

		}

	}

	public void Bob_save(String id) {

		st = dama.vo_loding(id);
		bob = st.getFood();

		if (bob >= 0) {
			System.out.println("���� ���Ѵ�.");
			bob++;
			st.setFood(bob);
			fa.Face_Fishing(id);
			st.Alldate(id);
			System.out.println("���� "+st.getFood()+"ȹ���ߴ�!");
		}
	}

	public void Herb_save(String id) {
		st = dama.vo_loding(id);
		her = st.getHurbs();
		if (her >= 0) {
			System.out.println("���ʸ� ���Ѵ�.");
			her++;
			st.setHurbs(her);
			fa.Face_Get_Medi(id);
			st.Alldate(id);
			System.out.println("���� "+st.getHurbs()+"ȹ���ߴ�!");
		}
	}
}
