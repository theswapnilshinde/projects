package com.example.shopping.reository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopping.model.Cart;
import com.example.shopping.model.User;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

   List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}
