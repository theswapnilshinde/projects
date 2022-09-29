package com.example.shopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.dto.ProductDto;
import com.example.shopping.dto.ResponseDto;
import com.example.shopping.service.ProductService;



@RestController
@RequestMapping("/product")
public class ProductController {
	
    @Autowired
    ProductService productService;



    @PostMapping("/add")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
//         Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
//         if (!optionalCategory.isPresent()) {
             //return new ResponseEntity<ProductDto>(new ApiResponse(false, "category does not exists"), HttpStatus.BAD_REQUEST);
        // }
         productService.createProduct(productDto);
         return new ResponseEntity<ProductDto>(HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // create an api to edit the product


    @PostMapping("/update/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("productId") Integer productId, @RequestBody ProductDto productDto)  {
//        Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
//        if (!optionalCategory.isPresent()) {
//            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exists"), HttpStatus.BAD_REQUEST);
//        }
        productService.updateProduct(productDto, productId);
        return new ResponseEntity<ProductDto>(HttpStatus.OK);
    }
}
