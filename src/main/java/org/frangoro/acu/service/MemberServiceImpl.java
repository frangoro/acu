package org.frangoro.acu.service;

import java.util.List;

import org.frangoro.acu.dao.MemberDAO;
import org.frangoro.acu.model.CategoryEntity;
import org.frangoro.acu.model.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO dao;
	
	@Override
	public List<MemberEntity> getAllMembers() {
		return dao.getAllMembers();
	}

	@Override
	public List<CategoryEntity> getAllCategories() {
		return dao.getAllCategories();
	}

	@Override
	public void addMember(MemberEntity member) {
		dao.addMember(member);
	}

}
