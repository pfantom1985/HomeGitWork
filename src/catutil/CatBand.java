package catutil;

import java.util.HashMap;
import java.util.Map;

public class CatBand {

    Map<String, Cat> catBand = new HashMap<>();

    public Map<String, Cat> getCatBand() {
        return new HashMap<>(catBand);
    }

    public void addCat(String catName, Cat cat) {
        this.catBand.put(catName, cat);
    }

}
