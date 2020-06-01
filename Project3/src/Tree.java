public class Tree
{
    String level0 = "";
    String level1 = "";
    String level2 = "";
    private Node root = new Node();            // make root node


    // insert a DataItem
    public void insert(double dValue)

// Performs the splits
// in a top-down (root -----> leaf) fashion.

    {
        Node currentNode = root;
        ItemData tempItem = new ItemData(dValue);

        while(true)
        {
            if( currentNode.isFull() )               // if node full,
            {
                split(currentNode);                   // split it
                currentNode = currentNode.getParent();    // back up
                // search once
                currentNode = getNextChild(currentNode, dValue);
            }  // end if(node is full)

            else if( currentNode.isLeaf() )          // if node is leaf,
                break;                            // go insert
                // node is not full, not a leaf; so go to lower level
            else
                currentNode = getNextChild(currentNode, dValue);
        }  // end while

        currentNode.insertItem(tempItem);       // insert new DataItem
    }  // end insert()
    // -------------------------------------------------------------
    public void split(Node thisNode)     // split the node
    {
        // assumes node is full
        ItemData itemB, itemC;
        Node parent, child2, child3;
        int itemIndex;

        itemC = thisNode.removeItem();    // remove items from
        itemB = thisNode.removeItem();    // this node
        child2 = thisNode.disconnectChild(2); // remove children
        child3 = thisNode.disconnectChild(3); // from this node

        Node newRight = new Node();       // make new node

        if(thisNode==root)                // if this is the root,
        {
            root = new Node();                // make new root
            parent = root;                    // root is our parent
            root.connectChild(0, thisNode);   // connect to parent
        }
        else                              // this node not the root
            parent = thisNode.getParent();    // get parent

        // deal with parent
        itemIndex = parent.insertItem(itemB); // item B to parent
        int n = parent.getNumItems();         // total items?

        for(int j=n-1; j>itemIndex; j--)          // move parent's
        {                                      // connections
            Node temp = parent.disconnectChild(j); // one child
            parent.connectChild(j+1, temp);        // to the right
        }
        // connect newRight to parent
        parent.connectChild(itemIndex+1, newRight);

        // deal with newRight
        newRight.insertItem(itemC);       // item C to newRight
        newRight.connectChild(0, child2); // connect to 0 and 1
        newRight.connectChild(1, child3); // on newRight
    }  // end split()

    // gets appropriate child of node during search for value
    public Node getNextChild (Node theNode, double theValue)
    {

// Should be able to do this w/o a loop, since we should know
// index of correct child already

        int j;
        // assumes node is not empty, not full, not a leaf
        int numItems = theNode.getNumItems();
        for(j=0; j<numItems; j++)          // for each item in node
        {                               // are we less?
            if( theValue < theNode.getItem(j).dData )
                return theNode.getChild(j);  // return left child
        }  // end for                   // we're greater, so
        return theNode.getChild(j);        // return right child
    }

   public void displayTree()

    {

        recDisplayTree(root, 0, 0);

            System.out.println("level0=\t\t\t\t\t\t\t" + level0);

            System.out.println("\nlevel1=\t\t\t\t\t" + level1);

            System.out.println("\nlevel2=  " + level2);

    }

    private void recDisplayTree(Node thisNode, int level, int childNumber)
    {

        // System.out.print("level="+level+" child="+childNumber+" ");

        // call ourselves for each child of this node
        int numItems = thisNode.getNumItems();
        if(level==0)
            level0 += thisNode.displayNode();// display this node
        else if(level==1)
            level1 += thisNode.displayNode();//
        else if(level==2)
            level2 += thisNode.displayNode();//
        for(int j=0; j<numItems+1; j++)
        {

            Node nextNode = thisNode.getChild(j);

            if(nextNode != null)
                recDisplayTree(nextNode, level+1, j);
            else
                return;
        }


    }  // end recDisplayTree()
    /*private void recDisplayTree(Node thisNode, int level, int childNumber)
    {
        System.out.print("level="+level+" child="+childNumber+" ");
        thisNode.displayNode();               // display this node

        // call ourselves for each child of this node
        int numItems = thisNode.getNumItems();
        for(int j=0; j<numItems+1; j++)
        {
            Node nextNode = thisNode.getChild(j);
            if(nextNode != null)
                recDisplayTree(nextNode, level+1, j);
            else
                return;
        }
    }  // end recDisplayTree()
    */
    /*public void displayTree()

   {
       printLevelOrder(root);
   }

      static void printLevelOrder(Node root)
     {
         int h = height(root);
         int i;
         for (i=1; i<=h; i++)
         {
             printGivenLevel(root, i);
             System.out.println();
         }
     }    void printGivenLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.println(root.data);
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }*/
}
