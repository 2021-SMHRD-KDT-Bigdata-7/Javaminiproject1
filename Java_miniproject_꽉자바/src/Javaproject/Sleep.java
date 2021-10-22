package Javaproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sleep {
	
	int result = 0;
	
	DAMADAO ddao = new DAMADAO();
	
	public int sleep(String id) {
			ddao.getConn();
			try {
				// ������ �÷��� �Ѱ� �̻��� ��� set �÷�1 = ?, �÷�2 = ?, ...
				String sql = "update dama_info set hp = 100, ene = 100 where id = ?";
				
				ddao.psmt = ddao.conn.prepareStatement(sql);
				ddao.psmt.setString(1, id);
				
				result = ddao.psmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				ddao.endClose();
			}
			return result;
		}
	
}
