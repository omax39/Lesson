package ru.khachalov.videolection.less2;

import jdk.internal.jline.internal.Nullable;

/*
Программа для проверки корректности скобок
Проверяются открытые и закрытые скобки
Для каждой открытой скобки должна быть закрывающая того же вида
Также должна быть соблюда правильная последовательность скобок
Используются следующие виды скобок : ( ) { } [ ]
P.S. Конечно можно было реализовать это через стек.
     Но я хотел попробовать через счетчики.
 */

public final class CorrectBracketSequencePredicate {

    /*
    Задаем каждый вид скобок в отдельную константную переменную
     */
    final static char OPEN_PAR = '(';
    final static char CLOSE_PAR = ')';
    final static char OPEN_SQR = '[';
    final static char CLOSE_SQR = ']';
    final static char OPEN_BRACE = '{';
    final static char CLOSE_BRACE = '}';

    public static String removeCharAt(String s, int pos){       // Удаление конкретного символа их строки
        return s.substring(0, pos) + s.substring(pos + 1);      // и возврат отредактированной строки
    }

    public static boolean check(@Nullable String sequence){     // Основной метод реализации проверки
        int i=0;      // Временная переменная, для проверки, что мы не превысили размер строки
        String opens = "";      // Объявление временной строки для записи открывающих скобок
        String close = "";      // Объявление временной строки для записи закрывающих скобок
        if (sequence.isEmpty()){    // Проверка строки на наличие в ней символов
            return true;        // Если строка пуста, то проверка пройдена
        } else if (sequence.charAt(0) == CLOSE_BRACE ||     // Если первый символ равен
                sequence.charAt(0) == CLOSE_PAR ||          // какой-либо из
                sequence.charAt(0) == CLOSE_SQR ||          // закрывающих скобок
                sequence.charAt(sequence.length()-1) == OPEN_PAR ||     // Либо последний символ равен
                sequence.charAt(sequence.length()-1) == OPEN_SQR ||     // какой-либо из
                sequence.charAt(sequence.length()-1) == OPEN_BRACE ) {  // открывающих скобок
            return false;       // Проверка провалена
        }
        while (i < sequence.length()) {     // Цикл пока мы обработаем все символы
            while ((i < sequence.length()) &&       // Пока все символы не обработаны
                    (sequence.charAt(i) == OPEN_PAR ||      // и проверяемый символ равен скобке вида (
                            sequence.charAt(i) == OPEN_SQR ||   // или вида [
                            sequence.charAt(i) == OPEN_BRACE)) {        // или {
                opens += sequence.charAt(i);     // добавляем во временную строку открытых скобок текущий символ
                i++;        // Переходим ко следующему символу
            }
            while ((i< sequence.length()) &&        // Пока все символы не обработаны
                    (sequence.charAt(i) == CLOSE_PAR ||     // и проверяемый символ равен скобке вида )
                            sequence.charAt(i) == CLOSE_SQR ||     // или вида ]
                            sequence.charAt(i) == CLOSE_BRACE)) {       // или }
                close += sequence.charAt(i);      // добавляем во временную строку закрытых скобок текущий символ
                i++;        // Переходим ко следующему символу
            }
            if (opens.length() == close.length()){      // Если текущее кол-во открытых скобок равно кол-ву закрытых
                                                        // То есть ситуация, когда у нас нет вставленных пар скобок
                for (int k = 0; k < opens.length(); k++){       // Перебираем текущий список открытых скобок
                    char charClose = close.charAt(close.length() - k - 1);  // временная переменная закрытой скобки,
                                                                // которая должна соответствовать текущей открытой
                    if ((opens.charAt(k) == OPEN_PAR &      // Если текущая открытая скобка
                            charClose == CLOSE_PAR) ||      // соответствует текущей закрытой
                        (opens.charAt(k) == OPEN_SQR &      // перебирается соответствие
                            charClose == CLOSE_SQR) ||      // всех видов скобок
                        (opens.charAt(k) == OPEN_BRACE &
                            charClose == CLOSE_BRACE)){     // то мы просто продолжаем выполнение программы
                    } else {
                        return false;      // Если какая-либо пара скобок не прошла проверку, то проверка провалена
                    }
                }
                close = "";     // Очищаем временные строки
                opens = "";     // Очищаем временные строки
            } else {        // Если кол-во открытых и закрытых скобок на временном участке не совпало
                int diffLen = opens.length() - close.length();      // Сколько открытых скобок осталось вначале,
                                                                    // которые мы оставим на потом
                for (int l = 0; l < close.length(); l++){           // Перебираем все закрытые скобки
                    if ((opens.charAt(l + diffLen) == OPEN_PAR &    // и сравниваем их с открытой скобкой,
                            close.charAt(close.length() - l - 1) == CLOSE_PAR) ||   // не учитывая начальные скобки,
                            (opens.charAt(l + diffLen) == OPEN_SQR &        // которые пока не проверяются.
                                    close.charAt(close.length() - l - 1) == CLOSE_SQR) ||   // сравниваем соответствие
                            (opens.charAt(l + diffLen) == OPEN_BRACE &                  // скобок, учитывая
                                    close.charAt(close.length() - l - 1) == CLOSE_BRACE)){      // расположение
                    } else {
                        return false;   // Если выявлено несоответствие, проверка провалена
                    }
                }
                for (int y = diffLen; y < close.length()*2+1; y++ ) {   // Проходимся по уже проверенным нами скобкам
                    sequence = removeCharAt(sequence, diffLen);     // и удаляем их из строки
                }
                i = 0;      // Временное значение i обнуляем.
                close = "";   // Обнуляем временные строки открытык скобок
                opens = "";     // и закрытых
            }
        }
        return true;      // Если у нас все прошло без провалов, то проверка считается пройденной успешно
    }

    public static void main(String[] args) {
        System.out.println(CorrectBracketSequencePredicate.check("{(())()[{}]}")); // тест
    }
}
