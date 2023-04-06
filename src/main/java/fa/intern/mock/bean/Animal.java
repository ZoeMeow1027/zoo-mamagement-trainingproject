package fa.intern.mock.bean;


public class Animal {
	private int idAnimal;
	protected Cage cages;
	protected Animal_Type types;
	protected String animalStatus;
	protected String animalName;
	protected String detail;
	protected String food;
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public Cage getCages() {
		return cages;
	}
	public void setCages(Cage cages) {
		this.cages = cages;
	}
	public Animal_Type getTypes() {
		return types;
	}
	public void setTypes(Animal_Type types) {
		this.types = types;
	}
	public String getAnimalStatus() {
		return animalStatus;
	}
	public void setAnimalStatus(String animalStatus) {
		this.animalStatus = animalStatus;
	}
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public Animal(Cage cages, Animal_Type types, String animalStatus, String animalName, String detail, String food) {
		super();
		this.cages = cages;
		this.types = types;
		this.animalStatus = animalStatus;
		this.animalName = animalName;
		this.detail = detail;
		this.food = food;
	}
	public Animal() {
		super();
	}
	
	
	
	
	
}
