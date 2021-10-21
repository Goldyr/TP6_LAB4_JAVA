package dao;

import java.util.List;

import entidades.Persona;

public interface PersonaDao {
	public boolean insert(Persona persona);
	public boolean delete(Persona persona_a_eliminar);
	public boolean update(Persona persona_modificar);
	public List<Persona> readAll();
}
