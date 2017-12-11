package FirstExersiceInterfaceAndAbstraction.CollectionHierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder add = new StringBuilder();
        StringBuilder addRemove = new StringBuilder();
        StringBuilder myList = new StringBuilder();

        AddCollection addCollection = new AddCollectionClass();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollectionClass();
        MyList myList1 = new MyListClass();


        String[] elementsInput = console.readLine().split("\\s+");
        for (int i = 0; i < elementsInput.length; i++) {
            add.append(addCollection.add(elementsInput[i])).append(" ");
            addRemove.append(addRemoveCollection.add(elementsInput[i])).append(" ");
            myList.append(myList1.add(elementsInput[i])).append(" ");
        }

        System.out.println(add.toString().trim());
        System.out.println(addRemove.toString().trim());
        System.out.println(myList.toString().trim());

        addRemove = new StringBuilder();
        myList = new StringBuilder();

        int numbersToRemove = Integer.parseInt(console.readLine());
        for (int i = 0; i < numbersToRemove; i++) {
            String remove1 = addRemoveCollection.remove();
            String remove2 = myList1.remove();
            if (!remove1.equalsIgnoreCase(" ") && !remove2.equalsIgnoreCase(" ")) {
                addRemove.append(remove1).append(" ");
                myList.append(remove2).append(" ");
            }
        }
        System.out.println(addRemove.toString().trim());
        System.out.println(myList.toString().trim());
    }
}
