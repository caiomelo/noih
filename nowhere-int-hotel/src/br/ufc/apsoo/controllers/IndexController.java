package br.ufc.apsoo.controllers;

import javax.annotation.Resource;

@Resource
public class IndexController {

	private final Result result;

	public IndexController(Result result) {
		this.result = result;
	}

	@Get @Path("/")
	public void index() { }

}
