package won.reservation.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import won.reservation.dao.DisplayInfoDao;
import won.reservation.domain.DisplayInfo;
import won.reservation.service.DisplayInfoService;

@Service
public class DisplayInfoServiceImple implements DisplayInfoService {

	private DisplayInfoDao dao;
	
	@Autowired
	public DisplayInfoServiceImple(DisplayInfoDao dao) {
		this.dao  = dao;
	}
	
	@Override
	public DisplayInfo readDetailInfo(Integer productId) {
		return dao.select(productId);
	}
	
}
