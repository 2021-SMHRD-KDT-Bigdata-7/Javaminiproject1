package Javaproject;

import java.util.ArrayList;
import java.util.Random;

public class Enemy {

	// �� ���� ����
	private String En_name;
	private int En_hp;
	private int En_atk;
	private int En_def;
	private int En_spd;
	Random rd = new Random();

	public Enemy() {
	}

	public String getEn_name() {
		return En_name;
	}

	public int getEn_hp() {
		return En_hp;
	}

	public int getEn_atk() {
		return En_atk;
	}

	public int getEn_def() {
		return En_def;
	}

	public int getEn_spd() {
		return En_spd;
	}

	public void setEn_name(String en_name) {
		En_name = en_name;
	}

	public void setEn_hp(int en_hp) {
		En_hp = en_hp;
	}

	public void setEn_atk(int en_atk) {
		En_atk = en_atk;
	}

	public void setEn_def(int en_def) {
		En_def = en_def;
	}

	public void setEn_spd(int en_spd) {
		En_spd = en_spd;
	}

	public Enemy getEnemy() {
		int i = rd.nextInt(17);
		ArrayList<Enemy> eList = new ArrayList<>();

		eList.add(new Enemy("��ī��", 150, 10, 25, 10));
		eList.add(new Enemy("������", 140, 20, 30, 10));
		eList.add(new Enemy("���̸�", 120, 35, 13, 30));
		eList.add(new Enemy("���α�", 200, 55, 20, 10));
		eList.add(new Enemy("������", 220, 60, 15, 10));
		eList.add(new Enemy("�ߵ���", 240, 75, 25, 10));
		eList.add(new Enemy("������", 300, 80, 30, 10));
		eList.add(new Enemy("�ǰ���", 120, 20, 19, 10));
		eList.add(new Enemy("�Ḹ��", 150, 120, 60, 10));
		eList.add(new Enemy("�ߵ�", 180, 50, 50, 60));
		eList.add(new Enemy("Ǫ��", 120, 40, 80, 50));
		eList.add(new Enemy("�����", 150, 30, 90, 40));
		eList.add(new Enemy("����Ҵ�", 130, 70, 100, 30));
		eList.add(new Enemy("�ǵ�����", 120, 80, 110, 20));
		eList.add(new Enemy("�߿���", 200, 500, 100, 60));
		eList.add(new Enemy("���ڿ�", 310, 50, 110, 70));
		eList.add(new Enemy("�׷���", 320, 30, 110, 80));

		return eList.get(i);
	}

	public Enemy(String en_name, int en_hp, int en_atk, int en_def, int en_spd) {
		En_name = en_name;
		En_hp = en_hp;
		En_atk = en_atk;
		En_def = en_def;
		En_spd = en_spd;
	}

}