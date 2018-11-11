public class Stat {
    private int stat;
    private int modifier;
    private String name;

    public Stat() {
        stat = 0;
        modifier = 0;
        name="";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStat(int stat) {
        this.stat = stat;
        this.modifier = (stat-10)/2;
    }

    public int getStat() {
        return stat;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String statInfo = String.format("Name: %s\nScore: %d\nModifier: %d",
                this.name, this.stat, this.modifier);
        return statInfo;
    }

}
