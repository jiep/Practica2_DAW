package tiendapox; 

public class AlmostCart {
	private Product product;
	private int cuantity;
	
	public AlmostCart(){
	}
	public AlmostCart(Product product, int cuantity){
		this.cuantity = cuantity;
		this.product = product;
	}
	
	
	public Product getProduct() {
		return product;
	}

	public int getCuantity() {
		return cuantity;
	}
	public void setCuantity(int cuantity) {
		this.cuantity = cuantity;
	}
	
	public void add(){
		this.cuantity++;
	}
	
	public void substract(){
		this.cuantity--;
	}
}
