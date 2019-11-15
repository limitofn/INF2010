import java.util.*; 


public class Main 
{
   /**
     * Fonction principale
     */
   public static void main(String[] args) throws Exception
   {
      // Creer un monceau avec 22 éléments et un tableau équivalent
      int numItems = 22;
      BinaryHeap<Integer> heap = new BinaryHeap<Integer>(true);
      Integer [ ] items = new Integer[ numItems ];
      int i;
      int j;

      // En insérant les éléments un a un
      for( i = 11, j = 0; j != numItems; i = ( i + 37 ), j++ )
      {
	     heap.offer( i );
	     items[ j ] = i;
	     i %=  numItems;
      }

      // en construisant le monceau depuis le depart
      System.out.println("Monceau min contruit element par element:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(false);
      // en inserant les elements un a un
      for( Integer item : items)
	  heap.offer( item );

      // en construisant le monceau depuis le depart
      System.out.println("Monceau max contruit element par element:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(items,false);
      System.out.println("Monceau max contruit a partir d'un tableau:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(items,true);
      System.out.println("Monceau min contruit a partir d'un tableau:");
      System.out.println( heap.printFancyTree() );

      System.out.println();
      System.out.println("Affichage recursif:");
      System.out.println( heap.printFancyTree() );

      System.out.println("Affichage non recursif:");
      System.out.println( heap.nonRecursivePrintFancyTree() );

      System.out.println();
      System.out.println("Tableau d'origine:");
      System.out.println( printArray( items ) );
      
      BinaryHeap.heapSort( items );
      System.out.println("Tableau ordonne:");
      System.out.println( printArray( items ) );

      BinaryHeap.heapSortReverse( items );
      System.out.println("Tableau inversement ordonne:");
      System.out.println( printArray( items ) );


      /*
       * Ajouter appels pour repondre a la question
       **/
      System.out.println("\n__________________________________ \n\t TESTS D'IMPLANTATION" );

      //Test poll() sur BinaryHeap MIN
      PriorityQueue testQueue = new PriorityQueue<Integer>();
      for( Integer item : items)
         testQueue.offer( item );
      heap = new BinaryHeap<Integer>(true);
      for( Integer item : items)
         heap.offer( item );

      int tamponQueue = (int) testQueue.poll();
      int tamponHeap = heap.poll();

      Exception pollMin = new Exception("\nError : poll() on min not working properly \n\tHeap poll =" + tamponHeap + "\t Queue poll =" + tamponQueue);

      if(tamponHeap != tamponQueue)
         throw pollMin;
      else
         System.out.println("\nPollMin : OK");

      //Test poll() sur BinaryHeap MAX
      testQueue = new PriorityQueue<Integer>((x,y)->y-x);
      for( Integer item : items)
         testQueue.offer( item );
      heap = new BinaryHeap<Integer>(false);
      for( Integer item : items)
         heap.offer( item );

      tamponQueue = (int) testQueue.poll();
      tamponHeap = heap.poll();

      Exception pollMax = new Exception("\nError : poll() on max not working properly \n\tHeap poll =" + tamponHeap + "\t Queue poll =" + tamponQueue);

      if(tamponHeap != tamponQueue)
         throw pollMax;
      else
         System.out.println("\nPollMax : OK");

      //Test clear
      testQueue = new PriorityQueue<Integer>((x,y)->y-x);
      for( Integer item : items)
         testQueue.offer( item );
      heap = new BinaryHeap<Integer>(false);
      for( Integer item : items)
         heap.offer( item );

      testQueue.clear();
      heap.clear();

      Exception clearTest = new Exception("\nError : clear() not working properly\n\tHeap size =" + heap.size() + "\t Queue size =" + testQueue.size());
      if(testQueue.size() != (heap.size()))
         throw clearTest;
      else
         System.out.println("\nClear : OK");

      //Tests iterator
      heap = new BinaryHeap<Integer>(items,true);
      Iterator it = heap.iterator();
      //Test modification with offer
      try {
         heap.offer(Integer.MAX_VALUE);
         it.next(); //Should throw exception concurrentModificationException
      }catch(ConcurrentModificationException modification){
         System.out.println("\nConcurrenModificationException on iterator when using offer() : OK");
      }

      //Test modification with clear
      try {
         it = heap.iterator();
         heap.clear();
         it.next();
      }catch(ConcurrentModificationException modification)
      {
         System.out.println("\nConcurrenModificationException on iterator when using clear() : OK");
      }
      //Test modification with poll
      try {
         it = heap.iterator();
         heap.poll();
         it.next();
      }catch(ConcurrentModificationException modification)
      {
         System.out.println("\nConcurrenModificationException on iterator when using poll() : OK");
      }
   }

   private static <AnyType> String printArray(AnyType[] a)
   {
      String outputString = "";

      for(AnyType item : a)
      {
         outputString += item;
         outputString += ", ";
      }

      return outputString.substring(0,outputString.length()-2);
   }
}
