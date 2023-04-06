package fa.intern.mock.bean;

public class Animal_Type {
	private int idAnimalType;
	protected String animalType;
	public int getIdAnimalType() {
		return idAnimalType;
	}
	public void setIdAnimalType(int idAnimalType) {
		this.idAnimalType = idAnimalType;
	}
	public String getAnimalType() {
		return animalType;
	}
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	public Animal_Type(String animalType) {
		super();
		this.animalType = animalType;
	}
	public Animal_Type() {
		super();
	}
	
	
	
}
