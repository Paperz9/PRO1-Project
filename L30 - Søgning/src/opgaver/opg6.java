package opgaver;

public class opg6 {
    public static void main(String[] args) {
        String str = "zzgkvvmmmmm";
        System.out.println(repeatedChars(str, 6));
    }

    public static boolean repeatedChars(String s, int k){
        boolean found = false;
        int i = 0;
        while(!found && i <= s.length() - k){
            if(match(s, i, k)){
                found = true;
            } else{
                i++;
            }
        }
        return found;
    }

    public static boolean match(String string, int index, int occurrence){
        boolean foundDiff = false;
        int j = 1;
        while(!foundDiff && j <= occurrence - 1){
            if(string.charAt(index) != string.charAt(index + j)){
                foundDiff = true;
            }else{
                j++;
            }
        }
        return !foundDiff;
    }
}
