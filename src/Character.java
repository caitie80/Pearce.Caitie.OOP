public class Character {
    private Stat[] abilities;
    private String name;
    private Race race;

    public Character(){
        abilities = new Stat[6];
        name = "";
    }

    public void setAbility(int index,String name, int score){
        abilities[index] = new Stat();
        abilities[index].setName(name);
        abilities[index].setStat(score);
    }

    public Stat getAbility(int index){
        return abilities[index];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
