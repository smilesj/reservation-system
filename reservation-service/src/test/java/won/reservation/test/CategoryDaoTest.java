package won.reservation.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import won.reservation.dao.CategoryDao;
import won.reservation.domain.Category;

public class CategoryDaoTest {

	@Autowired
	CategoryDao categoryDao;
	
	@Test
	public void testSelect() {
		List<Category> list = categoryDao.select();
		assertNotNull(list);
	}

}
