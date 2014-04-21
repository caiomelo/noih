package br.ufc.apsoo.controllers;

import javax.annotation.Resource;

@Resource
public class FormulariosController {
	private final Result result;
	
	public FormulariosController(Result result) {
		this.result = result;
	}
	
	@Get @Path("/formularios")
	public void index() {
		result.include("ativo", "formularios");
	}
}
