/*********************************************************************** 
Name: Moe
Number: Project #3

The BinaryTree class represent the tree based of the sign(s)
************************************************************************/
public class BinaryTree {
	
//	public static void main(String[] args) {
//		System.out.println(" root from main " + root);
//	}
	
	private static Node root = null;
	private static final int INDEX_ZERO = 0;
	private static final int INDEX_ONE = 1;
	private static final Character NEG_to_RIGHT = '-';
	private static final Character POS_to_LEFT = '+';

	
	private class Node {
		String data;
		Node left;
		Node right;
		
	
	public Node(String w) {
		data = w;
		left = right = null;
		}
	} // -----------------end of Node
	
	/**
	 * This is public overloaded method that insert string of word/letter in modified binary tree based off - and +.
	 * @param val word/ letter to insert
	 * @param sign either - or + 
	 */
	void insert(String val, String sign) {
		root = insert(root, val, sign);
		
	}
	
	/**
	 * This is the private recursive insert method that takes the root Node, data, and signs as an parameter.
	 * It first leave the root empty and then insert left if sign == + or right if sign == -
	 * @param r is root note passed as instance var of the class BinaryTree
	 * @param data words to be inserted.
	 * @param inputSign either - for right and + for left insertion.
	 * @return the Node inserted.
	 */
	private Node insert(Node r, String data, String inputSign) {
		if (inputSign.length() == INDEX_ZERO) {
			return new Node(data);
		}
		
		if (root == null ) {
			r = new Node("(Root left empty)");
		}
		
		if (inputSign.charAt(INDEX_ZERO) == NEG_to_RIGHT && r.right == null) {
			r.right = new Node(data);
		} 
		else if(inputSign.charAt(INDEX_ZERO) == POS_to_LEFT && r.left == null) {
			r.left = new Node(data);
		}
		else if(inputSign.charAt(INDEX_ZERO) == NEG_to_RIGHT) {
			insert(r.right, data, inputSign.substring(INDEX_ONE, inputSign.length()));
		}
		else {
			insert(r.left, data, inputSign.substring(INDEX_ONE, inputSign.length()));
		}
		return r;
	}
	
	/**
	 * Public overloaded method that takes string of sign(s) pluses and minuses and decode them based off the 
	 * binary tree that use insertion method.
	 * @param s string of sing(s)
	 * @return string word from the binary tree
	 */
	String decodeExpression(String s) {
		return decodeExpression(root, s);
	}
	
	/**
	 * This method is the private iterative decode expression that takes root Node, string of sign(s) as parameters.
	 * @param n is the root Node
	 * @param sings string of signs
	 * @return return the string word of the node data.
	 */
	private String decodeExpression(Node n, String sings) {
		
		while(sings.length() > 0) {
			if(sings.charAt(INDEX_ZERO) == NEG_to_RIGHT) {
				return decodeExpression(n.right, sings.substring(INDEX_ONE, sings.length()));
			}
			else {
				return decodeExpression(n.left, sings.substring(INDEX_ONE, sings.length()));
			}
		}
		return n.data;
	}
}
