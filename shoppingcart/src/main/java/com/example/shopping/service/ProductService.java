package com.example.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping.dto.ProductDto;
import com.example.shopping.model.Product;
import com.example.shopping.reository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public List<ProductDto> getAllProducts() {
		 List<Product> allProducts = productRepository.findAll();
	        List<ProductDto> productDtos = new ArrayList<>();
	        for(Product product: allProducts) {
	            productDtos.add(getProductDto(product));
	        }
	        return productDtos;
	}

	public void createProduct(ProductDto productDto) {
		Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setImageURL(productDto.getImageURL());
        product.setName(productDto.getName());
       // product.setCategory(category);
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
		
	}

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setImageURL(product.getImageURL());
        productDto.setName(product.getName());
        //productDto.setCategoryId(product.getCategory().getId());
        productDto.setPrice(product.getPrice());
        productDto.setId(product.getId());
        return productDto;
    }
	

	public void updateProduct(ProductDto productDto, Integer productId) {

	        Product product = productRepository.findById(productId).get();
	        product.setDescription(productDto.getDescription());
	        product.setImageURL(productDto.getImageURL());
	        product.setName(productDto.getName());
	        product.setPrice(productDto.getPrice());
	        productRepository.save(product);
	}
	 public Product findById(Integer productId) {
	        Product optionalProduct = productRepository.findById(productId).get();
	       
	        return optionalProduct;
	    }
}
