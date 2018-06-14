package COM.SDS.SERVICE;

import java.sql.Connection;
import java.util.ArrayList;

import COM.SDS.DAO.CustomerDao;
import COM.SDS.DAO.ItemDao;
import COM.SDS.FRAME.Dao;
import COM.SDS.FRAME.Service;
import COM.SDS.VO.CustomerVO;
import COM.SDS.VO.ItemVO;

public class CustomerService 
extends Service<String, CustomerVO> {
	
	
	Dao<String,CustomerVO> cDao;
	Dao<String,ItemVO> iDao;
	
	public CustomerService() {
		cDao = new CustomerDao();
		iDao = new ItemDao();

	}
	

	@Override
	public void register(CustomerVO v) throws Exception {
		// 고객 정보가 들어오면
		// 고객 정보에 아이템을 세팅하고
		//Dao를 통해 저장 요청을 한다.
		//입력을 하다가 오류가 나면 어플리케이션에 다시 되돌린다.
		ItemVO item = new ItemVO(v.getId(),"칼",1000);
		Connection con= getConn();
		try {
			cDao.insert(v, con);
			iDao.insert(item, con);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally
		{
			con.close();
		}		
	}

	@Override
	public void remove(String t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(CustomerVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomerVO get(String t) throws Exception {
		CustomerVO customer=null;	
		ItemVO item=null;
		Connection con= getConn();
		try {
			customer=cDao.select(t, con);
			customer.setItem(iDao.select(t, con));
		}catch(Exception e) {
			throw e;
		}finally
		{
			con.close();
		}		
		
		return customer;
	}

	@Override
	public ArrayList<CustomerVO> get() throws Exception {
		ArrayList<CustomerVO> customers=null;	
		Connection con= getConn();
		try {
			customers=cDao.select(con);
		}catch(Exception e) {
			throw e;
		}finally
		{
			con.close();
		}		
		
		return customers;
	}

}