package eus.dam.uni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eus.dam.uni.dao.PuntuazioaDAO;
import eus.dam.uni.model.Puntuazioa;

import java.util.List;

@RestController
@RequestMapping("/")
public class PuntuazioaController {

	   @Autowired
	   private PuntuazioaDAO puntuazoaDao;
	
	   @GetMapping("puntuazioa")
	    public List<Puntuazioa> getPuntuazioak() {
	        return puntuazoaDao.findAll();
	    }
}
