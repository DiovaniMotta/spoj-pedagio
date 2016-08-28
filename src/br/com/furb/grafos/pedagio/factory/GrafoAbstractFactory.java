package br.com.furb.grafos.pedagio.factory;

import java.util.List;

import br.com.furb.grafos.pedagio.fila.ProcessarFila;
import br.com.furb.grafos.pedagio.model.Aresta;
import br.com.furb.grafos.pedagio.model.Grafo;
import br.com.furb.grafos.pedagio.model.No;

/**
 * 
 * @author Diovani
 *
 */
public abstract class GrafoAbstractFactory {

	public static GrafoAbstractFactory getGrafo(int exemplo) {
		switch (exemplo) {
		case 1:
			return new GrafoFactoryExemplo1();
		case 2:
			return new GrafoFactoryExemplo2();
		default:
			return null;
		}
	}

	public Grafo getGrafo(int numeroCidade, int numeroEstradas,
			int cidadeAtual, int numeroPedagio) {
		return new Grafo(numeroCidade, numeroEstradas, cidadeAtual,
				numeroPedagio);
	}

	public void print(List<Aresta> arestas){
		for(Aresta aresta : arestas)
			System.out.println(aresta.toString());
	}
	
	public void grafo(Grafo grafo){
		System.out.println(grafo.toString());
	}
	
	public void largura(Grafo grafo){
		ProcessarFila processarFila = new ProcessarFila();
		processarFila.fila(grafo);
		List<No> nos = processarFila.visitados();
		exibir(nos);
	}
	
	public abstract List<Aresta> getArestas();
	
	protected abstract void exibir(List<No> nos);
	
	
}
