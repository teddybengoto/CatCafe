package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Chat;

public interface IDAOChat extends JpaRepository<Chat,Integer> {
	
	public List<Chat> findAllByClientId(Integer id);
}
