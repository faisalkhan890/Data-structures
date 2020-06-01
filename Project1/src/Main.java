

// importing the util package
import java.util.*;




public class Main // the main class


{




    static class Node
    {

        int key;

        Node lNode,rNode;

        private Node(int key)
        {

            this.key = key;

            lNode = null;

            rNode = null;

        }

    }



    public static void insertFunc(Node root,int key){

        Random rand = new Random();

        int number = rand.nextInt(Globals.BOUND_OF_RANDOM);

        if (number == 0)
        { //insert in left sub tree with 0.5 probability

            if (root.lNode!=null)
            {

                insertFunc(root.lNode,key);

                return;

            }

            else
                {

                Node tempVar = new Node(key);

                root.lNode = tempVar;

                return;

                }



        }

        else
            {

            if (root.rNode!=null)
            {

                insertFunc(root.rNode,key);

                return;

            }

            else
                {

                Node tempVar = new Node(key);

                root.rNode = tempVar;

                return;

                }

        }

    }

    /*Check if max key in left subtree is less than current key and min key in right subtree is greater than current key*/

    static boolean checkingrderBST(Node root) {

        return isBST(root, Integer.MIN_VALUE,

                Integer.MAX_VALUE);

    }

    /* Returns true if the given tree is a BST*/

    static boolean isBST(Node node, int min, int max) //checking if binary search tree

    {

        // if tree is empty then it is BST therefore returns true

        if (node == null)

            return true;

        // returns false if the node violates the min/max boundaries

        if (node.key < min || node.key > max)

            return false;

// else check the subtrees using recursion by tightening the min/max constraints */

// Allowing only distinct values

        return (isBST(node.lNode, min, node.key-1) &&

                isBST(node.rNode, node.key+1, max));

    }

    static class Height{

        int height=0;

    }

    static int heightOfTree(Node node)

    {

        // base case tree is if tree is empty
        if (node == null)

            return 0;

// If tree is not empty then add 1 to left and right heghts

        return 1 + Math.max(heightOfTree(node.lNode), heightOfTree(node.rNode));

    }

    static boolean checkAVLProperty(Node root,Height heightOfTree){

        // If tree is empty then returning true

        if (root == null)

        {

            heightOfTree.height = 0;

            return true;

        }

        /* Get heights of left and right sub trees */

        Height lheight = new Height();

        Height rheight = new Height();

        boolean left = checkAVLProperty(root.lNode, lheight);

        boolean right = checkAVLProperty(root.rNode, rheight);

        int leftheight = lheight.height;

        int rightheight = rheight.height;

/* Height of current node is max of heights of

left and right subtrees plus 1*/

        heightOfTree.height = (leftheight > rightheight? leftheight: rightheight) + 1;

/* If difference between heights of left and right

subtrees is more than 2 then this node is not balanced

so return 0 */

        if (Math.abs(leftheight - rightheight)>=2)

            return false;

/* If this node is balanced and left and right subtrees

are balanced then return true */

        else

            return left && right;

    }



    public static void main(String[] args) {

        Random rand = new Random();

        int number = rand.nextInt(Globals.BOUND_OF_TREE);

        Node root = new Node(number);

        // make an array of length of specific length to check whether the random number
        // generated is unique or has been generated earlier
        int array[] = new int[Globals.BOUND_OF_TREE];

        array[number]=1;

        for (int i=0;i<Globals.INSERT_KEYS;i++){ //insert 10 more keys in the BST

            while (true){ //generate a random number that has not been generated earlier

                number = rand.nextInt(Globals.BOUND_OF_TREE);

                if (array[number]==0)
                {

                    array[number] = 1; //mark that this number is generated now

                    break;

                }

            }

            insertFunc(root,number);

        }

        //outputting the result

        if (checkingrderBST(root)){

            System.out.println("It is following BST order property.");

        }

        else{

            System.out.println("It is not following BST order property.");

        }

        Height height = new Height();

        if (checkAVLProperty(root,height))
        {

            System.out.println("It is following AVL balance condition.");

        }

        else
            {

            System.out.println("It is not following AVL balance condition.");

            }

    }

}