package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
	private Locale locale = new Locale("en");
	private Faker faker = new Faker(locale);

	public static DataHelper getData() {
		return new DataHelper();
	}

	public String getFirstName() {
		return faker.address().firstName();
	}

	public String getLastName() {
		return faker.address().lastName();
	}

	public String getEmail() {
		return faker.internet().emailAddress();
	}

	public String getPassword() {
		return faker.internet().password(6, 15, true, true);
	}

	public String getCompanyName() {
		return faker.company().name();
	}

	public String getCityName() {
		return faker.address().cityName();
	}

	public String getFullAddress() {
		return faker.address().fullAddress();
	}

	public String getSecondAddress() {
		return faker.address().secondaryAddress();
	}

	public String getZipcode() {
		return faker.address().zipCode();
	}

	public String getPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}

}
