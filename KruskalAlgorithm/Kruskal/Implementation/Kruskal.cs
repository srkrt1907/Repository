namespace Kruskal
{
    using System.Collections.Generic;
    using System.Linq;

    public class Kruskal : IKruskal
    {
        #region IKruskal

        IList<Edge> IKruskal.Solve(IList<Edge> graph, out int totalCost)
        {

            Edge[] _edge = new Edge[graph.Count];
            int i = 0;
            foreach(Edge edge in graph)
            {
                _edge[i] = edge;
                i++; 
            }

            object[] sortedPeople = Entities.Heap.Sort(_edge);
            IList<Edge> solvedGraph = new List<Edge>();
            totalCost = 0;

            foreach (Edge ed in sortedPeople)
            {
                Vertex root1 = ed.V1.GetRoot();
                Vertex root2 = ed.V2.GetRoot();

                if (root1.Name != root2.Name)
                {
                    totalCost += ed.Cost;
                    Vertex.Join(root1, root2);
                    solvedGraph.Add(ed);
                }
            }
            return solvedGraph;
        } 

        #endregion

    }
}