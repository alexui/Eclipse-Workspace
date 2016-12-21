import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
	public static void main(String[] args) throws Exception {
		/*
		 * Parametri generator de clustere:
		 * N - numarul de puncte generate.
		 * k - numarul de clustere generate.
		 * minRadius - raza minima a unui cluster generat.
		 * maxRadius - raza maxima a unui cluster generat.
		 *
		 * Parametri Kmeans:
		 * k - numarul de clustere ce trebuie identificate.
		 * maxIterations - numarul maxim de iteratii ce se vor executa.
		 *
		 * Sunteti incurajati sa modificati aceste valori pentru a observa
		 * comportarea algoritmului in cat mai multe cazuri.
		 */
		final int N = 1000;
		final int k = 5;
		final double minRadius = 0.0;
		final double maxRadius = 0.5;
		final int maxIterations = 100;

		ArrayList<Point> points = Generator.generate(N, k, minRadius, maxRadius);
		kmeans(points, k, maxIterations);
	}

	/**
	 * Atribuie fiecarui punct din setul primit indexul clusterului caruia apartine.
	 *
	 * @param points
	 *            setul de puncte ce trebuie clusterizat
	 * @param k
	 *            numarul de clustere
	 * @param iterations
	 *            numarul de iteratii dupa care algoritmul se opreste
	 */
	public static void kmeans(ArrayList<Point> points, int k, int iterations) {
		/* Initializam punctele cu UNKNOWN_CLUSTER. */
		for (Point point : points) {
			point.clusterIndex = Point.UNKNOWN_CLUSTER;
		}

		/* Construim un obiect Painter pentru a reprezenta vizual procesul. */
		Painter picasso = new Painter(points);

		/* Initializam centroizii. */
		ArrayList<Point> centroids = randomCentroids(points, k);

		/*
		 * TODO Algoritmul Kmeans:
		 * 1. Atribuiti fiecarui punct indexul celui mai apropiat centroid.
		 * 2. Recalculati pozitiile centroizilor. Noua pozitie a unui centroid
		 *    este centrul de masa al punctelor ce au fost marcate cu indexul lui
		 *    la pasul anterior. Pasii 1 si 2 se vor repeta de un numar finit de
		 *    ori (variablia iterations).
		 */
		int steps = iterations;
		while(steps>0){
			
			for(Point p:points){
				double min =Double.MAX_VALUE;
				int index=Point.UNKNOWN_CLUSTER;
				for(Point q : centroids)
				{
					double d = p.distanceTo(q);
					if(d<min){
						min = d;
						index = q.clusterIndex;
					}
				}
				p.clusterIndex=index;
			}
			
			centroids = kmeansppCentroids(points, k);
			
			steps--;
		}


		for (int i = 0; i < iterations; i++) {

			

			picasso.setPoints(points);
			picasso.setCentroids(centroids);

			/* Sleep 1s to give us a chance to take a look at the image. */
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Initializeaza aleator cei k centroizi in patratul [0, 1] x [0, 1].
	 *
	 * @param points
	 *            setul de date ce trebuie clusterizat (nu este folosit in aceasta functie)
	 * @param k
	 *            numarul de clustere
	 * @return
	 */
	static ArrayList<Point> randomCentroids(ArrayList<Point> points, int k) {
		ArrayList<Point> centroids = new ArrayList<Point>();

		/*
		 * TODO Construiti aleator cei k centroizi.
		 * Este indicat sa folositi campul clusterIndex pentru a retine
		 * indexul fiecarui cluster.
		 */
		for(int cl_index=0;cl_index<k;cl_index++){
			Random rand = new Random();
			double x = rand.nextDouble();
			double y = rand.nextDouble();
			centroids.add(new Point(x,y,cl_index));
		}
				
		return centroids;
	}

	/**
	 * Initializeaza cei k centroizi dupa metoda specifica Kmeans++.
	 *
	 * @param points
	 *            setul de date ce trebuie clusterizat
	 * @param k
	 *            numarul de clustere
	 * @return
	 */
	static ArrayList<Point> kmeansppCentroids(ArrayList<Point> points, int k) {
		/*
		 * TODO Implementati algoritmul de initializare a centroizilor specific Kmeans++.
		 * http://en.wikipedia.org/wiki/K-means%2B%2B#Initialization_algorithm
		 */
		ArrayList<Point> centroids = new ArrayList<Point>();

		ArrayList<ArrayList<Point>> clusters = new ArrayList<ArrayList<Point>>();
		for(int i=0;i<k;i++){
			clusters.add(i, new ArrayList<Point>());
		}
		
		
		for(Point p: points){
			clusters.get(p.clusterIndex).add(p);
		}
		
		
		for(int i=0;i<k;i++){
			double sum_x=0;
			double sum_y=0;
			for(Point p:clusters.get(i)){
				sum_x+=p.x;
				sum_y+=p.y;
			}
			centroids.add(new Point(sum_x/clusters.get(i).size(),sum_y/clusters.get(i).size(),i));	
		}
		

		return centroids;
	}
	
	static ArrayList<Point> kmeansppCentroids2(ArrayList<Point> points,ArrayList<Point> centroids, int k) {
		
		Random r = new Random();
		
		ArrayList<Point> new_centroids = new ArrayList<Point>();
		
		ArrayList<ArrayList<Point>> clusters = new ArrayList<ArrayList<Point>>();

		for(int i=0;i<k;i++){
			clusters.add(i, new ArrayList<Point>());
		}
		
		for(Point p: points){
			clusters.get(p.clusterIndex).add(p);
		}
		
		for (int i=0;i<centroids.size();i++){
			ArrayList<Double> distances = new ArrayList<Double>();
			for(Point p:clusters.get(i)){
				if(distances.size()==0)
					distances.add(p.distanceTo(centroids.get(p.clusterIndex)));
				else
					distances.add(p.distanceTo(centroids.get(p.clusterIndex))+distances.get(distances.size()-1));
			}
			
			double rand_val;
			if(distances.size()>0)
				rand_val = distances.get(0) + r.nextDouble() * (distances.get(distances.size()-1)-distances.get(0));
			else 
				rand_val = r.nextDouble();
			
			for(int j=0;j<distances.size();j++)
				if(rand_val < distances.get(j))
				{
					new_centroids.add(new Point(clusters.get(i).get(j).x,clusters.get(i).get(j).y,clusters.get(i).get(j).clusterIndex));
					break;
				}
			
		}
		
		return new_centroids;

	}
}

