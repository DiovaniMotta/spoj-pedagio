import java.io.*;
import java.util.*;

/**
 * 
 * @author Diovani Bernardi da Motta Data: 28/08/2016 Implementacao algoritmica
 *         para a solucao do problema SPOJ Pedagio
 * 
 *         PEDAGIO - Pedágio Como prêmio pela primeira colocação na Olimpíada
 *         Brasileira de Informática, Juquinha e sua família ganharam uma viagem
 *         de uma semana à Coréia do Sul. Como o país é deslumbrante, com
 *         tradições, cultura, arquitetura e culinária muito diferentes das do
 *         Brasil, o pai de Juquinha, o Sr. Juca, decidiu alugar um carro para
 *         conhecer melhor o país. As estradas são muito bem cuidadas; todas são
 *         de sentido duplo, e duas cidades podem ser ligadas diretamente por
 *         mais de uma estrada. No entanto, em todas as estradas paga-se um
 *         pedágio de valor fixo (há um pedágio em cada direção, entre duas
 *         cidades). Como o Sr. Juca não tem muito dinheiro para gastar, as
 *         viagens com o carro devem ser muito bem planejadas.
 * 
 *         Tarefa Escreva um programa que, conhecidas as cidades e estradas
 *         existentes no país, e a cidade onde Juquinha e sua família estão,
 *         encontre cada cidade (que não a cidade onde eles estão) que possa ser
 *         visitada por eles, dada a restrição de que o Sr. Juca deseja pagar no
 *         máximo P pedágios (considerando apenas a viagem de ida).
 * 
 *         Entrada A entrada é composta de vários conjuntos de teste. A primeira
 *         linha de um conjunto de teste contém quatro números inteiros C, E, L
 *         e P. Os valores C e E indicam respectivamente o número de cidades e o
 *         número de estradas existentes. As cidades são identificadas por
 *         inteiros de 1 a C. os valores L e P indicam, respectivamente, a
 *         cidade onde a família de Juquinha está no momento e o número máximo
 *         de pedágios que o Sr. Juca está disposto a pagar. As E linhas
 *         seguintes contêm cada uma a informação de uma estrada, representada
 *         por um par de números inteiros positivos X e Y, indicando que há uma
 *         estrada (de sentido duplo) da cidade X para a cidade Y. O final da
 *         entrada é indicado por C = E = L = P = 0.
 * 
 *         Saída Para cada conjunto de teste da entrada seu programa deve
 *         produzir três linhas na saída. A primeira linha deve conter um
 *         identificador do conjunto de teste, no formato “Teste n”, onde n é
 *         numerado a partir de 1. Na segunda linha devem aparecer os
 *         identificadores das cidades que podem ser alcançadas, em ordem
 *         crescente, separados por pelo menos um espaço em branco. A terceira
 *         linha deve ser deixada em branco. A grafia mostrada no Exemplo de
 *         Saída, abaixo, deve ser seguida rigorosamente.
 * 
 *         Exemplo 
 *         Entrada: 5 4 2 1 
 *         1 2 
 *         2 3 
 *         3 4 
 *         4 5 
 *         9 12 1 2 
 *         2 1 
 *         1 5 
 *         2 1 
 *         3 2 
 *         9 3
 *         3 4 
 *         4 8 
 *         4 7 
 *         7 6 
 *         5 6 
 *         4 5 
 *         3 7 
 *         0 0 0 0
 * 
 *         Output: 
 *         Teste 1 
 *         1 3
 * 
 *         Teste 2 
 *         2 3 4 5 6
 */
public class Main {

	private static int indexador; // indexador que identifica o numero de
									// pedagios/saltos alcancados

	/**
	 * 
	 * @author Diovani Classe que representa a especificacao, modelo empregado
	 *         para a solucao do problema
	 */
	public static class Grafo {

		public int c; // numero de cidades apresentados no problema
		public int e; // numero de estradas
		public int l;// cidade de partida
		public int p; // numero de pedágios
		public int[][] arestas; // representa as estradas que ligam uma cidade a outra
	}

	/**
	 * Inicializacao do software
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		System.exit(0);
	}

	/**
	 * Responsavel por implementar o algoritmo de busca em largura e retorna os
	 * vertices(cidades) visitados
	 * 
	 * @param grafo
	 *            objeto contendo as definicoes do problema
	 * @return um array contendo as cidades que podem ser visitadas
	 */
	private static int[] find(Grafo grafo) {
		int[] visitados = new int[grafo.c];
		for (int i = 0; i < grafo.c; i++)
			visitados[i] = 0;
		ArrayList<Integer> fila = new ArrayList<Integer>();
		fila.add((grafo.l - 1));
		int atual = 0;
		int inicio = 0;
		while (fila.size() != inicio) {
			atual = fila.get(inicio);
			for (int tentar = 0; tentar < grafo.c; tentar++) {
				if (visitados[tentar] == 0 && grafo.arestas[atual][tentar] == 1) {
					visitados[tentar] = visitados[atual] + 1;
					fila.add(tentar);
				}
			}
			inicio++;
		}
		return visitados;
	}

	/**
	 * Responsavel por invocar o método de busca em largura e efetuar a
	 * impressao no console dos dados processados na busca
	 * 
	 * @param grafo
	 *            objeto contendo as definicoes do problema
	 */
	private static void process(Grafo grafo) {
		indexador++;
		boolean print = false;
		int[] visitados = find(grafo);
		System.out.println("Teste " + indexador);
		for (int i = 0; i < grafo.c; i++) {
			if (visitados[i] != 0 && i != grafo.l - 1
					&& visitados[i] <= grafo.p) {
				if (print)
					System.out.print(" ");
				System.out.print(i + 1);
				print = true;
			}
			System.out.println("\n");
		}
	}

	/**
	 * Responsavel por efetuar a captura das entradas de dados
	 */
	private static void input() {
		try {
			indexador = 0;
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String linha = new String("");
			Grafo grafo = new Grafo();
			while ((linha = br.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(linha);
				grafo.c = Integer.parseInt(tokenizer.nextToken());
				grafo.e = Integer.parseInt(tokenizer.nextToken());
				grafo.l = Integer.parseInt(tokenizer.nextToken());
				grafo.p = Integer.parseInt(tokenizer.nextToken());
				if (grafo.c == 0 && grafo.e == 0 && grafo.l == 0
						&& grafo.p == 0)
					return;
				grafo.arestas = new int[grafo.c][grafo.c];
				for (int i = 0; i < grafo.e; i++) {
					linha = br.readLine();
					tokenizer = new StringTokenizer(linha);
					int x = Integer.parseInt(tokenizer.nextToken());
					int y = Integer.parseInt(tokenizer.nextToken());
					grafo.arestas[x - 1][y - 1] = 1;
					grafo.arestas[y - 1][x - 1] = 1;
				}
				process(grafo);
			}
		} catch (Exception exception) {

		}
	}
}