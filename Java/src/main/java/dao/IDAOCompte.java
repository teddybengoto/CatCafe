package dao;

import java.util.List;

import model.Admin;
import model.Client;
import model.Compte;

public interface IDAOCompte extends IDAO<Compte,Integer>{

    public Compte findByLoginAndPassword(String login,String password);
	
	public List<Admin> findAllAdmin();
	public List<Client> findAllClient();
}
