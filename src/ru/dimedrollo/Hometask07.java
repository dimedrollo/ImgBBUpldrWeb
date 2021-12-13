package ru.dimedrollo;


import java.util.*;

import static java.util.Map.*;


public class Hometask07 {

    /**
     * The function reads input and counts repetitions of elements
     *
     * @return a hash map, where the key is a unique number, the value is the number of its repetitions
     */
    public static Map<Integer, Integer> readAndCount() {
        // declaring objects for reading from input and storing data
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();

        //read from the console while the input is in progress
        while (scanner.hasNext()) {
            // making sure that the number is entered
            if (scanner.hasNextInt()) {
                int i = scanner.nextInt();
                if (i == -1) {
                    break;
                }

                //when entering -1, exit the loop

                // check whether it belongs to the required range
                if (-100 < i && i < 100) {
                    // if the key is repeated, then increment its value. If the key is new, we give the value 1.
                    if (map.containsKey(i)) {
                        int a = map.get(i);
                        map.replace(i, a + 1);

                    } else {
                        map.put(i, 1);
                    }
                }
            } else {
                System.out.println("Watch out! It isn`t number!");
                scanner.nextLine();
            }
        }

        return map;
    }

    /**
     * The function sorts the hash map by values in ascending order
     *
     * @return A set of key-value pairs sorted by values in ascending order
     */
    public static Set<Map.Entry<Integer, Integer>> sort() {
        Map<Integer, Integer> unsortedMap = readAndCount();
        ArrayList<Integer> list = new ArrayList<>();
        LinkedHashMap sortedMap = new LinkedHashMap<>();
        // Getting a list of values
        for (Map.Entry<Integer, Integer> entry : unsortedMap.entrySet()) {
            list.add(entry.getValue());
        }
        // Sorting the list of values
        Collections.sort(list);
        // Create a hash map based on the sorted list
        for (Integer num : list) {
            for (Entry entry : unsortedMap.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        //Returning a set of pairs
        return sortedMap.entrySet();
    }


    public static void main(String[] args) {
        // We declare a list of rare values for storing elements that occur a minimum number of times
        ArrayList<Integer> rareNums = new ArrayList<>();

        Set<Entry<Integer, Integer>> entrySet = sort();
        // Convert the set into an array, to iterate over the elements
        Entry<Integer, Integer>[] entryArr = new Entry[entrySet.size()];
        entryArr = entrySet.toArray(entryArr);
        // If the value of the first element of the array matches the value of the last one, we add all the keys to the result list
        if (entryArr[0].getValue() == entryArr[entrySet.size() - 1].getValue()) {
            for (Entry e : entrySet) {
                rareNums.add((Integer) e.getKey());
            }
        } else {
            for (int i = 0; i < entrySet.size(); i++) {
                rareNums.add(entryArr[i].getKey());
                // If the value in the next pair is different from the current one, we exit the loop
                if (entryArr[i].getValue() != entryArr[i + 1].getValue()) {
                    break;
                }
            }
        }
        System.out.println(rareNums);
    }
}


