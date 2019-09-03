/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendajava.controle;

import br.com.agendajava.dao.ContatoDao;
import br.com.agendajava.modelo.ContatoModelo;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "contatobean")
@RequestScoped
public class ContatoBean {

    private ContatoDao contDao;
    private ContatoModelo contMode;
    private ArrayList<ContatoModelo> lista;

    public ContatoBean() {
        //buscar();
        contDao = new ContatoDao();
        contMode = new ContatoModelo();
        lista = contDao.busca();
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

    public ArrayList<ContatoModelo> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ContatoModelo> lista) {
        this.lista = lista;
    }

    public void salvarDados() {
        //if(contMode.getId() == null){
        contDao.salvar(contMode);
        lista.add(contMode);
        contMode = new ContatoModelo();

    }

    public void buscar() {
        lista = contDao.busca();
        lista.add(contMode);
    }
}
