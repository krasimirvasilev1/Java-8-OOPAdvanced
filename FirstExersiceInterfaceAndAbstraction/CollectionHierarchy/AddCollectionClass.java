package FirstExersiceInterfaceAndAbstraction.CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class AddCollectionClass implements AddCollection {
    private List<String> allAdds;

    public AddCollectionClass() {
        this.allAdds = new ArrayList<>();
    }

    @Override
    public int add(String element) {
        this.allAdds.add(element);
        return this.allAdds.size() - 1;
    }
}
