package opgave5;

public class FileUtilTest {
    public static void main(String[] args) {
        FileUtil fu = new FileUtil("L32 - Filer og Exceptions/src/opgave5");

        System.out.println(fu.max("Number10.txt"));
        System.out.println(fu.min("Number2500.txt"));
    }
}
