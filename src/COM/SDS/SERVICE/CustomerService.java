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
	public void register(CustomerVO v, ItemVO i) throws Exception {
		// 고객 정보가 들어오면
		// 고객 정보에 아이템을 세팅하고
		//Dao를 통해 저장 요청을 한다.
		//입력을 하다가 오류가 나면 어플리케이션에 다시 되돌린다.
		Connection con= getConn();
		try {
			cDao.insert(v, con);
			iDao.insert(i, con);
			iDao.insert(new ItemVO("id01","길리수트",1000), con);
			iDao.insert(new ItemVO("id01","15배율스코프",1500), con);
			iDao.insert(new ItemVO("id01","프라이펜",700), con);
			iDao.insert(new ItemVO("id01","삼위일체",3200), con);
			cDao.insert(new CustomerVO("id02","pwd02","대도서관"), con);
			iDao.insert(new ItemVO("id02","마체테",400), con);
			iDao.insert(new ItemVO("id02","AWM",1800), con);
			iDao.insert(new ItemVO("id02","진통제",200), con);
			iDao.insert(new ItemVO("id02","삼토바이",3000), con);
			iDao.insert(new ItemVO("id02","오라클",500), con);
			
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
		
	}

	@Override
	public void modify(CustomerVO v) throws Exception {
		
	}

	@Override
	public CustomerVO get(String t) throws Exception {
		CustomerVO customer=null;	
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
	
	@Override
	public ArrayList<ItemVO> getItem(String t) throws Exception {
		ArrayList<ItemVO> items=null;	
		Connection con= getConn();
		try {
			items=iDao.List(t, con);
		}catch(Exception e) {
			throw e;
		}finally
		{
			con.close();
		}		
		
		return items;
	}
	
	@Override
	public ArrayList<CustomerVO> getCustomer(String t) throws Exception {
		ArrayList<CustomerVO> customers=null;	
		Connection con= getConn();
		try {
			customers=cDao.List(t, con);
		}catch(Exception e) {
			throw e;
		}finally
		{
			con.close();
		}		
		
		return customers;
	}


	

}