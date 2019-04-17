package ml.penkisimtai.warehouse.controller;

import ml.penkisimtai.warehouse.model.Product;
import ml.penkisimtai.warehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(path = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(path = "/products/add", method = RequestMethod.GET)
    public String createProduct(Model model) {

        model.addAttribute("product", new Product());
        return "add";
    }

    @RequestMapping(path = "products", method = RequestMethod.POST)
    public String saveProduct(Model model, @Validated Product product, BindingResult bindingResult) {

        if (productRepository.existsByName(product.getName())){
            bindingResult.addError(new FieldError("product","name", "product exists"));
        }

        if (productRepository.existsByDescription(product.getDescription())){
            bindingResult.addError(new FieldError("product","description", "description exists"));
        }
        if (bindingResult.hasErrors()){
            model.addAttribute("product", product);
            return "add";
        }
        productRepository.save(product);
        return "redirect:/products";
    }

    @RequestMapping(path = "products", method = RequestMethod.PUT)
    public String updateProduct(@Valid Product product) {

        productRepository.save(product);
        return "redirect:/products";
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public String getAllProducts(Model model) {

        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @RequestMapping(path = "/products/edit/{id}", method = RequestMethod.GET)
    public String editProduct(Model model, @PathVariable(value = "id") Long id) {

        model.addAttribute("product", productRepository.findById(id));
        return "edit";
    }

    @RequestMapping(path = "/products/delete/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable(name = "id") Long id) {

        productRepository.deleteById(id);
        return "redirect:/products";
    }
}
