package cn.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import cn.bean.Product;
import cn.bean.ProductRepository;

public class ShopCar {
	private static Map<Integer,Product> carts = new HashMap<>();
	//获取购物车中的商品
	public static Map<Integer,Product> getCarts(){
		return carts;
	}
	//购买商品，如果购物车中已经存在该商品了，那就只更改数量
	public void buy(int pid) {
		//判断购物车中是否存在该商品
		if(carts.containsKey(pid)) {
			//修改数量
			Product p = carts.get(pid);
			//获取当前的数量
			int num = p.getCount();
			num++;
			p.setCount(num);
			
		}else{
			//先从仓库中获取商品
			Product p  = ProductRepository.getProducts().get(pid);
			//添加新商品
			Product pnew = new Product(p.getPid(), p.getName(), p.getPrice(),1);
			//添加到购物车中
			carts.put(pid, pnew);
		}
	}
	
	//修改商品数量
	public void update(int pid,int count) {
		Product p = carts.get(pid);
		//重新修改数量
		p.setCount(count);
	}
	
	//删除购物车中的指定商品
	public void delete(int pid) {
		//获取购物车中要删除的商品id
		Product p = carts.get(pid);
		//获取购物车中商品的数量
		int cnt  = p.getCount();
		//修改仓库中商品的数量
		Product p2 = ProductRepository.getProducts().get(pid);
		p2.setCount(p2.getCount()+cnt);
		
		//删除购物车中的商品
		carts.remove(pid);
	}
	
	//清除购物车中的所有商品
	public void clear() {
		//清空集合
		carts.clear();
	}
	
	//统计所有商品价格
	public double priceConnt() {
		double count = 0;
		for(Entry<Integer, Product> e:carts.entrySet()) {
			Product p = e.getValue();
			double cnt = p.getPrice()*p.getCount();
			count +=cnt;
		}
		return count;
	}
}
