package io.tyke.models;

public class LotteryBrandForeignDocument extends ForeignDocument<Brand> {
	String name;
	String image;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
