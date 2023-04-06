package fa.intern.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fa.intern.mock.bean.Animal;
import fa.intern.mock.bean.Animal_Type;
import fa.intern.mock.bean.Cage;
import fa.intern.mock.service.AnimalService;
import fa.intern.mock.service.AnimalTypeService;
import fa.intern.mock.service.CageService;

@Controller
public class AnimalController {

	@Autowired
	private AnimalService animalService;
	@Autowired
	private AnimalTypeService animalTypeService;
	@Autowired 
	private CageService cageService;

	@RequestMapping(value = "/getAnimalbyIDCage")
	public String getAnimalByIDCage(@RequestParam("idCage") int idCage, ModelMap model) {
		List<Animal> animals = animalService.getAnimalByIDCage(idCage);
		model.addAttribute("animal", animals);
		model.addAttribute("idCage" ,idCage);
		return "admin/AnimalbyCage";
	}

	@RequestMapping(value = "deleteAnimal", method = RequestMethod.GET)
	public String deleteCage(@RequestParam("idAnimal") int idAnimal, @RequestParam("idCage") int idCage) {
		if (animalService.deleteAnimal(idAnimal)) {
			return "redirect:getAnimalbyIDCage?idCage=" + idCage;
		} else
			return "redirect:admin/AnimalbyCage";
	}

	@RequestMapping(value = "showAnimalInfo", method = RequestMethod.GET)
	public String showAnimalInfo(@RequestParam("idAnimal") int idAnimal, ModelMap model) {
		List<Animal> animals = animalService.showAnimalInfo(idAnimal);
		List<Animal_Type> types = animalTypeService.showTypes();
		model.addAttribute("animalTypeList", types);
		if (!animals.isEmpty()) {
			model.addAttribute("animal", animals.get(0));
		}
		return "admin/editAnimal";
	}

	@RequestMapping(value = "/searchAnimal")
	public String searchAnimal(@RequestParam("idCage") String idCage, @RequestParam("option") String option, @RequestParam("search") String search,
			ModelMap model) {
		List<Animal> animals = animalService.searchAnimal(idCage, option, search);
		model.addAttribute("idCage", idCage);
		model.addAttribute("animal", animals);
		return "admin/AnimalbyCage";
	}
		
	@RequestMapping(value = "/editAnimal")
	public String editAnimal(@RequestParam("idAnimal")int idAnimal, @RequestParam("animalName") String animalName, 
			@RequestParam("animalStatus") String animalStatus, @RequestParam("idCage") int idCage,
			@RequestParam("detail") String detail, @RequestParam("food") String food, 
			@RequestParam("animalType") int animalType, ModelMap model) {
		animalService.editAnimal(idAnimal, animalName, animalStatus, detail, food, animalType);
		return "redirect:/getAnimalbyIDCage?idCage=" + idCage;
	}
	
	@RequestMapping(value = "showType")
	public String showType(@RequestParam("idCage") int idCage, ModelMap model) {
		
		if(cageService.showCageInfo(idCage).get(0).getLimit() <= animalService.getAnimalByIDCage(idCage).size()) {
			return "redirect:getAnimalbyIDCage?idCage=" + idCage;
		}
		
		List<Animal> animals = animalService.getAnimalByIDCage(idCage);
		model.addAttribute("animalList", animals);
		List<Animal_Type> types = animalTypeService.showTypes();
		model.addAttribute("typeList", types);
		model.addAttribute("idCage", idCage);
		return "admin/addAnimal";
	}
	
	@RequestMapping(value = "addAnimal")
	public String addAnimal(@RequestParam("idCage") int idCage, @RequestParam("animalName") String animalName,
			@RequestParam("status") String status, @RequestParam("detail") String detail, 
			@RequestParam("food") String food, @RequestParam("type") int type, ModelMap model) throws Exception {
		animalService.addAnimal(idCage, animalName, status, detail, food, type);
		return "redirect:/getAnimalbyIDCage?idCage=" + idCage;
	}
}
