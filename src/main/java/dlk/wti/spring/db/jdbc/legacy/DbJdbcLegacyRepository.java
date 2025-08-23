package dlk.wti.spring.db.jdbc.legacy;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Repository
public class DbJdbcLegacyRepository {
	
	private DataSource dataSource;
	public DbJdbcLegacyRepository(DataSource dataSource) {this.dataSource = dataSource;}
	
	public List<DbCrudDTO> list() {
		
		try {
			Connection conn = DataSourceUtils.getConnection(dataSource);
			
    		String 	sql  = "SELECT idx        ";
    				sql += "     , title      ";
    				sql += "     , content    ";
    				sql += "     , username   ";
    				sql += "     , datetime   ";
    				sql += "     , hit        ";
    				sql += "  FROM post_board ";
    		
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            List<DbCrudDTO> list = new ArrayList<>();
            while (rs.next()) {
            	DbCrudDTO dbCrudDTO = new DbCrudDTO();
            	dbCrudDTO.setIdx      (rs.getString("idx"));
            	dbCrudDTO.setTitle    (rs.getString("title"));
            	dbCrudDTO.setContent  (rs.getString("content"));
            	dbCrudDTO.setUsername (rs.getString("username"));
            	dbCrudDTO.setDatetime (rs.getString("datetime"));
            	dbCrudDTO.setHit      (rs.getString("hit"));
                list.add(dbCrudDTO);
            }
			
            rs.close();
            ps.close();
            DataSourceUtils.releaseConnection(conn, dataSource);
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void create(DbCrudDTO dbCrudDTO) {
    	try {
            Connection conn = DataSourceUtils.getConnection(dataSource);
            
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        
            String 	sql  = "INSERT INTO post_board ";
            		sql += "  			(title, content, setUsername, datetime, hit) ";
            		sql += "     VALUES (    ?,       ?,           ?,        ?,   ?) ";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dbCrudDTO.getTitle());
            ps.setString(2, dbCrudDTO.getContent());
            ps.setString(3, dbCrudDTO.getUsername());
            ps.setString(4, now.format(formatter));
            ps.setString(5, "0");
            ps.executeUpdate();
            ps.close();
            DataSourceUtils.releaseConnection(conn, dataSource);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateHit(String idx) {
    	try {
            Connection conn = DataSourceUtils.getConnection(dataSource);
                        
            String 	sql  = "UPDATE post_board    ";
            		sql += "   SET hit = hit + 1 ";
            		sql += " WHERE idx = ? ";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idx);
            ps.executeUpdate();
            ps.close();
            DataSourceUtils.releaseConnection(conn, dataSource);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public DbCrudDTO read(String idx) {
    	DbCrudDTO dbCrudDTO = null;
        try {
            Connection conn = DataSourceUtils.getConnection(dataSource);
            String 	sql  = "SELECT idx        ";
            		sql += "     , title      ";
            		sql += "     , content    ";
            		sql += "     , username   ";
            		sql += "     , datetime   ";
            		sql += "     , hit        ";
            		sql += "  FROM post_board ";
            		sql += " WHERE idx = ?    ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idx);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	dbCrudDTO = new DbCrudDTO();
            	dbCrudDTO.setIdx(rs.getString("idx"));
            	dbCrudDTO.setTitle(rs.getString("title"));
            	dbCrudDTO.setContent(rs.getString("content"));
            	dbCrudDTO.setUsername(rs.getString("username"));
            	dbCrudDTO.setDatetime(rs.getString("datetime"));
            	dbCrudDTO.setHit(rs.getString("hit"));
            }

            rs.close();
            ps.close();
            DataSourceUtils.releaseConnection(conn, dataSource);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbCrudDTO;
    }
    
    public void update(DbCrudDTO dbCrudDTO) {
    	try {
            Connection conn = DataSourceUtils.getConnection(dataSource);
                                    
            String 	sql  = " UPDATE post_board   ";
            		sql += "    SET title    = ? ";
            		sql += "      , content  = ? ";
            		sql += "      , username = ? ";
            		sql += "  WHERE idx      = ? ";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dbCrudDTO.getTitle());
            ps.setString(2, dbCrudDTO.getContent());
            ps.setString(3, dbCrudDTO.getUsername());
            ps.setString(4, dbCrudDTO.getIdx());
            ps.executeUpdate();
            ps.close();
            DataSourceUtils.releaseConnection(conn, dataSource);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String idx) {
    	try {
            Connection conn = DataSourceUtils.getConnection(dataSource);
                                    
            String sql = "DELETE FROM post_board WHERE idx = ? ";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idx);
            ps.executeUpdate();
            ps.close();
            DataSourceUtils.releaseConnection(conn, dataSource);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}