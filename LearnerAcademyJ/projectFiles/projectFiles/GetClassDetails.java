package projectFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetClassDetails {
	
	private DBConnection conn;
	private Connection dbCon;
	private PreparedStatement stmt;
	private String qry;
	private ResultSet rs;
	
	public GetClassDetails() {
		
		try {
			this.conn = new DBConnection();
			this.dbCon = conn.getConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found exception");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL not found exception");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public ResultSet getClassId() {
		
		try {
			this.qry = "Select * from classinfo";
			
			this.stmt = dbCon.prepareStatement(qry);
			
			this.rs = stmt.executeQuery();
			
			return(rs);
		
		}
		catch (SQLException e) {
			System.out.println("SQL not found exception");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return(rs);
	}
	
	public ResultSet getClassInfo(int id){
		
		try {
			
		if(id == 0) {
			this.qry = "SELECT cl.class_id, cl.class_name, st.stu_id,st.stu_name, t.teacher_name, sb.sub_name \r\n"
					+ "FROM classinfo cl, studentinfo st, class_sub_teacher cst, teacherinfo t, subjectinfo sb \r\n"
					+ "where cl.class_id = cst.class_id \r\n"
					+ "and cst.sub_id = sb.sub_id \r\n"
					+ "and cst.teacher_id = t.teacher_id \r\n"
					+ "and cl.class_id = st.class_id;\r\n";
			
			this.stmt = dbCon.prepareStatement(qry);
			
			this.rs = stmt.executeQuery();
			return(rs);
			
		}
		else {
			//Query
			this.qry = "SELECT cl.class_id, cl.class_name, st.stu_id,st.stu_name, t.teacher_name, sb.sub_name \r\n"
					+ "FROM classinfo cl, studentinfo st, class_sub_teacher cst, teacherinfo t, subjectinfo sb \r\n"
					+ "where cl.class_id = ? \r\n"
					+ "and cl.class_id = cst.class_id \r\n"
					+ "and cst.sub_id = sb.sub_id \r\n"
					+ "and cst.teacher_id = t.teacher_id \r\n"
					+ "and cst.class_id = st.class_id";
			
			//Prepared Statement
			this.stmt = dbCon.prepareStatement(qry);
			
			
			// Set the parameters got from the app
	        stmt.setInt(1, id);
	
	        this.rs =  stmt.executeQuery();
	        
	        return(rs);
		}
		}catch (SQLException e) {
			System.out.println("SQL not found exception");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return(rs);
		
	}
	
	public static void main(String[] args) {
		
//		GetClassDetails obj = new GetClassDetails();
//		ResultSet rs = obj.getClassId();
//		try {
//			while(rs.next()) {
//				int id = rs.getInt(1);
//				System.out.println("Value : "+id);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
