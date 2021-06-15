package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

class MessageSenderTest {
	
	@Test
	void sendTestForRussiaId() {
		String iP = "172.123.12.19";
		Country russia = RUSSIA;
		
		GeoService geoService = Mockito.mock(GeoService.class);
		Mockito.when(geoService.byIp(iP))
				.thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
		
		LocalizationService localizationService = Mockito.mock(LocalizationService.class);
		Mockito.when(localizationService.locale(russia)).thenReturn("Добро пожаловать");
		
		MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
		String expected = messageSender.send(headers);
		String actual = "Добро пожаловать";
		Assertions.assertEquals(expected,actual);
	}
	
	@Test
	void sendTestForUSAId() {
		String iP = "96.44.183.149";
		Country usa = USA;
		
		GeoService geoService = Mockito.mock(GeoService.class);
		Mockito.when(geoService.byIp(iP))
				.thenReturn(new Location("New York", USA, null,  0));
		
		LocalizationService localizationService = Mockito.mock(LocalizationService.class);
		Mockito.when(localizationService.locale(usa)).thenReturn("Welcome");
		
		MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
		String expected = messageSender.send(headers);
		String actual = "Welcome";
		Assertions.assertEquals(expected,actual);
	}
}