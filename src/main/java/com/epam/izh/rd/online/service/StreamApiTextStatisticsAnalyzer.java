package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.helper.Direction;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.*;

/**
 * Данный класс обязан использовать StreamApi из функционала Java 8. Функциональность должна быть идентична
 * {@link SimpleTextStatisticsAnalyzer}.
 */
public class StreamApiTextStatisticsAnalyzer implements TextStatisticsAnalyzer {
    @Override
    public int countSumLengthOfWords(String text) {
        return (int) Stream.of(text.split("(\\s|,|\\.|!|-|\")+"))
                .mapToInt(s -> s.length())
                .sum();

    }

    @Override
    public int countNumberOfWords(String text) {
        return (int) Stream.of(text.split("(\\s|,|\\.|!|-|\")+"))
                .count();
    }

    @Override
    public int countNumberOfUniqueWords(String text) {
        return (int) Stream.of(text.split("(\\s|,|\\.|!|-|\")+"))
                .distinct()
                .count();
    }

    @Override
    public List<String> getWords(String text) {
        return Stream.of(text.split("(\\s|,|\\.|!|-|\")+"))
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> getUniqueWords(String text) {
        return Stream.of(text.split("(\\s|,|\\.|!|-|\")+"))
                .collect(Collectors.toSet());
    }

    @Override
    public Map<String, Integer> countNumberOfWordsRepetitions(String text) {
        Map<String, Integer> countNumberOfWordsRepetitions = Stream.of(text)
                .flatMap(s -> Stream.of(s.split("(\\s|,|\\.|!|-|\")+")))
                .collect(HashMap::new, (m, c) -> {
                    if (m.containsKey(c)) {
                        m.put(c, m.get(c) + 1);
                    } else {
                        m.put(c, 1);
                    }
                }, HashMap::putAll);

        return countNumberOfWordsRepetitions;
    }

    @Override
    public List<String> sortWordsByLength(String text, Direction direction) {
        if (direction.equals(Direction.ASC)) {
            return Stream.of(text.split("(\\s|,|\\.|!|-|\")+"))
                    .sorted(Comparator.comparing(String::length))
                    .collect(Collectors.toList());
        } else {
            return Stream.of(text.split("(\\s|,|\\.|!|-|\")+"))
                    .sorted((f1, f2) -> Integer.compare(f2.length(), f1.length()))
                    .collect(Collectors.toList());
        }
    }
}
