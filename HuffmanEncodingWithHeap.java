public class HuffmanEncodingWithHeap{
  MinHeap<HuffmanNode> buildForest (int[] frequencies){

    
    MinHeap<HuffmanNode> forest = new MinHeap<>();
  
    for (int ascii = 0;  ascii< frequencies.length; ascii ++)
      if (frequencies[ascii] > 0){
        HuffmanNode newNode = new HuffmanNode((char) ascii, frequencies[ascii]);
        forest.insert(newNode);
      }
    
    return forest;
  }

  



  public HuffmanNode buildTree(MinHeap<HuffmanNode>forest){ 
    while (forest.size()>1){
      HuffmanNode t1 = forest.removeMin();
      HuffmanNode t2 = forest.removeMin();
      HuffmanNode newNode = new HuffmanNode(t1.getFrequency() + t2.getFrequency());
      newNode.setLeft(t1);
      newNode.setRight(t2);
      forest.insert(newNode);
    }
    
    return forest.getMin();
  }

    
  
}
