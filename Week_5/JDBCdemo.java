package Week_5;

import java.sql.Connection;

import org.junit.Test;



public class JDBCdemo {
	/**
	 * ��ѯ����������
	 */
	@Test
	public void testSelect(){
		Connection  con = null;
		
		try {
			con = JDBCTool.getConnection();
			String sql = "SELECT id,name,age FROM Animal WHERE id=?";
			Animal animal = JDBCTool.select(con, Animal.class, sql, 0001);
			System.out.println(animal);//��ӡ����ѯ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTool.release(null, con, null);
		}
	}
/**
 * ���²���������
 */
	@Test
	public void testUpdate() {
		Connection con = null;
		
		try {
			con = JDBCTool.getConnection();
			String sql = "INSERT INTO animal(id,name,age) VALUES (?,?,?)";//�������
			String sql1 = "UPDATE animal SET age=4 WHERE id=?";//�޸Ĳ���
//			String sql2 = "DELETE FROM animal WHERE id=?";//ɾ����¼�Ĳ���
			JDBCTool.update(con, sql, 0001,"dog",3);
			JDBCTool.update(con, sql1,0001);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCTool.release(null, con, null);
		}
	}
}
