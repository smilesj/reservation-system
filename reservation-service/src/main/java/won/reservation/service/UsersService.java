package won.reservation.service;

import won.reservation.domain.Users;

public interface UsersService {
	public Users get(String snsId, String snsType);
	public int add(Users user);
}
