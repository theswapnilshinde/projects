package com.application.blog.responce_payloads_Dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Getter
@Setter
public class CategoriesDto {


	public int categoriesId;

	@Column(name="title",length = 100 , nullable = false)
	@NotEmpty
	@Size(min =4,message = "Name is mandatory")
	private String categoriesTitle;

	@Column(name="description")
	@NotEmpty
	@Size(min =4,message = "Name is mandatory")
	private String categoriesDescription;


}
