package org.frangoro.acu.service;

import java.util.List;

import org.frangoro.acu.model.CategoryEntity;
import org.frangoro.acu.model.MemberEntity;

public interface MemberService {
	public List<MemberEntity> getAllMembers();
    public List<CategoryEntity> getAllCategories();
    public void addMember(MemberEntity member);
}
