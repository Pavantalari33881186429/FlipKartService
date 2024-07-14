package com.fproduct.feign;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.fproduct.model.FProduct;


@FeignClient(name="productmanufacturer",url="${productmanufacturer.url}")
public interface FiegnConfig {
  
  @GetMapping("/getallprod")
  public List<FProduct>	getProductDetailsFromProductManufacturer();


}
