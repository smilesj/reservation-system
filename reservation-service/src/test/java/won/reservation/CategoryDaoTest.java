package won.reservation;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import won.reservation.config.RootApplicationContextConfig;
import won.reservation.dao.CategoryDao;
import won.reservation.domain.Category;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class CategoryDaoTest {

	@Autowired
	CategoryDao categoryDao;
	
	@Test
	public void shouldSelect() {
		List<Category> list = categoryDao.select();
		assertNotNull(list);
	}
	
	@Test
	public void shouldUpdate() {
		// given
		String categoryName = "일번카테고리";
		int categoryPk = categoryDao.insert(categoryName);
	
		// when
		Category updateCategory = categoryDao.selectById(categoryPk);
		updateCategory.setName("수정카테고리");	
		categoryDao.update(updateCategory);
		
		// then
		Category result = categoryDao.selectById(categoryPk);
		assertThat(result.getId(), is(categoryPk));
		assertThat(result.getName(), is("수정카테고리"));
		
	}
	
	@Test
	public void shouldDelete() {
		// given
		String categoryName = "일번카테고리";
		int categoryPk = categoryDao.insert(categoryName);
		
		// when
		int delete = categoryDao.delete(categoryPk);
				
		// then
		assertThat(delete, is(1));		
	}

}
