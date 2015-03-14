package tiendapox;

public class Product {

	public static enum Category{
		PEQUEÑOS_ELECTRODOMESTICOS, TELEVISIONES, INFORMATICA, VIDEOCONSOLAS
	}
	private String name;
	private Category category;
	private String imagen;
	private String description;
	private double price;


	public Product(){
	}
	
	public Product(String name, Category category, String imagen, String description, double price){
		this.name = name;
		this.category = category;
		this.imagen = imagen;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
}