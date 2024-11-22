public class HuffmanEncodingWithHeap{
  
/**
this method creates a forest using the frequenciees array
  */
  MinHeap<HuffmanNode> buildForest (int[] frequencies){

    
    MinHeap<HuffmanNode> forest = new MinHeap<>(); //creates the forest

    
    for (int ascii = 0;  ascii< frequencies.length; ascii ++) //goes through through the ascii values and adds the values to the forest
      if (frequencies[ascii] > 0){
        HuffmanNode newNode = new HuffmanNode((char) ascii, frequencies[ascii]);
        forest.insert(newNode);
      }
    
    return forest;// returns the newly created forest
  }

  
/**
this method goes through a forest and turns it into a tree with one node as the base.
It goes through the forest, and takes the lowest 2 nodes and turns them into children
of a newly created node.
This repeats until there is only one node left, which is returned.
  */


  public HuffmanNode buildTree(MinHeap<HuffmanNode>forest){ 
    while (forest.size()>1){ //while there are at least 2 nodes in the forest, takes the lowest 2 
      HuffmanNode t1 = forest.removeMin();
      HuffmanNode t2 = forest.removeMin();
      
      HuffmanNode newNode = new HuffmanNode(t1.getFrequency() + t2.getFrequency());
      newNode.setLeft(t1);
      newNode.setRight(t2);
      forest.insert(newNode); // adds the newly created node back into the tree
    }
    
    return forest.getMin();
  }

    
  
}
