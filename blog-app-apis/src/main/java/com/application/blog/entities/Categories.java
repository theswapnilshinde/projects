package com.application.blog.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="categories")
@NoArgsConstructor
@Getter
@Setter
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)

	@Column(name="categoriesid")
	//public int id;
	public int categoriesId;

	@Column(name="title",length = 100 , nullable = false)
	@NotEmpty
	@Size(min =4,message = "Name is mandatory")
	private String categoriesTitle;

	@Column(name="description")
	@NotEmpty
	@Size(min =4,message = "Name is mandatory")
	private String categoriesDescription;

	@OneToMany(mappedBy = "categories",cascade = CascadeType.ALL)
	private List<Post> posts= new ArrayList<>();
}
