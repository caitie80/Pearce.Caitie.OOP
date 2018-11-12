public class Stat {
    private int score;
    private int modifier;
    private String name;

    public Stat(String name) {
        score = 0;
        modifier = 0;
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStat(int stat) {
        this.score = stat;
        double modHolder = ((float)stat-10)/2;
        if(modHolder<0)
            modHolder = Math.floor(modHolder);
        this.modifier = (int) modHolder;
    }

    public int getStat() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String statInfo = String.format("Name: %s\nScore: %d\nModifier: %d\n",
                this.name, this.score, this.modifier);
        return statInfo;
    }

}
