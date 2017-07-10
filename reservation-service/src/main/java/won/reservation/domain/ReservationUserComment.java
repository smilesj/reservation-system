package won.reservation.domain;

import java.sql.Timestamp;

public class ReservationUserComment {
	private int id;
	private int productId;
	private int userId;
	private Double score;
	private String comment;
	private Timestamp createDate;
	private Timestamp modifyDate;
	
	public ReservationUserComment() {
		
	}

	public ReservationUserComment(int id, int productId, int userId, Double score, 
			String comment, Timestamp createDate, Timestamp modifyDate) {
		this.id = id;
		this.productId = productId;
		this.userId = userId;
		this.score = score;
		this.comment = comment;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	
	@Override
	public String toString() {		
		return 	"[ReservationUserComment] id = " + id
				+", productId = " + productId
				+", userId = " + userId
				+", score = " + score
				+", comment = " +comment
				+", createDate = " + createDate
				+", modifyDate = " + modifyDate;
	}
}
