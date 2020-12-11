// EAT. SLEEP. CODE. REPEAT. 
// Viel Spaß beim Bäume züchten.

public class Main 
{
    public static void main(String[] args)  
    {
        IterativeBinaryTree binaryTree = new IterativeBinaryTree();

        binaryTree.createTree(new int[]{1,3,65,77,8,33,4});

        binaryTree.searchForKey(77);
        binaryTree.searchForKey(100);

        binaryTree.createTree(new int[]{5,4,10,2,3,6,12,24,1,4});
        binaryTree.inorderSortingIterativeWithStack();

        RecursiveBTSort sorter = new RecursiveBTSort();
        sorter.printAllOrdersRecursively();

        binaryTree.createTree(new int[]{1,2,3,4,5,6,7,8,9});
        binaryTree.createTree(new int[]{9,8,7,6,5,4,3,2,1});
    }
}


