import java.io.Serializable;
/**
 * Stat
 * A Stat is an object that represents an ability score
 * of a character
 *
 * @author  Caitie Pearce
 * @version 1.0
 * @since   2018-11-25
 */

public class Stat  implements Serializable {
    /**
     * The rolled score of a Stat
     */
    private int score;
    /**
     * The modifier used for rolls of this Stat type
     */
    private int modifier;
    /**
     * The name of the Stat
     */
    private String name;

    /**
     * Creates a Stat with the specified name
     * @param name The name of the Stat
     */
    public Stat(String name) {
        score = 0;
        modifier = 0;
        this.name=name;
    }

    /**
     * Gets a Stats modifier
     * @return The modifier for associated skill checks
     */
    public int getModifier() {
        return modifier;
    }

    /**
     * Sets the name of a Stat
     * @param name The name of the Stat
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieve the Stat's base score
     * @param stat The score of the Stat
     */
    public void setStat(int stat) {
        this.score = stat;
        double modHolder = ((float)stat-10)/2;
        if(modHolder<0)
            modHolder = Math.floor(modHolder);
        this.modifier = (int) modHolder;
    }

    /**
     * Set the Stat's base score
     * @return The score of the Stat
     */
    public int getStat() {
        return score;
    }

    /**
     * Retrieve the Stat's name
     * @return The name of the Stat
     */
    public String getName() {
        return name;
    }

    /**
     * Writes the data of a Stat to a String
     * @return The details of a Stat object
     */
    @Override
    public String toString() {
        String statInfo = String.format("Name: %s\nScore: %d\nModifier: %d\n",
                this.name, this.score, this.modifier);
        return statInfo;
    }
}
