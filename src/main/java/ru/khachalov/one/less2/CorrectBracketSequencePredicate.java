package ru.khachalov.one.less2;

import jdk.internal.jline.internal.Nullable;

public final class CorrectBracketSequencePredicate {

    private CorrectBracketSequencePredicate(){

    }
    final static char OPEN_PAR = '(';
    final static char CLOSE_PAR = ')';
    final static char OPEN_SQR = '[';
    final static char CLOSE_SQR = ']';
    final static char OPEN_BRACE = '{';
    final static char CLOSE_BRACE = '}';

    public static boolean test(@Nullable String sequence){
        int i=0;
        String opens = "";
        String close = "";
        if (sequence.isEmpty()){
            return true;
        } else if (sequence.charAt(0) == CLOSE_BRACE ||
                sequence.charAt(0) == CLOSE_PAR ||
                sequence.charAt(0) == CLOSE_SQR ||
                sequence.charAt(sequence.length()-1) == OPEN_PAR ||
                sequence.charAt(sequence.length()-1) == OPEN_SQR ||
                sequence.charAt(sequence.length()-1) == OPEN_BRACE ) {
            throw new IllegalArgumentException("wrong String");
        }
        while (i < sequence.length()) {
            while ((i < sequence.length()) &&
                    (sequence.charAt(i) == OPEN_PAR ||
                    sequence.charAt(i) == OPEN_SQR ||
                    sequence.charAt(i) == OPEN_BRACE)) {
                opens += sequence.charAt(i);
                i++;
            }
            while ((i< sequence.length()) &&
                    (sequence.charAt(i) == CLOSE_PAR ||
                    sequence.charAt(i) == CLOSE_SQR ||
                    sequence.charAt(i) == CLOSE_BRACE)) {
                close += sequence.charAt(i);
                i++;
            }
            if (opens.length() == close.length()){
                for (int k = 0; k < opens.length(); k++){
                    char charClose = close.charAt(close.length() - k - 1);
                    if ((opens.charAt(k) == OPEN_PAR &
                            charClose == CLOSE_PAR) ||
                        (opens.charAt(k) == OPEN_SQR &
                            charClose == CLOSE_SQR) ||
                        (opens.charAt(k) == OPEN_BRACE &
                            charClose == CLOSE_BRACE)){
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(CorrectBracketSequencePredicate.test("({})"));
    }
}
