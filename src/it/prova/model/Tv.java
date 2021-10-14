package it.prova.model;

import java.util.Date;

public class Tv {

	private Long id;
	private String marca;
	private String modello;
	private Date dataproduzione;

	public Tv() {
	}

	public Tv(String marca) {
		super();
		this.marca = marca;
	}

	public Tv(String marca, String modello) {
		super();
		this.marca = marca;
		this.modello = modello;
	}
	
	public Tv(String marca, String modello, Date dataproduzione) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.dataproduzione = dataproduzione;
	}

	public Tv(Long id, String marca, String modello, Date dataproduzione) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.dataproduzione = dataproduzione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public Date getDataproduzione() {
		return dataproduzione;
	}

	public void setDataproduzione(Date dataproduzione) {
		this.dataproduzione = dataproduzione;
	}

	@Override
	public String toString() {
		return "Tv [id=" + id + ", marca=" + marca + ", modello=" + modello + ", dataproduzione=" + dataproduzione
				+ "]";
	}

}
