package dardo.d3.services;

import java.util.List;

import dardo.d3.entities.D3Character;

public interface D3CharacterService {

	public List<D3Character> findAllCharacters();
	public void addCharacter(D3Character d3Character);
	
}
