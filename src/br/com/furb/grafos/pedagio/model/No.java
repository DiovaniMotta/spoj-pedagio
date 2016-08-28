package br.com.furb.grafos.pedagio.model;

import java.io.Serializable;

public class No implements Serializable{

	public enum Cor {
		BRANCO,
		PRETO,
		CINZA,
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8258978753880813209L;
	private Integer pai;
	private Integer nivel;
	private Cor cor;
	
	public No() {
		super();
	}

	public No(Integer pai, Integer nivel) {
		super();
		this.pai = pai;
		this.nivel = nivel;
	}

	public No(Integer pai, Integer nivel,Cor cor) {
		super();
		this.pai = pai;
		this.nivel = nivel;
		this.cor = cor;
	}

	public Integer getPai() {
		return pai;
	}

	public void setPai(Integer pai) {
		this.pai = pai;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
		result = prime * result + ((pai == null) ? 0 : pai.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		No other = (No) obj;
		if (nivel == null) {
			if (other.nivel != null)
				return false;
		} else if (!nivel.equals(other.nivel))
			return false;
		if (pai == null) {
			if (other.pai != null)
				return false;
		} else if (!pai.equals(other.pai))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%d ", nivel);				
	}
}
