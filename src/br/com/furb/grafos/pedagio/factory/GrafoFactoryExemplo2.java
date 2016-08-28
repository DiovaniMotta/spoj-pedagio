package br.com.furb.grafos.pedagio.factory;

import java.util.ArrayList;
import java.util.List;

import br.com.furb.grafos.pedagio.model.Aresta;
import br.com.furb.grafos.pedagio.model.No;

public class GrafoFactoryExemplo2 extends GrafoAbstractFactory {

	@Override
	public List<Aresta> getArestas() {
		List<Aresta> arestas = new ArrayList<Aresta>();
		Aresta aresta1 = new Aresta(2, 1);
		arestas.add(aresta1);
		Aresta aresta2 = new Aresta(1, 5);
		arestas.add(aresta2);
		Aresta aresta3 = new Aresta(2, 1);
		arestas.add(aresta3);
		Aresta aresta4 = new Aresta(3, 2);
		arestas.add(aresta4);
		Aresta aresta5 = new Aresta(9, 3);
		arestas.add(aresta5);
		Aresta aresta6 = new Aresta(3, 4);
		arestas.add(aresta6);
		Aresta aresta7 = new Aresta(4, 8);
		arestas.add(aresta7);
		Aresta aresta8 = new Aresta(4, 7);
		arestas.add(aresta8);
		Aresta aresta9 = new Aresta(7, 6);
		arestas.add(aresta9);
		Aresta aresta10 = new Aresta(5, 6);
		arestas.add(aresta10);
		Aresta aresta11 = new Aresta(4, 5);
		arestas.add(aresta11);
		Aresta aresta12 = new Aresta(3, 7);
		arestas.add(aresta12);
		return arestas;
	}
	@Override
	protected void exibir(List<No> nos) {
		if(nos.isEmpty())
			return;
		System.out.println("\nTeste 2");
		String impressao = new String();
		for (No no : nos)
			impressao += no.toString();
		System.out.print(impressao);
		System.out.println();
	}
}
