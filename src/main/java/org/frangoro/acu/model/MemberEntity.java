package org.frangoro.acu.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name="member")
public class MemberEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    private Integer id;
     
    @NotEmpty
    private String firstName;
    private String lastName;
    private String email;
     
    @NotNull
    @ManyToOne
    @JoinColumn(name="category")
    private CategoryEntity category;
     
    public MemberEntity() {}
      
    public MemberEntity(String name, CategoryEntity category) {
        this.firstName = name;
        this.category = category;
    }
      
    public MemberEntity(String name) {
        this.firstName = name;
    }
 
    @Override
    public String toString() {
        return "MemberVO [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", email=" + email
                + ", category=" + category + "]";
    }
    
    //Setters and Getters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
}
