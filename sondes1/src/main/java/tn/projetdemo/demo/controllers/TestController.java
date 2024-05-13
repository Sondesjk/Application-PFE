package tn.projetdemo.demo.controllers;


import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class TestController {

	//@RequestMapping(method = RequestMethod.GET, value = "/testController")
	@GetMapping(value = "/secondtestcontroller")
	public String testController()
	{
		return "Bonjour !!!";
	}
	
	@GetMapping(value = "/secondtest")
	public String secondTest()
	{
	return	"second test !!!!";
	}
	
	
}
