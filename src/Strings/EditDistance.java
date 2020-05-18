package Strings;

public class EditDistance {

    public boolean check(String a, String b) {
        if (a == null && b != null) return false;
        if (a != null && b == null) return false;

        if (Math.abs(a.length() - b.length()) > 1) return false;

        if (a == null && b == null) return true;

        int allowedChanges = 1;
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) != b.charAt(j)) {
                if (a.length() > b.length()) {
                    j--; // stay same index in b
                } else if (a.length() < b.length()) {
                    i--; // stay same index in a
                } else { // equal length
                    // do nothing advance (replace)
                }
                allowedChanges--;
                if (allowedChanges < 0)
                    return false;
            }
            i++;
            j++;
        }
        return (allowedChanges <= 1);
    }

    public static void main(String args[]) {
        String a = "abcdef";
//        String b = "abdef";
        String b = "abddef";

        EditDistance ed = new EditDistance();
        System.out.println("Edit Distance = " + ed.check(a,b));
    }
}
