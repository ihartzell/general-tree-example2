/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

/** Implementation of General Tree Nodes: Left Child/
    Right Sibling implementation (with parent pointer) */
public class GenNode 
{
	// The parent
	private GenNode parent;
	// The children
	private GenNode children[];
	private int size;
	private int maxSize;
	private int currentChild;

	/* Removed and put in the array children
	// The left child
	private GenNode leftchild;
	// the right child
	private GenNode rightsib;
	*/
	// the value of this node
	private String element;

	// General Node constructor
	public GenNode(String value) 
	{
		parent = null;
		element = value;
		children = null;
		size = maxSize = currentChild = 0;
	}

	/* Removed and replaced with the next constructor
	// General node constructor
	public GenNode(String value, GenNode par, GenNode leftc,
			GenNode rights) 
	{
		element = value;
		parent = par;
		leftchild = leftc;
		rightsib = rights;
	}
	 */
	
	// New constructor for children
	public GenNode(String value, GenNode par, GenNode children[])
	{
		element = value;
		parent = par;
		size = children.length;
		maxSize = size;
		currentChild = 0;
		this.children = new GenNode[size];
		for (int i = 0; i < size; i++)
		{
			this.children[i] =  children[i];
		}
	}
	
	// return the element
	public String value() 
	{
		return element;
	}

	// is the node a leaf
	public boolean isLeaf() 
	{
		return size == 0;
	}

	// return the parent
	public GenNode parent() 
	{
		return parent;
	}

	// return the left most child
	public GenNode leftmostChild() 
	{
		currentChild = 0;
		
		if (size == 0)
			return null;
		else
			return children[0];
	}

	// return the right most child
	public GenNode rightSibling() 
	{
		currentChild ++;
		
		
		if (currentChild < size)
			return children[currentChild];
		else
			return null;
	}

	// set the value of the element
	public void setValue(String value) 
	{
		element = value;
	}

	// set the value of the parent
	public void setParent(GenNode par) 
	{
		parent = par;
	}

	// insert a node as the left most
	public void insertFirst(GenNode it) 
	{
		// this is the default, I have coded the size to be the actual size of the array, you need to modify the code below
		// If the array is full
		//child_count =size;
		//capacity = maxSize
		if (maxSize == size )
		{
			maxSize = (maxSize + 1) * 2;
			GenNode[] temp = new GenNode[maxSize];
			
			for(int i = size ; i > 0; i--)
			{
				temp[i] = children[i-1];
			}
				children[0] = it;
				size = 1;
		}
		else
		{
			for(int i = size; i > 0; i--)
			{
				children[i] = children[i - 1];
			}
			children[0] = it;
			size = 1;
		}
		
	}

	// insert a node as the right node (move the existing right node to the right node of the new one)
	public void insertNext(GenNode it) 
	{
		// this is the default, I have coded the size to be the actual size of the array, you need to modify the code below		
		if (size == maxSize)
		{
			maxSize = (maxSize + 1) * 2;
			GenNode[] temp = new GenNode[maxSize];
			
			for(int i = 0; i < size; i++)
			{
				temp[i] = children[i];
				children = temp;
			}
		}
		
		GenNode n = it;
		
		children[size] = n;
		children[size].parent = this;
		size = size + 1;
	}

	// remove the left most node
	public void removeFirst() 
	{
		if (isLeaf())
			return;
		
		for (int i = 0; i < size -1; i++)
			children[i] = children[i+1];
		
		size--;
	}

	// remove the right most node
	public void removeNext() 
	{
		if (isLeaf())
			return;
		
		children[size] = null;
		
		size--;
	}
}
