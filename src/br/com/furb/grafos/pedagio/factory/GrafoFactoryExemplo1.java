package br.com.furb.grafos.pedagio.factory;

import java.util.ArrayList;
import java.util.List;

import br.com.furb.grafos.pedagio.model.Aresta;
import br.com.furb.grafos.pedagio.model.No;

/**
 * 
 * @author Diovani
 *
 */
public class GrafoFactoryExemplo1 extends GrafoAbstractFactory {

	@Override
	public List<Aresta> getArestas() {
		List<Aresta> arestas = new ArrayList<Aresta>();
		Aresta aresta1 = new Aresta(1, 2);
		arestas.add(aresta1);
		Aresta aresta2 = new Aresta(2, 3);
		arestas.add(aresta2);
		Aresta aresta3 = new Aresta(3, 4);
		arestas.add(aresta3);
		Aresta aresta4 = new Aresta(4, 5);
		arestas.add(aresta4);
		return arestas;
	}

	@Override
	protected void exibir(List<No> nos) {
		if(nos.isEmpty())
			return;
		System.out.println("\nTeste 1");
		String impressao = new String();
		for (No no : nos)
			impressao += no.toString();
		System.out.print(impressao);
		System.out.println();
	}

}
