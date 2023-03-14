package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Chat;

public interface IDAOChat extends JpaRepository<Chat,Integer> {
	
	public List<Chat> findAllByClientId(Integer id);
	
}
