package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;


class GeoServiceImplTest {
	
	@Test
	void byIpTest(){
		GeoServiceImpl geoService = new GeoServiceImpl();
		
		Location actual = geoService.byIp("172.0.32.11");
		Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
		
		Country countryActual = actual.getCountry();
		Country countryExpected = expected.getCountry();
		
		Assertions.assertEquals(countryExpected,countryActual);
	}
}