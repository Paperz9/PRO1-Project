package ex4student;

public class Stars
{
    public void starExA(int rowCount)
    {
        for (int row = 1; row <= rowCount; row++) {
            System.out.printf("%2d: ", row);
            int starCount = rowCount - row + 1;
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }
            for (int i = 1; i <= dashCount; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

}
