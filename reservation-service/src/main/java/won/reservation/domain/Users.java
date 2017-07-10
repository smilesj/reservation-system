package won.reservation.domain;

import java.sql.Timestamp;

public class Users {
	private int id;
	private String username;
	private String email;
	private String tel;
	private String nickname;
	private String snsId;
	private String snsType;
	private String snsProfile;
	private String adminFlag;
	private Timestamp createDate;
	private Timestamp modifyDate;
	
	public Users() {
		
	}

	public Users(int id, String username, String email, String tel, String nickname, String snsId, String snsType,
			String snsProfile, String adminFlag, Timestamp createDate, Timestamp modifyDate) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.tel = tel;
		this.nickname = nickname;
		this.snsId = snsId;
		this.snsType = snsType;
		this.snsProfile = snsProfile;
		this.adminFlag = adminFlag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSnsId() {
		return snsId;
	}

	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}

	public String getSnsType() {
		return snsType;
	}

	public void setSnsType(String snsType) {
		this.snsType = snsType;
	}

	public String getSnsProfile() {
		return snsProfile;
	}

	public void setSnsProfile(String snsProfile) {
		this.snsProfile = snsProfile;
	}

	public String getAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(String adminFlag) {
		this.adminFlag = adminFlag;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "[USERS] id = "+id+" ,username = " + username +" ,email = " + email +" ,tel = "+tel
				+" ,nickname = " + nickname +" ,snsId = " + snsId +" ,snsType = " + snsType +" ,snsProfile = " + snsProfile
				+" ,adminFlag = " + adminFlag +" , createDate = "+ createDate + " , modifyDate = "+ modifyDate;
	}
	
}
