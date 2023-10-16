package com.nopcommerce.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserDataMapper {
	public static UserDataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/resources/UserData.json"), UserDataMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@JsonProperty("RegisterUser")
	RegisterUser registerUser;

	static class RegisterUser {
		@JsonProperty("firstName")
		String fisrtName;

		@JsonProperty("lastName")
		String lastName;

		@JsonProperty("email")
		String email;

		@JsonProperty("password")
		String password;
	}

	public String getFirstName() {
		return registerUser.fisrtName;
	}

	public String getLastName() {
		return registerUser.lastName;
	}

	public String getEmail() {
		return registerUser.email;
	}

	public String getPassword() {
		return registerUser.password;
	}

	@JsonProperty("UpdateUser")
	UpdateUser updateUser;

	static class UpdateUser {
		@JsonProperty("updateGender")
		String updateGender;

		@JsonProperty("updateFirstName")
		String updateFirstName;

		@JsonProperty("updatelastName")
		String updatelastName;

		@JsonProperty("updateDateOfBirth")
		String updateDateOfBirth;

		@JsonProperty("updateMonthOfBirth")
		String updateMonthOfBirth;

		@JsonProperty("updateYearOfBirth")
		String updateYearOfBirth;

		@JsonProperty("updateEmail")
		String updateEmail;

		@JsonProperty("updateCompanyName")
		String updateCompanyName;

	}

	public String getUpdateGender() {
		return updateUser.updateGender;
	}

	public String getUpdateFirstName() {
		return updateUser.updateFirstName;
	}

	public String getUpdatelastName() {
		return updateUser.updatelastName;
	}

	public String getUpdateDateOfBirth() {
		return updateUser.updateDateOfBirth;
	}

	public String getUpdateMonthOfBirth() {
		return updateUser.updateMonthOfBirth;
	}

	public String getUpdateYearOfBirth() {
		return updateUser.updateYearOfBirth;
	}

	public String getUpdateEmail() {
		return updateUser.updateEmail;
	}

	public String getUpdateCompanyName() {
		return updateUser.updateCompanyName;
	}
}
