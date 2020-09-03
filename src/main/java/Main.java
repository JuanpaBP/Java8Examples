import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main
{
    public static void main(String[] args)
    {
        PersonasManager personasManager = new PersonasManager();
        Persona p = new Persona("A1", "Rosio", 22);
        Persona p2 = new Persona("A2", "Rosio", 22);
        Persona p3 = new Persona("A3", "Rhernan", 22);
        Persona p4 = new Persona("A4", "Melania", 23);
        Persona p5 = new Persona("A5", "BRNDN", 22);

        Persona p1 = new Persona();

        p1 = new Persona();


        personasManager.addPersona(p);
        personasManager.addPersona(p2);
        personasManager.addPersona(p3);
        personasManager.addPersona(p4);
        personasManager.addPersona(p5);

        Persona definitiva = personasManager.searchPersonaByName("JUAN");
        System.out.println(definitiva.getName().concat(" tiene ").concat(String.valueOf(definitiva.getAge())));

        Predicate<Persona> myPredicate = (juancitobajatedeltecho) -> juancitobajatedeltecho.getName().equals("Rosio");

        System.out.println(myPredicate.test(p));
        System.out.println(myPredicate.test(p2));
        System.out.println(myPredicate.test(p3));
        System.out.println(myPredicate.test(p4));
        System.out.println(myPredicate.test(p5));

        List<Persona> list = personasManager.searchPersonasByAge(22);
        Predicate<Persona> myFilterCondition = (persona) -> persona.getName().startsWith("R");
        list.stream()
                .filter( persona -> myFilterCondition.test(persona))
                .forEach( persona ->
        {
            System.out.print(persona.getName());
            System.out.println(" tiene ".concat(String.valueOf(persona.getAge())));
        });

    }
}
