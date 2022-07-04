package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/blogRest")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

//    @GetMapping("/listBlog")
//    public ResponseEntity<Page<Blog>> getPageBlog(@PageableDefault(value = 2) Pageable pageable) {
//        Page<Blog> blogPage = this.iBlogService.findAll(pageable);
//
//        if (!blogPage.hasContent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(blogPage, HttpStatus.OK);
//    }
    @GetMapping("/listBlog")
    public ResponseEntity<Page<Blog>> getPageBlog(Model model,@PageableDefault(value = 2) Pageable pageable
    , @RequestParam Optional<String> keyword) {
        String keywordVal=keyword.orElse("");
        Page<Blog> blogPage = this.iBlogService.findAllByName( keywordVal,pageable);

        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
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

