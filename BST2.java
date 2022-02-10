import java.util.*;
import java.io.*;

class BST2
{
  private Node root = null;
  ArrayList<String> al = new ArrayList<String>();
  class Node
  {
    String word;
    Node left;
    Node right;
    public Node(String st)
    {
      word = st;
      left = null;
      right = null;
    }
    public String toString()
    { 
      return word;
    }
  }
  
  public BST2()
  {
    read();
    show();
    buildTree();
    System.out.println("showing tree");
    showTree(root);
  }
  
  public void buildTree()
  {
  for(String s:al)
      recInsert(root,s);
  }
  
  public void recInsert (Node p, String item)
  {
    if(root==null)
      root = new Node(item);
    else if((p.word.compareTo(item)>0) && (p.left == null))
      p.left = new Node(item);
    else if((p.word.compareTo(item)<0) && (p.right == null))
      p.right = new Node(item);
    else if(p.word.compareTo(item)<0)
      recInsert(p.right,item);
    else
      recInsert(p.left,item);
  }

  public void iterInsert (Node p, String item)
  {
    if(root==null)
      root = new Node(item);
    else 
    {
      Boolean done = false;
      while(!done)
      {
        if((p.word.compareTo(item)>0) && (p.left == null))
        {
          p.left = new Node(item);
          done = true;
        }
        else if((p.word.compareTo(item)<0) && (p.right == null))
        {
          p.right = new Node(item);
          done = true;
        }
        else if(p.word.compareTo(item)<0) 
          p = p.right;
        else
          p = p.left;
      }
    }
  }


  public void show()
  {
    for(String s:al)
      System.out.println(s);
  }
  
  public void showTree(Node p)
  {
    if(p != null)
    {
      showTree(p.left);
      System.out.println("  " + p);
      showTree(p.right);
    }
  }
  
  public void read()
  {
    try{
      Scanner s = new Scanner(new File("words.txt"));
      while(s.hasNextLine()){
        String word = s.nextLine();
        al.add(word);
      }
    }
    catch(Exception e) {}  
  }
  
  public static void main(String[] args)
  {
    new BST2();
  }
 
}

