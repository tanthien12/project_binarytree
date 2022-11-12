package binarytree;


public class tree {
	//duyet cay nhi phan LNR
	node Root;
	public void readtree(node Root)
	{
		if(Root!=null) {
			readtree(Root.left);
			System.out.printf(Root.key + " ");
			readtree(Root.right);
		}
	}
	// them node cay nhi phan
	public node addnode(node Root, int label)
	{
		node newnode= new node(label);
		if(Root==null)return newnode;
		if(label<Root.key)
			Root.left = addnode(Root.left, label);
		else
			Root.right = addnode(Root.right, label);
		return Root;
	}
	// tao cay nhi phan
	public node addtree(node Root, node newtree)
	{
		if(newtree==null)
			return Root;
		if(Root==null)
			return newtree;
		if(newtree.key<Root.key)
			Root.left= addtree(Root.left, newtree);
		else 
			Root.right= addtree(Root.right, newtree);
		return Root;
	}
	// Xoa node cay nhi phan
	
	/*public node delnode(node Root, int label)
	{
		if(Root!=null) 
			if(Root.key==label)
			{
				node right = Root.right;
				Root.right= null;
				Root = Root.left;
				Root = addtree(Root, right);
			}
			else if(label<Root.key)
				Root.left = delnode(Root.left, label);
			else 
				Root.right= delnode(Root.right, label);
		return Root;
	}*/
	/*
	public void NodeTheMang(node X, node Y) // Node Y la node the mang cho node can xoa
	{
		//duyet xoa ben trai nhat
		if(Y.left!=null)
		{
			NodeTheMang(X, Y.left); // tim ra node trai nhat
		}
		else
		{
			X.key = Y.key;
			X = Y;
			Y = Y.right;
		}
	}
	public void delnode1(node Root, int data)
	{
		if(Root==null) return;
		else
		{
			// neu nhu data nho hon goc
			if(data<Root.key)
				delnode1(Root.left, data); // duyet sang ben trai cua cay
			else if(data>Root.key)
				delnode1(Root.right, data); // duyet sang ben phai cua cay
			else // data == Root.key
			{
				node X = Root; // node x la node the mang
				if(Root.left==null)
					Root = Root.right;
				else if(Root.right==null)
					Root = Root.left;
				else //node can xoa la node co 2 con
				{
					NodeTheMang(X, Root.right);
				}
				// delete X;
			}
		}
	}
	*/
	//dem so node cua cay nhi phan
	public int countnode(node Root)
	{
		if(Root==null) return 0;
		else return (1+countnode(Root.left)+countnode(Root.right));
	}
	//dem so node la cay nhi phan
	public int countleaf(node Root)
	{
		if(Root==null) return 0;
		else if(Root.left==null && Root.right==null) return 1;
		else return countleaf(Root.left)+countleaf(Root.right);
	}
	//tim chieu cao cua cay nhi phan
	public int highttree(node Root)
	{
		if(Root==null) return 0;
		else if(Root.left!=null || Root.right!=null)
			if(highttree(Root.left)>highttree(Root.right))
				return 1 + highttree(Root.left);
			else return 1 + highttree(Root.right);
		else return 0;
	}
	// tim node ben trai nhat
	public node theleftmost(node Root)
	{
		if(Root==null) return null;
		else if(Root.left==null) return Root;
		else return theleftmost(Root.left);
	}
	// tim node ben phai nhat
	public node therightmost(node Root)
	{
		if(Root==null) return null;
		else if(Root.right==null) return Root;
		else return therightmost(Root.right);
	}
	// node cha cua node ben phai nhat
	public node parenttherightmost(node Root)
	{
		if(Root==null) return null;
		else if (Root.right==null) return null;
		else if (Root.right.right==null) return Root;
		else return parenttherightmost(Root.right);
	}
	// xoa node trong cay nhi phan
	public node deletenode(node Root, int label)
	{
		if(Root!=null) {
			if(Root.key==label)
			{
				if(Root.left==null) return Root.right;
				if(Root.right==null) return Root.left;
				node left = Root.left;
				node right = Root.right;
				node thethan = therightmost(Root.left);
				if(parenttherightmost(Root.left)!=null)
				{
					if(therightmost(Root.left).left!=null)
						parenttherightmost(Root.left).right= therightmost(Root.left).left;
					else parenttherightmost(Root.left).right=null;
				}
				else
				{
					thethan.right = right;
					return thethan;
				}
				thethan.left = left;
				thethan.right = right;
				return thethan;
			}
			else if(label<Root.key) Root.left = deletenode(Root.left, label);
			else Root.right = deletenode(Root.right, label);
		}
		return Root;
		
	}
	// tim kiem nhi phan
	public boolean findNode(node Root, int label)
	{
//		if(Root==null)
//			return false;
//		if(Root.key==label)
//			return true;
//		if(Root.key>label)
//			return findNode(Root.left, label);
//		else
//			return findNode(Root.right, label);
		if(searchNode(Root, label)!=null)
			return true;
		else
			return false;
	}
	public node searchNode(node Root, int label)
	{
		//if(Root == null) return null;
		if(Root== null || Root.key==label)
			return Root;
		if(Root.key>label)
			return searchNode(Root.left, label);
		else
			return searchNode(Root.right, label);
		
	}
	public void suanode(node Root, int label, int sua)
	{
		if(searchNode(Root, label)!=null)
		{
			this.searchNode(Root, label).key= sua;
			readtree(Root);
		}
		else
			System.out.println("Khong tim thay node can sua");
	}
	
}
