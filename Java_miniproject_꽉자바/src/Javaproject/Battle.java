package Javaproject;

import java.util.Scanner;

public class Battle {

	DAMADAO dama = new DAMADAO();
	DAMAVO st ;

	Enemy ge = new Enemy();
	Enemy t = ge.getEnemy();
	Scanner sc = new Scanner(System.in);
	private int lv;
	private int exp;
	private int hp;
	private int max_hp;
	private int atk;
	private int def;
	private int spd;
	private String En_name;
	private int En_hp ;
	private int En_atk ;
	private int En_def ;
	private int En_spd ;

	public void Anything () {
		lv = st.getLv();
		exp = st.getExpe();
		hp = st.getHp();
		max_hp = st.getMax_hp();
		atk = st.getAtk();
		def = st.getDef();
		spd = st.getSpd();
		En_name = t.getEn_name();
		En_hp = t.getEn_hp();
		En_atk = t.getEn_atk();
		En_def = t.getEn_def();
		En_spd = t.getEn_spd();

	}

	public void Phase(String id) {
		st=dama.dama_loding(id);
		Anything ();
		int user_dmg = atk - En_def;
		int En_dmg = En_atk - def;
		System.out.println(atk);
		System.out.println(En_def);
		System.out.println(t.getEn_name() + "�� ����� �巯�½��ϴ�.");
		System.out.println(st.getNick() + "�� ������ �غ��մϴ�......");
		if (En_spd >= spd) {
			System.out.println(t.getEn_name() + "�� ����! " + st.getNick() + "�� " + En_dmg + "�� �������� �޾Ҵ�!");
			if (def>=En_atk) {
				En_dmg=0;
			}
			hp -= En_dmg;
		} 
			while (true) {
				System.out.println(t.getEn_name()+" ����// ü�� :" +En_hp+"���ݷ� : "+En_atk+"���� : "+En_def+"�ӵ� : "+En_spd);
				System.out.println("[1] ������ ��ġ�� ������ [2] ����ģ��");
				int choice = sc.nextInt();
				if (choice == 1) {
					System.out.println(st.getNick() + "�� ������ ��ġ! " + En_name + "�� " + user_dmg + "�� �������� �޾Ҵ�!");
					if (En_def>=atk) {
						user_dmg=0;
					}
					En_hp -= user_dmg;
					System.out.println(En_name+"�� ����! "+st.getNick()+"��"+En_dmg+"�� �������� �޾Ҵ�!");
					if (def>=En_atk) {
						En_dmg=0;
					}
					hp-=En_dmg;
				} else if (choice == 2) {
					if (En_spd > spd) {
						System.out.println(st.getNick() + "�� ����ĥ �� ������! " + En_dmg + "�� �������� �޾Ҵ�!");
						if (def>=En_atk) {
							En_dmg=0;
						}
						hp -= En_dmg;
					} else {
						System.out.println(st.getNick() + "�� ������ó�� ��������!");
						break;
					}
				}
					if (hp<1) {
						System.out.println("����� �׾����ϴ�.");
						break;
					} else if (En_hp<0) {
						System.out.println("�̰��!");
						break;
					}
		}
	}

}
