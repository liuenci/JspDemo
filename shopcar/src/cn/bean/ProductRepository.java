package cn.bean;

import java.util.HashMap;
import java.util.Map;

/*
 * ��Ʒ�ֿ���
 */
public class ProductRepository {
	private static Map<Integer, Product> products;
	static {
		products = new HashMap<>();
		products.put(1, new Product(1, "iphone7", 5500));
		products.put(2, new Product(2, "����pro6", 2500));
		products.put(3, new Product(3, "����ʼǱ�����", 3500));
		products.put(4, new Product(4, "kfc����", 500));
		products.put(5, new Product(5, "��Ȫˮ", 100));
	}
	
	public static Map<Integer, Product> getProducts(){
		return products;
	}
}
