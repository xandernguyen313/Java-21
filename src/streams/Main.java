package streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1,2,2,7,3,4,5,6));
        List<Integer> even = list.stream().filter(num -> num % 2 == 0).toList();
        System.out.println(even);

        Integer maxNum = list.stream().max((n1, n2) -> n1.compareTo(n2)).get();
        System.out.println(maxNum);

        int sum = list.stream().reduce(0, (integer, integer2) -> integer+integer2);
        System.out.println(sum);

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> upperNames = names.stream().map(s -> s.toUpperCase()).toList();
        System.out.println(upperNames);

        List<Integer> sortedList = list.stream().sorted().toList();
        System.out.println(sortedList);

        long count = list.stream().filter(n -> n > 5).count();
        System.out.println(count);

        List<Integer> distnctList = list.stream().distinct().toList();
        System.out.println(distnctList);

        int num = list.stream().findAny().get();
        System.out.println(num);

        List<String> fullNames = Arrays.asList("Alice Johnson", "Bob Harris", "Charlie Lou");
        List<String> firstNames = fullNames.stream().map(s -> s.split(" ")[0]).toList();
        System.out.println(firstNames);

        List<Integer> listNum = new ArrayList<>(List.of(1,2,2,-7,3,4,5,6));
        System.out.println(listNum.stream().allMatch(n -> n > 0));

        List<List<Integer>> nestedNumbers = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5));
        List<Integer> nums = nestedNumbers.stream().flatMap(ls -> ls.stream()).toList();
        System.out.println(nums);

        User u1 = new User(11, "X");
        User u2 = new User(33, "Y");
        User u3 = new User(33, "Z");
        User u4 = new User(44, "W");
        User u5 = new User(55, "R");
        List<User> users = Arrays.asList(u1, u2, u3, u4, u5);
        Map<Integer, List<User>> map = users.stream().collect(Collectors.groupingBy(u -> u.getAge()));

        for(Map.Entry<Integer, List<User>> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue().size());
        }

        
    }
}
