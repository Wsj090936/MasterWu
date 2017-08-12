package Week_5;

import java.sql.Connection;

import org.junit.Test;



public class JDBCdemo {
	/**
	 * 查询操作的例子
	 */
	@Test
	public void testSelect(){
		Connection  con = null;
		
		try {
			con = JDBCTool.getConnection();
			String sql = "SELECT id,name,age FROM Animal WHERE id=?";
			Animal animal = JDBCTool.select(con, Animal.class, sql, 0001);
			System.out.println(animal);//打印出查询结果
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTool.release(null, con, null);
		}
	}
/**
 * 更新操作的例子
 */
	@Test
	public void testUpdate() {
		Connection con = null;
		
		try {
			con = JDBCTool.getConnection();
			String sql = "INSERT INTO animal(id,name,age) VALUES (?,?,?)";//插入操作
			String sql1 = "UPDATE animal SET age=4 WHERE id=?";//修改操作
//			String sql2 = "DELETE FROM animal WHERE id=?";//删除记录的操作
			JDBCTool.update(con, sql, 0001,"dog",3);
			JDBCTool.update(con, sql1,0001);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCTool.release(null, con, null);
		}
	}
}
