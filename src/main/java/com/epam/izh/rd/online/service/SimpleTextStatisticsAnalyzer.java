package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.helper.Direction;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Совет:
 * Начните с реализации метода {@link SimpleTextStatisticsAnalyzer#getWords(String)}.
 * Затем переиспользуйте данный метод при реализации других.
 * <p>
 * При необходимости, можно создать внутри данного класса дополнительные вспомогательные приватные методы.
 */
public class SimpleTextStatisticsAnalyzer implements TextStatisticsAnalyzer {

    /**
     * Необходимо реализовать функционал подсчета суммарной длины всех слов (пробелы, знаким препинания итд не считаются).
     * Например для текста "One, I - tWo!!" - данный метод должен вернуть 7.
     *
     * @param text текст
     */
    @Override
    public int countSumLengthOfWords(String text) {
        List<String> listWordsFromText = new ArrayList<>();
        for(String word:text.split("(\\s|,|\\.|!|-|\")+")){
            listWordsFromText.add(word);
        }
        int countSumLengthOfWords = 0;
        for(int i=0;i<listWordsFromText.size();i++){
            countSumLengthOfWords = listWordsFromText.get(i).length()+countSumLengthOfWords;
        }
        return countSumLengthOfWords;
    }

    /**
     * Необходимо реализовать функционал подсчета количества слов в тексте.
     * Например для текста "One, two, three, three - one, tWo, tWo!!" - данный метод должен вернуть 7.
     *
     * @param text текст
     */
    @Override
    public int countNumberOfWords(String text) {
        List<String> listWordsFromText = new ArrayList<>();
        for(String word:text.split("(\\s|,|\\.|!|-|\")+")){
            listWordsFromText.add(word);
        }
        return listWordsFromText.size();
    }

    /**
     * Необходимо реализовать функционал подсчета количества уникальных слов в тексте (с учетом регистра).
     * Например для текста "One, two, three, three - one, tWo, tWo!!" - данный метод должен вернуть 5.
     * param text текст
     */
    @Override
    public int countNumberOfUniqueWords(String text) {
        List<String> listOfDuplicateWords = Arrays.asList((text).split("(\\s|,|\\.|!|-|\")+"));
        HashSet<String> uniqueWordsFromList = new HashSet<>();
        uniqueWordsFromList.addAll(listOfDuplicateWords);

        return uniqueWordsFromList.size();
    }

    /**
     * Необходимо реализовать функционал получения списка слов из текста.
     * Пробелы, запятые, точки, кавычки и другие знаки препинания являются разделителями слов.
     * Например для текста "One, two, three, three - one, tWo, tWo!!" должен вернуться список :
     * {"One", "two", "three", "three", "one", "tWo", "tWo"}
     *
     * @param text текст
     */
    @Override
    public List<String> getWords(String text) {
        return Stream.of(text)
                .flatMap(s -> Stream.of(s.split("(\\s|,|\\.|!|-|\")+")))
                .collect(Collectors.toList());
    }

    /**
     * Необходимо реализовать функционал получения списка уникальных слов из текста.
     * Пробелы, запятые, точки, кавычки и другие знаки препинания являются разделителями слов.
     * Например для текста "One, two, three, three - one, tWo, tWo!!" должен вернуться список :
     * {"One", "two", "three", "one", "tWo"}
     *
     * @param text текст
     */
    @Override
    public Set<String> getUniqueWords(String text) {

        return Stream.of(text)
                .flatMap(s -> Stream.of(s.split("(\\s|,|\\.|!|-|\")+")))
                .collect(Collectors.toSet());
    }

    /**
     * Необходимо реализовать функционал подсчета количества повторений слов.
     * Например для текста "One, two, three, three - one, tWo, tWo!!" должны вернуться результаты :
     * {"One" : 1, "two" : 1, "three" : 2, "one" : 1, "tWo" : 2}
     *
     * @param text текст
     */
    @Override
    public Map<String, Integer> countNumberOfWordsRepetitions(String text) {

        Map<String, Integer> unique = new TreeMap<String, Integer>();
        String stringToArray[] = text.split("(\\s|,|\\.|!|-|\")+");

        for (String str : stringToArray) {
            unique.put(str, (unique.get(str) == null ? 1 : (unique.get(str) + 1)));
        }
        return unique;
    }

    /**
     * Необходимо реализовать функционал вывода слов из текста в отсортированном виде (по длине) в зависимости от параметра direction.
     * Например для текста "Hello, Hi, mother, father - good, cat, c!!" должны вернуться результаты :
     * ASC : {"mother", "father", "Hello", "good", "cat", "Hi", "c"}
     * DESC : {"c", "Hi", "cat", "good", "Hello", "father", "mother"}
     *
     * @param text текст
     */
    @Override
    public List<String> sortWordsByLength(String text, Direction direction) {
        List<String> str = Arrays.asList(text.split("(\\s|,|\\.|!|-|\")+"));

        Comparator<String> sortUpLenthString = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        if (direction.equals(Direction.ASC)) {
            Collections.sort(str, sortUpLenthString);

        } else {
            str.sort((o1, o2) -> Integer.compare(o2.length(), o1.length()));
        }
        return str;
    }
}
