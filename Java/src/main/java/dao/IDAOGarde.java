package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Garde;

public interface IDAOGarde extends JpaRepository<Garde,Integer>{
	
	public List<Garde> findAllByClientId(Integer id);
	public List<Garde> findAllByChatId(Integer id);

}
