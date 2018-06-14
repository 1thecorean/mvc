package COM.SDS.FRAME;

public class SQL {
	//SQL은 JAVACODE와 구분하기 위해서 대문자로 쓰는게 통상적
	public static String insertCustomer = 
			"INSERT INTO CUSTOMER VALUES (?,?,?)";
	public static String insertItem = 
			"INSERT INTO CUSTOMERITEM VALUES (?,?,?)";
	public static String deleteCustomer = 
			"DELETE FROM CUSTOMER WHERE ID=?";
	public static String updateCustomer = 
			"UPDATE CUSTOMER SET PWD=?, NAME=?  WHERE ID=?";	
	public static String getCustomer = 
			"SELECT * FROM CUSTOMER WHERE ID=?";
	public static String getCustomerItem = 
			"SELECT * FROM CUSTOMERITEM WHERE ID=?";
	public static String selectAll=
			"SELECT c.ID, c.PWD, c.NAME, ci.NAME as ITEM, "
			+ "ci.PRICE FROM CUSTOMER c, "
			+ "CUSTOMERITEM ci "
			+ "WHERE c.ID=ci.ID";
	

}
