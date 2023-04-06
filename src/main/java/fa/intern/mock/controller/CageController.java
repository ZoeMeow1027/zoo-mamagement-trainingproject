package fa.intern.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fa.intern.mock.bean.Animal;
import fa.intern.mock.bean.Cage;
import fa.intern.mock.bean.Staff;
import fa.intern.mock.service.AnimalService;
import fa.intern.mock.service.CageService;
import fa.intern.mock.service.StaffService;

@Controller
public class CageController {
	@Autowired
	private CageService cageService;
	@Autowired
	private StaffService staffService;
	@Autowired 
	private AnimalService animalService;

	@RequestMapping(value = "showAllCage")
    public String getAllCages(Model model) {
        List<Cage> cages = cageService.showAllCage();
        model.addAttribute("cage", cages);
        return "admin/cage";
    }
	
	@RequestMapping(value = "deleteCage", method = RequestMethod.GET)
	public String deleteCage(@RequestParam("idCage") int idCage) {
		List<Animal> data = animalService.getAnimalByIDCage(idCage);
		if (data.isEmpty()) {
			cageService.deleteCage(idCage);
			return "redirect:showAllCage";				
		}
		else return "redirect:getAnimalbyIDCage?idCage=" + idCage;
	}
		
	
	@RequestMapping(value = "searchCage", method = RequestMethod.POST)
	public String searchCage(@RequestParam("option") String option,
	                     @RequestParam("search") String search,
	                     ModelMap model) {
		 List<Cage> cages = cageService.searchCage(option, search);
		  model.addAttribute("cage", cages);
	        return "admin/cage";
	}
	
	@RequestMapping(value = "/showCageInfo", method = RequestMethod.GET)
	public String showCageInfo(@RequestParam("idCage") int idCage, ModelMap model) {
		 List<Cage> cages = cageService.showCageInfo(idCage);
		 List<Staff> staffs = staffService.showStaff();
	     model.addAttribute("staffList", staffs);
		 if (!cages.isEmpty()) {
		        model.addAttribute("cage", cages.get(0));
		    }
	        return "admin/edit";
	}
	
	@RequestMapping(value = "editCage", method = RequestMethod.POST)
	public String editCage(@RequestParam("idCage") int idCage, @RequestParam("cageName") String nameCage, @RequestParam("limit") int limit,
			@RequestParam("staffName") int staffName,
			ModelMap model) throws Exception {
		cageService.editCage(idCage, nameCage, limit, staffName);
	        return "redirect:/showAllCage";
	}
	
	@RequestMapping(value = "showStaff")
	public String showStaff(ModelMap model) {
		List<Staff> staffs = staffService.showStaff();
	     model.addAttribute("staffList", staffs);
		return "admin/addCage";
	}
	
	@RequestMapping(value = "addCage")
	public String addCage(@RequestParam("cageName") String cageName, @RequestParam("limit") int limit, 
			@RequestParam("staffName") int staffName, ModelMap model) throws Exception {
		cageService.addCage(cageName, limit, staffName);
		return "redirect:showAllCage";
	}
	
}

