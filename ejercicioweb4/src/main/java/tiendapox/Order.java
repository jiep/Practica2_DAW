package tiendapox;

public class Order {
	
	public static enum State{
		PENDIENTE, PREPARADO
	}
	
	private Cart cart;
	private State state;
	private int id;
	
	public Order(){
	}
	
	public Order(Cart cart){
		this.cart = cart;
		this.state = State.PENDIENTE;
	}

	public Cart getCart() {
		return cart;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}
	
	public void changeState(){
		this.state = State.PREPARADO;
	}
	
}
