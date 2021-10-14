package it.prova.service;

import it.prova.dao.tv.TvDAOImpl;
import it.prova.service.tv.TvService;
import it.prova.service.tv.TvServiceImpl;

public class MyServiceFactory {

	public static TvService getTvServiceImpl() {
		TvService tvService = new TvServiceImpl();
		tvService.setTvDao(new TvDAOImpl());
		return tvService;
	}
}
