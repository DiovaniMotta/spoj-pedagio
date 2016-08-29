import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class MainAAA {

	public static class Aresta {

		public int x;
		public int y;

	}

	public static class Grafo {

		public int c;
		public int e;
		public int l;
		public int p;
		public List<Aresta> arestas = new ArrayList<Aresta>();
		public int[][] posicoes;
	}

	public static void main(String[] args) {
		iniciar();
		System.exit(0);
	}

	private static List<Integer> busca(Grafo grafo) {
		List<Integer> vetorVisitados = new ArrayList<Integer>();
		for (int i = 0; i < grafo.c; i++)
			vetorVisitados.add(0);
		ArrayList<Integer> filaVisitados = new ArrayList<Integer>();
		filaVisitados.add(grafo.l);
		int verticeAtual = 0;
		int inicioFila = 0;
		while (filaVisitados.size() != inicioFila) {
			verticeAtual = filaVisitados.get(inicioFila);
			for (int tentar = 0; tentar < grafo.c; tentar++) {
				if (vetorVisitados.get(tentar) == 0
						&& grafo.posicoes[verticeAtual][tentar] == 1) {
					vetorVisitados.add(tentar,
							vetorVisitados.get(verticeAtual) + 1);
					filaVisitados.add(tentar);
				}
			}
			inicioFila++;
		}
		return vetorVisitados;
	}

	private static void iniciar() {
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(System.in));
			int caso = 0;
			while (bufferedReader.readLine() != null) {
				StringTokenizer tokenizer = new StringTokenizer(
						bufferedReader.readLine());
				Grafo grafo = new Grafo();
				grafo.c = Integer.parseInt(tokenizer.nextToken());
				grafo.e = Integer.parseInt(tokenizer.nextToken());
				grafo.l = Integer.parseInt(tokenizer.nextToken());
				grafo.p = Integer.parseInt(tokenizer.nextToken());
				if (grafo.c == 0 && grafo.e == 0 && grafo.l == 0
						&& grafo.p == 0)
					return;
				List<Aresta> listaAresta = new ArrayList<Aresta>(grafo.c);
				grafo.posicoes = new int[grafo.c][grafo.c];
				for (int i = 0; i < grafo.e; i++) {
					tokenizer = new StringTokenizer(bufferedReader.readLine());
					Aresta aresta = new Aresta();
					aresta.x = Integer.parseInt(tokenizer.nextToken());
					aresta.y = Integer.parseInt(tokenizer.nextToken());
					grafo.posicoes[aresta.x - 1][aresta.y - 1] = 1;
					grafo.posicoes[aresta.x - 1][aresta.y - 1] = 1;
					listaAresta.add(aresta);
				}
				grafo.arestas = listaAresta;
				List<Integer> visitados = busca(grafo);
				caso++;
				System.out.println("Teste " + caso);
				boolean jaImprimi = false;
				for (int i = 0; i < grafo.c; i++) {
					if (visitados.get(i) != 0 && i != grafo.l - 1
							&& visitados.get(i) <= grafo.p) {
						if (jaImprimi)
							System.out.print(" ");
						System.out.print(i + 1);
						jaImprimi = true;
					}
				}
				System.out.println("\n");
			}
		} catch (Exception e) {
			return;
		}
	}
}