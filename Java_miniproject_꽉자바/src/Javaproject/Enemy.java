package Javaproject;

import java.util.ArrayList;
import java.util.Random;

public class Enemy {

	// �� ���� ����
	private String En_name;
	int En_hp;
	int En_atk;
	int En_def;
	int En_spd;
	Random rd = new Random();

	public Enemy() {
	}

	public Enemy getEnemy() {
		int i = rd.nextInt(17);
		ArrayList<Enemy> eList = new ArrayList<>();

		eList.add(new Enemy("��ī��", 100, 100, 100, 100));
		eList.add(new Enemy("������", 100, 100, 100, 100));
		eList.add(new Enemy("���̸�", 100, 100, 100, 100));
		eList.add(new Enemy("���α�", 100, 100, 100, 100));
		eList.add(new Enemy("������", 100, 100, 100, 100));
		eList.add(new Enemy("�ߵ���", 100, 100, 100, 100));
		eList.add(new Enemy("������", 100, 100, 100, 100));
		eList.add(new Enemy("�ǰ���", 100, 100, 100, 100));
		eList.add(new Enemy("�Ḹ��", 100, 100, 100, 100));
		eList.add(new Enemy("�ߵ�", 100, 100, 100, 100));
		eList.add(new Enemy("Ǫ��", 100, 100, 100, 100));
		eList.add(new Enemy("�����", 100, 100, 100, 100));
		eList.add(new Enemy("����Ҵ�", 100, 100, 100, 100));
		eList.add(new Enemy("�ǵ�����", 100, 100, 100, 100));
		eList.add(new Enemy("�߿���", 100, 100, 100, 100));
		eList.add(new Enemy("���ڿ�", 100, 100, 100, 100));
		eList.add(new Enemy("�׷���", 100, 100, 100, 100));

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