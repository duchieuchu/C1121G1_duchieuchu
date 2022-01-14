package ss12_java_collection_framework.bai_tap.use_arraylist_linkedlist.services;

import ss12_java_collection_framework.bai_tap.use_arraylist_linkedlist.models.Product;

import java.util.Comparator;

public class SortAscending implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getPrice()- o2.getPrice();
    }
}
