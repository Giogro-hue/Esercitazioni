public enum Outcome {
    WIN, LOSE, DRAW;

    private int count = 0 ;
    public void increment() {
        count++;
    }
    public int getCount() {
        return count;
    }
}
