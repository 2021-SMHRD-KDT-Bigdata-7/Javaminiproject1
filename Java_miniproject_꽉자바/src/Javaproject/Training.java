package Javaproject;

import java.util.Random;
import java.util.Scanner;

//�Ʒ��� �ϴ� Ŭ�����Դϴ�.
public class Training {
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	
	DAMADAO dama = new DAMADAO();
	Face fa = new Face();
	DAMAVO st = new DAMAVO();
	int menu ;		
	
	public void tr_Select(String id) {
		System.out.println("1. �ٸ����͵�(+wis) 2. 3��(+str) 3. ����(+shd) 4. �޸���(+spd)");
		menu = sc.nextInt();
		if(menu == 1) {
			System.out.println("������ Ǯ��ƿ�!");
			fa.Face_Talk(id);
			Quiz(id);
		}else if(menu == 2) {
			Health(id);
		}else {
			System.out.println("���� �غ��� �Դϴ�.");
		}
	}
	
	public void training_base(String id) {
			st=dama.vo_loding(id);
			st.VO_experience(50,id);
			st.VO_day(id, 1);
			st.Alldate(id);
			fa.Face_Normal(id);
	}
	
	public void Quiz(String id) {
		int num1 = rd.nextInt(99)+1;
		int num2 = rd.nextInt(99)+1;
		int rdnum = rd.nextInt(4);
		int ans;
		if(rdnum == 0) {
			System.out.print(num1 + " + " + num2 + " = ");
			ans = sc.nextInt();
			if(ans == num1 + num2) {
				System.out.println("�����Դϴ�! wis + 1!");
				st.VO_trStudy(1, id);
			}else {
				System.out.println("Ʋ�Ƚ��ϴ�.. �ٽ� �����غ�����");
			}
		}else if(rdnum == 1) {
			System.out.print(num1 + " - " + num2 + " = ");
			ans = sc.nextInt();
			if(ans == num1 - num2) {
				System.out.println("�����Դϴ�! wis + 1!");
				st.VO_trStudy(1, id);
			}else {
			System.out.println("Ʋ�Ƚ��ϴ�.. �ٽ� �����غ�����");
				}
		}else if (rdnum == 2) {
			System.out.print(num1 + " * " + num2 + " = ");
			ans = sc.nextInt();
			if(ans == num1 * num2) {
				System.out.println("�����Դϴ�! wis + 1!");
				st.VO_trStudy(1, id);
			}else {
				System.out.println("Ʋ�Ƚ��ϴ�.. �ٽ� �����غ�����");
				}
		}else if (rdnum == 3) {
			if(num1 < num2) {
				int temp = num2;
				num2 = num1;
				num1 = temp;}
			System.out.println("���� ���ϼ���");
			System.out.print(num1 + " / " + num2 + " = ");
			ans = sc.nextInt();
				if(ans == num1 / num2) {
					System.out.println("�����Դϴ�! wis + 1!");
					st.VO_trStudy(1, id);
				}else {
					System.out.println("Ʋ�Ƚ��ϴ�.. �ٽ� �����غ�����");
			}
		}
	}
	
	public void Health(String id) {
		st=dama.vo_loding(id);
		System.out.println(st.getNick() + "(��)�� �� ���Ը� �Է��ϼ���. ���� Str : " + st.getStr());
		int kg = sc.nextInt();
		
		if(kg > st.getStr()+10) {
			System.out.println("��...");
			System.out.println("�ʹ� ���ſ��� �� �� ����� T^T");
		}else if(kg >= st.getStr()-10 && kg <= st.getStr()+10) {
			fa.Face_HealthTwo(id);
			System.out.println("������!!");
			System.out.println("str + 1!");
			System.out.println();
			st.VO_trHealth(1, id);
			st.Alldate(id);
		}else if(kg < st.getStr()-10) {
			fa.Face_HealthTwo(id);
			System.out.println("�̰� ���� ... �ʹ� ������ ...");
			System.out.println("��� ȿ���� ����.. str + 0..");
		}
	}
	
	public void Shield(String id) {
		System.out.println();
	}
		
	
	
	
	
}
