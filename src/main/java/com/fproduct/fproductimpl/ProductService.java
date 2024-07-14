package com.fproduct.fproductimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fproduct.model.FProduct;

import com.fproduct.productdao.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository repo;
	@Autowired
	FProduct product;
	public String createProduct(List<FProduct> prod) {
		
		
		
		if(prod.isEmpty()) {
			
			return "Create product Service Failed";
		}
		else {
			
		
			for( FProduct p : prod) {
				
				product = new FProduct(p.getProductID(),p.getProductName(), p.getProductPrice());
				
				repo.save(product);
				
				
			}
			return "Product Creation Successfull";
		}
	}
	
	public List<FProduct> displayAll(){
		
		
		return repo.findAll();
		
	}
	
   public FProduct displayById(long prodID){
		
	   Optional<FProduct> prod = repo.findById(prodID);
	   
	   
	   product = new FProduct(prod.get().getProductID(),prod.get().getProductName(), prod.get().getProductPrice());
		return product;
		
	
   }
   
   public String deleteProd(long prodID) {
	   
	   String response = null;
	   try {
	   repo.deleteById(prodID);
	   response = "Product deleted successfully";
	   }
	   catch(Exception e) {
		   System.out.println("Product doesnot exist");
	   }
	
	   return response;
   }

public String addProductFromManufacturer(List<FProduct> products) {
	
	long price;
	long actualPrice;
	String response = null;
	try {
		for(FProduct prod : products) {
			price=prod.getProductPrice();
			actualPrice=flipkartSellingPrice(price);
			prod.setProductPrice(actualPrice);
		    repo.save(prod);
		    response="Added Products Successfully!!";
		}
		
	}
	catch(Exception e){
		
		response="Exception: "+e;
	}
	return response;
	
	
}

public String updateProduct(FProduct prod) {
	
	try {
		
	
	repo.save(prod);
	return "Product update successfull";
	}catch(Exception e){
		return "Product update unsuccessfull"+e;
	}
	
}

private long flipkartSellingPrice(long costPrice) {

	long profit = 0L;
	long sellingPrice = 0L;

	if (costPrice <= 100) {
		profit = ((costPrice * 60) / 100);
		sellingPrice = costPrice + profit;
		System.out.println("COST PRICE" + "-" + costPrice + " PROFIT-" + "60%" + " PROFIT " + profit + " SELLING PRICE" + sellingPrice);
		return sellingPrice;

	} else if (costPrice > 100 && costPrice <= 500) {
		profit = ((costPrice * 50) / 100);
		sellingPrice = costPrice + profit;
		System.out.println("COST PRICE" + "-" + costPrice + " PROFIT-" + "50%" + " PROFIT - " + profit + " SELLING PRICE - " + sellingPrice);
		return sellingPrice;

	} else if (costPrice > 500 && costPrice <= 1000) {
		profit = ((costPrice * 40) / 100);
		sellingPrice = costPrice + profit;
		System.out.println("COST PRICE" + "-" + costPrice + " PROFIT-" + "40%" + " PROFIT - " + profit + " SELLING PRICE - " + sellingPrice);
		return sellingPrice;

	} else if (costPrice > 1000 && costPrice <= 2000) {
		profit = ((costPrice * 30) / 100);
		sellingPrice = costPrice + profit;
		System.out.println("COST PRICE" + "-" + costPrice + " PROFIT-" + "30%" + " PROFIT - " + profit + " SELLING PRICE - " + sellingPrice);
		return sellingPrice;

	} else if (costPrice > 2000 && costPrice <= 4000) {
		profit = ((costPrice * 20) / 100);
		sellingPrice = costPrice + profit;
		System.out.println("COST PRICE" + "-" + costPrice + " PROFIT-" + "20%" + " PROFIT - " + profit + " SELLING PRICE - " + sellingPrice);
		return sellingPrice;

	} else if (costPrice > 4000 && costPrice <= 7000) {
		profit = ((costPrice * 10) / 100);
		sellingPrice = costPrice + profit;
		System.out.println("COST PRICE" + "-" + costPrice + " PROFIT-" + "10%" + " PROFIT - " + profit + " SELLING PRICE - " + sellingPrice);
		return sellingPrice;

	} else{
		profit = ((costPrice * 5) / 100);
		sellingPrice = costPrice + profit;
		System.out.println("COST PRICE" + "-" + costPrice + " PROFIT-" + "05%" + " PROFIT - " + profit + " SELLING PRICE - " + sellingPrice);
		return sellingPrice;

	}
}

}




