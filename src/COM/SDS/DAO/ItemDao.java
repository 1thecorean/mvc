package COM.SDS.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import COM.SDS.FRAME.Dao;
import COM.SDS.FRAME.SQL;
import COM.SDS.VO.ItemVO;

public class ItemDao extends Dao<String, ItemVO> {

	
	@Override
	public void insert(ItemVO v, Connection con) throws Exception {
		PreparedStatement pstmt = con.prepareStatement(SQL.insertItem);
		try {
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getName());
			pstmt.setDouble(3, v.getPrice());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			close(pstmt);
			
		}
	}

	@Override
	public void delete(String t, Connection con) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ItemVO v, Connection con) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemVO select(String t, Connection con) throws Exception {
		ItemVO item=null;
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		try {
			pstmt=con.prepareStatement(SQL.getCustomer);
			pstmt.setString(1, t);
			rset=pstmt.executeQuery();
			rset.next();
			item = new ItemVO();
				item.setId(rset.getString("ID"));
				item.setName(rset.getString("PWD"));
				item.setPrice(rset.getDouble("PRICE"));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		
		return item;
	}

	@Override
	public ArrayList<ItemVO> select(Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	//t에 ID가 들어가서 한사람이 가진 중복없는 아이템들을 반환.
	@Override
	public ArrayList<ItemVO> List(String t, Connection con) throws Exception {
		ArrayList<ItemVO> list=new ArrayList<>();
		ItemVO item=null;
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		try {
			pstmt=con.prepareStatement(SQL.ListOfItems);
			pstmt.setString(1, t);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				item = new ItemVO(rset.getString("ID"),rset.getString("NAME"),rset.getDouble("PRICE"));
				list.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		
		return list;
	}

	

}