import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonasManager
{
    private List<Persona> personas = new ArrayList<Persona>();

    public List<Persona> getPersonas()
    {
        return personas;
    }

    public void addPersona(Persona persona)
    {
        personas.add(persona);
    }

    public void addPersona(String name, int age, String id)
    {
        personas.add(new Persona(id, name, age));
    }

    public Persona searchPersonaByName(String name)
    {
        Optional<Persona> personaOptional = personas.stream()
                .filter(miPersonaDentroDeLaLista -> miPersonaDentroDeLaLista.getName().equals(name))//Esto "->" indica una lambda, QUE ES UNA LAMBDA? Es una función anónima.
                .findFirst();                                                                       //En ESTE caso la lambda es DE UNA SOLA LINEA, pero podría ser de mas.
                                                                                                    //y en ESTE caso, DEBE devolver un boolean, porque filter() recibe como parámetro
                                                                                                    //una función que devuelva un bool, o un PREDICADO.
        if(personaOptional.isPresent())
            return personaOptional.get();
        else
            return new Persona();

    }

    private Optional<Persona> searchOptionalPersonaByName(String name)
    {
        return personas.stream()
                .filter(miPersonaDentroDeLaLista -> miPersonaDentroDeLaLista.getName().equals(name))
                .findFirst();
    }

    public List<Persona> searchPersonasByAge(int age)
    {
        List<Persona> personasListWithSameAge = personas.stream()
                .filter(personaConEdadEnLista -> personaConEdadEnLista.getAge() == age)
                .collect(Collectors.toList());
        return personasListWithSameAge;
    }

}
