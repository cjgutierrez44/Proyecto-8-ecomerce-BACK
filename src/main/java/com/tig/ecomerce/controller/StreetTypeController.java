package com.tig.ecomerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tig.ecomerce.model.StreetType;
import com.tig.ecomerce.service.StreetTypeService;

@RestController
@RequestMapping("/streetTypes")
@CrossOrigin(origins = "*")
public class StreetTypeController {
	@Autowired
	private StreetTypeService streetTypeService;
	
	@GetMapping("")
	private List<StreetType> getStreetTypes(){
		return streetTypeService.getStreetTypes();
	}
	
}
