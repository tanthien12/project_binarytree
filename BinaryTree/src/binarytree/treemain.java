package binarytree;

public class treemain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		tree T = new tree();
		//node Root = new node(51);	
		
		  // them node vao cay nhi phan
		  T.Root = T.addnode(T.Root, 55); 
		  T.Root = T.addnode(T.Root, 10); 
		  T.Root = T.addnode(T.Root, 6);
		  T.Root = T.addnode(T.Root, 56); 
		  T.Root = T.addnode(T.Root, 110); 
		  T.Root = T.addnode(T.Root, 15); 
		  T.Root = T.addnode(T.Root, 101); 
		  T.Root = T.addnode(T.Root, 66);
		  T.Root = T.addnode(T.Root, 76);
		 


		
		// duyet cay nhi phan
		System.out.println("Duyet cay theo LNR");
		T.readtree(T.Root);
		System.out.println();
		// xoa node cua cay nhi phan
		//T.Root= T.delnode(T.Root, 76);
		T.Root = T.deletenode(T.Root, 55);
		System.out.println("Cay sau khi xoa: ");
		T.readtree(T.Root);		
		
		System.out.println("\nDem node: "+T.countnode(T.Root));
		System.out.println("Dem la: "+T.countleaf(T.Root));
		System.out.println("chieu cao: "+T.highttree(T.Root));

		System.out.println("\nLa ben trai nhat: "+T.theleftmost(T.Root).key);
		System.out.println("La ben phai nhat: "+T.therightmost(T.Root).key);
		//Tim kiem node trong cay nhi phan
		System.out.println("Ket qua tim kiem: "+ T.findNode(T.Root, 220));
		// Sua node
		System.out.println("Sua node");
		T.suanode(T.Root,101 , 1030);
//		T.readtree(T.Root);
//		System.out.println();
		
	}

}
