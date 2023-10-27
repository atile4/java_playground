public class AttClass {
    public boolean validCheck(String input, String[] l) {
        for (String s : l) {
            if (input.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public boolean validCheck(char input, char[] l) {
        for (int i = 0; i < l.length; i++) {
            if (input == l[0]) {
                return true;
            }
        }
        return false;
    }
}
