import java.util.*; 


public class BinaryHeap<AnyType extends Comparable<? super AnyType>> extends AbstractQueue<AnyType>
{
    private static final int DEFAULT_CAPACITY = 100;
    private int currentSize;      // Nombre d'elements
    private AnyType [ ] array;    // Tableau contenant les donnees (premier element a l'indice 1)
    private boolean min;
    private int modifications;    // Nombre de modifications apportees a ce monceau
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( boolean min ){
	    this.min = min;
	    currentSize = 0;
	    array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( AnyType[] items, boolean min ){
	    this.min = min;
		// COMPLETEZ
	    // invoquez buildMinHeap() ou buildMaxHeap() en fonction du parametre min;

        // On remplit le tableau interne a partir de 1
        array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];

        this.array[0] = null;
        for (int i = 1; i < items.length; i++){
            this.array[i] = items[i-1];
            this.currentSize++;
            }

        if(min)
            this.buildMinHeap(items);
        else
            this.buildMaxHeap(items);

    }
    
    public boolean offer( AnyType x ){
	    if (x == null)
	    throw new NullPointerException("Cannot insert null in a BinaryHeap");
	
	    if( currentSize + 1 == array.length )
	    doubleArray();
	
	    // COMPLETEZ
        this.array[++this.currentSize] = x;
        int position = this.currentSize;

        if(this.min)
            while(this.array[parent(position,true)] != null && this.array[position].compareTo(this.array[parent(position,true)]) < 0 ){
                swapReferences(position,parent(position,true));
                position = parent(position,true);
            }
        else
            while(this.array[parent(position,true)] != null && this.array[position].compareTo(this.array[parent(position,true)]) > 0){
                swapReferences(position,parent(position,true));
                position = parent(position,true);
            }
	
	    return true;
    }
    
    public AnyType peek(){
	    if(!isEmpty())
	    return array[1];
	
	    return null;
    }
    
    public AnyType poll(){
	    //COMPLETEZ
        //Methode qui permet de retirer l'element en tete du monceau
        if(isEmpty())
    	    return null;
        AnyType headElement = array[1];
        array[1] = array[currentSize--];
        if(min)
            percolateDownMinHeap(1, currentSize);
        else
            percolateDownMaxHeap(1, currentSize);
        return headElement;
    }
    
    public Iterator<AnyType> iterator(){
	    return new HeapIterator();
    }
    
    private void buildMinHeap(AnyType[] items){
	   //COMPLETEZ

       for(int i = this.currentSize/2; i> 0; i--){
           percolateDownMinHeap(i,this.currentSize);
       }
    }
    
    private void buildMaxHeap(AnyType[] items){
	    //COMPLETEZ
        for(int i = this.currentSize/2; i> 0; i--){
            percolateDownMaxHeap(i,this.currentSize);
        }
    }
    
    public boolean isEmpty(){
	    return currentSize == 0;
    }
    
    public int size(){
	    return currentSize;
    }
    
    public void clear(){
	    currentSize = 0;
	    modifications = 0;
	    array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    private static int leftChild( int i, boolean heapIndexing ){
        return ( heapIndexing ? 2*i : 2*i+1 );
    }

    private static int parent(int i,boolean heapIndexing){
        return ( heapIndexing ? i/2 : (i-1)/2 );
    }
    private static int rightChild(int i,boolean heapIndexing){
        return ( heapIndexing ? 2*i+1 : 2*i+2 );
    }
    
    private void swapReferences( int index1, int index2 ){
	    swapReferences(array, index1, index2);
    }
    
    private static <AnyType extends Comparable<? super AnyType>>
				    void swapReferences( AnyType[] array, int index1, int index2 ){
	
    	AnyType tmp = array[ index1 ];
	    array[ index1 ] = array[ index2 ];
	    array[ index2 ] = tmp;
    }
    
    @SuppressWarnings("unchecked")
    private void doubleArray() {
        AnyType[] newArray;

        newArray = (AnyType[]) new Comparable[array.length * 2];
        for (int i = 0; i < array.length; i++)
            newArray[i] = array[i];
        array = newArray;
    }
    
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMinHeap( int hole, int size ){
	     percolateDownMinHeap(array, hole, size, true);
    }
    
    /**
     * @param array   Tableau d'element
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>>
				    void percolateDownMinHeap( AnyType[] array, int hole, int size, boolean heapIndexing )
    {
	//COMPLETEZ -- application notes de cours
        int child;
        AnyType tempo = array[hole];

        for(;hole*2 <= size;hole = child){
            child = hole * 2;

            if (child != size &&
                    array[child + 1].compareTo(array[child]) < 0)
                child++; // fils de droite
            if (array[child].compareTo(tempo) < 0)
                array[hole] = array[child];
            else {
                break;
            }
        }
        array[ hole ] = tempo;

    }

    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMaxHeap( int hole, int size ){
	    percolateDownMaxHeap(array, hole, size, true);
    }
    
    /**
     * @param array         Tableau d'element
     * @param hole          Position a percoler
     * @param size          Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>> 
				    void percolateDownMaxHeap( AnyType[] array, int hole, int size, boolean heapIndexing ) {
        //COMPLETEZ -- Application du code des notes de cours
        int child;
        AnyType tempo = array[hole];

        for(;hole*2 <= size;hole = child){
            child = hole * 2;

            if (child != size &&
                    array[child + 1].compareTo(array[child]) > 0)
                child++; // fils de droite
            if (array[child].compareTo(tempo) > 0)
                array[hole] = array[child];
            else {
                break;
            }
        }
        array[ hole ] = tempo;
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSort( AnyType[] a )
    {
	    //COMPLETEZ
        for (int i = a.length/2; i >= 0; i--)
            percolateDownMinHeap(a, i, a.length, true);
        for (int i = a.length - 1; i > 0; i-- )
        {
            swapReferences(a,0,i);
            percolateDownMinHeap(a, 0, i, true);
        }
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSortReverse( AnyType[] a )
    {
	    //COMPLETEZ
        for (int i = a.length/2; i >= 0; i--)
            percolateDownMaxHeap(a, i, a.length, true);
        for (int i = a.length - 1; i > 0; i-- )
        {
            swapReferences(a,0,i);
            percolateDownMaxHeap(a, 0, i, true);
        }
    }
    
    public String nonRecursivePrintFancyTree()
    {
        //COMPLETEZ
	    String outputString = "";
	    String prefix = "";
	    int treeIndex = 1;
	    Boolean fromLeftChild = false;

	    while (treeIndex > 0)
	    {
	        outputString += prefix + "|__" + array[treeIndex] + "\n";

	        //Left child
            if (treeIndex*2 <= currentSize)
            {
                prefix += fromLeftChild ? "|  " : "   ";
                fromLeftChild = true;
                treeIndex *= 2;
            }
            //Next child from the last child print
            else if (fromLeftChild & treeIndex + 1 <= currentSize)
            {
                fromLeftChild = false;
                treeIndex++;
            }
            //If no more left child
            else {
                do {
                    treeIndex = treeIndex/2;
                    if (treeIndex > 0)
                        prefix = prefix.substring(0, prefix.length() - 3);
                } while(treeIndex % 2 != 0 & treeIndex > 0);

                if (treeIndex > 0)
                    treeIndex += 1;
                fromLeftChild = false;
            }
        }
	    return outputString;
    }
    
    public String printFancyTree()
    {
	return printFancyTree(1, "");
    }
    
    private String printFancyTree( int index, String prefix)
    {
        String outputString = "";

        outputString = prefix + "|__";

        if( index <= currentSize )
            {
                boolean isLeaf = index > currentSize/2;

                outputString += array[ index ] + "\n";

                String _prefix = prefix;

                if( index%2 == 0 )
                    _prefix += "|  "; // un | et trois espace
                else
                    _prefix += "   " ; // quatre espaces

                if( !isLeaf ) {
                    outputString += printFancyTree( 2*index, _prefix);
                    outputString += printFancyTree( 2*index + 1, _prefix);
                }
            }
        else
            outputString += "null\n";

        return outputString;
    }
    
    private class HeapIterator implements Iterator
    {
        int position;
        int modificationHeapIterator;

        //Constructeur du HeapIterator
        public HeapIterator(){
            this.modificationHeapIterator = modifications;
            this.position = 0;
        }

	    //Verifie s'il y a un element existant apres celui courant
        public boolean hasNext() {
            //COMPLETEZ
            return ++position <= currentSize;
        }

        //retourne le prochain element s'il est existant sinon renvoies une erreur
        public Object next() throws NoSuchElementException,
                        ConcurrentModificationException,
                        UnsupportedOperationException {
            //COMPLETEZ
            if (!hasNext())
                throw new NoSuchElementException();
            if (modificationHeapIterator != modifications)
                throw new ConcurrentModificationException();
            else
                return array[position++];
	    }
	
	    public void remove()    {
	        throw new UnsupportedOperationException();
	    }
    }
}
