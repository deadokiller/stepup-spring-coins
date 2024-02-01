package javapro.lesson4;

import javapro.lesson4.model.Employee;
import javapro.lesson4.model.Position;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class lesson4 {
    public static Integer getBiggestThirdNumber(List<Integer> massive) {
        return massive.stream().sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst().orElse(null);
    }

    public static Integer getBiggestThirdNumberDistinct(List<Integer> massive) {
        return massive.stream().sorted(Comparator.reverseOrder())
                .distinct()
                .skip(2)
                .findFirst().orElse(null);
    }

    public static List<Integer> getDistinct(List<Integer> massive) {
        return massive.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> getOldestEngineerName(List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.getPosition().equals(Position.ENGINEER))
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .limit(3)
                .sorted(Comparator.comparingInt(Employee::getAge))
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public static Double getAverageAge(List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.getPosition().equals(Position.ENGINEER))
                .mapToDouble(Employee::getAge)
                .average()
                .orElse(Double.NaN);
    }

    public static String getLongestWord(List<String> wordList) {
        return wordList.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }

    public static Map<String, Long> getMap(String string) {
        return Arrays.stream(string.split(" "))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
    }

    public static List<String> getOrderStringList(List<String> list) {
        return list.stream()
                .sorted((s1, s2) -> {
                    var t = s1.length() - s2.length();
                    if (t == 0) {
                        return s1.compareTo(s2);
                    } else {
                        return t;
                    }
                })
                .collect(Collectors.toList());
    }

    public static String getLongestLongestWord(List<String> stringList) {
        return stringList.stream()
                .flatMap(s -> Stream.of(s.split(" ")))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }
}
