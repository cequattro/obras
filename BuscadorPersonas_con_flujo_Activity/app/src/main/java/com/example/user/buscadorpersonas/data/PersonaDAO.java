package com.example.user.buscadorpersonas.data;

import java.util.List;

/**
 * Created by Android on 26/11/2016.
 */

public interface PersonaDAO {
    public  long insertarPersona(Persona persona);
    public List<Persona> listaPersona(Persona persona);
}
