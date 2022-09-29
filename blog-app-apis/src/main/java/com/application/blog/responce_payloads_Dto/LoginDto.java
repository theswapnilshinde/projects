package com.application.blog.responce_payloads_Dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Data
public class LoginDto {

	    private Long id;

		private String name;

		private String email;

		private String password;

		private String about;

}
