package ex0;

import java.util.Collection;
import java.util.HashMap;


public class Node implements node_data {
	/**
	 i will use in hashmap for the node because we need to do remove and add in O(1) and we need to make the collection.
	 */
	private static int counter = 0 ;   
	private	int key; 
	private String info;
	private int tag;
    private HashMap<Integer,node_data> map =  new HashMap<Integer,node_data> ();
    
    /**
     * default constructor.
     * the counter its for the place in the hashmap
     */
    public Node () {
	  this.key = counter;  
	  counter ++ ; 
	  info = "";
	  tag = 0;
	  map =  new HashMap<Integer,node_data> (); 
	  
     }
    /** 
     * copy constructor
     * @param p
     */
    public Node (node_data p){
    	map = new HashMap<>();
        this.key = p.getKey();
        this.info = p.getInfo();
        this.tag = p.getTag();
   
    }
    // constructor
	public  Node (int key ) {
		this.key = key ;
	}
	@Override
	public int getKey() {

		return this.key;
	}

	@Override
	public Collection<node_data> getNi() {

		return map.values();
	}

	@Override
	public boolean hasNi(int key) {
		if (map.containsKey(key)) return true;
		return false;
	}

	@Override
	public void addNi(node_data t) {
		if (t == null || t.getKey() == this.getKey()) return; 
		else {
			map.put(t.getKey(),t) ;
		}
	}

	@Override
	public void removeNode(node_data node) {
		if(node != null) {
     map.remove(node.getKey());
		}
	}

	@Override
	public String getInfo() {

		return this.info;
	}

	@Override
	public void setInfo(String s) {
         this.info = s;
	}

	@Override
	public int getTag() {

		return this.tag;
	}

	@Override
	public void setTag(int t) {
         this.tag =t;
	}

}
