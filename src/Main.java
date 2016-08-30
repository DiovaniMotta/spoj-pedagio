import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

	private static class Grafo {

		public int c;
		public int e;
		public int l;
		public int p;
		public int[][] arestas;

	}

	public static void main(String[] args) {
		input();
		System.exit(0);
	}

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
			return;
		}
	}


	private static int[] find(Grafo grafo) {
		int[] vetorVisitados = new int[grafo.c];
		for (int i = 0; i < grafo.c; i++)
			vetorVisitados[i] = 0;
		ArrayList<Integer> filaVisitados = new ArrayList<Integer>();
		filaVisitados.add((grafo.l - 1));
		int verticeAtual = 0;
		int inicioFila = 0;
		while (filaVisitados.size() != inicioFila) {
			verticeAtual = filaVisitados.get(inicioFila);
			for (int tentar = 0; tentar < grafo.c; tentar++) {
				if (vetorVisitados[tentar] == 0
						&& grafo.arestas[verticeAtual][tentar] == 1) {
					vetorVisitados[tentar] = vetorVisitados[verticeAtual] + 1;
					filaVisitados.add(tentar);
				}
			}
			inicioFila++;
		}
		return vetorVisitados;
	}

	
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