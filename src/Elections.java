

/**
 *
 * @author 21422705 Abas Abdi & Prabhleen 21402915 & Said 21428213
 */

// Importing the necessary classes from Java libary to run the programme.
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Elections {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Created an ArrayList object called Candidates that will store strings
        ArrayList<String> Candidates = new ArrayList<>();

        // Created a HashMap object called map that will store String keys and Integer values
        HashMap<String, Integer> map = new HashMap<>();

        // Created a Scanner object called in
        Scanner in = new Scanner(System.in);

        // Printing out information the user needs to run the programme
        System.out.println("#######################################\n"
                + "# Enter the votes, one vote per line. #\n"
                + "#        End by entereing 'end'       #\n"
                + "#######################################");

        // Populating the arraylist with the candidate names
        for (String h = "start"; !h.equals("end");) {

            h = in.next().toLowerCase();

            /* Only storing the value if it doesn't contain the word 'end'
            which the user needs to type to end the loop and print out the results */
            if (!h.equals("end")) {
                
                Candidates.add(h.substring(0, 1).toUpperCase() + h.substring(1).toLowerCase());
            }
        }
        
        // Loops through the names in the Candidates arraylist 
        for (String Name : Candidates) {
            /* If the 'map' hashmap doesn't already contains a name
            in the Candidates arraylist it inserts the name in the map 
            hashmap and gives it a value of Zero (0) */
            if (!map.containsKey(Name)) {
                map.put(Name, 0);
            }
            /* If the 'map' hashmap already contains a name in the 
            Candidates arraylist it inserts the name in the same place 
            within the map and increases it's value by 1. */
            map.put(Name, map.get(Name) + 1);
        }
        
        // This is here to seperate the programmes input section from it's output section. 
        System.out.println("=================================");
        
        // Loops through the keys in the 'map' hashmap 
        for (String Name : map.keySet()) {
            
                System.out.println(Name /* prints the key */ + " got " 
                        + map.get(Name) /* gets the value associated with the key */ + " vote(s)");
            
        }
        
        // This is here to seperate the votes each candidate got from the winner
        System.out.println("=================================");
        // Gets the max value in the hashmap
        int max = Collections.max(map.values());
        
        //Loops through hashmap and prints out the winner if the 'map' hashmap's value is equal to max value.
        for (Entry<String, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                System.out.println("The winner is " + entry.getKey().toUpperCase() + " with " + entry.getValue() + " votes!");
            }
        }
        // This is here to indicate the end of the programme 
        System.out.println("=============THE=END=============");
    }
}
