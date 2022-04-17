package com.cragardev.candycrud.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="candys")
public class Candy {
	
	// attributes
	
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long id;
			
			@NotNull
			@Size(min=3, message="===  Candy name must be at least 3 characters.  ===")
			private String name;
			
			@NotNull
			@Size(min=3, message="===  Brand name must be at least 3 characters.  ===")
			private String brand;
			
			@NotNull(message="===  Cannot be blank  ===")
			@Min(value=1, message="===  Rating need to be between 1 and 10.  ===")
			@Max(value=10, message="===  Rating need to be between 1 and 10.  ===")
			private Integer rating;
			
			
			@NotNull(message="===  Price Cannot be blank  ===")
			@Min(value=0)
			private Double price;
			

			
			// This will not allow the createdAt column to be updated after creation
			@Column(updatable = false)
			@DateTimeFormat(pattern="yyyy-MM-dd")
			private Date createdAt;
			
			
			@DateTimeFormat(pattern="yyyy-MM-dd")
			private Date updatedAt;
			
			
			
			// Constructors
			
			// blank constructor

			public Candy() {
				super();
			}
			
			
			// full constructor
			
			public Candy(Long id, String name,  String brand, Integer rating, Double price, Date createdAt,
					Date updatedAt) {
				super();
				this.id = id;
				this.name = name;
				this.brand = brand;
				this.rating = rating;
				this.price = price;
				this.createdAt = createdAt;
				this.updatedAt = updatedAt;
			}



			// Simple constructor

			public Candy(String name, String brand, Integer rating, Double price) {
				super();
				this.name = name;
				this.brand = brand;
				this.rating = rating;
				this.price = price;
			}


			// Getters and Setters


			public Long getId() {
				return id;
			}



			public void setId(Long id) {
				this.id = id;
			}



			public String getName() {
				return name;
			}



			public void setName(String name) {
				this.name = name;
			}



			public String getBrand() {
				return brand;
			}



			public void setBrand(String brand) {
				this.brand = brand;
			}



			public Integer getRating() {
				return rating;
			}



			public void setRating(Integer rating) {
				this.rating = rating;
			}



			public Double getPrice() {
				return price;
			}



			public void setPrice(Double price) {
				this.price = price;
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
