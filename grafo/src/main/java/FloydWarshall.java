public class FloydWarshall 
{
    private double[][] distTo;
    private DirectedEdge[][] edgeTo;


    public FloydWarshall(EdgeWeightedIntDigraph G)
    {
        int size = G.V();
        distTo = new double[size][size]; // distancia mas corta de i a j
        edgeTo = new DirectedEdge[size][size];  //ultima arista usada para conectar i j


        for(int i = 0; i < size; i++)   
        {
            for(int n = 0; n < size ; n++)
            {
                if(i == n) // (i==n) significa que es el mismo nodo, entoces asigno  0.0
                {
                    distTo[i][n] = 0.0;
                }
                else //sino le asigno positivo porque todavia no se conocen caminos
                {
                    distTo[i][n] = Double.POSITIVE_INFINITY; 
                }
            }

        }

        for(int i =0; i < size; i++) //cargar las aristas directas del grafo
        {   
            for(DirectedEdge e : G.adj(i))
            {
                distTo[e.from()][e.to()] = e.weight();
                edgeTo[e.from()][e.to()] = e;


            }

        }


        /*lo que hace este andidamiento de for es lo principal del alogirtmos,
         * pregunta si el peso de una arista es > al peso de la suma de dos otras aristas
         * si es asi lo relaja y guarda la suma de las dos aristas 
         * el edge regista la nueva arista si es que se cumple la condicion
         */

        for(int i = 0; i < size; i++)
        {
            for(int n = 0; n < size; n++)
            {
                for(int m = 0; m < size; m++)
                {
                    if(distTo[n][m] > distTo[n][i] + distTo[i][m])  

                    {
                        distTo[n][m] = distTo[n][i] + distTo[i][n];
                        edgeTo[n][m] = edgeTo[i][n];

                    }
                }
            }
    
        }





    }






















}
















