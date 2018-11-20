import java.util.Random;

public class Race {
    private String name;
    private String size;
    private int speed;
    private int height;
    private int weight;
    private int strengthMod;
    private int dexMod;
    private int conMod;
    private int intMod;
    private int wisMod;
    private int charMod;
    private int heightRoll;
    private int weightRoll;
    Random rand = new Random();

    public Race(){
        this("unknown");
    }

    public Race(String name){

        strengthMod = 0;
        dexMod = 0;
        conMod = 0;
        intMod = 0;
        wisMod = 0;
        charMod = 0;

        if(name.toLowerCase().equals("elf")){
            this.name ="Elf";
            this.size = "Medium";
            this.speed = 30;
            intMod = 1;
            dexMod = 2;




            //Simulates a roll of 2d10
            heightRoll = rand.nextInt(19) + 2;
            this.height = 54+heightRoll ;

            //Simulates a roll of 1d4
            weightRoll = rand.nextInt(4) + 1;
            this.weight = 90 + (heightRoll * weightRoll);
        }

        else if(name.toLowerCase().equals("human")){
            this.name ="Human";
            this.size = "Medium";
            this.speed = 30;

            strengthMod = 1;
            dexMod = 1;
            conMod = 1;
            intMod = 1;
            wisMod = 1;
            charMod = 1;

            //Simulates a roll of 2d10
            heightRoll = rand.nextInt(19) + 2;
            this.height = 56+heightRoll ;

            //Simulates a roll of 2d4
            weightRoll = rand.nextInt(7) + 2;
            this.weight = 110 + (heightRoll * weightRoll);
        }

        else if(name.toLowerCase().equals("dwarf")){
            this.name ="Dwarf";
            this.size = "Medium";
            this.speed = 25;

            conMod = 2;
            wisMod=1;

            //Simulates a roll of 2d4
            heightRoll = rand.nextInt(7) + 2;
            this.height = 48+heightRoll ;

            //Simulates a roll of 2d6
            weightRoll = rand.nextInt(11) + 2;
            this.weight = 115 + (heightRoll * weightRoll);
        }
        else{
            this.name ="unknown name";
            this.size = "unknown size";
            this.speed = 000;
            this.height =000;
            this.weight = 000;
        }
    }

    public int getStrengthMod() {
        return strengthMod;
    }

    public int getDexMod() {
        return dexMod;
    }

    public int getConMod() {
        return conMod;
    }

    public int getIntMod() {
        return intMod;
    }

    public int getWisMod() {
        return wisMod;
    }

    public int getCharMod() {
        return charMod;
    }

    public String toString(){
        String text = String.format("\nRace: %s\nSize: %s\nSpeed: %dft\nHeight: %s" +
                "\nWeight: %dlbs",this.name,this.size,this.speed,Race.toFeetAndInches(this.height),
                this.weight);
        return text;
    }

    public static String toFeetAndInches(int height){
        String result = height/12 + "ft " +height%12 + "in";
        return result;
    }
}
