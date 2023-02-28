package dao;

import java.util.List;

import model.Chat;

public interface IDAOChat extends IDAO<Chat,Integer> {
	
	public List<Chat> findAllByClient(Integer idClient);
}
