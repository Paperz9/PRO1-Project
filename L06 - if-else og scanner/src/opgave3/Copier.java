package opgave3;

public class Copier {
    private int paperCount;

    public Copier() {
        paperCount = 0;
    }

    public Copier(int paperCount) {
        this.paperCount = paperCount;
    }

    public void insertPaper(int amount) {
        if (amount > 500) {
            System.out.println("Error, can't have more than 500 sheets of paper");
        }
        else {
            this.paperCount = amount;
        }
    }

    public int getPaperCount() {
        return paperCount;
    }

    public void makeCopy() {
        if (paperCount == 0) {
            System.out.println("Error, no paper left");
        }
        else {
            paperCount = paperCount - 1;
        }
    }

    public void makeCopy(int copies) {
        if (copies > 500) {
            System.out.println("Error, can't print more than 500 copies");
        }
        else {
            paperCount = paperCount - copies;
        }
    }
}
