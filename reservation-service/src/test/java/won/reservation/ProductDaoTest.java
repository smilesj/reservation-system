package won.reservation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import won.reservation.config.RootApplicationContextConfig;
import won.reservation.dao.ProductDao;
import won.reservation.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class ProductDaoTest {

	@Autowired
	ProductDao dao;
	
	@Test
	public void shouldTest() {
		List<Product> list = dao.select();
		assertNotNull(list);
	}
	
	@Test
	public void shouldGetCount() {
		// given
		int categoryId = 1;
		
		// when
		int result = dao.getCount(categoryId);
				
		// then
		assertThat(result, is(2));	
		
		assertThat(dao.getCount(null), is(12));
	}

}
