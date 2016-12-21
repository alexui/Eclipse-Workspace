/**
 * Proiectarea Algoritmilor, 2013
 * Lab 10: Flux Maxim
 * Andrei Parvu, andrei.parvu@cti.pub.ro
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Lab10 {

  /* Fisiere de intrare */
  final static String TASK_1_INPUT_FILE = "GraphBinary.in";
  final static String TASK_2_INPUT_FILE = "GraphDegree.in";

  /* Sursa si destinatia pentru flux */
  final static int flowSource = 0;
  final static int flowDest = 12;

  final static int NONE = -1;

  private static class Pair {
    int first, second;

    public Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    public String toString() {
      return first + " " + second;
    }
  }

  //nu se mai iau in calcul muchiile care nu exista si care simuleaza un flux
  public static ArrayList<Integer> bfs(Graph g, int source, int sink) {
    /* Ne vom folosi de vectorul de parinti pentru a spune daca un nod a fost
     * adaugat sau nu in coada. */
    ArrayList<Integer> parent = new ArrayList<Integer>(g.getSize());

    for (int i = 0; i < g.getSize(); ++i) {
      parent.add(NONE);
    }

    LinkedList<Integer> q = new LinkedList<Integer>();
    q.add(source);

    while (parent.get(sink) == NONE && q.size() > 0)
    {
      int node = q.get(0);
      q.remove(0);

      for (int i = 0; i < g.getSize(); ++i) {
        if (g.capacityMatrix[node][i] > 0 && parent.get(i) == NONE) {//daca capacitatea e mai mare ca 0 se poate adauga muchia
          parent.set(i, node);
          q.add(i);
        }
      }
    }

    /* Daca nu s-a atins destinatia, atunci nu mai exista drumuri de crestere. */

    if (parent.get(sink) == NONE) {
      return new ArrayList<Integer>(0);
    }

    /* Reconstituim drumul de la destinatie spre sursa. */
    ArrayList<Integer> path = new ArrayList<Integer>();
    for (int node = sink; ; node = parent.get(node)) {
      /* TODO - Adaugati nodul la drumul curent si verificati
       * conditia de oprire */
    	if(node!=NONE){
    		path.add(node);
    	}
    	else break; 
    }
    
    return path;
  }

  //satureaza drum de ameliorare
  public static int saturate_path(Graph g, ArrayList<Integer> path) {
    /* Niciodata nu ar trebui sa se intample asta pentru ca sursa si destinatia
     * sunt noduri distincte si cel putin unul dintre ele se afla in path. */
    if (path.size() < 2) {
      return 0;
    }

    /* Determinam fluxul maxim prin drum. */
    int flow = g.capacityMatrix[path.get(0)][path.get(1)];
    for (int i = 0; i < path.size() - 1; ++i) {
      int u = path.get(i), v = path.get(i + 1);

      /* TODO - Determinati fluxul in functie de capacitata muchiei (u, v) */
      if(g.capacityMatrix[u][v]<flow){			//se cauta capacitatea reziduala minima
    	  flow = g.capacityMatrix[u][v];
      }
      
    }

    /* Si il saturam in graf. */
    for (int i = 0; i < path.size() - 1; ++i) {
      int u = path.get(i), v = path.get(i + 1);

      /* TODO - Modificati fluxul in functie de capacitatea muchiei (u, v) */
      g.capacityMatrix[u][v]-=flow;
      g.capacityMatrix[v][u]+=flow;
      
    }

    /* Raportam fluxul cu care am saturat graful. */
    return flow;
  }

  public static int maxFlow(Graph g, int source, int sink) {
    int maxFlow = 0;

    /* Vom incerca in mod repetat sa determinam drumuri de crestere folosind
     * BFS si sa le saturam pana cand nu mai putem determina un astfel de drum in
     * graf. */
    while (true) {
      /* Determina drum de crestere. */
      ArrayList<Integer> new_path = bfs(g, source, sink);

      /* TODO - In functie de new_path determinati daca fluxul trebuie
       * marit sau trebuie iesit din while */
      
      if(new_path.size()==0)		//aceasta se produce cand nu exista cale pana in sink
    	  break;
      
      int flow = saturate_path(g,new_path);
      
      if ( flow == 0 )
    	  break;
      
      maxFlow +=flow;
    }
    
    return maxFlow;
  }

  public static void minCut(Graph g, int source, ArrayList<Pair> edgeSet) {
    /* Facem o parcurgere BFS din nodul sursa si punem nodurile atinse de
     * parcurgere in source_set. Toate celelalte noduri se vor afla in
     * sink_set. */

    ArrayList<Boolean> in_queue = new ArrayList<Boolean>();
    for (int i = 0; i < g.getSize(); ++i) {
      in_queue.add(false);
    }
    LinkedList<Integer> q = new LinkedList<Integer>();
    q.add(source);
    in_queue.set(source, true);

    /* Rulam BFS din sursa si marcam nodurile atinse. */
    while (q.size() > 0) {
      int node = q.get(0);
      q.remove(0);

      for (int i = 0; i < g.getSize(); ++i) {
        if (in_queue.get(i) == false && g.capacityMatrix[node][i] > 0) {
          in_queue.set(i, true);
          q.add(i);
        }
        else if(g.isSaturated(node, i) && g.isEdge(node, i)){
        	edgeSet.add(new Pair(node, i));
        }
        	
      }
    }

    /* TODO - In functie de marcajele obtinute de la BFS-ul anterior determinati
     * muchiile ce fac parte din taietura minima */
   
    
  }

  static void compute_path(Graph g,
                           int cur_node,
                           boolean[][] usedEdge,
                           ArrayList<Integer> path) {
    path.add(cur_node);

    /* TODO - Selctati o posibila urmatoare muchie care sa faca parte din
     * drumul curent si apelati recursiv compute_path */
    for (int i = 0; i < g.getSize(); ++i) {
        if(g.isSaturated(cur_node,i) && !usedEdge[cur_node][i]) {
            usedEdge[cur_node][i] = true;
            compute_path(g, i, usedEdge, path);
            break;
        }
  }
  }

  public static void disjointPaths(Graph g, int source, ArrayList<ArrayList<Integer>> paths) {
    boolean[][] usedEdge = new boolean[g.getSize()][g.getSize()];

    for (int i = 0; i < g.getSize(); ++i) {
      for (int j = 0; j < g.getSize(); ++j) {
        usedEdge[i][j] = false;
      }
    }

    for (int i = 0; i < g.getSize(); ++i) {
      if (g.isSaturated(source, i)) {
        ArrayList<Integer> new_path = new ArrayList<Integer>(g.getSize());
        new_path.add(source);

        /* Incercam sa determinam un drum ce pleaca catre sink pe directia
         * (source, i) */
        compute_path(g, i, usedEdge, new_path);

        paths.add(new_path);
      }
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    /* Creem graful din primul fisier de intrare */
    Graph g = new Graph(TASK_1_INPUT_FILE, Graph.Type.DIRECTED);

    /* Calculam fluxul maxim de date care poate fi suportat de retea
     * intre nodurile 0 si 12. */
    int flow = maxFlow(g, flowSource, flowDest);

    /* Calculam si afisam o taietura minimala a grafului. */
    ArrayList<Pair> edgeSet = new ArrayList<>();
    minCut(g, flowSource, edgeSet);
    System.out.println("The minimum cut associated with the flow yields:");
    for (Pair p : edgeSet) {
      System.out.println(p);
    }

    /* Printam un numar maximal de drumuri disjuncte intre aceleasi doua noduri
     * din graf. */
    System.out.println("Maximum number of disjoint paths from source to sink "
        + flow);
    System.out.println("A list a maximum number of disjoint paths from source to sink");

    ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    disjointPaths(g, flowSource, paths);
    for (int i = 0; i < paths.size(); i++) {
      System.out.print("Path " + (i + 1) + ": ");
      for (Integer node : paths.get(i)) {
        System.out.print(node + " ");
      }
      System.out.println();
    }

    /* Deschidem un fisier din care sa incarcam restrictiile pentru problem a
     * doua. */
    Scanner inputScanner = new Scanner(new File(TASK_2_INPUT_FILE));

    int nr_nodes = inputScanner.nextInt();

    /* Vom forma urmatorul graf:
               o1       i1
               o2       i2
               .        .
     source    .        .     sink
               .        .
               on       in

    In partea stanga vom controla gradul de iesire al fiecarui nod -
    capacitatea de la source la oi va fi numarul maxim de muchii ce pot iesi
    din oi, adica exact gradul de iesire pe care acel nod il poate avea

    In partea stanga vom controla gradul de intrare al fiecarui nod -
    capacitatea de la ii la sink va fi numarul maxim de muchii ce pot intra
    in ii, adica exact gradul de intrare pe care acel nod il poate avea.

    Pompand flux maxim, vom umple capacitatile, deci vom satisface conditiile
    pentru gradele de intrare si de iesire.
    */

    /* TODO - Creati-va structura de graph cu un numar de noduri corespunzatoare */
    
    Graph my_graph = new Graph(nr_nodes *2 + 2, Graph.Type.DIRECTED);
    for (int i = 1; i <= nr_nodes; ++i) {
      int in_degree = inputScanner.nextInt(),
          out_degree = inputScanner.nextInt();

      /* TODO - Adaugati muchiile corespunzatoare care sa reliefeze gradul de
       * intrare si de iesire al nodului curent */
      my_graph.addEdge(0, i, out_degree);
      my_graph.addEdge(nr_nodes+i, 2*nr_nodes+1, in_degree);
    }

    for (int i = 1; i <= nr_nodes; ++i) {
      for (int j = 1; j <= nr_nodes; ++j) {
        /* TODO - Adaugati muchiile corespunzatoare intre noduri */
    	  if(i!=j)
    		  my_graph.addEdge(i, nr_nodes+j, 1);
      }
    }

    /* TODO - Calculati fluxul maxim in graful creat */
    int flowMax = maxFlow(my_graph, 0, nr_nodes *2 + 1);    

    System.out.println("List of possible edges: ");

    for (int i = 1; i <= nr_nodes; ++i) {
      for (int j = 1; j <= nr_nodes; ++j) {
        /* TODO - Afisati muchiile gasite in urma algoritmului de flux */
        if(g.isSaturated(i, nr_nodes+j) && my_graph.isEdge(i, nr_nodes+j)){
        	System.out.println("("+i+","+j+")");
        }
      }
    }

  }
}
