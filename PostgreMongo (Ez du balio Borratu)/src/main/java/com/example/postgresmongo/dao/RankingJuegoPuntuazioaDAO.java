package com.example.postgresmongo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.postgresmongo.pojo.RankingJuegoPuntuazioa;

@Repository
@Transactional
public class RankingJuegoPuntuazioaDAO {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Puntuazioa sortzean persistentzia izateko
	 * 
	 * @param puntuazioa
	 */
	public void create(RankingJuegoPuntuazioa puntuazioa) {
		entityManager.persist(puntuazioa);
		return;
	}

	/**
	 * Puntuazioa ezabatzeko; produktu bat jasotzen du
	 * 
	 * @param puntuazioa
	 */
	public void delete(RankingJuegoPuntuazioa puntuazioa) {
		if (entityManager.contains(puntuazioa))
			entityManager.remove(puntuazioa);
		else {
			entityManager.remove(entityManager.merge(puntuazioa));
		}
		return;
	}

	/**
	 * Puntuazioaren select bat egiten du eta produktuen lista bat itzultzen du
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<RankingJuegoPuntuazioa> getAll() {
		return entityManager.createQuery("from RankingJuegoPuntuazioa").getResultList();
	}

	/**
	 * Puntua id bidez bilatzen du
	 * 
	 * @param id
	 * @return
	 */
	public RankingJuegoPuntuazioa getById(long id) {
		return entityManager.find(RankingJuegoPuntuazioa.class, id);
	}

	/**
	 * Zegoen puntuazioa updateatu egiten du.
	 * 
	 * @param puntuazioa
	 */
	public void update(RankingJuegoPuntuazioa puntuazioa) {
		entityManager.merge(puntuazioa);
		return;
	}
}
