package ru.khachalov.one.less3;

public class Par {
    private String parString;

    public Par(String parString) {
        this.parString = parString;
    }

    public String parring() {
        if (parString.contains("(")) {
            int x = 0;
            int y = parString.length() - 1;
            int count = 0;
            int parOpen = 0;
            int parClose = 0;
            while (count == 0 & (x < parString.length())) {
                if (parString.charAt(x) == '(') {
                    parOpen = x;
                    count++;
                }
                x++;
            }
            while (count == 1 & (y > parOpen)) {
                if (parString.charAt(y) == ')') {
                    parClose = y;
                    count++;
                }
            }
            parString = parString.substring(parOpen+1,parClose);
            parring();
            return parString;
        }
        return parString;
    }


}
