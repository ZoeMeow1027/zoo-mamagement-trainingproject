package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Animal_Type;
import fa.intern.mock.dao.AnimalTypeDAO;

@Service
public class AnimalTypeService {
	@Autowired
	private AnimalTypeDAO animalTypeDAO;

	public List<Animal_Type> showTypes() {
		return animalTypeDAO.showTypes();
	}
	
	

}
