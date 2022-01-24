package com.example.postgresmongo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.postgresmongo.pojo.AppUser;
import com.example.postgresmongo.pojo.RankingJuegoPuntuazioa;

@Repository
@Transactional
public class AppUserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Puntuazioa sortzean persistentzia izateko
	 * 
	 * @param puntuazioa
	 */
	public void create(AppUser puntuazioa) {
		entityManager.persist(puntuazioa);
		return;
	}

	/**
	 * Puntuazioa ezabatzeko; produktu bat jasotzen du
	 * 
	 * @param puntuazioa
	 */
	public void delete(AppUser puntuazioa) {
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
	public List<AppUser> getAll() {
		return entityManager.createQuery("from RankingJuegoPuntuazioa").getResultList();
	}

	/**
	 * Puntua id bidez bilatzen du
	 * 
	 * @param id
	 * @return
	 */
	public AppUser getById(long id) {
		return entityManager.find(AppUser.class, id);
	}

	/**
	 * Zegoen puntuazioa updateatu egiten du.
	 * 
	 * @param puntuazioa
	 */
	public void update(AppUser puntuazioa) {
		entityManager.merge(puntuazioa);
		return;
	}
}