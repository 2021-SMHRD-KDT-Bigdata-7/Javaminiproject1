package Javaproject;

public class Eat {
	//������ �Դ� Ŭ�����Դϴ�.

	
       
		DAMADAO dama = new DAMADAO();
		DAMAVO st;
		
		public void Face_Bob(String id) {
			st=dama.dama_loding(id);
			System.out.println("    �� �̸��� " + st.getNick() + " ���� ���� �Ҿ��Ҿ����� �ķ�� ���");
			System.out.println("              �� _ ��  ");
			System.out.println("           �� (@ O @)");
			System.out.println("           .c(__����_)");
			System.out.println("    HP  : "+st.getHp() + "\t ENE : "+st.getEne());
			System.out.println("    ATK : "+st.getAtk()+"\t DEF : "+st.getDef()+"\t SPD : "+st.getSpd());
			System.out.println("    Lv  : "+st.getLv()+"\t EXP : "+st.getExp());
		}
		public void Face_Herb(String id) {
			st=dama.dama_loding(id);
			System.out.println("    �� �̸��� " + st.getNick() + " ���ʸ� ���� ���� ���� �� �λ�");
			System.out.println("              �� _ ��  ");
			System.out.println("           �� (�� ^ ��)");
			System.out.println("           .c(__����_)");
			System.out.println("    HP  : "+st.getHp() + "\t ENE : "+st.getEne());
			System.out.println("    ATK : "+st.getAtk()+"\t DEF : "+st.getDef()+"\t SPD : "+st.getSpd());
			System.out.println("    Lv  : "+st.getLv()+"\t EXP : "+st.getExp());
		}
		
}

