package com.example.shopping.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.common.ApiResponse;
import com.example.shopping.dto.cart.AddToCartDto;
import com.example.shopping.dto.cart.CartDto;
import com.example.shopping.model.User;
import com.example.shopping.reository.CartRepository;
import com.example.shopping.reository.UserRepository;
import com.example.shopping.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    
    @Autowired
    private UserRepository userrepo;

   

    // post cart api
    @PostMapping("/add/{id}")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto,
    		@PathVariable Integer id) {

        User user = userrepo.findById(id).get();


        cartService.addToCart(addToCartDto, user );

        return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
    }


    // get all cart items for a user
    @GetMapping("/{id}")
    public ResponseEntity<CartDto> getCartItems(@PathVariable Integer id) {
        

        // find the user
    	  User user = userrepo.findById(id).get();

        // get cart items

        CartDto cartDto = cartService.listCartItems(user);
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    // delete a cart item for a user

    @DeleteMapping("/delete/{cartItemId}/{id}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") Integer itemId,
    		@PathVariable Integer id) {

        
    	  User user = userrepo.findById(id).get();

        cartService.deleteCartItem(itemId, user);

        return new ResponseEntity<>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);

    }

}
