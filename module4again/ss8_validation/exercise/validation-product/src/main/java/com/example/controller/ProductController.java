package com.example.controller;

import com.example.dto.ProductDto;
import com.example.model.Category;
import com.example.model.Product;
import com.example.service.ICategoryService;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String page(Model model, @PageableDefault(value = 2) Pageable pageable) {
        Page<Product> productPage = this.iProductService.findAll(pageable);
        model.addAttribute("productPage", productPage);
        return "/go";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("productDto", new ProductDto());
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "/create";
    }

    @PostMapping("/add")
    public String create(@Valid ProductDto productDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msgError", "đăng kí thất bại");
            return "redirect:/product/create";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            this.iProductService.save(product);
            redirectAttributes.addFlashAttribute("msg", "đã tạo mới san pham  " + product.getName() + " thành công");
            return "redirect:/product";
        }

    }
}
