
package abctreeapp;
import java.io.*;
import java.util.*;

public class AbcTree {
    
public AbcNode root;             // first node of tree  
   
// -------------------------------------------------------------  
    public AbcTree() // constructor  
    {  
        root = null;  
    }            // no nodes in tree yet  
// -------------------------------------------------------------  
   
// -------------------------------------------------------------  
    public AbcNode insert(char character,AbcNode root) {
        if(root==null){
            AbcNode newNode = new AbcNode();  
            AbcNode newRootNode = new AbcNode();  
            newRootNode.sData = '+';  
            root = newRootNode ;  
            root.leftChild = newNode;  
            root.leftChild.sData = character;
            return root;
        }else{
            if(character < root.leftChild.sData){
                root.leftChild = insert(character,root.leftChild);
                return root;
            }else{
                root.rightChild = insert(character,root.rightChild);
                return root;
            }
        }
         
    }  
   
// -------------------------------------------------------------  
// -------------------------------------------------------------  
   
 public void displayTree() {  
        Stack globalStack = new Stack();  
        globalStack.push(root);  
        int nBlanks = 32;  
        boolean isRowEmpty = false;  
        System.out.println(  
                "......................................................");  
        while (isRowEmpty == false) {  
            Stack localStack = new Stack();  
            isRowEmpty = true;  
   
            for (int j = 0; j < nBlanks; j++) {  
                System.out.print(' ');  
            }  
   
            while (globalStack.isEmpty() == false) {  
                AbcNode temp = (AbcNode) globalStack.pop();  
                if (temp != null) {  
                    System.out.print(temp.sData);  
                    localStack.push(temp.leftChild);  
                    localStack.push(temp.rightChild);  
   
                    if (temp.leftChild != null 
                            || temp.rightChild != null) {  
                        isRowEmpty = false;  
                    }  
                } else {  
                    System.out.print("--");  
                    localStack.push(null);  
                    localStack.push(null);  
                }  
                for (int j = 0; j < nBlanks * 2 - 2; j++) {  
                    System.out.print(' ');  
                }  
            }  // end while globalStack not empty  
            System.out.println();  
            nBlanks /= 2;  
            while (localStack.isEmpty() == false) {  
                globalStack.push(localStack.pop());  
            }  
        }  // end while isRowEmpty is false  
        System.out.println(  
                "......................................................");  
    }  // end displayTree()---------------------------------  
 public AbcNode[] ShowTree(String initString)
		{ 
			root = null;
			initString = "ABCDEFG";
			//Parse the input string into an array of single-letter nodes
			AbcNode[] nodeArray = new AbcNode[initString.length()];
			for(int i = 0; i < initString.length(); i++)
			{
				nodeArray[i] = new AbcNode();
				nodeArray[i].sData = initString.charAt(i);
			}
			
			//Generate "+" nodes and add children iteratively
			AbcNode plusNode = new AbcNode();
			plusNode.sData = '+';
			plusNode.leftChild = nodeArray[0];
			plusNode.rightChild = nodeArray[1];
			
			for(int j = 2; j < nodeArray.length; j++)
			{
				AbcNode newNode = new AbcNode();
				newNode.sData = '+';
				newNode.leftChild = plusNode;
				newNode.rightChild = nodeArray[j];
				plusNode = newNode;
			}
			root = plusNode;
                        return nodeArray;
		}
  public void traverse(int traverseType)
	{
		switch(traverseType)
		{
		case 1: System.out.print("\nPreorder traversal: ");
				preOrder(root);
				break;
		case 2: System.out.print("\nInorder traversal: ");
				inOrder(root);
				break;
		case 3: System.out.print("\nPostorder traversal: ");
				postOrder(root);
				break;
		}
		System.out.println("");
	}
	
	private void preOrder(AbcNode localRoot)
	{
		if(localRoot != null)
		{
			System.out.print(localRoot.sData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	private void inOrder(AbcNode localRoot)
	{
		if(localRoot != null)
		{
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.sData + " ");
			inOrder(localRoot.rightChild);
		}
	}
	
	private void postOrder(AbcNode localRoot)
	{
		if(localRoot != null)
		{
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.sData + " ");
		}
	}
}  // end class Tree  
