package Javaproject;

import java.util.Random;
import java.util.Scanner;

public class Event {
	Random rd = new Random(); 
	DAMAVO st = new DAMAVO();
	DAMADAO t = new DAMADAO();
	Face fc = new Face();
	Scanner sc = new Scanner(System.in);
	Battle bt = new Battle();
	Sick si = new Sick();
	
	public void Eventset(String id) {
		int event_menu = rd.nextInt(100);
		if (event_menu<20) {
			int select=0;
			st=t.vo_loding(id);
			System.out.println("    ==���� ���� �߻�== ");
			System.out.println("    [1]Ȯ��   [2]�ص� ");
			while(true) {
				select = sc.nextInt();
				if(select == 1) {
					si.SSick(id);
					break;
				}else if(select == 2) {
					if (st.getHurbs()>0) {
						st.setHurbs(st.getHurbs()-1);
						System.out.println("������ ȸ���ߴ�.");
						st.Alldate(id);
					}else {
						System.out.println("���ʰ� ����.");
						System.out.println("������ �ɷȴ� ���� �� ����.");
						si.SSick(id);
					}
					break;
				}
			}
			
		}else if(event_menu>10) {
			int select=0;
			System.out.println("  ==���� ���� �߻�==");
			System.out.println("   [1] ���� ����  ");
			while (select != 1) {
				select=sc.nextInt();
			}
			int a=rd.nextInt(3);
			bt.Phase(id, a);
			
			
		}
	}

}
