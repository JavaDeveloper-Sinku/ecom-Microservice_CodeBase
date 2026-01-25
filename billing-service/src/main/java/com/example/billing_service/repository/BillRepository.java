package com.example.billing_service.repository;

import com.example.billing_service.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BillRepository extends JpaRepository<Bill, String> {
}

