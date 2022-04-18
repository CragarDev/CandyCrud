package com.cragardev.candycrud.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="owners")
public class Owner {
	
	// Attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=3, message="===  Owner first name must be at least 3 characters.  ===")
	private String firstName;
	
	@NotNull
	@Size(min=3, message="===  Owner last name must be at least 3 characters.  ===")
	private String lastName;
	
	
	// CreatedAt and UpdatedAt
	// This will not allow the createdAt column to be updated after creation
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
				
	
	// Relationships connections
	@OneToMany(mappedBy="owner", fetch = FetchType.LAZY)
    private List<Candy> candys;
	
	
	// Constructors
	
	// blank constructor
	public Owner() {
		super();
	}
	
	
	// full constructor
	public Owner(Long id, String firstName, String lastName, Date createdAt, Date updatedAt, List<Candy> candys) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.candys = candys;
	}

	// Simple constructor 1

	public Owner( String firstName, String lastName, List<Candy> candys) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.candys = candys;
	}
	
	// Simple constructor 2
	
	public Owner( String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	
	

	// Getters and Setters

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Candy> getCandys() {
		return candys;
	}
	public void setCandys(List<Candy> candys) {
		this.candys = candys;
	}
	
	
	// PrePersist and PreUpdate
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}
