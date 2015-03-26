import com.sun.xml.internal.ws.api.message.HeaderList;

/**
 * Created by Krzysztof on 2015-03-26.
 */
public class Creature
{
    String Name;
    int Health = 1;
    int Mana = 1;
    enum Gender {MALE, FEMALE}
    Gender gender;

    public Creature(String n, Gender g)
    {
        Name = n;
        gender = g;
    }

    void setHealth(int h)
    {
        Health = h;
    }
    void setMana(int m)
    {
        Mana = m;
    }
}
