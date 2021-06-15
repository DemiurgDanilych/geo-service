package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {
	
	@ParameterizedTest
	@EnumSource(Country.class)
	void localeTest(Country country) {
		LocalizationServiceImpl locServ = new LocalizationServiceImpl();
		
		if (Country.RUSSIA.equals(country)) {
			String actual = "Добро пожаловать";
			String expected = locServ.locale(country);
			Assertions.assertEquals(expected, actual);
		} else {
			String actual = "Welcome";
			String expected = locServ.locale(country);
			Assertions.assertEquals(expected, actual);
			
		}
	}
}