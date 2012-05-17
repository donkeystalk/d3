package dardo.d3.repos;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import dardo.d3.entities.D3Character;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:config/repo.xml")
@Transactional
public class IntegrationTestD3CharacterRepository {
	
	private Logger logger = Logger.getLogger(IntegrationTestD3CharacterRepository.class);
		
	@Autowired
	private D3CharacterRepository repo;
	
	@Test
	public void testInject()
	{
		assertNotNull(repo);
	}
	
	@Rollback
	@Test
	public void testSaveD3Character()
	{
		long numCharacters = repo.count();
		D3Character character = new D3Character();
		character.setCharacterClass("Wizard");
		character.setLevel(26);
		character.setName("Dardo");
		repo.save(character);
		character = null;
		character = repo.findOne(1);
		assertNotNull(character);
		assertEquals("Dardo", character.getName());
		assertEquals(1, repo.count());
	}

}
