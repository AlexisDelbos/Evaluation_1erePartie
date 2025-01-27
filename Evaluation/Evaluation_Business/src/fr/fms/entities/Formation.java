package fr.fms.entities;

public class Formation {
	private int idFormation;
	private String nameFormation;
	private String descriptionFormation;
	private int durationFormation;
	private String typeFormation;
	private double priceFormation;	
	private int idCategory;
	private String nameCategory;
	
	
	public Formation(int idFormation, String nameFormation, String descriptionFormation, int durationFormation,
			String typeFormation, double priceFormation, int idCategory, String nameCategory) {
		this.idFormation = idFormation;
		this.nameFormation = nameFormation;
		this.descriptionFormation = descriptionFormation;
		this.durationFormation = durationFormation;
		this.typeFormation = typeFormation;
		this.priceFormation = priceFormation;
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
	}


	private int quantity=1;


	
	public Formation(int idFormation, String nameFormation, String descriptionFormation, int durationFormation,
			String typeFormation, double priceFormation) {
		this.idFormation = idFormation;
		this.nameFormation = nameFormation;
		this.descriptionFormation = descriptionFormation;
		this.durationFormation = durationFormation;
		this.typeFormation = typeFormation;
		this.priceFormation = priceFormation;
	}


	public Formation(int idFormation, String nameFormation, String descriptionFormation, int durationFormation,
			String typeFormation, double priceFormation, int idCategory) {
		this.idFormation = idFormation;
		this.nameFormation = nameFormation;
		this.descriptionFormation = descriptionFormation;
		this.durationFormation = durationFormation;
		this.typeFormation = typeFormation;
		this.priceFormation = priceFormation;
		this.idCategory = idCategory;
	}
	
	public Formation(String nameFormation, String descriptionFormation, int durationFormation,
			String typeFormation, double priceFormation) {
		this.idFormation = 0;
		this.nameFormation = nameFormation;
		this.descriptionFormation = descriptionFormation;
		this.durationFormation = durationFormation;
		this.typeFormation = typeFormation;
		this.priceFormation = priceFormation;
		}


	@Override
	public String toString() {
	    return "Article [id=" + idFormation + 
	           ", nameFormation=" + nameFormation + 
	           ", descriptionFormation=" + descriptionFormation + 
	           ", durationFormation=" + durationFormation + 
	           ", typeFormation=" + typeFormation + 
	           ", priceFormation=" + priceFormation + 
	           ", idCategory=" + idCategory + 
	           ", nameCategory=" + nameCategory+
	           "]\n";
	}

	
	
	public int getDurationFormation() {
		return durationFormation;
	}

	public void setDurationFormation(int durationFormation) {
		this.durationFormation = durationFormation;
	}

	public String getTypeFormation() {
		return typeFormation;
	}

	public void setTypeFormation(String typeFormation) {
		this.typeFormation = typeFormation;
	}

	public double getPriceFormation() {
		return priceFormation;
	}

	public void setPriceFormation(double priceFormation) {
		this.priceFormation = priceFormation;
	}

	public int getIdFormation() {
		return idFormation;
	}
	
	
	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}
	public String getNameFormation() {
		return nameFormation;
	}
	public void setNameFormation(String nameFormation) {
		this.nameFormation = nameFormation;
	}
	public String getDescriptionFormation() {
		return descriptionFormation;
	}
	public void setDescriptionFormation(String descriptionFormation) {
		this.descriptionFormation = descriptionFormation;
	}


	public int getIdCategory() {
		return idCategory;
	}


	public void setNameCategory(int idCategory) {
		this.idCategory = idCategory;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getNameCategory() {
		return nameCategory;
	}


	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}


	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
}
