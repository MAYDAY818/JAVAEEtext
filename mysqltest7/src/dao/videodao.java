package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.video;



public class videodao {
	public List<video> getVideos(){
		List<video> List = new ArrayList<video>();
		Connection conn = database.getConnection();
		PreparedStatement pstmt = null;
		String sql ="select * from video";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				video r1=new video(rs.getInt("id"),
						rs.getString("title"),
						rs.getString("info"),
						rs.getString("text"),
						rs.getString("uri"),
						rs.getString("img")
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
