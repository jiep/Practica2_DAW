package tiendapox;

import java.util.ArrayList;

public class Orders {
	ArrayList <Order> orders;
	
	public Orders(){
		orders = new ArrayList <>();
	}
	
	public Orders(ArrayList <Order> orders){
		this.orders=orders;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	public void changeOrderState(Order order){
		if (orders.contains(order)){
			orders.get(orders.indexOf(order)).changeState();
		}
	}
}
