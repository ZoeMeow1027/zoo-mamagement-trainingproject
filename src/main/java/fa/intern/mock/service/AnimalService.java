package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Animal;
import fa.intern.mock.bean.Animal_Type;
import fa.intern.mock.bean.Cage;
import fa.intern.mock.bean.Staff;
import fa.intern.mock.dao.AnimalDAO;
import fa.intern.mock.dao.AnimalTypeDAO;

@Service
public class AnimalService {
	@Autowired
	private AnimalDAO animalDAO;

	
	public List<Animal> getAnimalByIDCage(int idCage) {
	        return animalDAO.getAnimalByIDCage(idCage);
	}


	public boolean deleteAnimal(int idAnimal) {
		return animalDAO.deleteAnimal(idAnimal);
	}



	public List<Animal> showAnimalInfo(int idAnimal) {
        return animalDAO.showAnimalInfo(idAnimal);
	}


	public List<Animal> searchAnimal(String idCage, String option, String search) {
		return animalDAO.searchAnimal(idCage, option, search);
	}


	public void editAnimal(int idAnimal, String animalName, String animalStatus, String detail, String food,
			int animalType) {
		animalDAO.editAnimal(idAnimal, animalName, animalStatus, detail, food, animalType);
		
	}


	public void addAnimal(int idCage, String animalName, String status, String detail, String food, int type) throws Exception {
		animalDAO.addAnimal(idCage, animalName, status, detail, food, type);
		
	}
	
}
