package Javaproject;

import java.util.Scanner;

//������ �ϴ� Ŭ���� �Դϴ�.
public class Adventure {
	Scanner sc= new Scanner(System.in);
	Battle bt = new Battle();
	Eat ea = new Eat();
	DAMAVO st=new DAMAVO();
	Face fc = new Face();
	int select_admenu;
	
	public void select_Adven(String main_id) {
		select_admenu=0;
		while (true) {
			if (select_admenu==0) {
			System.out.println("[1]����ϱ� [2]���ı��ϱ� [3]�౸�ϱ� [4]�ڷΰ���");
			select_admenu=sc.nextInt();
			}else if(select_admenu==1) {
				System.out.println("[1]������ [2]���� [3]��ǳ����");
				int a=sc.nextInt();
				bt.Phase(main_id, a);
				break;
				
			}else if(select_admenu==2) {
				ea.Bob_save(main_id);
				break;
				
			}else if(select_admenu==3) {
				ea.Herb_save(main_id);
				break;
				
			}else if(select_admenu==4) {
				break;
			}else {
				select_admenu=0;
			}
			
		}
		
	}


}
