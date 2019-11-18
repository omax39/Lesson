package ru.khachalov.structandalgorithms.orderarrays;

// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public OrdArray(int max)          // constructor
      {
      a = new long[max];             // create array
      nElems = 0;
      }
   //-----------------------------------------------------------
   public int size()
      { return nElems; }
   //-----------------------------------------------------------
   public long getVal(int index){
      if (index < nElems){
         return a[index];
      }
      return nElems;
   }

   public long[] merge(OrdArray arr1, OrdArray arr2){
      for (int i = 0; i < arr1.size(); i++){
         for (int j = 0; i < arr2.size(); j++){
            if (arr1.getVal(i) < arr2.getVal(j)){
               insert(arr1.getVal(i));
               break;
            } else {
               insert(arr2.getVal(j));
               break;
            }
         }
      }
      for (int k = arr1.size(); k < arr2.size(); k++){
         insert(arr2.getVal(k));
      }
      return a;
   }

   public int find(long searchKey)
      {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;

      while(true)
         {
         curIn = (lowerBound + upperBound ) / 2;
         if(a[curIn]==searchKey)
            return curIn; // found it
         else if(lowerBound > upperBound)
            return upperBound + 1;             // can't find it
         else                          // divide range
            {
            if(a[curIn] < searchKey)
               lowerBound = curIn + 1; // it's in upper half
            else
               upperBound = curIn - 1; // it's in lower half
            }  // end else divide range
         }  // end while
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      int currIn = find(value);
      for(int k=nElems; k>currIn; k--)    // move bigger ones up
         a[k] = a[k-1];
      a[currIn] = value;                  // insert it
      nElems++;                      // increment size
      }  // end insert()
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j = find(value);
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move bigger ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------
   }  // end class OrdArray
