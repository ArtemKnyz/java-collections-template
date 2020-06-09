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
        List<String> d = Arrays.asList(text).stream().collect(Collectors.toList());
        Stream.of(text).collect(Collectors.toList()).size();

        return d.size();
    }

    @Override
    public int countNumberOfWords(String text) {
        return (int) Stream.of(text)
                .flatMap(s -> Stream.of(s.split("(\\s|,|\\.|!|-|\")+")))
                .count();
    }

    @Override
    public int countNumberOfUniqueWords(String text) {
        return (int) Stream.of(text)
                .flatMap(s -> Stream.of(s.split("(\\s|,|\\.|!|-|\")+")))
                .distinct()
                .count();
    }

    @Override
    public List<String> getWords(String text) {
        return Stream.of(text)
                .flatMap(s -> Stream.of(s.split("(\\s|,|\\.|!|-|\")+")))
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> getUniqueWords(String text) {
        return Stream.of(text)
                .flatMap(s -> Stream.of(s.split("(\\s|,|\\.|!|-|\")+")))
                .distinct()
                .collect(Collectors.toSet());
    }

    @Override
    public Map<String, Integer> countNumberOfWordsRepetitions(String text) {

        return null;
    }

    @Override
    public List<String> sortWordsByLength(String text, Direction direction) {
        return emptyList();
    }
}
