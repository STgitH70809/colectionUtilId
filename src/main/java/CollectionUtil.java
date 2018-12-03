//package com.fd.sfelix.core.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CollectionUtil {

    /**
     * Get the list or return an empty list
     * @param list list param
     * @param <T> type of the list
     * @return the list or empty list
     */
    public static <T> List<T> getOrEmpty(List<T> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList());
    }

    /**
     * Get the first item of a list
     * @param list list param
     * @param <T> type of the list
     * @return Optional.empty() if nothing found, or the first item
     */
    public static <T> Optional<T> getFirst(List<T> list) {
        return getOrEmpty(list).stream()
                .findFirst();
    }

    /**
     * Get the stream which is null-safe out of the list
     *
     * @param list list of items
     * @param <T>  item type T
     * @return a null-safe stream
     */
    public static <T> Stream<T> nullSafeStream(List<T> list) {
        return getOrEmpty(list).stream().filter(Objects::nonNull);
    }

    /**
     * Get an random item of a collection
     *
     * @param col a collection type of T
     * @param <T> type of the collection
     * @return the random item or Optional.empty() if there is nothing found
     */
    public static <T> Optional<T> getRandom(Collection<T> col) {
        List<T> tempt = new ArrayList<>(col);
        Collections.shuffle(tempt);
        return CollectionUtil.getFirst(tempt);
    }
}
