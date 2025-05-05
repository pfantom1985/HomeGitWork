package catutil;

public class CatUtil {

    public static CatBand createBand() {

        CatBand company = new CatBand();

        Cat tempCat;

        tempCat = new Cat("Betty", "grey", 15);
        company.addCat("Betty", tempCat);

        tempCat = new Cat("Bonny", "yellow", 16);
        company.addCat("Bonny", tempCat);

        return company;
    }

}