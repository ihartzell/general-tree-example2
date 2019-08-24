/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

public class GenTree 
{

	// The root of the tree
	private GenNode rt;

	// generic tree default
	public GenTree() 
	{
		rt = null;
	}

	// The clear function (sets everything to empty)
	public void clear() 
	{
		rt = null;
	}

	// returns the root of the tree
	public GenNode root() 
	{
		return rt;
	}

	// creates a new root of a tree
	// Slight modification to take the two subnodes and make them an array
	public void newroot(String value, GenNode first, GenNode sib) 
	{
		GenNode subnodes[] = new GenNode[2];
		subnodes[0] = first;
		subnodes[1] = sib;
		
		clear();
		rt = new GenNode(value, null, subnodes);
		if (first != null)
		{
			first.setParent(rt);
		}
		if (sib != null)
			sib.setParent(rt);
	}

	// adds a child to the root of the tree
	// Slight modification to take the one subnode and make it an array
	public void newleftchild(String value) 
	{
		if (rt == null)						// then we are entering a root node
		{
			rt = new GenNode(value);
			return;
		}
		
		GenNode subnodes[] = new GenNode[1];
		subnodes[0] = rt.leftmostChild();
		
		GenNode temp = new GenNode(value, rt, subnodes);
		rt.insertFirst(temp);
	}

	// added this to the program, it prints a node
	public void printNode(GenNode rt)
	{
		System.out.println(rt.value());
	}
	
	// added this to the program from the book, it is used to print the node via preorder processing
	// Slight modification to have the rightSibling() call to the rt node instead of the temp node.
	public void preorder(GenNode rt, int level)
	{
		for (int i = 0; i < level; i++)
			System.out.print("\t");
		
		printNode(rt);
		
		if (! rt.isLeaf())
		{
			GenNode temp = rt.leftmostChild();
			while (temp != null)
			{
				preorder(temp, level+1);
				temp = rt.rightSibling();
			}
		}
	}
	
	// this calls the preorder processing
	public void print()
	{
		if (rt != null)	// it is not empty
			preorder(rt,0);
	}
	public void remove(String value)
	{
		
	}
	
}
