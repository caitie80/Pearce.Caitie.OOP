public class Character {
    private Stat strength;
    private Stat dex;
    private Stat con;
    private Stat intel;
    private Stat wis;
    private Stat cha;
    private String name;
    private Race race;

    public Character(){
        strength = new Stat("Strength");
        dex = new Stat("Dexterity");
        con = new Stat("Constitution");
        intel = new Stat("Intelligence");
        wis = new Stat("Wisdom");
        cha = new Stat("Charisma");
        name = "";
        race = new Race();
    }

    public Stat getStrength() {
        return strength;
    }

    public void setStrength(int score) {
        this.strength.setStat(score);
    }

    public Stat getDex() {
        return dex;
    }

    public void setDex(int score) {
        this.dex.setStat(score);
    }

    public Stat getCon() {
        return con;
    }

    public void setCon(int score) {
        this.con.setStat(score);
    }

    public Stat getIntel() {
        return intel;
    }

    public void setIntel(int score) {
        this.intel.setStat(score);
    }

    public Stat getWis() {
        return wis;
    }

    public void setWis(int score) {
        this.wis.setStat(score);
    }

    public Stat getCha() {
        return cha;
    }

    public void setCha(int score) {
        this.cha.setStat(score);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRace(String name){
        race = new Race(name);
    }

    public void updateScores(){
        strength.setStat(strength.getStat()+ this.race.getStrengthMod());
        dex.setStat(dex.getStat() + this.race.getDexMod());
        con.setStat(con.getStat() + this.race.getConMod());
        intel.setStat(intel.getStat() + this.race.getIntMod());
        wis.setStat(wis.getStat() + this.race.getWisMod());
        cha.setStat(cha.getStat() + this.race.getCharMod());
    }

    public String toString(){
        String text;
        text = String.format("Name: %s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                name,strength.toString(),dex.toString(),con.toString(),
                intel.toString(),wis.toString(),cha.toString(),race.toString());

        return text;
    }
}
