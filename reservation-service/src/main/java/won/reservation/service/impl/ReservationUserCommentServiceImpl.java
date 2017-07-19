package won.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import won.reservation.dao.FileDao;
import won.reservation.dao.ReservationUserCommentDao;
import won.reservation.dto.CommentInfo;
import won.reservation.service.ReservationUserCommentService;

@Service
public class ReservationUserCommentServiceImpl implements ReservationUserCommentService {

	private ReservationUserCommentDao dao;
	private FileDao fileDao;
	
	@Autowired
	public ReservationUserCommentServiceImpl(ReservationUserCommentDao dao, FileDao fileDao) {
		this.dao = dao;
		this.fileDao = fileDao;
	}
	
	@Override
	public List<CommentInfo> get(Integer productId) {
		List<CommentInfo> list = dao.selectByProductId(productId);
		for(CommentInfo i : list) {
			if(i.getTempFileId() != null) {
				i.setCommentImg(fileDao.selectByReservationUserCommentId(i.getCommentId()));
			}
		}
		return list;
	}
	
	@Override
	public Double getAvgScore(Integer productId) {
		return dao.getAvgScore(productId);
	}
}
