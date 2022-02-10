/***********************************************
  A recursive algorithm for insert
 ***********************************************/

class BST
{
   private Node root = null;
   
  private class Node
  {
    int data;
    Node left;
    Node right;
    
    public Node(int v)
    { data = v; left = right = null; };
  }
  
  
  private void insert(int val)
  {
    root = insert(root,val);
  }
  
  Node insert (Node r, int data)
  {
	if (r == null)
		return new Node(data);
	if (r.data > data)
	   r.left = insert (r.left, data);
	else
		r.right = insert (r.right, data);
    return r;
  }
  
    public void inord()
  {
    inord(root);
  }
  
  
  
  public void inord(Node p)
  {
    if(p != null)
    {
      inord(p.left);
      System.out.println(p.data);
      inord(p.right);
    }
  }
 
  public Node search(int key)
  {
    return search(root,key);
  }
 
  
 public Node search(Node r, int key)
{	
	if (r == null)
		return null;
	if (key < r.data)
		return search (r.left, key);
	if (key > r.data)
		return search (r.right, key);
	return r;
}

  
  
  
  
  public static void main(String[] args)
  {
    BST b = new BST();
    b.insert(25);
    b.insert(20);
    b.insert(45);
    b.insert(5);
    b.insert(15);
    b.insert(35);
    b.insert(55);
    b.insert(26);   
    Node val = b.search(35); 
    System.out.println("found "+ val.data);
    b.inord();
  }
  
}