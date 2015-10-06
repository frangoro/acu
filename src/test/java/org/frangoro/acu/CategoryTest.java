package org.frangoro.acu;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.frangoro.acu.model.CategoryEntity;
import org.frangoro.acu.service.MemberServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"MemberTest-context.xml"})
public class CategoryTest {
	
	final Logger logger = LoggerFactory.getLogger(CategoryTest.class);
	
	@Autowired
	private MemberServiceImpl service;
	
	@Test
	public void testGetAllCategories() {
		List<CategoryEntity> categories = service.getAllCategories();
		assertNotNull("getAllCategories is null.", categories);
		logger.info("Number of categories: " + categories.size());
	}
	
}
