package tp2;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class Interview {

    /**
     * Finds all pairs within values which sum up to targetSum
     * @param values All possible values that can form a pair (can contain duplicates)
     * @param targetSum Pairs should add up to this
     * @return A collection containing all valid pairs with no permutations, but all combinations (empty collection if none found)
     */

// methode par hashage

    public Collection<MatchingPair> matchingPairs(Collection<Integer> values, Integer targetSum){
        HashSet<Integer> table = new HashSet<Integer>();
        Collection col = new LinkedList();
        for (Integer element : values){
            int temp = targetSum - element;

            // on regarde si c'est egal
            if(table.contains(temp)){
                System.out.println("Pair with given sum " + targetSum + " is (" + element + ", " + temp + ")");
                    col.add(new MatchingPair(element, temp));
            }
            table.add(element);
        }
        return col;
    }
}

