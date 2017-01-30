package com.carrello;

public class Prodotto {

	int id_prodotto;
	String nome;
	double prezzo;
	boolean disponibilita;
	String link;
	int id_categoria;
	int id_negozio;
	String email;
	
	
	public Prodotto(int id_prodotto, String nome, String email, double prezzo, boolean disponibilita, String link, int id_categoria, int id_negozio) {
		
		this.id_prodotto = id_prodotto;
		this.nome = nome;
		this.email= email;
		this.prezzo= prezzo;
		this.disponibilita = disponibilita;
		this.link = link;
		this.id_categoria = id_categoria;
		this.id_negozio = id_negozio;
		
		
	}


	public int getId_prodotto() {
		return id_prodotto;
	}


	public void setId_prodotto(int id_prodotto) {
		this.id_prodotto = id_prodotto;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}


	public boolean isDisponibilita() {
		return disponibilita;
	}


	public void setDisponibilita(boolean disponibilita) {
		this.disponibilita = disponibilita;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public int getId_categoria() {
		return id_categoria;
	}


	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}


	public int getId_negozio() {
		return id_negozio;
	}


	public void setId_negozio(int id_negozio) {
		this.id_negozio = id_negozio;
	}


	
	
}
