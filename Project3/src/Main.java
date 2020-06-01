import java.io.*;                 // for I/O
import java.lang.Integer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //creating an object for the tree.
        Tree Tree234 = new Tree();

        //inserting values in a tree one by one.
        Tree234.insert(1);
        Tree234.insert(12);
        Tree234.insert(8);
        Tree234.insert(2);
        Tree234.insert(25);
        Tree234.insert(6);
        Tree234.insert(14);
        Tree234.insert(28);
        Tree234.insert(17);
        Tree234.insert(7);
        Tree234.insert(52);
        Tree234.insert(16);
        Tree234.insert(48);
        Tree234.insert(68);
        Tree234.insert(3);
        Tree234.insert(26);
        Tree234.insert(29);
        Tree234.insert(53);
        Tree234.insert(55);
        Tree234.insert(45);

        //displaying the tree
        Tree234.displayTree();

    }
}
