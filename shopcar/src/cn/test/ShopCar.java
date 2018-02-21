package cn.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import cn.bean.Product;
import cn.bean.ProductRepository;

public class ShopCar {
	private static Map<Integer,Product> carts = new HashMap<>();
	//��ȡ���ﳵ�е���Ʒ
	public static Map<Integer,Product> getCarts(){
		return carts;
	}
	//������Ʒ��������ﳵ���Ѿ����ڸ���Ʒ�ˣ��Ǿ�ֻ��������
	public void buy(int pid) {
		//�жϹ��ﳵ���Ƿ���ڸ���Ʒ
		if(carts.containsKey(pid)) {
			//�޸�����
			Product p = carts.get(pid);
			//��ȡ��ǰ������
			int num = p.getCount();
			num++;
			p.setCount(num);
			
		}else{
			//�ȴӲֿ��л�ȡ��Ʒ
			Product p  = ProductRepository.getProducts().get(pid);
			//�������Ʒ
			Product pnew = new Product(p.getPid(), p.getName(), p.getPrice(),1);
			//��ӵ����ﳵ��
			carts.put(pid, pnew);
		}
	}
	
	//�޸���Ʒ����
	public void update(int pid,int count) {
		Product p = carts.get(pid);
		//�����޸�����
		p.setCount(count);
	}
	
	//ɾ�����ﳵ�е�ָ����Ʒ
	public void delete(int pid) {
		//��ȡ���ﳵ��Ҫɾ������Ʒid
		Product p = carts.get(pid);
		//��ȡ���ﳵ����Ʒ������
		int cnt  = p.getCount();
		//�޸Ĳֿ�����Ʒ������
		Product p2 = ProductRepository.getProducts().get(pid);
		p2.setCount(p2.getCount()+cnt);
		
		//ɾ�����ﳵ�е���Ʒ
		carts.remove(pid);
	}
	
	//������ﳵ�е�������Ʒ
	public void clear() {
		//��ռ���
		carts.clear();
	}
	
	//ͳ��������Ʒ�۸�
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
