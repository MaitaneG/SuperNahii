package eus.dam.uni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eus.dam.uni.dao.PuntuazioaDAO;
import eus.dam.uni.model.Puntuazioa;

import java.util.List;

/**
 * 
 * Url-aren bidez puntuazioak bistaratu REST-API-an
 *
 */
@RestController
@RequestMapping("/")
public class PuntuazioaController {

	@Autowired
	private PuntuazioaDAO puntuazoaDao;

	/**
	 * 
	 * @return Puntuazio guztiak
	 */
	@GetMapping("puntuazioak")
	public List<Puntuazioa> getPuntuazioak() {
		return puntuazoaDao.findAll();
	}

	/**
	 * 
	 * @return Puntuazio onenak
	 */
	@GetMapping("puntuazioak/hallOfFame")
	public List<Puntuazioa> getHallOfFame() {
		return puntuazoaDao.findHallOfFame();
	}

	/**
	 * 
	 * @return Puntuazio txarrenak
	 */
	@GetMapping("puntuazioak/hallOfShame")
	public List<Puntuazioa> getHallOfShame() {
		return puntuazoaDao.findHallOfShame();
	}
	
	/**
	 * 
	 * @return Partehartutako langileen kopurua
	 */
	@GetMapping("puntuazioak/partidaKopurua")
	public int countPartidak() {
		return puntuazoaDao.countPartidak();
	}
}
