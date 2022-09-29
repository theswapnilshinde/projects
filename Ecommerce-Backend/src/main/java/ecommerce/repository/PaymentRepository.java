package ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
