package lesson5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataDemo {

    public static void main(String[] args) {
        //Итоговый вывод - [33, 22]
        List<Data> dataList = List.of(
                new Data("22", "1"),
                new Data("11", "3"),
                new Data("33", "1"));
        List<Data> dataList1 = List.of(
                new Data("11", "3"),
                new Data("22", "3"),
                new Data("33", "2"));
        System.out.println(findData(dataList, dataList1));
        System.out.println("--------------------");
        System.out.println(findData2(dataList, dataList1));
        System.out.println("--------------------");
        System.out.println(findData3(dataList, dataList1));
    }

    public static Collection<String> findData(List<Data> data, List<Data> data2) {
        return data.stream()
                .filter(v1 -> data2.stream()
                        .anyMatch(v2 -> v1.getCode().equals(v2.getCode())
                                        && !v1.getVersion().equals(v2.getVersion())))
                .map(Data::getCode)
                .toList();
    }

    public static Collection<String> findData2(List<Data> data, List<Data> data2) {
        return Stream.concat(data.stream(), data2.stream())
                .collect(Collectors.groupingBy(Data::getCode,
                        Collectors.mapping(Data::getVersion, Collectors.toSet())))
                .entrySet().stream()
                .filter(v -> v.getValue().size() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Collection<String> findData3(List<Data> data, List<Data> data2) {
        return Stream.of(data, data2)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(Data::getCode, Data::getVersion, (old, n) -> old.equals(n) ? null : n))
                .entrySet().stream()
                .filter(e -> e.getValue() != null)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}
