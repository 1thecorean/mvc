package COM.SDS.FRAME;

public class SQL {
	
	
	public static String insertCustomer = 
			"INSERT INTO TB_USER VALUES (?,?,?)";
	public static String insertItem = 
			"INSERT INTO TB_ITEM VALUES (?,?,?)";
	public static String deleteCustomer = 
			"DELETE FROM TB_USER WHERE ID=?";
	public static String updateCustomer = 
			"UPDATE TB_USER SET PWD=?, NAME=?  WHERE ID=?";	
	public static String getCustomer = 
			"SELECT c.ID, c.PWD, c.NAME, ci.NAME as ITEM, "
					+ "ci.PRICE FROM TB_USER c, "
					+ "TB_ITEM ci "
					+ "WHERE ci.ID=?";
	public static String selectAll=
			"SELECT c.ID, c.PWD, c.NAME, ci.NAME as ITEM, "
			+ "ci.PRICE FROM TB_USER c, "
			+ "TB_ITEM ci "
			+ "WHERE c.ID=ci.ID";
	
	
	
	// 특정 아이템을 가지고 있는 사람 리스트
	public static String ListOfPeople="SELECT u.id, u.name, u.pwd"
			+ " FROM TB_USER u, TB_ITEM i "
			+ " WHERE i.name = ? and u.id = i.id";
	
	// 한 사람이 가지고 있는 Items
	public static String ListOfItems="SELECT i.id, i.name,i.price"
			+ " FROM TB_USER u, TB_ITEM i "
			+ " WHERE i.id = ? and u.id = i.id";

	

}
