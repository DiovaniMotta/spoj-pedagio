import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Main processando = new Main();
        processando.processa();
       
        System.exit(0);
    }
    
    int[] busca(int[][] mapa, int pontoPartidaL, int numVertices) {
        int[] vetorVisitados = new int[numVertices];
                
        for (int i = 0; i < numVertices; i++) {
            vetorVisitados[i] = 0;
        }
        
        ArrayList<Integer> filaVisitados = new ArrayList<Integer>();
        filaVisitados.add(pontoPartidaL);
        
        int verticeAtual = 0;
        
        int inicioFila = 0;
        while (filaVisitados.size() != inicioFila) {
            verticeAtual = filaVisitados.get(inicioFila);
            
            for (int tentar = 0; tentar < numVertices; tentar++) {
                if (vetorVisitados[tentar] == 0 && mapa[verticeAtual][tentar] == 1) {
                    vetorVisitados[tentar] = vetorVisitados[verticeAtual]+1;
                    filaVisitados.add(tentar);
                }
            }
            inicioFila++;
        }    
        
        return vetorVisitados;
    }
   
    void processa() throws NumberFormatException, IOException {
        String line = "";
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caso = 0;
        while ((line = br.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            int qteCidades = Integer.parseInt(tokenizer.nextToken());
            int qteEstradas = Integer.parseInt(tokenizer.nextToken());
            int cidadePartida = Integer.parseInt(tokenizer.nextToken());
            int maxPedagio = Integer.parseInt(tokenizer.nextToken());
            
            if (qteCidades == 0 && qteEstradas == 0 && cidadePartida == 0 && maxPedagio == 0) {
                return;
            }
            
            int[][] matriz = new int[qteCidades][qteCidades];
            
            for (int i = 0; i < qteEstradas; i++) {
                line = br.readLine();
                tokenizer = new StringTokenizer(line);
                int a = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());
                
                matriz[a-1][b-1] = 1;
                matriz[b-1][a-1] = 1;
            }
           
            int[] vetorVisitados = busca(matriz, cidadePartida-1, qteCidades);
            
            caso++;
            System.out.println("Teste " + caso);
            boolean jaImprimi = false;
            for (int i = 0; i < qteCidades; i++) {
                if (vetorVisitados[i] != 0 && i != cidadePartida-1 && vetorVisitados[i] <= maxPedagio) {
                    if (jaImprimi) {
                        System.out.print(" ");    
                    }
                    System.out.print(i+1);
                    jaImprimi = true;
                }
            }
            System.out.println("\n");
        }
                               
        return;
    }
}