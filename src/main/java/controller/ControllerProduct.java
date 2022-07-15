package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import java.util.ArrayList;

@Controller

//@RequestMapping("/home")

public class ControllerProduct {
    ProductService productService = new ProductService();

    @GetMapping("/product")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("products", productService.products);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreat() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("category", productService.categories);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView creat(@ModelAttribute Product product, @RequestParam int id) {
        product.setCategory(productService.getCategory(id));
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam int id) {
        int index = productService.findIndex(id);
        productService.delete(index);
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("category", productService.categories);
        Product product = productService.products.get(productService.findIndex(id));
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute Product product, @RequestParam int id) {
        product.setCategory(productService.getCategory(id));
        int index = productService.getIndex(id);
        productService.products.set(index, product);
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam String search) {
        ArrayList<Product> listSearch = productService.seachByName(search);

        ModelAndView modelAndView = new ModelAndView("showSearch");
        modelAndView.addObject("searchs", listSearch);

        return modelAndView;
    }
}
