/**
 * Created by Krzysztof on 2015-03-26.
 */
public class TestCreature
{
    public static void main(String  args[])
    {
        Creature Bot = new Creature("Gremlin", Creature.Gender.MALE);
        System.out.println("Hi, i'm " + Bot.Name);
        System.out.println("Health = " + Bot.Health);
        System.out.println("Mana = " + Bot.Mana);
        Bot.setHealth(160);
        System.out.println("Health = " + Bot.Health);
        System.out.println("Mana = " + Bot.Mana);
    }
}
