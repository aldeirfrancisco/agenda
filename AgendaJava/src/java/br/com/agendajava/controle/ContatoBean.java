/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendajava.controle;

import br.com.agendajava.dao.ContatoDao;
import br.com.agendajava.modelo.ContatoModelo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


 @ManagedBean(name = "contatobean")
 @SessionScoped
public class ContatoBean {
    private ContatoDao contDao = new ContatoDao();
    private ContatoModelo contMode;

    public ContatoBean (){
     
     contMode = new ContatoModelo();
 }
    public ContatoDao getContDao() {
        return contDao;
    }

    public void setContDao(ContatoDao contDao) {
        this.contDao = contDao;
    }

    public ContatoModelo getContMode() {
        return contMode;
    }

    public void setContMode(ContatoModelo contModelo) {
        this.contMode = contModelo;
    }
    public void salvarDados(){
      //if(contMode.getId() == null){
          contDao.salvar(contMode);
          contMode = new ContatoModelo();
    
}
 }
