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
	
	public void Eventset(String id) {
		int event_menu = rd.nextInt(100);
		System.out.println("������"+event_menu);
		if (event_menu<2) {
			int select=0;
			st=t.vo_loding(id);
			System.out.println("    ==���� ���� �߻�== ");
			System.out.println("    [1]Ȯ��   [2]�ص� ");
			st.Alldate(id);
			fc.Face_Sick(id);
		}else if(event_menu>50) {
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
