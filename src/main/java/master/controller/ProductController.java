package master.controller;


import master.entity.Product;
import master.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public String list(Model model) {

        List<Product> products = service.findAll();

        model.addAttribute("products", products);

        return "products";
    }

    @GetMapping("/new")
    public String form(Model model) {

        model.addAttribute("product", new Product());

        return "form-product";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {

        Product product = service.findById(id);

        model.addAttribute("product", product);

        return "form-product";
    }

    @PostMapping
    public String save(@ModelAttribute Product product) {

        service.save(product);

        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);

        return "redirect:/products";
    }
}