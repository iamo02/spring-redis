package com.pongchai.springredis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.pongchai.springredis.entity.Product;

@Repository
public class ProductDao {
	public static final String Hash_KEY = "Product";
	
	@Autowired
	private RedisTemplate template;

	public Product save(Product product) {
		template.opsForHash().put(Hash_KEY, product.getId(), product);
		return product;
	}

	public List<Product> fiadAll() {
		return template.opsForHash().values(Hash_KEY);
	}

	public Product findProductById(int id) {
		return (Product) template.opsForHash().get(Hash_KEY, id);
	}

	public String deleteProduct(int id) {
		template.opsForHash().delete(Hash_KEY, id);
		return "product remove";
	}
}
