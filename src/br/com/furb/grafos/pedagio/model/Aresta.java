package br.com.furb.grafos.pedagio.model;

import java.io.Serializable;

/**
 * 
 * @author Diovani Bernardi da Motta Data: 27/08/2016 Classe que tem a
 *         responsabilidade de implementar o model usado para representar as
 *         arestas(também chamadas de estradas) que ligam uma cidade a outra
 */
public class Aresta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cidadeX;
	private int cidadeY;
	private int visitado;
	
	public Aresta() {
		super();
	}

	public Aresta(int cidadeX, int cidadeY) {
		super();
		this.cidadeX = cidadeX;
		this.cidadeY = cidadeY;
	}

	public Aresta(int cidadeX, int cidadeY, int visitado) {
		super();
		this.cidadeX = cidadeX;
		this.cidadeY = cidadeY;
		this.visitado = visitado;
	}

	public int getCidadeX() {
		return cidadeX;
	}

	public void setCidadeX(int cidadeX) {
		this.cidadeX = cidadeX;
	}

	public int getCidadeY() {
		return cidadeY;
	}

	public void setCidadeY(int cidadeY) {
		this.cidadeY = cidadeY;
	}

	public int getVisitado() {
		return visitado;
	}

	public void setVisitado(int visitado) {
		this.visitado = visitado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cidadeX;
		result = prime * result + cidadeY;
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
		Aresta other = (Aresta) obj;
		if (cidadeX != other.cidadeX)
			return false;
		if (cidadeY != other.cidadeY)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%d %d",cidadeX,cidadeY);
	}
	
	public String visitado(){
		return String.format("%d ",visitado);
	}
}
