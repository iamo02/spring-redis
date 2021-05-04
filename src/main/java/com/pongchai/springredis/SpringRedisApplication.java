package com.pongchai.springredis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pongchai.springredis.entity.Product;
import com.pongchai.springredis.repository.ProductDao;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class SpringRedisApplication {

	@Autowired
	private ProductDao dao;
	
	@PostMapping
	public Product save(@RequestBody Product product) {
		return dao.save(product);
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		return dao.fiadAll();
	}
	
	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id) {
		return dao.findProductById(id);
	}
	
	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id) {
		return dao.deleteProduct(id);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRedisApplication.class, args);
	}

}
