package dardo.d3.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dardo.d3.entities.D3Character;
import dardo.d3.services.D3CharacterService;

@Controller
@RequestMapping("/character")
public class CharacterController {
	
	@Autowired
	private D3CharacterService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model)
	{
		model.addAttribute("characters", service.findAllCharacters());
		return "character/index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model)
	{
		model.addAttribute("character", new D3Character());
		return "character/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String validateAdd(@ModelAttribute("character") @Valid D3Character d3Character, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "characters/add";
		}
		service.addCharacter(d3Character);
		return "redirect:/character";
	}

}
