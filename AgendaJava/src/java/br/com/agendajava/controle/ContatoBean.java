/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendajava.controle;

import br.com.agendajava.dao.ContatoDao;
import br.com.agendajava.modelo.ContatoModelo;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


 @ManagedBean(name = "contatobean")
 @SessionScoped
public class ContatoBean {
     
    private ContatoDao contDao = new ContatoDao();
    private ContatoModelo contMode = new ContatoModelo();;
    private  List<ContatoModelo> lista = new VirtualFlow.ArrayLinkedList<>();
    
    public ContatoBean (){
     buscar();
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

    public List<ContatoModelo> getLista() {
        return lista;
    }

    public void setLista(List<ContatoModelo> lista) {
        this.lista = lista;
    }
    
    public void salvarDados(){
      //if(contMode.getId() == null){
          contDao.salvar(contMode);
          contMode = new ContatoModelo();
    
}
    public void buscar(){
    lista = contDao.busca();
    }
 }
