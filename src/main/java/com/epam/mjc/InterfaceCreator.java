package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return var -> {
            for (String e : var) {
                if (!e.matches("^[A-Z].*")) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> tmp = new ArrayList<>();
            for (int num : x) {
                if (num % 2 == 0) {
                    tmp.add(num);
                }
            }
            x.addAll(tmp);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();
            for (String val : values) {
                if (val.matches("^[A-Z].*\\.$") && (val.split(" ").length > 3))
                    result.add(val);
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> result = new HashMap<>();
            for (String val : x) {
                result.put(val, val.length());
            }
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x, y) -> {
            List<Integer> result = new ArrayList<>(x);
            result.addAll(y);
            return result;
        };
    }
}
