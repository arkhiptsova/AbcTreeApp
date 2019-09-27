
package abctreeapp;
import java.io.*;
import java.util.*;

public class AbcNode {
    
   
    public char sData;              // data item (key)  
    //public double dData;           // data item  
    public AbcNode  leftChild;         // this node's left child  
    public AbcNode  rightChild;        // this node's right child  
   
    public void displayNode() // display ourself  
    {  
        System.out.print('{');  
        System.out.print(sData);  
        System.out.print(", ");  
        System.out.print("} ");  
    }  
}  // end class Node  
