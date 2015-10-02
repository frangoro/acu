package org.frangoro.acu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.frangoro.acu.model.CategoryEntity;
import org.frangoro.acu.model.MemberEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MemberDAOImpl implements MemberDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<MemberEntity> getAllMembers() {
        List<MemberEntity> members = em.createQuery("Select a From MemberEntity a", MemberEntity.class).getResultList();
		return members;
	}

	@Override
	public List<CategoryEntity> getAllCategories() {
		List<CategoryEntity> categories = em.createQuery("Select a From CategoryEntity a", CategoryEntity.class).getResultList();
		return categories;
	}

	@Override
	public void addMember(MemberEntity member) {
        em.persist(member);
	}

}
