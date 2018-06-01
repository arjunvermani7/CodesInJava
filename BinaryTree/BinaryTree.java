package BT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;
	private int size;

	public BinaryTree() {
		this.root = construct(new Scanner(System.in), null, false);
	}

	public Node construct(Scanner pop, Node parent, boolean ilc) {
		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {
			if (ilc) {
				System.out.println("Enter the data for left child" + parent.data);
			} else {
				System.out.println("Enter the data for right child " + parent.data);
			}
		}

		Node nn = new Node();
		int val = pop.nextInt();
		nn.data = val;
		this.size++;

		System.out.println("Is there a left child " + nn.data);
		boolean lc = pop.nextBoolean();

		if (lc) {
			nn.left = construct(pop, nn, true);
		}
		System.out.println("Is there a right child " + nn.data);
		boolean rc = pop.nextBoolean();
		if (rc) {
			nn.right = construct(pop, nn, false);
		}
		return nn;
	}

	public void display() {
		display(this.root);
	}

	public void display(Node node) {

		if (node == null) {
			return;
		}
		String str = "";
		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ".";
		}
		str += "-->";

		str += node.data;

		str += "<--";
		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public int sumOfNodes() {
		return sumOfNodes(this.root);
	}

	private int sumOfNodes(Node node) {
		if (node == null) {
			return 0;
		}
		int ans = 0;
		ans += sumOfNodes(node.left);
		ans += sumOfNodes(node.right);

		return node.data + ans;

	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		int lh = height(node.left);
		int rh = height(node.right);

		return Math.max(lh, rh) + 1;
	}

	public boolean structurallyIdentical(BinaryTree other) {
		return this.structurallyIdentical(this.root, other.root);
	}

	private boolean structurallyIdentical(Node tnode, Node onode) {
		if (tnode == null && onode == null) {
			return true;
		}
		if (tnode == null || onode == null) {
			return false;
		}
		boolean lr = structurallyIdentical(tnode.left, onode.left);
		boolean rr = structurallyIdentical(tnode.right, onode.right);

		return lr && rr;
	}

	public void LevelOrderNewLine() {
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();

		queue.addLast(this.root);

		while (!queue.isEmpty()) {
			Node k = queue.removeFirst();
			System.out.print(k.data + " ");

			if (k.left != null) {
				helper.addLast(k.left);
			}
			if (k.right != null) {
				helper.addLast(k.right);
			}
			if (queue.isEmpty()) {
				queue = helper;
				helper = new LinkedList<>();
				System.out.println();
			}
		}
	}

	public void LevelOrderZZ() {
		LinkedList<Node> stack = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();

		stack.addFirst(this.root);
		int cnt = 0;
		while (!stack.isEmpty()) {
			Node k = stack.removeFirst();
			System.out.print(k.data + " ");
			if (cnt % 2 == 0) {
				if (k.left != null) {
					helper.addFirst(k.left);
				}
				if (k.right != null) {
					helper.addFirst(k.right);
				}
			} else {
				if (k.right != null) {
					helper.addFirst(k.right);
				}
				if (k.left != null) {
					helper.addFirst(k.left);
				}

			}
			if (stack.isEmpty()) {
				stack = helper;
				helper = new LinkedList<>();
				cnt++;
			}
		}

	}

	public void removeLeaves() {
		this.removeLeaves(null, this.root, false);
	}

	private void removeLeaves(Node parent, Node child, boolean ilc) {
		
		

		if (child.left == null && child.right == null) {
			if (ilc) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			return;
		}
	    
		if(child.left!=null)
		removeLeaves(child, child.left, true);
       
		if(child.right!=null)
		removeLeaves(child, child.right, false);

	}

	public void sibling() {
		this.sibling(this.root);
	}

	private void sibling(Node node) {
		if (node == null) {
			return;
		}

		if (node.left != null && node.right == null) {
			System.out.print(node.left.data + " ");
		}

		if (node.left == null && node.right != null) {
			System.out.print(node.right.data + " ");
		}

		sibling(node.left);

		sibling(node.right);

	}
	
   public void root_to_leaf(int k) {
	  HeapMover mover = new HeapMover();
	  
	   root_to_leaf(this.root,0,k,"", mover);
   }
   private class HeapMover{
	   int  c=0;
   }
   public void root_to_leaf(Node node, int sum, int k, String asf, HeapMover mover) {
	    if(node == null ) {
	       if(sum==k && mover.c>0) {
	    	   System.out.println(asf);
	       }
	      mover.c=0;
	       return ;
	    }
	   
	     sum +=node.data;
	     mover.c++;
	   
	   root_to_leaf(node.left, sum, k,asf+node.data+" ",mover);
	   
	   root_to_leaf(node.right, sum, k, asf+node.data+" ", mover);
	   
   }
	public boolean isBalanced() {
		return this.isBalanced(this.root).isBalanced;
	}

	private BalancedPair isBalanced(Node node) {
	     if(node == null) {
	    	BalancedPair pair= new BalancedPair();
	    	pair.isBalanced=true;
	    	pair.height=-1;
	    	return pair;
	     }
		
		BalancedPair lh= isBalanced(node.left);
		BalancedPair rh= isBalanced(node.right);
		
		int lr= lh.height;
		int rr= rh.height;
		
		int bf= lr-rr;
		
		BalancedPair mr= new BalancedPair();
	    mr.height=Math.max(lr, rr)+1;
	    
	    if(lh.isBalanced && rh.isBalanced && Math.abs(bf)<=1) {
	    	mr.isBalanced=true;
	    }else {
	    	mr.isBalanced=false;
	    }
		return mr;
	}

	private class BalancedPair {
		int height;
		boolean isBalanced;
	}
	public ArrayList<ArrayList<Integer>> levelArrayList() {
       ArrayList<ArrayList<Integer>> mr= new ArrayList<>();
       
       LinkedList<Node> queue= new LinkedList<>();
       LinkedList<Node> helper= new LinkedList<>();
       queue.addLast(this.root);
       
     int cnt=0;
      ArrayList<Integer> rr= null;
       while(!queue.isEmpty()) {
    	   Node k= queue.removeFirst();
    	   if(cnt==0) {
    	    rr= new ArrayList<>();
    	   }
    	   rr.add(k.data);
    	   if(k.left!=null) {
    		   helper.addLast(k.left);
    		   
    	   }
    	   if(k.right!=null) {
    		   helper.addLast(k.right);
    		  
    	   }
    	   cnt++;
    	   if(queue.isEmpty()) {
    		   queue=helper;
    		   helper= new LinkedList<>();
    		   mr.add(rr);
    		   cnt=0;
    	   }
       }
       
	return mr;		
	}

//	public BinaryTree(int[] pre, int[] in) {
//		this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
//	}

//	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
//       if(plo>phi) {    
//    	   return null;
//       }
//       Node nn= new Node();
//       nn.data=pre[plo];
//       
//	   int si=-1;
//	   
//	   for(int i=ilo; i<=ihi; i++) {
//		   if(nn.data==in[i]) {
//			   si=i;
//			   break;
//		   }
//	   }
//	   int nel=si-ilo;
//	   
//	   nn.left= construct(pre, plo+1, plo+nel, in, ilo, si-1);
//	   nn.right= construct(pre, plo+nel+1, phi, in, si+1, ihi);
//	   return nn;
//	}
	public BinaryTree(int[] post, int[] in) {
		this.root = this.construct(post, 0, post.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] post, int plo, int phi, int[] in, int ilo, int ihi) {

		if(plo>phi) {
			return null;
		}
		
		Node nn= new Node();
		nn.data=post[phi];
		
		int si=-1;
		
		for(int i=ilo; i<=ihi; i++) {
			if(nn.data==in[i]) {
				si=i;
				break;
			}
		}
		int nel=si-ilo;
		
		nn.left= construct(post, plo, plo+nel-1, in, ilo, ilo+nel-1);
		
		nn.right= construct(post, plo+nel, phi-1, in, ilo+nel+1,ihi );
		
		return nn;
	}
	
	public int LCA(int d1, int d2) {
		
		Node ans=LCA(this.root,d1, d2);
		return ans.data;
	}
	
	public Node LCA(Node node, int d1, int d2) {
		if(node == null ) {
			return null;
		}
		if(node.data==d1 || node.data==d2) {
			return node;
		}
		Node left=  LCA(node.left, d1, d2);
		Node right= LCA(node.right, d1, d2);
		
		if(left!=null  &&  right!=null )
			 return node;
		
        return (left!=null) ? left : right;		
	}
	
	
	public int maxSubtree() {
		HeapMove mover= new HeapMove();
		
		return maxSubtree(this.root,mover);
	}
	
	private int maxSubtree(Node node, HeapMove mover) {
		if(node == null) {
			return 0;
		}
		int max=0;
		
		int left_sum=maxSubtree(node.left, mover);
		int right_sum=maxSubtree(node.right, mover);

		
		max=node.data+left_sum+right_sum;
		if(max>mover.ans) {
			mover.ans=max;
		}
		
		return mover.ans;
		
	}
	private class HeapMove{
		int ans=Integer.MIN_VALUE;
	}
	
	
}