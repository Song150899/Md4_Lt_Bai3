package service;

import model.Category;
import model.Product;

import java.util.ArrayList;

public class ProductService {
    public ArrayList<Category> categories = new ArrayList<>();
    public ArrayList<Product> products = new ArrayList<>();

    public ProductService() {
        categories.add(new Category(1, "romance"));
        categories.add(new Category(2, "fantasy movie"));
        categories.add(new Category(3, "action movie"));
        categories.add(new Category(4, "comedy"));

        products.add(new Product(1, "Bikes", 20000, "https://www.cgv.vn/media/catalog/product/cache/1/image/1800x/71252117777b696995f01934522c402d/b/i/bikes_localized_poster.jpg", categories.get(1), true));
        products.add(new Product(2, "Our Beloved Summer", 30000, "https://kenh14cdn.com/thumb_w/660/203336854389633024/2022/1/26/image498576cc71-164317654384495735762.png", categories.get(2), false));
    }

    public Category getCategory(int id) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId() == id) {
                return categories.get(i);
            }
        }
        return null;
    }

    public int getIndex(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Product> seachByName(String name) {
        ArrayList<Product> productSearch = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().contains(name)) {
                productSearch.add(products.get(i));
            }
        }
        return productSearch;
    }


    public void save(Product product) {
        products.add(product);
    }

    public void edit(Product product, int index) {
        products.set(index, product);
    }

    public int findIndex(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int index) {
        products.remove(index);
    }

}
