package org.frangoro.acu.dao;

import java.util.List;

import org.frangoro.acu.model.CategoryEntity;
import org.frangoro.acu.model.MemberEntity;

public interface MemberDAO {
	public List<MemberEntity> getAllMembers();
    public List<CategoryEntity> getAllCategories();
    public void addMember(MemberEntity member);
}
