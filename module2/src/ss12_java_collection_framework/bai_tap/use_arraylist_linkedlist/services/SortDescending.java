package ss12_java_collection_framework.bai_tap.use_arraylist_linkedlist.services;

import ss12_java_collection_framework.bai_tap.use_arraylist_linkedlist.models.Product;

import java.util.Comparator;

public class SortDescending implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o2.getPrice()- o1.getPrice();
    }
}
