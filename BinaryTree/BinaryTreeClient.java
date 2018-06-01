package BT;

public class BinaryTreeClient {
   // 50 true 25 true 12 false false false true 75 true 62 false false false
  //10 true 20 true 50 false false true 60 false false true 40  true 70 false false true 80 false false	
	public static void main(String[] args) {
		BinaryTree bt= new BinaryTree();
		BinaryTree other= new BinaryTree();
       
		System.out.println(bt.sumOfNodes());
		 System.out.println(bt.structurallyIdentical(other));
		   bt.LevelOrderNewLine();
		     bt.LevelOrderZZ(
		     bt.removeLeaves();
		      bt.display();
		        bt.root_to_leaf(60);
		      bt.sibling();
	          System.out.println(bt.levelArrayList());
		        bt.root_to_leaf(130);
		bt.display();
		System.out.println(bt.LCA(40, 70));
		
	}

}
