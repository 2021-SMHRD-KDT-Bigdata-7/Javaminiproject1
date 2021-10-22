package Javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAMADAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int result;
	String sql;

	// �����ͺ��̽��� �����ϴ� �޼ҵ� getConn()

	// �����ͺ��̽��� ������� �޼ҵ� endClose()

	// ȸ������ �޼ҵ�

	// insert insert()

	// select select()

	// update update()

	// delete delete()

	public void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "cgi_2_3_1022";
			String password = "smhrd3";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) { // ��� ������ �߻��� ĳġ���ִ� ��Ȱ
			System.out.println("���� ����");
			e.printStackTrace();
		}
	}
 
	public void endClose() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void table1() {
		getConn();

		sql = "CREATE TABLE USER_INFO (USER_ID varchar2(10),PASSWORD varchar2(10) NOT NULL,CONSTRAINT INFO_PK PRIMARY KEY (USER_ID))";
		try {
			conn.createStatement();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			endClose();
		}
	}

	public void table2() {
		getConn();
		sql = "CREATE TABLE DAMA_INFO (USER_ID VARCHAR2(10), NICK VARCHAR2(10), EXPER NUMBER(5), LV NUMBER(5), ENERGY NUMBER(5),MAXENERGY NUMBER(5),FOOD NUMBER(5), HERBS NUMBER(5), STARTDAY NUMBER(5), SICKDAY NUMBER(5),CONSTRAINT DAMA_FK FOREIGN KEY(USER_ID) REFERENCES USER_INFO(USER_ID))";
		try {
			conn.createStatement();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			endClose();
		}
	}
	public void table3() {
		getConn();
		sql = "CREATE TABLE BATTLE_INFO (USER_ID VARCHAR2(10), HP NUMBER(5),MAXHP NUMBER(5),ATK NUMBER(5),SHD NUMBER(5),SPD NUMBER(5),STR NUMBER(5),DEX NUMBER(5),WIS NUMBER(5),LUK NUMBER(5),DUMMI NUMBER(5), CONSTRAINT BATTLE_FK FOREIGN KEY(USER_ID) REFERENCES USER_INFO(USER_ID))";
		try {
			conn.createStatement();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			endClose();
		}
	}

	
	public int join(String Id, String Pw) {
		int i=0;
		getConn();
		try {
			String sql = "insert into user_info values(?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Id);
			psmt.setString(2, Pw);
			int up=psmt.executeUpdate();// ������Ʈ �ټ�
			if (up>0) {
				i=5;
				System.out.println("ȸ������ ����");
			}else {
				System.out.println("ȸ������ ����");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			endClose();
		}
		return i;
	}
	public void joinStators1(String Id, String Nick) {
		getConn();
		try {
			String sql = "insert into DAMA_INFO values(?,?,1,1,100,100,5,1,1,1,1)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Id);
			psmt.setString(2, Nick);
			psmt.executeUpdate();// ������Ʈ �ټ�
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			endClose();
		}
	}
	
	public void joinStators2(String Id) {
		getConn();
		try {
			String sql = "insert into BATTLE_INFO values(?,100,100,10,10,10,10,10,10,30,0)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Id);
			psmt.executeUpdate();// ������Ʈ �ټ�
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			endClose();
		}
	}

	public void select() {
		getConn();
		String sql = "select * from user_info";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String getId = rs.getString(1);
				String getPw = rs.getString(2);
				System.out.println("���̵� : " + getId + " ��й�ȣ : " + getPw);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			endClose();
		}
	}
	
	public void ranksys() {
		getConn();
		int i=0;
		String sql = "select * from dama_info order by Lv,Exper,STARTDAY";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				i++;
				String getID = rs.getString(1);
				String getnick = rs.getString(2);
				int getLv = rs.getInt(4);
				int getExpe = rs.getInt(3);
				int getturn = rs.getInt(9);
				System.out.println(i+"��  ���̵� : "+getID + "\t�г��� : "+getnick+"\t���� : "+getLv+"\t����ġ : "+ getExpe +"\t�ϼ� : "+getturn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			endClose();
		}
	}
	
	public DAMAVO dama_loding(String id) {
		DAMAVO dm = new DAMAVO();
		getConn();
		String sql = "select * from DAMA_INFO where user_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				String getId = rs.getString(1);
				String getNick = rs.getString(2);
				int getExper = rs.getInt(3);
				int getLv = rs.getInt(4);
				int getEne = rs.getInt(5);
				int getMaxene = rs.getInt(6);
				int getFood = rs.getInt(7);
				int getHerbs = rs.getInt(8);
				int getStart = rs.getInt(9);
				int getSick = rs.getInt(10);
				int getjobid = rs.getInt(11);
				
				dm = new DAMAVO(getId, getNick, getExper, getLv, getEne, getMaxene, getFood, getHerbs, getStart, getSick, getjobid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			endClose();
		}
		return dm;
	}
	public DAMAVO battle_loding(String id) {
		DAMAVO dm = new DAMAVO();
		getConn();
		String sql = "select * from BATTLE_INFO where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				String getId = rs.getString(1);
				int gethp = rs.getInt(2);
				int getmaxhp = rs.getInt(3);
				int getatk = rs.getInt(4);
				int getshd = rs.getInt(5);
				int getspd = rs.getInt(6);
				int getstr = rs.getInt(7);
				int getdex = rs.getInt(8);
				int getwis = rs.getInt(9);
				int getluk = rs.getInt(10);
				int getdummi = rs.getInt(11);
				
				dm = new DAMAVO(getId, gethp, getmaxhp, getatk, getshd, getspd, getstr, getdex, getwis, getluk, getdummi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			endClose();
		}
		return dm;
	}

	public int login(String Id, String Pw) {
		getConn();
		int i = 0;
		String sql = "select * from user_info where USER_ID = ? and password = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Id);
			psmt.setString(2, Pw);
			rs = psmt.executeQuery();
			if (rs.next()) {
				i = 5;
			} else {
				i = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			endClose();
		}
		return i;
	}
	
	public int battle_update(String id,int hp, int maxhp, int atk, int shd, int spd,int str,int dex,int wis,int luk,int dummi) {        
        getConn();           
        String sql = "update BATTLE_INFO set (USER_ID=?,HP=?,MAXHP=?,ATK=?,SHD=?,SPD=?,STR=?,DEX=?,WIS=?,LUK=?,DUMMI=?) where ID=?";;
        try {
           psmt = conn.prepareStatement(sql);
           psmt.setString(1, id);
           psmt.setInt(2, hp);
           psmt.setInt(3, maxhp);
           psmt.setInt(4, atk);
           psmt.setInt(5, shd);
           psmt.setInt(6, spd);
           psmt.setInt(7, str);
           psmt.setInt(8, dex);
           psmt.setInt(9, wis);
           psmt.setInt(10, luk);
           psmt.setInt(11, dummi);
           psmt.setString(12, id);
           result = psmt.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
           endClose();
        }    
        return result;
     }
	public int dama_update(String id,String nick, int exper,int lv, int energy, int maxenergy,int food, int herbs,int startday,int sick,int jobid) {        
        getConn();           
        String sql = "UPDATE DAMA_INFO SET USER_ID=?,NICK=?,EXPER=?,LV=?,ENERGY=?,MAXENERGY=?,FOOD=?,HERBS=?,STARTDAY=?,SICK=?,JOBid=? where ID=?";
        try {
           psmt = conn.prepareStatement(sql);
           psmt.setString(1, id);
           psmt.setString(2, nick);
           psmt.setInt(3, exper);
           psmt.setInt(4, lv);
           psmt.setInt(5, energy);
           psmt.setInt(6, maxenergy);
           psmt.setInt(7, food);
           psmt.setInt(8, herbs);
           psmt.setInt(9, startday);
           psmt.setInt(10,sick);
           psmt.setInt(11,jobid);
           psmt.setString(12, id);
           result = psmt.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
           endClose();
        }    
        return result;
     }
	
	
	
		
}
