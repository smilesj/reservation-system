package won.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import won.reservation.dao.CategoryDao;
import won.reservation.domain.Category;

@Service
public class CategoryServiceImple implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public List<Category> readCategory() {
		return categoryDao.select();
	}
	
	@Override
	@Transactional(readOnly = true)	
	public Category readCategoryById(int id) {
		return categoryDao.selectById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int addCategory(String name) {
		return categoryDao.insert(name);
	}

	@Override
	public int update(Category category) {
		return categoryDao.update(category);
	}

	@Override
	public int delete(int id) {
		return categoryDao.delete(id);
	}
	
}
