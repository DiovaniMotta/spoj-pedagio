package br.com.furb.grafos.pedagio.model;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Diovani Bernardi da Motta Data: 27/08/2016 Classe que representa o
 *         modelo do problema, contém as informações usadas para a modelagem do grafo
 * 
 *         numeroCidade(C) indica número de cidades(vértices) contidos no grafos
 *         numeroEstradas(E) indica o numero de estradas (arestas) contidas no
 *         grafo 
 *         cidadeAtual(L) indica a cidade de partida(vértice de origem) da
 *         familia de juca numeroPedagio 
 *         (P) indica o número de pedágios (níveis
 *         de busca) que a familia pretende pagar
 *
 */
public class Grafo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7173028636254893655L;
	private int numeroCidade;
	private int numeroEstradas;
	private int cidadeAtual;
	private int numeroPedagio;
	private List<Aresta> arestas;
	
	public Grafo() {
		super();
	}

	public Grafo(int numeroCidade, int numeroEstradas, int cidadeAtual,
			int numeroPedagio) {
		super();
		this.numeroCidade = numeroCidade;
		this.numeroEstradas = numeroEstradas;
		this.cidadeAtual = cidadeAtual;
		this.numeroPedagio = numeroPedagio;
	}

	public Grafo(int numeroCidade, int numeroEstradas, int cidadeAtual,
			int numeroPedagio, List<Aresta> arestas) {
		super();
		this.numeroCidade = numeroCidade;
		this.numeroEstradas = numeroEstradas;
		this.cidadeAtual = cidadeAtual;
		this.numeroPedagio = numeroPedagio;
		this.arestas = arestas;
	}

	public int getNumeroCidade() {
		return numeroCidade;
	}

	public void setNumeroCidade(int numeroCidade) {
		this.numeroCidade = numeroCidade;
	}

	public int getNumeroEstradas() {
		return numeroEstradas;
	}

	public void setNumeroEstradas(int numeroEstradas) {
		this.numeroEstradas = numeroEstradas;
	}

	public int getCidadeAtual() {
		return cidadeAtual;
	}

	public void setCidadeAtual(int cidadeAtual) {
		this.cidadeAtual = cidadeAtual;
	}

	public int getNumeroPedagio() {
		return numeroPedagio;
	}

	public void setNumeroPedagio(int numeroPedagio) {
		this.numeroPedagio = numeroPedagio;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	public void setArestas(List<Aresta> arestas) {
		this.arestas = arestas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cidadeAtual;
		result = prime * result + numeroCidade;
		result = prime * result + numeroEstradas;
		result = prime * result + numeroPedagio;
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
		Grafo other = (Grafo) obj;
		if (cidadeAtual != other.cidadeAtual)
			return false;
		if (numeroCidade != other.numeroCidade)
			return false;
		if (numeroEstradas != other.numeroEstradas)
			return false;
		if (numeroPedagio != other.numeroPedagio)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%d %d %d %d", numeroCidade, numeroEstradas,
				cidadeAtual, numeroPedagio);
	}
}
