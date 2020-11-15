package ex0;

import java.util.Collection;
import java.util.HashMap;
import java.util.*;




public class Graph_DS implements graph {
	private HashMap<Integer,node_data> map =  new HashMap<Integer,node_data> ();
	private static int counterEdge = 0 ;
	private static int counterMC= 0;


	public Graph_DS(){
		map = new HashMap<>();
		counterEdge = 0;
		counterMC = 0;
	}

	@Override
	/**
	 *  i using in contains key method and contains between the key that i am got to the keys that i have in the hashmap.
	 */
	public node_data getNode(int key) {
		if (map.get(key)== null) return null;

		return this.map.get(key);

	}

	@Override
	/** 
	 * i check with hasNi method if node1 is a neighbored of node2
	 */
	public boolean hasEdge(int node1, int node2) {
		if (map.get(node1).hasNi(node2))return true;
		else return false;
	}

	@Override
	/** 
	 * i using in the method put to add a node to the graph with the hashmap and i check before if the node exist .
	 */
	public void addNode(node_data n) {
		if (map.containsKey(n.getKey()))return;
		else 
			map.put(n.getKey(), n);
		counterMC ++ ;
	}

	@Override
	/** 
	 * i take the keys and whit the addNi method in Node i connect the keys  but i check before a some conditions.
	 */
	public void connect(int node1, int node2) {
		if ((!this.map.containsKey(node1)) || (!this.map.containsKey(node2)) || hasEdge(node1, node2))
			return;
		if((node1 == node2)&&(!hasEdge(node1,node2)))
			return;
		if((map.get(node1) ==null) || (map.get(node2) ==null) )
			return;
		if ((!this.map.containsKey(node1)) || (!this.map.containsKey(node2)) || hasEdge(node1, node2)) {
			return;
		}
		else {
			this.map.get(node1).addNi(this.map.get(node2));
			this.map.get(node2).addNi(this.map.get(node1));
			counterEdge++;
			counterMC ++;		    }
	}

	@Override
	/**
	  i return a collection whit values method;
	 */
	public Collection<node_data> getV() {
		return map.values();
	}

	@Override
	/**
	 i take the key and return whit getNi(that return collection ) a collection for this id.
	 */
	public Collection<node_data> getV(int node_id) {

		return map.get(node_id).getNi();
	}
	/** 
	 * before i removing i check if the node is exist.
	 * if the node exist i running on the graph (the hashmap) whit getV method that return me the Collection
	 * and i remove the node whit hashmap methods and i init the counters;
	 */
	@Override
	public node_data removeNode(int key) {
		if (!this.map.containsKey(key)) {
			return null;
		}
		else {
			node_data t= this.map.get(key);
			for (node_data node : this.getV(key)) {
				node.removeNode(t);
				counterMC++;
				counterEdge--;
			}
			map.remove(key);
			counterMC++;
			counterEdge--;
			return t;
		}
	}

	@Override
	/**
	 * before i removing edge i check that node1 and node2 exist and i check if the nodes is neighborhoods ,
	 * and then i use in the removeNode method (there i init the counters)
	 */
	public void removeEdge(int node1, int node2) {
		if (map.containsKey(node1) && map.containsKey(node2) && map.get(node1).hasNi(node2) ) {
			map.get(node2).removeNode(map.get(node1));
			counterMC++;

		}
	}


	@Override
	/**
	 * i use in size methods in hashmap
	 */
	public int nodeSize() {

		return map.size();
	}

	@Override
	/**
	 * i return the counter of edge
	 */
	public int edgeSize() {

		return counterEdge;
	}

	@Override
	/**
	 * i return the counter of modes
	 */
	public int getMC() {

		return counterMC;
	}

	// ********** in this method i will use in the BFS algorithm  *************
	public void setcounterEdge(int counterEdge) {
		this.counterEdge = counterEdge;
	}

	public void setcounterMC(int counterMC) {
		counterMC = counterMC;
	}

}
