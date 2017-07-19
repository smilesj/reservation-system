package won.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import won.reservation.dao.CategoryDao;
import won.reservation.domain.Category;
import won.reservation.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao;
	
	@Autowired
	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	@Override
	public List<Category> get() {
		return categoryDao.select();
	}
	
	@Override
	@Transactional(readOnly = true)	
	public Category get(int id) {
		return categoryDao.selectById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int add(String name) {
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
