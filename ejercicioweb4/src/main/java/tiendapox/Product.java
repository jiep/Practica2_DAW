package tiendapox;

public class Product {

	/*public static enum Category {
		PEQUEÑOS_ELECTRODOMESTICOS, TELEVISIONES, INFORMATICA, VIDEOCONSOLAS
	}*/

	//private int id;
	private String name;
	private String category;
	private String image;
	private String description;
	private double price;

	public Product() {
	}

	public Product(String name, String category, String image,
			String description, double price) {
		this.name = name;
		this.category = category;
		this.image = image;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImagen(String image) {
		this.image = image;
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

	/*public int getId() {
		return id;
	}*/

}