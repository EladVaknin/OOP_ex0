# OOP_ex0 - Undirected & Unweighted Graph

This is the first exercise in OOP course.
In this task we were asked to implement interfaces that display an weighted graph in Java.
we got the interfaces node_date , graph and graph_algoritem.

node_data (implement by Node) - displays the vertices in the graph and the actions that are performed on them.
The vertex receives a key, tag, and data.

graph (implement by Graph_DS) - which represents a weighted graph.

graph_algoritem (implements by Graph_Algo) - a class that receives a graph and on this graph do a number of functions that calculate distance, ways whit BFS algorithm.

 when i start the exercise i saw the we need to do things in O(1) and we neet to work whit Collections, so i chose to work whit Hashmap (methods - add ,size,values,remove,replace and more).
I used in Hashmap in Node and Graph_DS class.
in Graph_algo class i make a 2 BFS algoritems - one is boolean BFS for isConnect function that check if the graph is linking or not.
In the start i running on the graph whit Collection and i set all the nodes tags in 0 (that say we are not visited in the node),in the BFS i used in counter that has progressed when we visited a node finally i check if the counter equal to the number of the node size, if is equal the graph is linking like we learnd in the lession. 
. For shortestPath function i make the second BFS that save the parnt whit list and return the way from the source to the destenion , i used in boolean Hashmap that got a Integer and boolean word to know if we visited in node or not and i return the list
In shortestPathDist function we need to return the distance between the source to the destenion - i used in the list from shortestPath function.
in list we have a size method so i return the size -1 for the distance between the source to the destenion, because the list save the faster way (BFS) and if i return the list.size its the faster distance.



  
On the code I added above each function a description of what it does and what I used.


Links and information sources I used in this project:

https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
https://www.youtube.com/watch?v=oDqjPvD54Ss&t=184s
https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
https://docs.oracle.com/javase/8/docs/api/java/util/List.html



