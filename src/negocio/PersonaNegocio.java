package negocio;

import java.util.List;

import entidades.Persona;

public interface PersonaNegocio {
	public int insert(Persona persona);
	public boolean delete(Persona persona_a_eliminar);
	public int update(Persona persona_modificar);
	public List<Persona> readAll();
}
