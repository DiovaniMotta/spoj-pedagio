import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainApp {

	public enum Cor {
		BRANCO, PRETO, CINZA,
	}

	public static class GrafoAbstractFactory {

		protected Grafo grafo;

		public Grafo getGrafo(int numeroCidade, int numeroEstradas,
				int cidadeAtual, int numeroPedagio) {
			grafo = new Grafo(numeroCidade, numeroEstradas, cidadeAtual,
					numeroPedagio);
			return grafo;
		}

		public void print(List<Aresta> arestas) {
			for (Aresta aresta : arestas)
				System.out.println(aresta.toString());
		}

		public void grafo(Grafo grafo) {
			//System.out.println(grafo.toString());
		}

		public void largura(Grafo grafo) {
			ProcessarFila processarFila = new ProcessarFila();
			processarFila.fila(grafo);
			List<No> nos = processarFila.visitados();
			exibir(nos);
		}

		public List<Aresta> getArestas() {
			List<Aresta> arestas = new ArrayList<Aresta>();
			for (int i = 0; i < grafo.getNumeroEstradas(); i++) {
				Scanner scanner = new Scanner(System.in);
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				scanner.nextLine();
				Aresta aresta = new Aresta(x, y);
				arestas.add(aresta);
			}
			return arestas;
		}

		protected void exibir(List<No> nos) {
			if (nos.isEmpty())
				return;
			System.out.println("\nTeste 1");
			String impressao = new String();
			for (No no : nos)
				impressao += no.toString();
			System.out.print(impressao);
			System.out.println();
		}
	}

	public static class No implements Serializable {

		/**
	 * 
	 */
		private static final long serialVersionUID = 8258978753880813209L;
		private Integer pai;
		private Integer nivel;
		private Cor cor;

		public No() {
			super();
		}

		public No(Integer pai, Integer nivel) {
			super();
			this.pai = pai;
			this.nivel = nivel;
		}

		public No(Integer pai, Integer nivel, Cor cor) {
			super();
			this.pai = pai;
			this.nivel = nivel;
			this.cor = cor;
		}

		public Integer getPai() {
			return pai;
		}

		public void setPai(Integer pai) {
			this.pai = pai;
		}

		public Integer getNivel() {
			return nivel;
		}

		public void setNivel(Integer nivel) {
			this.nivel = nivel;
		}

		public Cor getCor() {
			return cor;
		}

		public void setCor(Cor cor) {
			this.cor = cor;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
			result = prime * result + ((pai == null) ? 0 : pai.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			No other = (No) obj;
			if (nivel == null) {
				if (other.nivel != null)
					return false;
			} else if (!nivel.equals(other.nivel))
				return false;
			if (pai == null) {
				if (other.pai != null)
					return false;
			} else if (!pai.equals(other.pai))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return String.format("%d ", nivel);
		}
	}

	/**
	 * 
	 * @author Diovani Bernardi da Motta Data: 27/08/2016 Classe que representa
	 *         o modelo do problema, contém as informações usadas para a
	 *         modelagem do grafo
	 * 
	 *         numeroCidade(C) indica número de cidades(vértices) contidos no
	 *         grafos numeroEstradas(E) indica o numero de estradas (arestas)
	 *         contidas no grafo cidadeAtual(L) indica a cidade de
	 *         partida(vértice de origem) da familia de juca numeroPedagio (P)
	 *         indica o número de pedágios (níveis de busca) que a familia
	 *         pretende pagar
	 *
	 */

	public static class Grafo implements Serializable {

		/**
	 * 
	 */
		private static final long serialVersionUID = -7173028636254893655L;
		private int numeroCidade;
		private int numeroEstradas;
		private int cidadeAtual;
		private int numeroPedagio;
		private List<Aresta> arestas;

		public Grafo() {
			super();
		}

		public Grafo(int numeroCidade, int numeroEstradas, int cidadeAtual,
				int numeroPedagio) {
			super();
			this.numeroCidade = numeroCidade;
			this.numeroEstradas = numeroEstradas;
			this.cidadeAtual = cidadeAtual;
			this.numeroPedagio = numeroPedagio;
		}

		public Grafo(int numeroCidade, int numeroEstradas, int cidadeAtual,
				int numeroPedagio, List<Aresta> arestas) {
			super();
			this.numeroCidade = numeroCidade;
			this.numeroEstradas = numeroEstradas;
			this.cidadeAtual = cidadeAtual;
			this.numeroPedagio = numeroPedagio;
			this.arestas = arestas;
		}

		public int getNumeroCidade() {
			return numeroCidade;
		}

		public void setNumeroCidade(int numeroCidade) {
			this.numeroCidade = numeroCidade;
		}

		public int getNumeroEstradas() {
			return numeroEstradas;
		}

		public void setNumeroEstradas(int numeroEstradas) {
			this.numeroEstradas = numeroEstradas;
		}

		public int getCidadeAtual() {
			return cidadeAtual;
		}

		public void setCidadeAtual(int cidadeAtual) {
			this.cidadeAtual = cidadeAtual;
		}

		public int getNumeroPedagio() {
			return numeroPedagio;
		}

		public void setNumeroPedagio(int numeroPedagio) {
			this.numeroPedagio = numeroPedagio;
		}

		public List<Aresta> getArestas() {
			return arestas;
		}

		public void setArestas(List<Aresta> arestas) {
			this.arestas = arestas;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + cidadeAtual;
			result = prime * result + numeroCidade;
			result = prime * result + numeroEstradas;
			result = prime * result + numeroPedagio;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Grafo other = (Grafo) obj;
			if (cidadeAtual != other.cidadeAtual)
				return false;
			if (numeroCidade != other.numeroCidade)
				return false;
			if (numeroEstradas != other.numeroEstradas)
				return false;
			if (numeroPedagio != other.numeroPedagio)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return String.format("%d %d %d %d", numeroCidade, numeroEstradas,
					cidadeAtual, numeroPedagio);
		}
	}

	/**
	 * 
	 * @author Diovani Bernardi da Motta Data: 27/08/2016 Classe que tem a
	 *         responsabilidade de implementar o model usado para representar as
	 *         arestas(também chamadas de estradas) que ligam uma cidade a outra
	 */
	public static class Aresta implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 3692215515698831975L;
		private int cidadeX;
		private int cidadeY;
		private int visitado;

		public Aresta() {
			super();
		}

		public Aresta(int cidadeX, int cidadeY) {
			super();
			this.cidadeX = cidadeX;
			this.cidadeY = cidadeY;
		}

		public Aresta(int cidadeX, int cidadeY, int visitado) {
			super();
			this.cidadeX = cidadeX;
			this.cidadeY = cidadeY;
			this.visitado = visitado;
		}

		public int getCidadeX() {
			return cidadeX;
		}

		public void setCidadeX(int cidadeX) {
			this.cidadeX = cidadeX;
		}

		public int getCidadeY() {
			return cidadeY;
		}

		public void setCidadeY(int cidadeY) {
			this.cidadeY = cidadeY;
		}

		public int getVisitado() {
			return visitado;
		}

		public void setVisitado(int visitado) {
			this.visitado = visitado;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + cidadeX;
			result = prime * result + cidadeY;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Aresta other = (Aresta) obj;
			if (cidadeX != other.cidadeX)
				return false;
			if (cidadeY != other.cidadeY)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return String.format("%d %d", cidadeX, cidadeY);
		}

		public String visitado() {
			return String.format("%d ", visitado);
		}
	}

	public static abstract class Fila {

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

	public static class ProcessarFila extends Fila {

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

	public static void main(String[] args) {
		// representação dos valores de entrada do exemplo 1
		GrafoAbstractFactory grafoAbstractFactory1 = new GrafoAbstractFactory();
		Scanner scanner = new Scanner(System.in);
		int c = scanner.nextInt();
		int e = scanner.nextInt();
		int l = scanner.nextInt();
		int p = scanner.nextInt();
		scanner.nextLine();
		
		Grafo grafo = grafoAbstractFactory1.getGrafo(c, e, l, p);
		grafoAbstractFactory1.grafo(grafo);
		List<Aresta> arestas = grafoAbstractFactory1.getArestas();
		grafo.setArestas(arestas);
		//grafoAbstractFactory1.print(arestas);
		// representa as saidas referente ao exemplo 1
		grafoAbstractFactory1.largura(grafo);
	}
}
