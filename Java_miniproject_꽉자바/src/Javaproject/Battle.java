package Javaproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Battle {
	// Battle 내에서 사용할 외부 메소드를 불러옴.
	Face fc = new Face();
	DAMADAO dama = new DAMADAO();
	DAMAVO st;
	Enemy t;

	// 안에서 사용할 Random과 Scanner 불러옴.
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);

	// 외부 변수 선언. DAMADAO와 DAMAVO에서 가져올 변수를 미리 선언함.
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

	// 적 공격력 선언. 적의 속도가 빠를 경우 턴 메소드 실행 이전에 선공을 진행하므로 미리 선언함
	int En_dmg;

	// 기본 확률 선언. basePro는 유저 턴과 적 턴 메소드를 분리해서 초기화하므로
	// 유저의 확률과 적의 확률을 다르게 설정하여 난이도 조절을 할 수 있도록 함
	int basePro;

	// 확률 선언.
	int user_EsPro;
	int user_HitPro;
	int user_CriPro;
	int En_EsPro;
	int En_HitPro;
	int En_CriPro;
	int En_dmgR;
	private int user_dmg = 0;
	
	// DAMAVO와 Enemy에서 각각 유저 스탯, 적 스탯을 불러옴.
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
		str = st.getStr();
		dex = st.getDex();
		wis = st.getWis();
		luk = st.getLuk();
		food = st.getFood();
		hurbs = st.getHurbs();
		startday = st.getStartday();
		sickday = st.getSickday();
		En_name = t.getEn_name();
		En_hp = t.getEn_hp();
		En_atk = t.getEn_atk();
		En_def = t.getEn_def();
		En_spd = t.getEn_spd();
		En_str = t.getEn_str();
		En_dex = t.getEn_dex();
		En_wis = t.getEn_wis();
		En_luk = t.getEn_luk();
		// 유저 데미지 기본값

		int user_dmg = (str + atk - En_def);
		// 유저 데미지 분산값

		// 적 데미지 기본값
		int En_dmg = (En_str + En_atk - shd);

		// 적 데미지 분산값


		// 가중확률 선언. Turn 메소드 내에서 계산된 확률 기반.
		WeightsPro(user_EsPro);
		WeightsPro(user_HitPro);
		WeightsPro(user_CriPro);
		WeightsPro(En_EsPro);
		WeightsPro(En_HitPro);
		WeightsPro(En_CriPro);
		
		int[] En_dmgList = { En_dmg - 5, En_dmg - 4, En_dmg - 3, En_dmg - 2, En_dmg - 1, En_dmg, En_dmg + 1, En_dmg + 2,
				En_dmg + 3, En_dmg + 4, En_dmg + 5 };
		int En_dmgDev = rd.nextInt(10);
		int En_dmgR = En_dmgList[En_dmgDev];
		int[] user_dmgList = { user_dmg - 5, user_dmg - 4, user_dmg - 3, user_dmg - 2, user_dmg - 1, user_dmg,
				user_dmg + 1, user_dmg + 2, user_dmg + 3, user_dmg + 4, user_dmg + 5 };
		int user_dmgDev = rd.nextInt(10);
		int user_dmgR = user_dmgList[user_dmgDev];

		int basePro = 50;

		int En_EsPro = basePro + (En_spd - spd);
		int En_HitPro = (basePro + 20) + (En_spd - spd);
		int En_CriPro = (basePro - 40) + (En_luk - luk);


	}

	// 전투 기본 메소드
	public void Phase(String id) {
		
		Enemy ge = new Enemy();
		t = ge.getEnemy();
		st = dama.vo_loding(id);	
		Anything();
		

		System.out.println(t.getEn_name() + "이(가) 모습을 드러냈습니다.");
		System.out.println(st.getNick() + "은(는) 전투를 준비합니다......");
		System.out.println("");
		if (En_spd > spd + 10) {
			System.out.println(t.getEn_name() + "의 기습공격! " + st.getNick() + "은 " + En_dmg + "의 데미지를 받았다!");
			System.out.println("");
			if (shd >= En_dmg) {
				En_dmg = 0;
			}
		}
		while (true) {
			System.out.println(t.getEn_name() + " 정보// 체력 :" + En_hp + " 공격력 : " + En_atk + " 방어력 : " + En_def
					+ " 속도 : " + En_spd);
			System.out.println(st.getNick() + " 정보// 체력 :" + hp + " 공격력 : " + atk + " 방어력 : " + shd + " 속도 : " + spd);
			System.out.println("");

			Turn();
			En_Turn();

			if (Turn() == 2 || En_Turn() == 2) {
				break;

			}
			if (hp < 1) {
				System.out.println("당신은 죽었습니다.");
				break;
			} else if (En_hp < 1) {
				System.out.println("이겼다!" + t.getEn_name() + "을 해치웠다!");
				break;
			}

		}
	}

	// 유저 턴 메소드
	public int Turn() {
		
		System.out.println(st.getNick() + "의 턴");

		Anything();

		int[] user_dmgList = { user_dmg - 5, user_dmg - 4, user_dmg - 3, user_dmg - 2, user_dmg - 1, user_dmg,
				user_dmg + 1, user_dmg + 2, user_dmg + 3, user_dmg + 4, user_dmg + 5 };
		int user_dmgDev = rd.nextInt(10);
		int user_dmgR = user_dmgList[user_dmgDev];
		int[] En_dmgList = { En_dmg - 5, En_dmg - 4, En_dmg - 3, En_dmg - 2, En_dmg - 1, En_dmg, En_dmg + 1, En_dmg + 2,
				En_dmg + 3, En_dmg + 4, En_dmg + 5 };
		int En_dmgDev = rd.nextInt(10);
		int En_dmgR = En_dmgList[En_dmgDev];

		int basePro = 50;
		int turnCount = 1;
		int user_EsPro = (basePro - 20) + (spd - En_spd);
		int user_HitPro = (basePro + 30) + (dex - En_dex);
		int user_CriPro = (basePro - 40) + (luk - En_luk);

		while (true) {

			System.out.println("[1] 공격한다 [2] 스킬 [3] 도망친다");
			System.out.println(" ");
			int choice = sc.nextInt();
			if (choice == 1) {
				if (user_dmgList[0] < 0) {
					user_dmgList[0] = 0;
				}
				System.out.println(
						"공격하시겠습니까? 명중확률 : " + user_HitPro + "%   예상 데미지 : " + user_dmgList[0] + "~" + user_dmgList[10]);
				System.out.println("[1] 공격한다 [2] 뒤로가기");

				int choice_attack = sc.nextInt();

				if (choice_attack == 1) {
					if (WeightsPro(user_HitPro)) {
						if (WeightsPro(user_CriPro)) {
							user_dmgR = atk;
							fc.Face_Cri(id);
							System.out.println("크리티컬! " + En_name + "은 " + user_dmgR + "의 데미지를 받았다! ");
							System.out.println("");
							En_hp -= user_dmgR;
						} else {
							fc.Face_Fight(id);
							if (user_dmgR < 0) {
								user_dmgR = 0;
							}
							System.out.println(st.getNick() + "의 펀치! " + En_name + "은(는) " + user_dmgR + "의 데미지를 받았다!");
							System.out.println("");
							if (En_def >= user_dmgR) {
								user_dmgR = 0;
							} else {
								En_hp -= user_dmgR;
							}
						}
						break;
					} else {
						fc.Face_Miss(id);
						System.out.println(En_name + " 회피! " + st.getNick() + "은(는) 아무런 피해도 입히지 못했다!");
						System.out.println("");
						break;
					}

				}

			}

			else if (choice == 2) {

				System.out.println("[1] 파이어볼 [2] 돌진  [3] 힐 [4] 뒤로가기");
				System.out.println("");
				int choice_skill = sc.nextInt();
				if (choice_skill == 1) {
					if (ene <= 30) {
						System.out.println("에너지가 없다! 지금 파이어볼을 쓰는 건 위험하다!");
						System.out.println("");
					} else {
						user_dmg = (atk * wis) / 2;
						if ((atk * wis) % 2 == 1) {
							user_dmg = (atk * wis + 1) / 2;
						}
						ene -= 30;
						System.out.println(
								st.getNick() + "은 파이어볼을 시전했다! " + En_name + "은(는) 불길에 휩싸여" + user_dmg + "의 데미지를 받았다!");
						System.out.println("");
						En_hp -= user_dmg;
					}
					break;
				} else if (choice_skill == 2) {
					int a = 30;

					if (hp <= 30) {
						System.out.println(st.getNick() + " : '그래. 이젠 이 방법밖엔 없어..'");
					} else {
						user_dmg = (atk * wis * str) / 2;
						if ((atk * wis) % 2 == 1) {
							user_dmg = (atk * wis + 1) / 2;
						}
						ene -= 30;
						System.out.println(st.getNick() + "의 돌진! " + En_name + "은(는) " + user_dmg + "의 데미지를 받았다!");
						System.out.println("그러나" + st.getNick() + " 역시 " + a + "의 체력을 소모했다!");
						System.out.println("");
						En_hp -= user_dmg;
						hp -= a;
					}
					break;
				} else if (choice_skill == 3) {
					if (hurbs < 1) {
						System.out.println("약초가 없다! 회복이 불가능하다!");
						System.out.println(st.getNick() + " : '제길! 이럴 줄 알았으면 더 구해놓는 건데!'");
						System.out.println("");
					} else {
						hp += 20;
						hurbs--;
						if (hp > maxhp) {
							hp = maxhp;
						}
						System.out.println(st.getNick() + "은(는) 약초를 사용하여 체력을 회복했다! 20만큼 체력이 회복되었다!");
						System.out.println("");
					}
					break;
				}

			}

			else if (choice == 3) {
				System.out.println("도망치시겠습니까? 탈출확률 : " + user_EsPro + "%");
				System.out.println("[1] 예 [2] 아니오");
				int choice_Escape = sc.nextInt();
				if (choice_Escape == 1) {
					if (WeightsPro(user_EsPro)) {
						fc.Face_Escape(id);
						System.out.println(st.getNick() + "은(는) 겁쟁이처럼 도망갔다!");
						System.out.println("");

						turnCount = 2;
					}

					else {
						if (En_dmgR < 0) {
							En_dmgR = 0;
						}
						System.out.println(st.getNick() + "은(는) 도망칠 수 없었다! " + En_dmgR + "의 데미지를 받았다!");
						System.out.println("");
						if (shd >= En_dmg) {
							En_dmg = 0;
						}
						hp -= En_dmgR;

					}
					break;
				}
			}

		}
		return turnCount;
	}

	// 적 턴 메소드
	public int En_Turn() {
		
		Anything();
		
		System.out.println(t.getEn_name() + "의 턴");


		if (En_hp < user_dmg && En_EsPro < 50) {
			if (WeightsPro(En_EsPro)) {
				System.out.println(En_name + "이(가) 도망쳤다!");
				return 2;
			} else {
				En_Attack();
			}

		} else {
			En_Attack();
		}
		return 1;
	}

	// 가중 확률 추출용 메소드
	public static boolean WeightsPro(int percentNum) {

		boolean result = false;

		List<Integer> arrPick = getScopeList(1, 100);
		int pickNum = getRandom(1, 100); // 백분율, 1 ~ 100개 숫자중 택1(이 숫자가 확률배열에 포함여부 체크)

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
	
	//적 턴 알고리즘
	public void En_Attack() {
		
		int En_dmg = (En_str + En_atk - shd);
		int[] En_dmgList = { En_dmg - 5, En_dmg - 4, En_dmg - 3, En_dmg - 2, En_dmg - 1, En_dmg, En_dmg + 1, En_dmg + 2,
				En_dmg + 3, En_dmg + 4, En_dmg + 5 };
		int En_dmgDev = rd.nextInt(10);
		int En_dmgR = En_dmgList[En_dmgDev];
		int basePro = 50;
		int En_EsPro = basePro + (En_spd - spd);
		int En_HitPro = (basePro + 20) + (En_spd - spd);
		int En_CriPro = (basePro - 40) + (En_luk - luk);
		
		System.out.println("적탈출확률" + En_EsPro);
		System.out.println("적명중률" + En_HitPro);
		System.out.println("적치명율" + En_CriPro);
		
		if (WeightsPro(En_HitPro)) {
			if (WeightsPro(En_CriPro)) {
				En_dmgR = En_atk;
				fc.Face_Cri(id);
				System.out.println(En_name + "의 치명적인 공격! " + st.getNick() + "은(는)" + En_dmgR + "의 데미지를 받았다!");
				System.out.println("");
				if (shd >= En_atk) {
					En_dmgR = 0;
				}
				hp -= En_dmgR;
			} else {
				if (En_dmgR < 0) {
					En_dmgR = 0;
				}
				fc.Face_Fight(id);
				System.out.println(En_name + "의 공격! " + st.getNick() + "은(는)" + En_dmgR + "의 데미지를 받았다!");
				System.out.println("");
				if (shd >= En_dmgR) {
					En_dmgR = 0;
				} else {
					hp -= En_dmgR;
				}
			}

		} else {
			fc.Face_Miss(id);
			System.out.println(st.getNick() + "의 재빠른 회피! " + En_name + "은(는) 어떠한 피해도 입히지 못했다!");
			System.out.println("");
		}

	}

	// 변수 점검용 메소드
	public void checkUserValues() {
		System.out.println("레벨" + lv);
		System.out.println("경험치" + expe);
		System.out.println("체력" + hp);
		System.out.println("에너지" + ene);
		System.out.println("최대체력" + maxhp);
		System.out.println("최대에너지" + maxene);
		System.out.println("공격력" + atk);
		System.out.println("속도" + spd);
		System.out.println("음식" + food);
		System.out.println("약초" + hurbs);
		System.out.println("방어력" + shd);
		System.out.println("힘" + str);
		System.out.println("민" + dex);
		System.out.println("지" + wis);
		System.out.println("운" + luk);
		System.out.println("탈출확률" + user_EsPro);
		System.out.println("치명율" + user_CriPro);
		System.out.println("명중률" + user_HitPro);
	}

	public void checkEnValues() {
		System.out.println("적체력" + En_hp);
		System.out.println("적공격력" + En_atk);
		System.out.println("적속도" + En_spd);
		System.out.println("적방어력" + En_def);
		System.out.println("적힘" + En_str);
		System.out.println("적민" + En_dex);
		System.out.println("적지" + En_wis);
		System.out.println("적운" + En_luk);
		System.out.println("적탈출확률" + En_EsPro);
		System.out.println("적명중률" + En_HitPro);
		System.out.println("적치명율" + En_CriPro);
	}
}


