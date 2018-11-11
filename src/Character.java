public class Character {
    private Stat[] abilities = new Stat[6];

    public Character(){

    }

    public void setAbility(int index,String name, int score){
        abilities[index] = new Stat();
        abilities[index].setName(name);
        abilities[index].setStat(score);
    }

    public Stat getAbility(int index){
        return abilities[index];
    }
}
