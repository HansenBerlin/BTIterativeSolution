class CustomNode 
{     
	int key; 
    CustomNode leftChild;
    CustomNode rightChild;      
    
    CustomNode newNode(int key) 
    { 
        CustomNode node = new CustomNode(); 
   
        node.key = key; 
   
        node.leftChild = null; 
        node.rightChild = null; 
   
        return node; 
    }	
} 

