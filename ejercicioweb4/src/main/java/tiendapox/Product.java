package tiendapox;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable{

	/*
	 * public static enum Category { PEQUEÑOS_ELECTRODOMESTICOS, TELEVISIONES,
	 * INFORMATICA, VIDEOCONSOLAS }
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_id")
	private int id;
	private String name;
	private String category;
	private String image;

	@Column(columnDefinition = "TEXT")
	private String description;
	private String minidescription;
	private double price;

	public Product() {
	}

	public Product(String name, String category, String image,
			String description, double price) {
		this.name = name;
		this.category = category;
		this.image = image;
		this.description = description;
		if(this.description.length() <= 250){
			this.minidescription = description; 
		}else{
			this.minidescription = this.description.substring(0,250)+"...";
		}
		this.price = price;
	}
	
	public Product(String name, String category, String image,
			String description, String mini_description, double price) {
		this.name = name;
		this.category = category;
		this.image = image;
		this.description = description;
		this.minidescription = mini_description;
				//this.description.substring(0,15)+"...";
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

	public int getId() {
		return id;
	}
	
	public String getMinidescription() {
		return minidescription;
	}

	public void setMinidescription(String mini_description) {
		this.minidescription = mini_description;
	}

	@Override
	public boolean equals(Object o) {
		boolean equals = false;

		if (o instanceof Product
				&& this.getName().equals(((Product) o).getName())
				&& this.getCategory().equals(((Product) o).getCategory())
				&& this.getImage().equals(((Product) o).getImage())
				&& this.getDescription().equals(((Product) o).getDescription())
				&& this.getPrice() == ((Product) o).getPrice()
				&& this.getId() == ((Product) o).getId()) {
			
			equals = true;

		}

		return equals;
	}

	public void setImage(String image) {
		this.image = image;
		
	}

}