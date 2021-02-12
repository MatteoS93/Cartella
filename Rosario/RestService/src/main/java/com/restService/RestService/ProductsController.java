package com.restService.RestService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Product;

@RestController
public class ProductsController {

	private static HashMap<Long,Product> prodotti;
	
	static {
		prodotti = new HashMap<>();		
		Product prod1 = new Product(1L,"Pasta",10);
		prodotti.put(1L,prod1);
		Product prod2 = new Product(2L,"Pane",18);
		prodotti.put(2L,prod2);
		Product prod3 = new Product(3L,"Latte",3);
		prodotti.put(3L,prod3);
		Product prod4 = new Product(4L,"Uova",21);
		prodotti.put(4L,prod4);	
		
	}
	
	
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return new ArrayList<>(prodotti.values());
	}
	
	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable Long id) {
		return prodotti.get(id);
	}
	
	@PostMapping("/products")
	public Product newProduct(@RequestBody Product prod) {
		prodotti.put(prod.getId(), prod);
		return prod;
	}
	
	@PutMapping("/products/{id}")
	public Product replaceProduct(@PathVariable Long id, @RequestBody Product prod) {
		prodotti.replace(id, prod);
		return prod;
	}
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable Long id) {
		prodotti.remove(id);
	}
	
	
}
