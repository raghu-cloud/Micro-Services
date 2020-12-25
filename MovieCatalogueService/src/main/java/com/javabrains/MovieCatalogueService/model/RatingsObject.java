package com.javabrains.MovieCatalogueService.model;

import java.util.*;

public class RatingsObject {
	
	private List<Rating> ratingsObject;
	
	public RatingsObject() {
		
	}
	
	public List<Rating> getRatingsObject(){
		return ratingsObject;
	}
	
	public void setRatingsObject(List<Rating> ratingsObject) {
		this.ratingsObject=ratingsObject;
	}
	

}
