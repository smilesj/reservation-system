package won.reservation.service;

import java.util.List;

import won.reservation.dto.CommentInfo;

public interface ReservationUserCommentService {
	public List<CommentInfo> readReservationUserComment(Integer productId);
	public Double getReservationUserCommentAvgScore(Integer productId);
}
