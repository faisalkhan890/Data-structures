public class Node
{
    private static final int ORDER = 4;
    private int numItems;
    private Node parent;
    private Node childArray[] = new Node[ORDER];
    private ItemData itemArray[] = new ItemData[ORDER-1];

    // connect child to this node
    public void connectChild(int childNum, Node child)
    {
        childArray[childNum]    = child;
        if(child != null)
            child.parent = this;
    }

    // disconnect child from this node, return it
    public Node disconnectChild(int childNum)
    {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    public Node getChild(int childNum)
    {
        return childArray[childNum];
    }

    public Node getParent()
    {

        return parent;
    }

    public boolean isLeaf()
    {
        return (childArray[0]==null);// returns true or false
    }

    public int getNumItems()
    {
        return numItems;
    }

    public ItemData getItem(int index)   // get DataItem at index
    {
        return itemArray[index];
    }

    public boolean isFull()
    {
        return (numItems==ORDER-1);// returns true or false
    }


    public int insertItem(ItemData newItem)
    {
        // if node is not full
        numItems++;                          // will add 1 to num items
        double newKey = newItem.dData;       // key of new item

// Should start this for loop at numItems-1, rather than ORDER -2

        for(int j=ORDER-2; j>=0; j--)        // start on right,
        {                                 //    examine items
            if(itemArray[j] == null)          // if item null,
                continue;                      // go left one cell
            else                              // not null,
            {                              // get its key
                double itsKey = itemArray[j].dData;
                if(newKey < itsKey)            // if it's bigger
                    itemArray[j+1] = itemArray[j]; // shift it right
                else
                {
                    itemArray[j+1] = newItem;   // insert new item
                    return j+1;                 // return index to
                }                           //    new item
            }  // end else (not null)
        }  // end for                     // shifted all items,
        itemArray[0] = newItem;              // insert new item
        return 0;
    }  // end insertItem()

    public ItemData removeItem()        // remove largest item
    {
        // assumes node not empty
        ItemData temp = itemArray[numItems-1];  // save item
        itemArray[numItems-1] = null;           // disconnect it
        numItems--;                             // one less item
        return temp;                            // return item
    }

    public String displayNode()           // format "/24/56/74/"
    {
        String ret = "";
        for(int j=0; j<numItems; j++)
        {
            ret += itemArray[j].displayItem();
        }// "/56"
        return (ret+"/   ");         // final "/"
    }
}
