package COM.SDS.APP;

import java.util.ArrayList;

import COM.SDS.FRAME.Service;
import COM.SDS.SERVICE.CustomerService;
import COM.SDS.VO.CustomerVO;

public class SelectAllTest {

	public static void main(String[] args) {

		Service<String,CustomerVO> service = new CustomerService();
		
		ArrayList<CustomerVO> list= null;
		try {
			list=service.get();
			for(CustomerVO c:list) {
				System.out.println(c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
