package br.com.furb.grafos.pedagio;

import java.util.List;

import br.com.furb.grafos.pedagio.factory.GrafoAbstractFactory;
import br.com.furb.grafos.pedagio.model.Aresta;
import br.com.furb.grafos.pedagio.model.Grafo;

public class MainApp {

	public static void main(String[] args) {
		// representação dos valores de entrada do exemplo 1
		GrafoAbstractFactory grafoAbstractFactory1 = GrafoAbstractFactory
				.getGrafo(1);
		Grafo grafo1 = grafoAbstractFactory1.getGrafo(5, 4, 2, 1);
		grafoAbstractFactory1.grafo(grafo1);
		List<Aresta> arestas1 = grafoAbstractFactory1.getArestas();
		grafo1.setArestas(arestas1);
		grafoAbstractFactory1.print(arestas1);
		// representação dos valores de entrada do exemplo 2
		GrafoAbstractFactory grafoAbstractFactory2 = GrafoAbstractFactory
				.getGrafo(2);
		Grafo grafo2 = grafoAbstractFactory2.getGrafo(9, 12, 1, 2);
		grafoAbstractFactory2.grafo(grafo2);
		List<Aresta> arestas2 = grafoAbstractFactory2.getArestas();
		grafo2.setArestas(arestas2);
		Grafo grafoZerado = grafoAbstractFactory2.getGrafo(0, 0, 0, 0);
		grafoAbstractFactory2.grafo(grafoZerado);
		grafoAbstractFactory2.print(arestas2);
		// representa as saidas referente ao exemplo 1
		grafoAbstractFactory1.largura(grafo1);
		// representa as saidas referente ao exemplo 2
		grafoAbstractFactory2.largura(grafo2);

	}
}
