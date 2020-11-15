package ex0;

import java.util.*;



public class Graph_Algo implements graph_algorithms{


	graph graph = new Graph_DS ();


	@Override
	public void init(graph g) {
		this.graph = g ;
	}

	@Override
	/**
	 *  i create a new graph and i whit the Collection i running on the graph, 
	 *  and i copy the nodes.
	 *  after i copy the nodes and i init the counters(of edge and MC) whit the functions.
	 */
	public graph copy() {
		Graph_DS graphCopy = new Graph_DS();
		Collection <node_data> copy = graph.getV();
		for (node_data Node : copy) {
			Node t = new Node(Node);
			graphCopy.addNode(t);
		}
		Collection <node_data> copy2 = graph.getV();
		for (node_data Node : copy2) {
			for(node_data Ni : Node.getNi()){
				graphCopy.getNode(Node.getKey()).addNi(graphCopy.getNode(Ni.getKey()));
			}
		}
		graphCopy.setcounterEdge(this.graph.edgeSize());
		graphCopy.setcounterMC(this.graph.getMC());
		return graphCopy;
	}


	@Override
	/**
	 * in isConnect function i check before that we have a graph that is not null and he have more 0 node - 
	 * because if the condition is true so the node is connect to himself.
	 * after this check i use in Collection and running on all the graph and set to num 0 - that say that i not visit 
	 * in this node.
	 * after this i do the BFS algorithm and i init a counter , and when we visited a node the counter ++ ,
	 * finally i check if the num of the node == to the counter so the graph is linking.
	 */
	public boolean isConnected() {
		boolean flag = true; ;
		int v = graph.nodeSize();
		if (this.graph==null ||this.graph.nodeSize() <= 1) return flag;
		Collection<node_data> set = graph.getV(); 
		for (node_data n : set) {
			n.setTag(0);
		}
		Queue<Integer> queue = new LinkedList<>();
		int key= this.graph.getV().iterator().next().getKey();
		int counter = 0;
		queue.add(key);
		while (!queue.isEmpty()) {
			key= queue.poll();
			Collection<node_data> get = graph.getV(key); 
			if (get != null) {
				for (node_data b : get) {
					if (b.getTag() == 0) {
						counter ++ ;
						queue.add(b.getKey());
						b.setTag(1);
					}
				}
			}
		}
		if (v == counter) {
			flag = true;
		}else {
			flag = false;
		}
		return flag;
	}

	@Override
	/**
	 * i use in shortestPath (the next function) for this BFS.
	 * @param dis - because shortestPath return a list i use in list dis for return the distance
	 */
	public int shortestPathDist(int src, int dest) {
		if (dest == src){
			return 0;
		}
		List<node_data> dis = shortestPath(src,dest);
		if (dis == null){
			return -1;
		}
		else{
			return dis.size() - 1;
		}
	}

	@Override
	/**
	 * in this BFS i will use in boolean hashmap to know if i visited in node or not and to know the parent,
	 * and a list for to save the way.
	 * i start whit running on all the graph and set to false and after i add the source to the queue i init hem to true,
	 * i do the BFS algorithm and i use in setTag to init the the Key that changes.
	 */
	public List<node_data> shortestPath(int src, int dest) {
		Queue<Integer> queue = new LinkedList<>();
		HashMap<Integer, Boolean> parent= new HashMap<>();
		List<node_data> way = new ArrayList<>();   // for the way
		Collection <node_data> setGraph = graph.getV();
		for (node_data node : setGraph){
			parent.put(node.getKey(), false);
		}
		int Key=src;                         // i need to save him becuse i will rape him in the BFS.
		int Dest=dest;
		queue.add(Key);
		parent.replace(Key, true);                     // i visited on the source
		while (!queue.isEmpty() && !parent.get(dest)) {
			Key=queue.poll();
			Collection <node_data> onGraph = graph.getV(Key);
			for (node_data node : onGraph) {
				if (!parent.get(node.getKey())) {
					node.setTag(Key);
					parent.replace(node.getKey(), true);                // i visited
					queue.add(node.getKey());                           // i add to the queue
				}
			}
		}
		if (!parent.get(dest)) return null;
		while (Dest != src) {
			way.add(0,graph.getNode(Dest));
			Dest = graph.getNode(Dest).getTag();
		}
		way.add(0,graph.getNode(src));
		return way;
	}
}



