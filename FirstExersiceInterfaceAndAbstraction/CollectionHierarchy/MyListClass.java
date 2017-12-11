package FirstExersiceInterfaceAndAbstraction.CollectionHierarchy;

import java.util.ArrayDeque;

public class MyListClass implements MyList {
    ArrayDeque<String> collection;

    public MyListClass() {
        this.collection = new ArrayDeque<>();
    }

    @Override
    public int used() {
        return this.collection.size();
    }

    @Override
    public String remove() {
        if (!this.collection.isEmpty()) {
            return this.collection.removeFirst();
        }
        return "";
    }

    @Override
    public int add(String element) {
        this.collection.addFirst(element);
        return 0;
    }
}
