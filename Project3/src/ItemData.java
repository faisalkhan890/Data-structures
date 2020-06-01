public class ItemData
{
    public double dData;        // one data item
    //--------------------------------------------------------------
    public ItemData(double dd)  // constructor
    {
        dData = dd;
    }
    //--------------------------------------------------------------
    public String displayItem()   // display item, format "/27"
    {
        return ("/"+dData);
    }
//----------
}
