package br.ufc.edeajr.controllers;

import javax.annotation.Resource;

@Resource
public class HomeController {

	@Get @Path("home")
	public void home() {}
	
}
