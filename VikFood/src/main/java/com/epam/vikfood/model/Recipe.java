package com.epam.vikfood.model;

import java.util.List;

public class Recipe {
	private int id;
	
	private String title;
	
	private String recipe;
	
	private List<String> ingridients;
	
	private List<String> images;

	public Recipe() {
		super();
	}

	public Recipe(int id, String title, String recipe, List<String> ingridients, List<String> images) {
		super();
		this.id = id;
		this.title = title;
		this.recipe = recipe;
		this.ingridients = ingridients;
		this.images = images;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public List<String> getIngridients() {
		return ingridients;
	}

	public void setIngridients(List<String> ingridients) {
		this.ingridients = ingridients;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((ingridients == null) ? 0 : ingridients.hashCode());
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		if (id != other.id)
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (ingridients == null) {
			if (other.ingridients != null)
				return false;
		} else if (!ingridients.equals(other.ingridients))
			return false;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
