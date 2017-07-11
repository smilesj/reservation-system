package won.reservation.domain;

public class ReservationUserCommentImage {
	private int id;
	private int reservationUserCommentId;
	private int fileId;
	
	public ReservationUserCommentImage() {
		
	}

	public ReservationUserCommentImage(int id, int reservationUserCommentId, int fileId) {
		this.id = id;
		this.reservationUserCommentId = reservationUserCommentId;
		this.fileId = fileId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReservationUserCommentId() {
		return reservationUserCommentId;
	}

	public void setReservationUserCommentId(int reservationUserCommentId) {
		this.reservationUserCommentId = reservationUserCommentId;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	@Override
	public String toString() {
		return "[ReservationUserCommentImage] id = " + id
				+", reservationUserCommentId = " + reservationUserCommentId
				+", fileId = " + fileId;
	}
}