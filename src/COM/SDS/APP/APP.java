package COM.SDS.APP;

import COM.SDS.FRAME.Service;
import COM.SDS.SERVICE.CustomerService;
import COM.SDS.VO.CustomerVO;

public class APP {

	public static void main(String[] args) {
		
		Service<String, CustomerVO> service = new CustomerService();
		CustomerVO customer = new CustomerVO("id11","pwd11","종말숙");
		try {
			service.register(customer);
			System.out.println("입력 정상");
		} catch (Exception e) {
			System.out.println("입력 실패");
			e.printStackTrace();
		}
		

	}

}
















