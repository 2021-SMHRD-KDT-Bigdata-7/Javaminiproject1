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
	}
	
	public void training_base(String id) {
		
		if(menu == 1) {
			st=dama.vo_loding(id);
			st.VO_experience(50,id);
			st.VO_day(id, 1);
			st.Alldate(id);
			fa.Face_Health(id);
		}else if(menu == 2) {
			st=dama.vo_loding(id);
			st.VO_experience(50,id);
			st.VO_day(id, 1);
			st.Alldate(id);
			fa.Face_Health(id);
		}else if(menu == 3) {
			st=dama.vo_loding(id);
			st.VO_experience(50,id);
			st.VO_day(id, 1);
			st.Alldate(id);
			fa.Face_����(id);
		}else if(menu == 4) {
			st=dama.vo_loding(id);
			st.VO_experience(50,id);
			st.VO_day(id, 1);
			st.Alldate(id);
			fa.Face_run(id);
		}else {
			System.out.println("��Ȯ�� ���� �Է��ϼ���.");
		}
		
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
		System.out.println("���Ը� �Է��ϼ���");
		int kg = sc.nextInt();
		
		if(kg >= st.getStr()) {
			
		}
		
	}
	
	
	
	
}
