package com.example.controller;

import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    // value , size ,page,sort,direction trong pageableDF
    //pageable la phan trang
    @RequestMapping("")
    public String list(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Product> productPage = iProductService.findAll(pageable);
        model.addAttribute("productPage", productPage);
        return "list";
    }


    //thong tin se qua dto
    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "/create";
    }
// kiem tra co loi khi validate ko , neu ko thi save product
    @PostMapping("save")
    public String create(@ModelAttribute @Validated ProductDto productDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        new ProductDto().validate(productDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/create";
        }else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto,product);
            iProductService.save(product);
            redirectAttributes.addFlashAttribute("mess",
                    "create product: "+product.getName() +" completed");
        }
        return "redirect:/product";
    }
    @GetMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.remove(product);
        redirectAttributes.addFlashAttribute("mess", "Delete song Completed");
        return "redirect:/product";
    }
}
