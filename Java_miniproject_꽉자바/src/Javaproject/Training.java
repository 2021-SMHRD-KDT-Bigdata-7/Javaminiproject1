package Javaproject;


//�Ʒ��� �ϴ� Ŭ�����Դϴ�.
public class Training {

int result = 0;
	
	DAMADAO ddao = new DAMADAO();
	
	public int threeT (String id) {
			ddao.getConn();
			try {
				String sql = "update dama_info set expe = expe + 1, atk= atk + 1, ene = ene - 10, startday = startday + 1 where id = ?";
				
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
	
	public int shield (String id) {
		ddao.getConn();
		try {
			String sql = "update dama_info set expe = expe + 1, def = def + 1, ene = ene - 10, startday = startday + 1 where id = ?";
			
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
	
	public int run (String id) {
		ddao.getConn();
		try {
			String sql = "update dama_info set expe = expe + 1, spd = spd + 1, ene = ene - 10, startday = startday + 1 where id = ?";
			
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
