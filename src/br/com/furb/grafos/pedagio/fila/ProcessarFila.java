package br.com.furb.grafos.pedagio.fila;

import java.util.List;
import java.util.stream.Collectors;

import br.com.furb.grafos.pedagio.model.Aresta;
import br.com.furb.grafos.pedagio.model.Grafo;
import br.com.furb.grafos.pedagio.model.No;
import br.com.furb.grafos.pedagio.model.No.Cor;

public class ProcessarFila extends Fila {

	@Override
	public void fila(Grafo grafo) {
		arestas = grafo.getArestas();
		noInicial = grafo.getCidadeAtual();
		noFinal = grafo.getNumeroPedagio();
		No nosInicial = null;
		for (int numero = 1; numero <= grafo.getNumeroCidade(); numero++) {
			No no = new No(null, numero, Cor.BRANCO);
			visitados.add(no);
		}
		for (No no : visitados) {
			if (no.getNivel() == noInicial) {
				no.setPai(0);
				no.setCor(Cor.PRETO);
				nosInicial = no;
			}
		}
		enfileirar(nosInicial);
	}

	@Override
	protected void enfileirar(No no) {
		fila.clear();
		fila.addAll(arestas
				.stream()
				.filter(aresta -> ((aresta.getCidadeX() == no.getNivel()) || (aresta
						.getCidadeY() == no.getNivel())))
				.collect(Collectors.toList()));
		for (Aresta aresta : fila) {
			if (aresta.getCidadeX() == no.getNivel()) {
				int numero = aresta.getCidadeY();
				definir(no.getNivel(), numero);
			}
			if (aresta.getCidadeY() == no.getNivel()) {
				int numero = aresta.getCidadeX();
				definir(no.getNivel(), numero);
			}
		}
		List<No> nosVisitados = visitados
				.stream()
				.filter(n -> ((n.getPai() != null) && (n.getPai() == no
						.getNivel()))).collect(Collectors.toList());
		noInicial++;
		if (noInicial > noFinal)
			return;
		for (No n : nosVisitados)
			enfileirar(n);
	}

	@Override
	protected void definir(int pai, int visitado) {
		for (No no : visitados) {
			if (no.getNivel() == visitado) {
				if (no.getCor() == Cor.BRANCO) {
					no.setPai(pai);
					no.setCor(Cor.CINZA);
					return;
				}
			}
		}
	}

	@Override
	public List<No> visitados() {
		return visitados.stream().filter(no -> (no.getCor() == Cor.CINZA))
				.collect(Collectors.toList());

	}
}
