package opgave3;

public class Survoyer extends Mechanic {

    private int surveys;
    private int bonusPerSurvey;

    public Survoyer(String name, String address, int apprenticeshipTest, int hourlyRate,
                    int surveys) {
        super(name, address, apprenticeshipTest, hourlyRate);
        this.surveys = surveys;
        this.bonusPerSurvey = 29;
    }

    @Override
    public double getWeeklySalary() {
        double sum = surveys * bonusPerSurvey;
        return super.getWeeklySalary() + sum;
    }

}
