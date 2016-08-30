import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @author Diovani Bernardi da Motta Data: 30/08/2016 Implementacao do problema
 *         SPOJ - 819 Pedagio
 */
public class Main {

	/**
	 * 
	 * @author Diovani Bernardi da Motta Classe que representa o dominio do
	 *         problema
	 */
	private static class Grafo {

		public int c; // numero de cidade
		public int e; // numero de estrada
		public int l; // ponto de partida
		public int p; // numero de pedagio
		public int[][] arestas; // identifica os pontos(estradas) entre uma
								// cidade e outra

	}

	/**
	 * Inicio do programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		System.exit(0);
	}

	/**
	 * Responsavel por capturar as entradas fornecidas no console, instanciar um
	 * objeto Grafo, que contém os dados da definicao do problema e invocar as
	 * rotinas de processamento e busca
	 */
	private static void input() {
		try {
			String line = "";
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			Grafo grafo = new Grafo();
			while ((line = br.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(line);
				grafo.c = Integer.parseInt(tokenizer.nextToken());
				grafo.e = Integer.parseInt(tokenizer.nextToken());
				grafo.l = Integer.parseInt(tokenizer.nextToken());
				grafo.p = Integer.parseInt(tokenizer.nextToken());
				if (grafo.c == 0 && grafo.e == 0 && grafo.l == 0
						&& grafo.p == 0)
					return;
				grafo.arestas = new int[grafo.c][grafo.c];
				for (int i = 0; i < grafo.e; i++) {
					line = br.readLine();
					tokenizer = new StringTokenizer(line);
					int x = Integer.parseInt(tokenizer.nextToken());
					int y = Integer.parseInt(tokenizer.nextToken());
					grafo.arestas[x - 1][y - 1] = 1;
					grafo.arestas[y - 1][x - 1] = 1;
				}
				process(grafo);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return;
		}
	}

	/**
	 * Responsavel por efetuar a busca das cidades que sera visitadas.Implementacao do algoritmo de busca em largura
	 * @param grafo o objeto contendo as definicoes lidas na tela de entrada(console)
	 * @return um array contendo as cidades que poderam ser visitadas
	 */
	private static int[] find(Grafo grafo) {
		int[] vetorVisitados = new int[grafo.c];
		for (int i = 0; i < grafo.c; i++)
			vetorVisitados[i] = 0; // inicializa todas as posicoes para zero
		ArrayList<Integer> filaVisitados = new ArrayList<Integer>();
		filaVisitados.add((grafo.l - 1)); // adiciona o ponto de inicio da zornada
		int verticeAtual = 0;
		int inicioFila = 0;
		while (filaVisitados.size() != inicioFila) { // enquanto o numero de cidades visitadas for diferente do que o inicio da fila
			verticeAtual = filaVisitados.get(inicioFila); // retorno a primeira cidade visitada
			for (int tentar = 0; tentar < grafo.c; tentar++) {
				if (vetorVisitados[tentar] == 0 // se a cidade ainda nao foi visitada
						&& grafo.arestas[verticeAtual][tentar] == 1) { 
					vetorVisitados[tentar] = vetorVisitados[verticeAtual] + 1; // adiciono o pai do vertices
					filaVisitados.add(tentar); // adiciono a fila de visitados
				}
			}
			inicioFila++;
		}
		return vetorVisitados;
	}

	/**
	 * Responsavel por invocar as rotinas de busca em largura e imprimir os resultados no console.
	 * @param grafo o objeto contendo as definicoes lidas na tela de entrada(console)
	 */
	private static void process(Grafo grafo) {
		int[] vetorVisitados = find(grafo);
		int caso = 0;
		caso++;
		System.out.println("Teste " + caso);
		boolean jaImprimi = false;
		for (int i = 0; i < grafo.c; i++) {
			if (vetorVisitados[i] != 0 && i != (grafo.l - 1)
					&& vetorVisitados[i] <= grafo.p) {
				if (jaImprimi)
					System.out.print(" ");
				System.out.print(i + 1);
				jaImprimi = true;
			}
		}
		System.out.println("\n");
		return;
	}
}
