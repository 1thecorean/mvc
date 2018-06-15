package COM.SDS.FRAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import COM.SDS.VO.CustomerVO;
import COM.SDS.VO.ItemVO;

public abstract class Service<T,V> {
	
	private String id="db";
	private String password="db";
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";

	public Service() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConn() throws SQLException{
		Connection con=null;
		con=DriverManager.getConnection(url, id, password);
		con.setAutoCommit(false);
		return con;
	}
	
	
	public void close(Connection con) throws SQLException {
		if(con!=null) {
			con.close();
		}
	}
	public abstract void register(CustomerVO v, ItemVO i) throws Exception ;
	public abstract void remove(T t) throws Exception;
	public abstract void modify(V v) throws Exception;
	public abstract V get(T t) throws Exception;//1개조회
	public abstract ArrayList<V> get() throws Exception;//2개조회
	public abstract ArrayList<ItemVO> getItem(String t) throws Exception;
	public abstract ArrayList<CustomerVO> getCustomer(String t) throws Exception;



}
