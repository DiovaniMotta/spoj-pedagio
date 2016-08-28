package br.com.furb.grafos.pedagio.fila;

import java.util.ArrayList;
import java.util.List;

import br.com.furb.grafos.pedagio.model.Aresta;
import br.com.furb.grafos.pedagio.model.Grafo;
import br.com.furb.grafos.pedagio.model.No;

public abstract class Fila {

	protected int noInicial;
	protected int noFinal;
	protected List<No> visitados = new ArrayList<No>();
	protected List<Aresta> fila = new ArrayList<Aresta>();
	protected List<Aresta> arestas = new ArrayList<Aresta>();

	public abstract void fila(Grafo grafo);

	protected abstract void enfileirar(No no);

	protected abstract void definir(int pai, int visitado);

	public abstract List<No> visitados();
}
