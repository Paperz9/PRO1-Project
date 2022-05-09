package opgave3;

public class Survoyer extends Mechanic {

    private int surveys;
    private int appendixPerSurvey;

    public Survoyer(String name, String address, int apprenticeshipTest, int hourlyRate,
                    int surveys) {
        super(name, address, apprenticeshipTest, hourlyRate);
        this.surveys = surveys;
        this.appendixPerSurvey = 29;
    }

    @Override
    public double getWeeklySalary() {
        double sum = surveys * appendixPerSurvey;
        return super.getWeeklySalary() + sum;
    }

}
