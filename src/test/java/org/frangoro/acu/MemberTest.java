package org.frangoro.acu;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.frangoro.acu.model.MemberEntity;
import org.frangoro.acu.service.MemberServiceImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MemberTest {
	
	final Logger logger = LoggerFactory.getLogger(MemberTest.class);
	
	@Autowired
	private MemberServiceImpl service;
	@Autowired
	private MemberEntity member;
	
	@Test
	public void testGetAllMembers() {
		List<MemberEntity> members = service.getAllMembers();
		assertNotNull("getAllMembers is null.", members);
		logger.info("Number of members: " + members.size());
	}
	
	@Ignore
	@Test
	//TODO: Transactional
	public void testAddMember() {
		service.addMember(member);
	}
}
