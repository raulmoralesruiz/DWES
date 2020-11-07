package z_com.jacaranda.entity.old;
//package com.jacaranda.entity;
//
//import java.io.Serializable;
//
//@SuppressWarnings("serial")
//public class Movie extends Product implements Serializable {
//
//	private int idMovie;
//	private static int idSiguiente = 0;
//	private String title;
//	private SuscriptionEnum tipoSuscripcion;
//	private Category categoria;
//	//idProducto heredado de Producto
//	
//	
//	
//	public Movie() {
//		super();
//	}
//	public Movie(String title) {
//		super();
//		this.idMovie = idSiguiente++;
//		this.title = title;
//	}
//	public Movie(String title, SuscriptionEnum tipoSuscripcion) {
//		super();
//		this.idMovie = idSiguiente++;
//		this.title = title;
//		this.tipoSuscripcion = tipoSuscripcion;
//	}
//	public Movie(String title, SuscriptionEnum tipoSuscripcion, Category categoria) {
//		super();
//		this.idMovie = idSiguiente++;
//		this.title = title;
//		this.tipoSuscripcion = tipoSuscripcion;
//		this.categoria = categoria;
//	}
//
//	
//	
//	public int getIdMovie() {
//		return idMovie;
//	}
//	public void setIdMovie(int idMovie) {
//		this.idMovie = idMovie;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public SuscriptionEnum getTipoSuscripcion() {
//		return tipoSuscripcion;
//	}
//	public void setTipoSuscripcion(SuscriptionEnum tipoSuscripcion) {
//		this.tipoSuscripcion = tipoSuscripcion;
//	}
//	public Category getCategoria() {
//		return categoria;
//	}
//	public void setCategoria(Category categoria) {
//		this.categoria = categoria;
//	}
//	
//	
//	@Override
//	public int getIdSerie() {
//		return -11;
//	}
//
//	
//	
//}
