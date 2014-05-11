/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.Hospede;
import model.Registro;

/**
 *
 * @author RodriguesMoises
 */
@Resource
public class CheckController {
    private Hospede hospede;
    private Registro registro;
    private Result result;

    public CheckController(Result result) {
        this.result = result;
    }
    
    
}
