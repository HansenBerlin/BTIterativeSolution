// kudos to danielbritten and andrew 1234 from G4G
// Sind hier einfach zum Testen eingefügt.

public class RecursiveBTSort 
{
    public void printAllOrdersRecursively()
    {
        System.out.println("\n");
        printPostorder(IterativeBinaryTree.root);
        System.out.println("\n");
        printInorder(IterativeBinaryTree.root);
        System.out.println("\n");
        printPreorder(IterativeBinaryTree.root);
        System.out.println("\n");
    }

    void printPostorder(CustomNode node) 
    { 
        if (node == null) 
            return; 
  
        printPostorder(node.leftChild);   
        printPostorder(node.rightChild);  
        System.out.print(node.key + " "); 
    } 
  
    void printInorder(CustomNode node) 
    { 
        if (node == null) 
            return; 
  
        printInorder(node.leftChild);   
        System.out.print(node.key + " ");   
        printInorder(node.rightChild); 
    } 
  
    void printPreorder(CustomNode node) 
    { 
        if (node == null) 
            return; 
  
        System.out.print(node.key + " ");   
        printPreorder(node.leftChild);   
        printPreorder(node.rightChild); 
    } 
}
