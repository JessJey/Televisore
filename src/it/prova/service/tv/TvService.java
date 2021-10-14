package it.prova.service.tv;

import java.util.List;

import it.prova.dao.tv.TvDAO;
import it.prova.model.Tv;

public interface TvService {

	public void setTvDao(TvDAO tvDao);

	public List<Tv> listAll() throws Exception;

	public Tv findById(Long idInput) throws Exception;

	public int aggiorna(Tv input) throws Exception;

	public int inserisciNuovo(Tv input) throws Exception;

	public int rimuovi(Tv input) throws Exception;

	public List<Tv> findByExample(Tv input) throws Exception;
}
