package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/blogRest")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping("")
    public String list(Model model, @PageableDefault(value = 10) Pageable pageable) {
        Page<Blog> smartphonePage = iBlogService.findAll(pageable);
        model.addAttribute("smartphonePage", smartphonePage);
        return "list1";
    }
    @GetMapping("/listBlog")
    public ResponseEntity<Page<Blog>> getPageBlog(@PageableDefault(value = 4) Pageable pageable) {
        Page<Blog> blogPage = this.iBlogService.findAll(pageable);

        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("/listCategory")
    public ResponseEntity<List<Category>> getCategory() {
        List<Category> categoryList = this.iCategoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/viewOneBlog")
    public ResponseEntity<Blog> getBlog(@RequestParam Integer id) {
        Blog blog = this.iBlogService.findById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/viewBlogInOneCategory")
    public ResponseEntity<Page<Blog>> getPageBlogInOneCategory(@PageableDefault(value = 4) Pageable pageable,
                                                               @RequestParam String category) {
        Page<Blog> blogPage = this.iBlogService.findAllByCategoryName(category, pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);


    }

}
