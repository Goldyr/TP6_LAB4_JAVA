package negocio;

import java.util.List;

import entidades.Persona;

public interface PersonaNegocio {
	public int insert(Persona persona);
	public boolean delete(Persona persona_a_eliminar);
	public List<Persona> readAll();
}
