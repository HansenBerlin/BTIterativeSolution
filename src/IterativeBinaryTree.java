import java.util.Stack;

class IterativeBinaryTree extends CustomNode 
{    
    public static CustomNode root;

    public IterativeBinaryTree() 
	{ 		 
    } 


    // Helferfunktion zum Erstellen des Trees, nicht weiter wichtig fürs Verständnis
    public void createTree(int[] addValues)
    {
        root = newNode(addValues[0]);

        for (int i = 1; i < addValues.length; i++) 
        {
            insertIterative(root, addValues[i]);             
        } 
    }	

    
    private void insertIterative(CustomNode root, int key) 
    {     
        int depth = 0;

        // Wir erstellen drei Nodeobjekte. 
        // 1. Den eigentlichen Knoten, der eingefügt werden soll
        // 2. einen Helferknoten, der immer die Position des Nodes annimmt, an der er sich im Baum befindet
        // 3. einen zweiten Helfer, der immer den letzten besuchten Elternnode repräsentiert
        CustomNode nodeToAdd = newNode(key); 
        CustomNode helperNode = root;   
        CustomNode lastNodeVisited = null; 

        // Hier passiert im Prinzip das Gleiche wie in der searchForKey Methode, also mal da gucken  
        while (helperNode != null) 
        { 
            lastNodeVisited = helperNode; 
             
            if (key < helperNode.key) helperNode = helperNode.leftChild; 
            else helperNode = helperNode.rightChild;

            depth++;
        }    

        // Und jetzt da wir ja durch das Ende der Schleife oben auf jeden Fall an einem Blatt angekommen sind
        // können wir den Node hinzufügen, je nach Größe rechts oder links.  
        if (key < lastNodeVisited.key) 
        {
            System.out.println(String.format("Added LEFT child on depth %d with a value of %d. Parent has a value of %d." 
                ,depth, key, lastNodeVisited.key));

            lastNodeVisited.leftChild = nodeToAdd; 
        }
        else 
        {
            System.out.println(String.format("Added RIGHT child on depth %d with a value of %d. Parent has a value of %d." 
                ,depth, key, lastNodeVisited.key));    

            lastNodeVisited.rightChild = nodeToAdd;     
        }
    } 


    public String searchForKey(int key) 
	{ 
        if(root == null) return "No root node found.";
        CustomNode helperNode = root;

        // Solange localroot (anfangs die Root des Trees) nicht null ist schaue jedes Mal ob der gesuchte
        // Wert größer ist als der derzeitige Wert des Nodes auf dem wir stehen oder kleiner. Besuche das entsprechende
        // Kind indem localroot zum Kind "gemacht" wird und von da aus weitergeht. Da der Baum beim erstellen sortiert wurde,
        // wird so der gesuchte Wert immer gefunden

        while (helperNode != null) 
        { 
			if (key > helperNode.key) helperNode = helperNode.rightChild; 
			else if (key < helperNode.key) helperNode = helperNode.leftChild; 
            else return key + " was found in the tree.";   
        } 
		return key + " could not be found in this tree."; 
    } 


    public void inorderSortingIterativeWithStack() 
    { 
        CustomNode currentPosition = root;   
        Stack<CustomNode> nodestack = new Stack<CustomNode>(); 
        
        
        if (root == null) return;   
        
        // Solange der untersuchte Node nicht null (also hier ein Child und Leaf ohne Werte/key) ist ODER der 
        // Stack Elemente enthält, läuft die Schleife. Abbruchbedingung ist also, dass der
        // Stack keine Elemente mehr enthält UND der untersuchte Node null ist
        while (currentPosition != null || nodestack.size() > 0) 
        { 
  
            // Laufe solange linksbündig, bis das linke Kind null ist. Jeden Durchlauf wird der zuletzt
            // besuchte Node auf den Stack gelegt (push), also quasi "gespeichert"
            while (currentPosition !=  null) 
            {                 
                nodestack.push(currentPosition); 
                currentPosition = currentPosition.leftChild; 
            } 
  
            // an dieser Stelle ist currentPosition null, sonst würde ja die Schleife oben noch laufen.
            // Nun wird diesem Objekt der Wert des oberen Objekts im Stack zugewiesen (dem letzten Node)
            // der nicht null war (also ein Elternnode). Zugleich wird das Element aus dem Stack gelöscht (pop)
            currentPosition = nodestack.pop(); 
  
            System.out.print(currentPosition.key + " "); 
  
            // Da nach dem ersten Durchlauf linksbündig alles abgegrast ist, geht es jetzt mit dem rechten Childnode/Leafs
            // des letzten Elternnodes weiter, dann von vorn also von da aus wieder linksbündig usw (weil wir ja immer noch
            // in der Schleife hängen)
            currentPosition = currentPosition.rightChild; 
        } 
    } 
} 

