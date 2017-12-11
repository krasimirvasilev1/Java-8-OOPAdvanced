package FirstExersiceInterfaceAndAbstraction.CollectionHierarchy;

import java.util.ArrayDeque;
import java.util.List;

public class AddRemoveCollectionClass implements AddRemoveCollection {
    ArrayDeque<String> collection;

    public AddRemoveCollectionClass() {
        this.collection = new ArrayDeque<>();
    }

    @Override
    public String remove() {
        if (!this.collection.isEmpty()) {
            return this.collection.removeLast();
        }
        return "";
    }

    @Override
    public int add(String element) {
        this.collection.addFirst(element);
        return 0;
    }
}
