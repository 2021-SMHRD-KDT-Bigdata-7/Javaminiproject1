package Javaproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.lang.Math;

public class Battle {
	Face fc = new Face();
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
	private int maxhp;
	private int maxene;
	private int atk;
	private int spd;
	private int food;
	private int hurbs;
	private int startday;
	private int sickday;
	private int shd;
	private int str;
	private int dex;
	private int wis;
	private int luk;
	private String En_name;
	private int En_atk;
	private int En_def;
	private int En_spd;
	private int En_hp;
	private int En_str;
	private int En_dex;
	private int En_wis;
	private int En_luk;
	int En_dmg = 0;
	int basePro;
	int user_EsPro;
	int user_HitPro;
	int user_CriPro;
	int En_EsPro;
	int En_HitPro;
	int En_CriPro;

	private int user_dmg = 0;

	public void Anything() {
		id = st.getId();
		nick = st.getNick();
		lv = st.getLv();
		expe = st.getExpe();
		hp = st.getHp();
		ene = st.getEne();
		maxhp = st.getMaxhp();
		maxene = st.getMaxene();
		atk = st.getAtk();
		shd = st.getShd();
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

		int user_dmg = (str + atk - En_def);
		int En_dmg = (En_str + En_atk - shd);

		int basePro = 50;

		int user_EsPro = (basePro - 20) + (spd - En_spd);
		int user_HitPro = (basePro + 30) + (dex - En_dex);
		int user_CriPro = (basePro - 40) + (luk - En_luk);
		int En_EsPro = basePro + (En_spd - spd);
		int En_HitPro = (basePro + 20) + (En_spd - spd);
		int En_CriPro = (basePro - 40) + (En_luk - luk);

		WeightsPro(user_EsPro);
		WeightsPro(user_HitPro);
		WeightsPro(user_CriPro);
		WeightsPro(En_EsPro);
		WeightsPro(En_HitPro);
		WeightsPro(En_CriPro);

	}

	public void Phase(String id) {

		fc.Face_Fight(id);
		Enemy ge = new Enemy();
		t = ge.getEnemy();
		st = dama.dama_loding(id);
		Anything();

		System.out.println(t.getEn_name() + "��(��) ����� �巯�½��ϴ�.");
		System.out.println(st.getNick() + "��(��) ������ �غ��մϴ�......");
		System.out.println("");
		if (En_spd >= spd) {
			System.out.println(t.getEn_name() + "�� �������! " + st.getNick() + "�� " + En_dmg + "�� �������� �޾Ҵ�!");
			System.out.println("");
			if (shd >= En_atk) {
				En_dmg = 0;
			}
		}
		while (true) {
			System.out.println(
					t.getEn_name() + " ����// ü�� :" + En_hp + "���ݷ� : " + En_atk + "���� : " + En_def + "�ӵ� : " + En_spd);
			System.out.println(st.getNick() + " ����// ü�� :" + hp + "���ݷ� : " + atk + "���� : " + shd + "�ӵ� : " + spd);
			System.out.println("");
			Turn();
			if (Turn() == 2) {
				break;
			}
			if (hp < 1) {
				System.out.println("����� �׾����ϴ�.");
				break;
			} else if (En_hp < 1) {
				System.out.println("�̰��!" + t.getEn_name() + "�� ��ġ����!");
				break;
			}

		}
	}

	public int Turn() {
		Anything();
		System.out.println("[1] �����Ѵ� [2] ��ų [3] ����ģ��");
		System.out.println(" ");
		int choice = sc.nextInt();

		if (choice == 1) {
			if (WeightsPro(user_HitPro)) {
				if (WeightsPro(user_CriPro)) {
					user_dmg = atk;
					System.out.println("ũ��Ƽ��! " + En_name + "�� " + user_dmg + "�� �������� �޾Ҵ�! ");
					System.out.println("");
					En_hp -= user_dmg;
				} else {
					System.out.println(st.getNick() + "�� ������ ��ġ! " + En_name + "��(��) " + user_dmg + "�� �������� �޾Ҵ�!");
					System.out.println("");
					if (En_def >= atk) {
						user_dmg = 0;
					} else {
						En_hp -= user_dmg;
					}
				}

			} else {
				System.out.println(En_name + "ȸ��! " + st.getNick() + "��(��) �ƹ��� ���ص� ������ ���ߴ�!");
				System.out.println("");
			}

		} else if (choice == 2) {
			System.out.println("[1] ���̾ [2] ����  [3] �� [4] �ڷΰ���");
			System.out.println("");
			int choice_skill = sc.nextInt();
			if (choice_skill == 1) {
				if (ene <= 30) {
					System.out.println("�������� ����! ���� ���̾�� ���� �� �����ϴ�!");
					System.out.println("");
				} else {
					user_dmg = (atk * wis) / 2;
					if (atk * wis == 1) {
						user_dmg = (atk * wis + 1) / 2;
					}
					ene -= 30;
					System.out.println(
							st.getNick() + "�� ���̾�� �����ߴ�! " + En_name + "��(��) �ұ濡 �۽ο�" + user_dmg + "�� �������� �޾Ҵ�!");
					System.out.println("");
					En_hp -= user_dmg;
				}
			} else if (choice_skill == 2) {
				int a = 30;

				if (hp <= 30) {
					System.out.println(st.getNick() + " : '�׷�. ���� �� ����ۿ� ����..'");
				} else {
					user_dmg = (atk * wis * str) / 2;
					if (atk * wis == 1) {
						user_dmg = (atk * wis + 1) / 2;
					}
					ene -= 30;
					System.out.println(st.getNick() + "�� ����! " + En_name + "��(��) " + user_dmg + "�� �������� �޾Ҵ�!");
					System.out.println("�׷���" + st.getNick() + " ���� " + a + "�� ü���� �Ҹ��ߴ�!");
					System.out.println("");
					En_hp -= user_dmg;
					hp -= a;
				}
			} else if (choice_skill == 3) {
				if (hurbs < 1) {
					System.out.println("���ʰ� ����! ȸ���� �Ұ����ϴ�!");
					System.out.println(st.getNick() + " : '����! �̷� �� �˾����� �� ���س��� �ǵ�!'");
					System.out.println("");
				} else {
					hp += 20;
					hurbs--;
					if (hp > maxhp) {
						hp = maxhp;
					}
					System.out.println(st.getNick() + "��(��) ���ʸ� ����Ͽ� ü���� ȸ���ߴ�! 20��ŭ ü���� ȸ���Ǿ���!");
					System.out.println("");
				}
			}
		} else if (choice == 3) {
			if (WeightsPro(user_EsPro)) {
				fc.Face_Escape(id);
				System.out.println(st.getNick() + "��(��) ������ó�� ��������!");
				System.out.println("");
			}

			else {
				System.out.println(st.getNick() + "��(��) ����ĥ �� ������! " + En_dmg + "�� �������� �޾Ҵ�!");
				System.out.println("");
				if (shd >= En_dmg) {
					En_dmg = 0;
				}
				hp -= En_dmg;
				return 2;
			}
		}

		return 1;

	}

	public int En_Turn() {
		if (rd.nextInt(5) == 0) {
			System.out.println(st.getNick() + "�� ����� ȸ��! " + En_name + "��(��) ��� ���ص� ������ ���ߴ�!");
			System.out.println("");
		} else {
			if (rd.nextInt(5) == 0) {
				En_dmg = En_atk;
				System.out.println(En_name + "�� ġ������ ����! " + st.getNick() + "��(��)" + En_dmg + "�� �������� �޾Ҵ�!");
				System.out.println("");
				if (shd >= En_atk) {
					En_dmg = 0;
				}
				hp -= En_dmg;
			} else {
				System.out.println(En_name + "�� ����! " + st.getNick() + "��(��)" + En_dmg + "�� �������� �޾Ҵ�!");
				System.out.println("");
				if (shd >= En_atk) {
					En_dmg = 0;
				} else {
					hp -= En_dmg;
				}
			}
			return 1;
		}
		return 2;
	}

	public static boolean WeightsPro(int percentNum) {

		boolean result = false;

		List<Integer> arrPick = getScopeList(1, 100);
		int pickNum = getRandom(1, 100); // �����, 1 ~ 100�� ������ ��1(�� ���ڰ� Ȯ���迭�� ���Կ��� üũ)

		if (0 < percentNum && percentNum < 100) {
			Collections.shuffle(arrPick);
			for (int i = 1; i <= percentNum; i++) {

				if (arrPick.get(i - 1) == pickNum) {
					result = true;
					break;
				}
			}
		} else if (percentNum >= 100) {

			result = true;
		}
		return result;
	}

	public static List<Integer> getScopeList(int pstart, int pend) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = pstart; i <= pend; i++) {

			list.add(i);
		}
		return list;
	}

	public static int getRandom(int p_start, int p_end) {

		Random rnd = new Random();

		if (p_start >= p_end) {

			return 0;

		} else {

			return rnd.nextInt(p_end - p_start + 1) + p_start;
		}

	}

}
