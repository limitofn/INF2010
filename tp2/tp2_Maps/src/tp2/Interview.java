package tp2;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import static java.lang.Math.pow;

public class Interview {

    /**
     * Finds all pairs within values which sum up to targetSum
     *
     * @param values    All possible values that can form a pair (can contain duplicates)
     * @param targetSum Pairs should add up to this
     * @return A collection containing all valid pairs with no permutations, but all combinations (empty collection if none found)
     */

    // methode par hashage
    public Collection<MatchingPair> matchingPairs(Collection<Integer> values, Integer targetSum)
    {
        HashMap<Integer, Integer> tableCompteur = new HashMap<>();
        LinkedHashMap<Integer, Integer> tablePaire = new LinkedHashMap<Integer, Integer>();
        Collection<MatchingPair> paireSansDuplication = new LinkedList();
        Collection<MatchingPair> solution = new LinkedList();

        // On itere sur les valeurs donnee pour savoir le compte de chaque valeur
        for (Integer valeur : values)
        {
            if (tableCompteur.containsKey(valeur))
            {
                // Partie Compteur
                Integer compteur = tableCompteur.get(valeur);
                compteur++;
                tableCompteur.put(valeur, compteur);
            }
            else {
                tableCompteur.put(valeur, 0);
            }

        }

        // On itere sur les valeurs donnee pour savoir les paires
        for (Integer element : values)
        {
            int temp = targetSum - element;
            if (tablePaire.containsKey(element))
            {
                if (tablePaire.get(element) != null)
                {
                    paireSansDuplication.add(new MatchingPair(element, temp));
                }
                // si la table contient l'element on met nul pour ne pas avoir de repetition
                tablePaire.put(temp, null);
            }
            else if (!tablePaire.containsKey(element))
            {
                tablePaire.put(temp, element);
            }
        }

        // On trouve le minimum count entre les paire et leur compte pour tenir en compte de toutes les possibilites. Ici le meilleur cas reste O(n) ( pas de paire)
        for (MatchingPair paire : paireSansDuplication)
        {
            if (paire != null) { // verification au debug pr erreur nullpointer
                int a = tableCompteur.get(paire.first);
                int b = tableCompteur.get(paire.second);
                int minCount = Math.min(a+1, b+1);
                for (int i = 0; i < pow(minCount, 2); i++)
                {
                    solution.add(new MatchingPair(paire.first, paire.second));
                }
            }
        }
        return solution;
    }
}
