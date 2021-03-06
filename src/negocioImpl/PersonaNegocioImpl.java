package negocioImpl;

import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidades.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio{

	PersonaDao pDao = new PersonaDaoImpl();
	
	@Override
	public int insert(Persona persona) {
		
		// Si existen datos iguales -1
		// Campos incorrectos 0
		// Alta exitosa 1
		
		int estadoInsert = 1;
		
		if(persona.getNombre().trim().length()>0 && persona.getApellido().trim().length()>0 && persona.getDni().trim().length()>0)
		{
			// Si no existe, inserto los datos a la bd
			if(!verificarExistencia(pDao.readAll(), persona)) {
				// Verifico si se puede insertar, si no un campo esta mal
				if(pDao.insert(persona)) {
					estadoInsert = 1;
				}else estadoInsert = -2; //si no se pudo insertar
			}
			// Si existe, devuelve -1
			else {
				estadoInsert = -1;
			}
	
		}
		else estadoInsert = 0;
		
		return estadoInsert;
	}

	
	@Override
	public int update(Persona persona_modificar) {
		int estadoUpdate;
		if(persona_modificar.getNombre().trim().length()>0 && persona_modificar.getApellido().trim().length()>0 && persona_modificar.getDni().trim().length()>0) {
			if(pDao.update(persona_modificar)) {
				estadoUpdate = 1; // si se pudo hacer el update devuelve 1
			}else estadoUpdate=-1; //si no se pudo hacer devuelve -1
		}else estadoUpdate =0; //si un campo esta vacio devuelve 0
		// TODO Auto-generated method stub
		return estadoUpdate;
	}
	
	private boolean verificarExistencia(List<Persona> listPersona, Persona persona_a_comparar) {
		
		boolean existe = false;
		
		ArrayList<Persona> arrListPersona = (ArrayList<Persona>) listPersona;
		
		for (Persona _persona : arrListPersona) {
			if(_persona.compareTo(persona_a_comparar) == 0) existe = true;
		}
		
		return existe;
	}
	
	@Override
	public boolean delete(Persona persona) {
		boolean estadoDelete = false;
		if(persona.getDni().trim().length()>0)//Tambi?n se puede preguntar si existe ese ID 
		{
			estadoDelete= pDao.delete(persona);
		}
		return estadoDelete;
	}

	@Override
	public List<Persona> readAll() {
		return pDao.readAll();
	}



}
