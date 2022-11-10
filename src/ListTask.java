public enum ListTask {
    PERSONALTASK(1),
    WORKTASK(2);

    private int constant;

    public int getConstant() {
        return constant;
    }

    ListTask(int i) {
        this.constant = i;
    }

    public static ListTask getBackConstant(int i) {
        return values()[i];
    }
}
