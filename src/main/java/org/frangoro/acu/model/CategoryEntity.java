package org.frangoro.acu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="category")
public class CategoryEntity implements Serializable{
	 private static final long serialVersionUID = 1L;
     
	    @Id
	    @GeneratedValue
	    private Integer id;
	    private String name;
	     
	    public CategoryEntity(){
	    }
	 
	    public CategoryEntity(Integer id, String name) {
	        super();
	        this.id = id;
	        this.name = name;
	    }
	     
	    @OneToMany(mappedBy="category",cascade=CascadeType.PERSIST)
	    private List<MemberEntity> categories = new ArrayList<MemberEntity>();
	     
	    @Override
	    public String toString() {
	        return "CategoryVO [id=" + id + ", name=" + name + "]";
	    }

	    //Setters and Getters
	    
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<MemberEntity> getCategories() {
			return categories;
		}

		public void setCategories(List<MemberEntity> categories) {
			this.categories = categories;
		}
	    
}
