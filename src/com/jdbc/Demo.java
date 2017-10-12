package com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) throws Exception {
		Connection conn = DB.getConn(); //获取连接
		//String sql = "INSERT INTO student values(null,'10004','jdbc','男','18')";
		//st.executeUpdate(sql);
		Statement st = DB.getStat(conn);
		
		//批量执行插入,生成数据后注释
		
		//学生表
		st.addBatch("INSERT INTO student values(null,'10001','张三','男','18'),(null,'10002','李四','男','18'),(null,'10003','王五','男','18')");
		//课程表
		st.addBatch("INSERT INTO course values(null,'001','高数','lisa'),(null,'002','毛概','fona'),(null,'003','计算机','hh')");
		//选课表
		st.addBatch("INSERT INTO s_course values(null,'高数','10001'),(null,'高数','10002'),(null,'毛概','10001'),(null,'毛概','10003'),(null,'计算机','10002'),(null,'计算机','10003')");
		st.executeBatch();
		
		
		
		//执行查询
		//String sql = "select couName from s_course where stuNo = '10001'";
		String sql = "SELECT * FROM student s,s_course sc,course c WHERE s.stuNo = sc.stuNo AND sc.couName = c.couName AND s.stuNo = '10001';";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			String stuNo = rs.getString("stuNo");      //取得学号
			String stuName = rs.getString("stuName");  //取得姓名
			String couNo = rs.getString("couNo");      //取得课程号
			String couName = rs.getString("couName");  //取得课程名
			
			System.out.print(stuNo+" ");
			System.out.print(stuName+" ");
			System.out.print(couNo+" ");
			System.out.print(couName+" ");
			System.out.println();
		}
		
		st.close();
		conn.close();
		
	}
}
