package COM.SDS.APP;

import COM.SDS.FRAME.Service;
import COM.SDS.SERVICE.CustomerService;
import COM.SDS.VO.CustomerVO;

public class SelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Service<String, CustomerVO> service = new CustomerService();
		CustomerVO getcustomer = null;
		
		try {
			getcustomer=service.get("id02");
			System.out.println(getcustomer);
			//예외, DB가 죽었을때, id가 잘못되었을때.
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("조회 실패");
		}

	}

}
