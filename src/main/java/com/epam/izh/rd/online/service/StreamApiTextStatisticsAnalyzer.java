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
        return 0;
    }

    @Override
    public int countNumberOfWords(String text) {
        List<String> listWordsFromText= Stream.of(text)
                .flatMap(s -> Stream.of(s.split("(\\s|,|\\.|!|-|\")+")))
                .collect(Collectors.toList());
        return listWordsFromText.size();
    }

    @Override
    public int countNumberOfUniqueWords(String text) {
        return 0;
    }

    @Override
    public List<String> getWords(String text) {
        List<String> listWordsFromText= Stream.of(text)
                .flatMap(s -> Stream.of(s.split("(\\s|,|\\.|!|-|\")+")))
                .collect(Collectors.toList());
        return listWordsFromText;
    }

    @Override
    public Set<String> getUniqueWords(String text) {
        return emptySet();
    }

    @Override
    public Map<String, Integer> countNumberOfWordsRepetitions(String text) {
        return emptyMap();
    }

    @Override
    public List<String> sortWordsByLength(String text, Direction direction) {
        return emptyList();
    }
}
