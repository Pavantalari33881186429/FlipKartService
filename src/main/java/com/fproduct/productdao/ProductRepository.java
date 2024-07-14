package com.fproduct.productdao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.fproduct.model.FProduct;




@Repository
public interface ProductRepository extends JpaRepository<FProduct, Long>{

}