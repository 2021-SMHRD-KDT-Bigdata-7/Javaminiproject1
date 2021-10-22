package Javaproject;

import java.util.Random;
import java.util.Scanner;

public class Battle {

	DAMADAO dama = new DAMADAO();
	DAMAVO st;
	Enemy t;
	Random rd = new Random();

	Scanner sc = new Scanner(System.in);
	private String id;
	private String nick;
	private int lv;
	private int expe;
	private int hp;
	private int ene;
	private int max_hp;
	private int max_ene;
	private int atk;
	private int def;
	private int spd;
	private int food;
	private int hurbs;
	private int startday;
	private int sickday;
	private String En_name;
	private int En_atk;
	private int En_def;
	private int En_spd;
	private int En_hp;

	public void Anything() {
		id = st.getId();
		nick = st.getNick();
		lv = st.getLv();
		expe = st.getExpe();
		hp = st.getHp();
		ene = st.getEne();
		max_hp = st.getMax_hp();
		max_ene = st.getMax_ene();
		atk = st.getAtk();
		def = st.getDef();
		spd = st.getSpd();
		food = st.getFood();
		hurbs = st.getHurbs();
		startday = st.getStartday();
		sickday = st.getSickday();
		En_name = t.getEn_name();
		En_hp = t.getEn_hp();
		En_atk = t.getEn_atk();
		En_def = t.getEn_def();
		En_spd = t.getEn_spd();

	}

	public void Phase(String id) {
		Enemy ge = new Enemy();
		t = ge.getEnemy();
		st = dama.dama_loding(id);
		Anything();
		int user_dmg = atk - En_def;
		int En_dmg = En_atk - def;
		System.out.println(atk);
		System.out.println(En_def);
		System.out.println(t.getEn_name() + "��(��) ����� �巯�½��ϴ�.");
		System.out.println(st.getNick() + "��(��) ������ �غ��մϴ�......");
		if (En_spd >= spd) {
			System.out.println(t.getEn_name() + "�� �������! " + st.getNick() + "�� " + En_dmg + "�� �������� �޾Ҵ�!");
			if (def >= En_atk) {
				En_dmg = 0;
			}
			hp -= En_dmg;
		}
		while (true) {
			if (hp < 1) {
				System.out.println("����� �׾����ϴ�.");
				break;
			} else if (En_hp < 1) {
				System.out.println("�̰��!" + t.getEn_name() + "�� ��ġ����!");
				System.out.println("");
				break;

			}
			System.out.println(
					t.getEn_name() + " ����// ü�� :" + En_hp + "���ݷ� : " + En_atk + "���� : " + En_def + "�ӵ� : " + En_spd);
			System.out.println(st.getNick() + " ����// ü�� :" + hp + "���ݷ� : " + atk + "���� : " + def + "�ӵ� : " + spd);
			System.out.println("[1] ������ ��ġ�� ������ [2] ��ų [3] ����ģ��");
			int choice = sc.nextInt();
			if (choice == 1) {
				if (rd.nextInt(5) == 0) {
					System.out.println(En_name + "ȸ��! " + st.getNick() + "��(��) �ƹ��� ���ص� ������ ���ߴ�!");
				} else {
					if (rd.nextInt(5) == 0) {
						user_dmg = atk;
						System.out.println("ũ��Ƽ��! " + En_name + "�� " + user_dmg + "�� �������� �޾Ҵ�! ");
						En_hp -= user_dmg;
					} else {
						System.out.println(st.getNick() + "�� ������ ��ġ! " + En_name + "��(��) " + user_dmg + "�� �������� �޾Ҵ�!");
						if (En_def >= atk) {
							user_dmg = 0;
						}
						En_hp -= user_dmg;
						if (rd.nextInt(5) == 0) {
							System.out.println(st.getNick() + "�� ����� ȸ��! " + En_name + "��(��) ��� ���ص� ������ ���ߴ�!");
						} else {
							if (rd.nextInt(5) == 0) {
								En_dmg = En_atk;
								System.out.println(
										En_name + "�� ġ������ ����! " + st.getNick() + "��(��)" + En_dmg + "�� �������� �޾Ҵ�!");
								if (def >= En_atk) {
									En_dmg = 0;
								}
								hp -= En_dmg;
							} else {
								System.out.println(En_name + "�� ����! " + st.getNick() + "��(��)" + En_dmg + "�� �������� �޾Ҵ�!");
								if (def >= En_atk) {
									En_dmg = 0;
								}
								hp -= En_dmg;
							}
						}
					}
				}
			} else if (choice == 2) {
				System.out.println("[1] �����ġ�� [2] �� [3] �ڷΰ���");
				int choice_skill = sc.nextInt();
				if (choice_skill == 1) {
					if (ene < 30) {
						System.out.println("���� �����ġ�⸦ �ϴ� �� �����ϴ�!");
					} else {
						user_dmg = atk;
						ene -= 40;
						System.out.println(st.getNick() + " �����ġ��! " + En_name + "��(��)" + user_dmg + "�� �������� �޾Ҵ�!");
						En_hp -= user_dmg;
					}
				} else if (choice_skill == 2) {
					if (hurbs < 1) {
						System.out.println("���ʰ� ����! ȸ���� �Ұ����ϴ�!");
					} else {
						hp += 20;
						hurbs--;
						if (hp > max_hp) {
							hp = max_hp;
						}
						System.out.println(st.getNick() + "��(��) ���ʸ� ����Ͽ� ü���� ȸ���ߴ�! 20��ŭ ü���� ȸ���Ǿ���!");
					}
				}
			} else if (choice == 3) {
				if (En_spd > spd) {
					System.out.println(st.getNick() + "��(��) ����ĥ �� ������! " + En_dmg + "�� �������� �޾Ҵ�!");
					if (def >= En_atk) {
						En_dmg = 0;
					}
					hp -= En_dmg;
				} else {
					System.out.println(st.getNick() + "��(��) ������ó�� ��������!");
					break;
				}

			}

		}
		dama.update(id, nick, lv, expe, hp, ene, max_hp, max_ene, atk, def, spd, food, hurbs, startday, sickday);
	}

}
