package it.prova.test;

import java.util.Date;
import java.util.List;

import it.prova.model.Tv;
import it.prova.service.MyServiceFactory;
import it.prova.service.tv.TvService;

public class TestTv {

	public static void main(String[] args) {

		TvService tvService = MyServiceFactory.getTvServiceImpl();

		try {

			// ora con il service posso fare tutte le invocazioni che mi servono
			System.out.println("In tabella ci sono " + tvService.listAll().size() + " elementi.");

			testInserimentoNuovaTV(tvService);
			System.out.println("In tabella ci sono " + tvService.listAll().size() + " elementi.");

			testRimozioneTv(tvService);
			System.out.println("In tabella ci sono " + tvService.listAll().size() + " elementi.");

			testFindByExample(tvService);
			System.out.println("In tabella ci sono " + tvService.listAll().size() + " elementi.");

			testUpdateTv(tvService);
			System.out.println("In tabella ci sono " + tvService.listAll().size() + " elementi.");

			// E TUTTI I TEST VANNO FATTI COSI'

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void testInserimentoNuovaTV(TvService tvService) throws Exception {
		System.out.println(".......testInserimentoNuovaTV inizio.............");
		Tv newTvInstance = new Tv("HiSense", "Next", new Date());
		if (tvService.inserisciNuovo(newTvInstance) != 1)
			throw new RuntimeException("testInserimento NUOVA TV fallito ");

		System.out.println("inserito nuovo record: " + newTvInstance);
		System.out.println(".......test InserimentoNuovaTV fine.............");
	}

	private static void testRimozioneTv(TvService tvService) throws Exception {
		System.out.println(".......testRimozioneTV inizio.............");
		// recupero tutti gli user
		List<Tv> interoContenutoTabella = tvService.listAll();
		if (interoContenutoTabella.isEmpty() || interoContenutoTabella.get(0) == null)
			throw new Exception("Non ho nulla da rimuovere");

		Long idDelPrimo = interoContenutoTabella.get(0).getId();
		// ricarico per sicurezza con l'id individuato
		Tv toBeRemoved = tvService.findById(idDelPrimo);
		System.out.println("User candidato alla rimozione: " + toBeRemoved);
		if (tvService.rimuovi(toBeRemoved) != 1)
			throw new RuntimeException("testRimozioneTV fallito ");

		System.out.println("rimosso record: " + toBeRemoved);
		System.out.println(".......testRimozioneTV fine.............");
	}

	private static void testFindByExample(TvService tvService) throws Exception {
		System.out.println(".......testFindByExample inizio.............");
		// inserisco i dati che poi mi aspetto di ritrovare
		tvService.inserisciNuovo(new Tv("Panasonic", "ABC", new Date()));
		tvService.inserisciNuovo(new Tv("Pasony", "Light", new Date()));

		// preparo un example che ha come nome 'as' e ricerco
		List<Tv> risultatifindByExample = tvService.findByExample(new Tv("pa"));
		if (risultatifindByExample.size() != 2)
			throw new RuntimeException("testFindByExample fallito ");

		// se sono qui il test è ok quindi ripulisco i dati che ho inserito altrimenti
		// la prossima volta non sarebbero 2 ma 4, ecc.
		for (Tv userItem : risultatifindByExample) {
			tvService.rimuovi(userItem);
		}

		System.out.println(".......testFindByExample fine.............");
	}

	private static void testUpdateTv(TvService tvService) throws Exception {
		System.out.println(".......testUpdateTV inizio.............");

		// inserisco i dati che poi modifico
		if (tvService.inserisciNuovo(new Tv("Sony", "Ultra", new Date())) != 1)
			throw new RuntimeException("testUpdateTV: inserimento preliminare fallito ");

		// recupero col findbyexample e mi aspetto di trovarla
		List<Tv> risultatifindByExample = tvService.findByExample(new Tv("Sony", "Ultra"));
		if (risultatifindByExample.size() != 1)
			throw new RuntimeException("testUpdateTv: testFindByExample fallito ");

		Long idTv = risultatifindByExample.get(0).getId();
		// ricarico per sicurezza con l'id individuato e gli modifico un campo
		String nuovoModello = "Plus";
		Tv toBeUpdated = tvService.findById(idTv);
		toBeUpdated.setModello(nuovoModello);
		System.out.println("TV candidata alla modifica: " + toBeUpdated);
		if (tvService.aggiorna(toBeUpdated) != 1)
			throw new RuntimeException("testUpdateTV fallito ");

		System.out.println("aggiornato record: " + toBeUpdated);
		System.out.println(".......testUpdateTv inizio.............");
	}

}
