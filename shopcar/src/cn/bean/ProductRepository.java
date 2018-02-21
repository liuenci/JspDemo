package cn.bean;

import java.util.HashMap;
import java.util.Map;

/*
 * 商品仓库类
 */
public class ProductRepository {
	private static Map<Integer, Product> products;
	static {
		products = new HashMap<>();
		products.put(1, new Product(1, "iphone7", 5500));
		products.put(2, new Product(2, "魅族pro6", 2500));
		products.put(3, new Product(3, "联想笔记本电脑", 3500));
		products.put(4, new Product(4, "kfc汉堡", 500));
		products.put(5, new Product(5, "矿泉水", 100));
	}
	
	public static Map<Integer, Product> getProducts(){
		return products;
	}
}
