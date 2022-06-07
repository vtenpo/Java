package algorithms.datastructures.graphs;

public class Graph {
    private final int MAX_VERTS = 20;
    private int nVerts;
    private int[][] adjMat;
    private Vertex[] vertexList;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        
        for (int row = 0; row < MAX_VERTS; row++) {
            for (int col = 0; col < MAX_VERTS; col++) {
                adjMat[row][col] = 0;
            }
        }
    }
}