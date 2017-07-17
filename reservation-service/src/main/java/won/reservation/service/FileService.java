package won.reservation.service;

import java.util.List;

import won.reservation.domain.File;

public interface FileService {
	public List<File> readProductImgList(Integer productId);
	public List<File> readByReservationUserCommentId(Integer reservationUserCommentId);
}
