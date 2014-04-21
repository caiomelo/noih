package br.ufc.apsoo.controllers;

import javax.annotation.Resource;

@Resource
public class RelatoriosController {
	private final Result result;
	
	public RelatoriosController(Result result) {
		this.result = result;
	}
	
	@Get @Path("/relatorios")
	public void index() {
		result.include("ativo", "relatorios");
	}
}
