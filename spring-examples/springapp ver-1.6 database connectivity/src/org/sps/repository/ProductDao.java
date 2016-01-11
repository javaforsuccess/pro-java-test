package org.sps.repository;

import java.util.List;

import org.sps.domain.Product;

public interface ProductDao 
{
	public List<Product> getProductList();
	public void saveProduct(Product prod);
}
