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

    public static String removeCharAt(String s, int pos){
        return s.substring(0, pos) + s.substring(pos + 1);
    }

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
        String tempSeq = sequence;
        while (i < tempSeq.length()) {
            while ((i < tempSeq.length()) &&
                    (tempSeq.charAt(i) == OPEN_PAR ||
                            tempSeq.charAt(i) == OPEN_SQR ||
                            tempSeq.charAt(i) == OPEN_BRACE)) {
                opens += tempSeq.charAt(i);
                i++;
            }
            while ((i< tempSeq.length()) &&
                    (tempSeq.charAt(i) == CLOSE_PAR ||
                            tempSeq.charAt(i) == CLOSE_SQR ||
                            tempSeq.charAt(i) == CLOSE_BRACE)) {
                close += tempSeq.charAt(i);
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
                    } else {
                        return false;
                    }
                }
                close = "";
                opens = "";
            } else {
                int diffLen = opens.length() - close.length();
                for (int l = 0; l < close.length(); l++){
                    if ((opens.charAt(l + diffLen) == OPEN_PAR &
                            close.charAt(close.length() - l - 1) == CLOSE_PAR) ||
                            (opens.charAt(l + diffLen) == OPEN_SQR &
                                    close.charAt(close.length() - l - 1) == CLOSE_SQR) ||
                            (opens.charAt(l + diffLen) == OPEN_BRACE &
                                    close.charAt(close.length() - l - 1) == CLOSE_BRACE)){
                    } else {
                        return false;
                    }
                }
                for (int y = diffLen; y < close.length()*2+1; y++ ) {
                    tempSeq = removeCharAt(tempSeq, diffLen);
                }
                i = 0;
                close = "";
                opens = "";
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(CorrectBracketSequencePredicate.test("{(())()[{}]}"));
    }
}
