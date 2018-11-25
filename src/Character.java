import java.io.*;
import java.util.ArrayList;

public class Character implements Serializable {
    private static final long serialversionUID =
            129348938L;

    private Stat strength;
    private Stat dex;
    private Stat con;
    private Stat intel;
    private Stat wis;
    private Stat cha;

    private int acrobatics;
    private int animalHandling;
    private int arcana;
    private int athletics;
    private int deception;
    private int history;
    private int insight;
    private int intimidation;
    private int investigation;
    private int medicine;
    private int nature;
    private int perception;
    private int performance;
    private int persuasion;
    private int religion;
    private int sleightOfHand;
    private int stealth;
    private int survival;

    private String name;
    private ArrayList<String> profSkills ;
    private int profBonus;
    private Race race;
    private CharacterClass cclass;

    public Character(){
        profBonus = 2;
        strength = new Stat("Strength");
        dex = new Stat("Dexterity");
        con = new Stat("Constitution");
        intel = new Stat("Intelligence");
        wis = new Stat("Wisdom");
        cha = new Stat("Charisma");
        name = "";
        race = new Race();
        cclass = new CharacterClass();
        profSkills = new ArrayList<String>();
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

    public int getProfBonus() {
        return profBonus;
    }

    public void setProfBonus(int profBonus) {
        this.profBonus = profBonus;
    }

    public CharacterClass getCclass() {
        return cclass;
    }

    public void setCclass(String cclass) {
        this.cclass = new CharacterClass(cclass);
    }

    public void setRace(String name){
        race = new Race(name);
    }

    public void setProfSkills(String skill){
        this.profSkills.add(skill);
    }

    public void updateScores(){
        strength.setStat(strength.getStat()+ this.race.getStrengthMod());
        dex.setStat(dex.getStat() + this.race.getDexMod());
        con.setStat(con.getStat() + this.race.getConMod());
        intel.setStat(intel.getStat() + this.race.getIntMod());
        wis.setStat(wis.getStat() + this.race.getWisMod());
        cha.setStat(cha.getStat() + this.race.getCharMod());
    }
    
    public void updateStrengthSkills(){
        this.athletics = this.strength.getModifier();

        for (String ps: profSkills) {
            if(ps.toLowerCase().equals("athletics")){
                this.athletics += profBonus;
            }
        }
    }

    public void updateDexSkills(){
        this.acrobatics = this.dex.getModifier();
        this.sleightOfHand = this.dex.getModifier();
        this.stealth = this.dex.getModifier();

        for (String ps: profSkills) {
            if(ps.toLowerCase().equals("acrobatics")){
                this.acrobatics += profBonus;
            }

            else if(ps.toLowerCase().equals("sleight of hand")){
                this.sleightOfHand += profBonus;
            }

            else if(ps.toLowerCase().equals("stealth")){
                this.sleightOfHand += profBonus;
            }
        }

    }

    public void updateIntSkills(){
        this.arcana = this.intel.getModifier();
        this.history = this.intel.getModifier();
        this.investigation = this.intel.getModifier();
        this.nature = this.intel.getModifier();
        this.religion = this.intel.getModifier();

        for (String ps: profSkills) {
            if(ps.toLowerCase().equals("arcana")){
                this.arcana += profBonus;
            }

            else if(ps.toLowerCase().equals("investigation")){
                this.investigation += profBonus;
            }

            else if(ps.toLowerCase().equals("nature")){
                this.nature += profBonus;
            }
            else if(ps.toLowerCase().equals("religion")){
                this.religion += profBonus;
            }
        }
    }

    public void updateWisSkills(){
        this.animalHandling = this.wis.getModifier();
        this.insight = this.wis.getModifier();
        this.medicine = this.wis.getModifier();
        this.perception = this.wis.getModifier();
        this.survival = this.wis.getModifier();

        for (String ps: profSkills) {
            if(ps.toLowerCase().equals("animal handling")){
                this.animalHandling += profBonus;
            }

            else if(ps.toLowerCase().equals("insight")){
                this.insight += profBonus;
            }

            else if(ps.toLowerCase().equals("medicine")){
                this.medicine += profBonus;
            }
            else if(ps.toLowerCase().equals("perception")){
                this.perception += profBonus;
            }
            else if(ps.toLowerCase().equals("survival")){
                this.survival += profBonus;
            }
        }
    }

    public void updateChaSkills(){
      this.deception = this.cha.getModifier();
      this.intimidation = this.cha.getModifier();
      this.performance = this.cha.getModifier();
      this.persuasion = this.cha.getModifier();

        for (String ps: profSkills) {
            if(ps.toLowerCase().equals("deception")){
                this.deception += this.profBonus;
            }

            else if(ps.toLowerCase().equals("intimidation")){
                this.intimidation += this.profBonus;
            }

            else if(ps.toLowerCase().equals("performance")){
                this.performance += this.profBonus;
            }
            else if(ps.toLowerCase().equals("persuasion")){
                this.persuasion += this.profBonus;
            }
        }
    }

    public String statsToString(){
        String text;
        text = String.format("%s\n%s\n%s\n%s\n%s\n%s\n",strength.toString(),dex.toString(),con.toString(),
                intel.toString(),wis.toString(),cha.toString());
        return text;
    }

    public String skillsToString(){
        String text = "";
        text += "Acrobatics: " + acrobatics;
        text += "\nAnimal Handling: " + animalHandling;
        text += "\nArcana: " + arcana;
        text += "\nAthletics: " + athletics;
        text += "\nDeception: " + deception;
        text += "\nHistory: " + history;
        text += "\nInsight: " + insight;
        text += "\nIntimidation: " + intimidation;
        text += "\nInvestigation: " + investigation;
        text += "\nMedicine: " + medicine;
        text += "\nNature: " + nature;
        text += "\nPerception: " + perception;
        text += "\nPerformance: " + performance;
        text += "\nPersuasion: " + persuasion;
        text += "\nReligion: " + religion;
        text += "\nSlight of Hand: " + sleightOfHand;
        text += "\nStealth: " + stealth;
        text += "\nSurvival: " + survival;

        text+="\nProficiencies:";

        for (String skill: profSkills) {
            text+="\n-" + skill;
        }
        return text;
    }

    public String infoToString(){
        String text;
        text = String.format("Name: %s\n%s\n%s",
                name,race.toString(),cclass.toString());
           return text;
    }

    public void saveCharacter(){
        try{
            FileOutputStream fileOut = new FileOutputStream(this.getName() + "character.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(this);
            out.close();
            fileOut.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Character loadCharacter(File c){
        Character chara = null;
        try{
            FileInputStream fileIn = new FileInputStream(c);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            chara = (Character) in.readObject();
            in.close();
            fileIn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }


        return chara;

    }
}
