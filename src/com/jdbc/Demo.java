package com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) throws Exception {
		Connection conn = DB.getConn(); //��ȡ����
		//String sql = "INSERT INTO student values(null,'10004','jdbc','��','18')";
		//st.executeUpdate(sql);
		Statement st = DB.getStat(conn);
		
		//����ִ�в���,�������ݺ�ע��
		
		//ѧ����
		st.addBatch("INSERT INTO student values(null,'10001','����','��','18'),(null,'10002','����','��','18'),(null,'10003','����','��','18')");
		//�γ̱�
		st.addBatch("INSERT INTO course values(null,'001','����','lisa'),(null,'002','ë��','fona'),(null,'003','�����','hh')");
		//ѡ�α�
		st.addBatch("INSERT INTO s_course values(null,'����','10001'),(null,'����','10002'),(null,'ë��','10001'),(null,'ë��','10003'),(null,'�����','10002'),(null,'�����','10003')");
		st.executeBatch();
		
		
		
		//ִ�в�ѯ
		//String sql = "select couName from s_course where stuNo = '10001'";
		String sql = "SELECT * FROM student s,s_course sc,course c WHERE s.stuNo = sc.stuNo AND sc.couName = c.couName AND s.stuNo = '10001';";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			String stuNo = rs.getString("stuNo");      //ȡ��ѧ��
			String stuName = rs.getString("stuName");  //ȡ������
			String couNo = rs.getString("couNo");      //ȡ�ÿγ̺�
			String couName = rs.getString("couName");  //ȡ�ÿγ���
			
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
