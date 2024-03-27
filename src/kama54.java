public class kama54 {
    public static void main(String[] args) {
        String s = "a1b2c3";
        solutionmaka54 so = new solutionmaka54();

        System.out.println(so.replaceNumber(s));
    }

}
class solutionmaka54 {
    public String replaceNumber(String s) {
        StringBuilder res = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch))
                res.append("number");
            else
                res.append(ch);
        }
        return res.toString();
    }
}

