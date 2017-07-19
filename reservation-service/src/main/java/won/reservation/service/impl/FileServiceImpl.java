package won.reservation.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import won.reservation.dao.FileDao;
import won.reservation.domain.File;
import won.reservation.service.FileService;

@Service
public class FileServiceImple implements FileService {

	private FileDao dao;
	
	@Autowired
	public FileServiceImple(FileDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<File> readProductImgList(Integer productId) {
		return dao.selectByProductId(productId);
	}
	
	@Override
	public List<File> readProductDetailImgList(Integer productId) {
		return dao.selectDetailByProductId(productId);
	}
	
	@Override
	public List<File> readByReservationUserCommentId(Integer reservationUserCommentId) {
		return dao.selectByReservationUserCommentId(reservationUserCommentId);
	}
	
	@Override
	public String read(Integer fileId) {
		return dao.selectById(fileId);
	}
}
