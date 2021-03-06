package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.news;
import bean.radio;

public class radiodao {
	public List<radio> getSomeRadios(int fromIndex,int count){
		List<radio> List = new ArrayList<radio>();
		Connection conn = database.getConnection();
		PreparedStatement pstmt = null;
		String sql ="select * from radios limit ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fromIndex);
			pstmt.setInt(2, count);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				radio r1=new radio(rs.getInt("id"),
						rs.getString("title"),
						rs.getString("info"),
						rs.getString("date"),
						rs.getString("img"),
						rs.getString("uri")
						); 
				
				List.add(r1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return List;
		
	}


}
