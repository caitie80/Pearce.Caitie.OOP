public class CharacterClass {
    private String name;
    private int hitDice;
    private String[] skills;

    public CharacterClass(){
        this("unknown");
    }

    public CharacterClass(String type){
        if(type.toLowerCase().equals("barbarian")){
            name = "Barbarian";
            hitDice = 12;
            skills = new String[]{"Animal Handling", "Athletics", "Intimidation", "Nature",
                    "Perception", "Survival"};
        }

        else if(type.toLowerCase().equals("cleric")){
            name = "Cleric";
            hitDice = 8;
            skills = new String[]{"History", "Insight", "Medicine", "Persuasion", "Religion"};
        }
        else if(type.toLowerCase().equals("druid")){
            name  ="Druid";
            hitDice = 8;
            skills = new String[]{"Arcana", "Animal Handling", "Insight", "Medicine", "Nature", "Perception",
                    "Religion", "Survival"};
        }
        else {
            name  ="unknown";
            hitDice = 0;
        }
    }

    public String toString(){
        String text = String.format("\nClass: %s\nHit dice: 1d%d\n",name,hitDice);
        return text;
    }
}
