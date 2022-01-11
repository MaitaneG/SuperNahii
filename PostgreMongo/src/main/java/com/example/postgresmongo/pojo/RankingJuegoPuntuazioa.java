package com.example.postgresmongo.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ranking_juego_puntuazioa database table.
 * 
 */
@Entity
@Table(name="ranking_juego_puntuazioa")
@NamedQuery(name="RankingJuegoPuntuazioa.findAll", query="SELECT r FROM RankingJuegoPuntuazioa r")
public class RankingJuegoPuntuazioa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_uid")
	private Integer createUid;

	private Timestamp data;

	private String jokalari;

	@Column(name="jokalari_id")
	private Integer jokalariId;

	private Integer puntuazioa;

	@Column(name="write_date")
	private Timestamp writeDate;

	@Column(name="write_uid")
	private Integer writeUid;

	public RankingJuegoPuntuazioa() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Integer getCreateUid() {
		return this.createUid;
	}

	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public String getJokalari() {
		return this.jokalari;
	}

	public void setJokalari(String jokalari) {
		this.jokalari = jokalari;
	}

	public Integer getJokalariId() {
		return this.jokalariId;
	}

	public void setJokalariId(Integer jokalariId) {
		this.jokalariId = jokalariId;
	}

	public Integer getPuntuazioa() {
		return this.puntuazioa;
	}

	public void setPuntuazioa(Integer puntuazioa) {
		this.puntuazioa = puntuazioa;
	}

	public Timestamp getWriteDate() {
		return this.writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public Integer getWriteUid() {
		return this.writeUid;
	}

	public void setWriteUid(Integer writeUid) {
		this.writeUid = writeUid;
	}

}