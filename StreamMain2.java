import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamMain2 {

    public static void main(String[] args) {
        List<String> names = List.of("java", "javascript", "python", "c", "c++", "c#", "ruby");

        // findFirst-> 옵셔널값으로 리턴한다.
        // 컴퓨터는 리스트에 값이있을지없을지 모름
        var findFirstName = names.stream().findFirst().orElse("초기값");

        // findAny
        var findAnyName = names.stream().findAny().get();
        System.out.println(findAnyName);

        // match
        // allMatch,anyMatch,noneMatch 다 맞아야함,맞는게 잇어야함,맞으면안됨
        var n = names.stream().allMatch(name -> name.equals("java")); // 오직 불린값만 반환.
        System.out.println(n);
        var n2 = names.stream().anyMatch(name -> name.equals("java"));
        System.out.println(n2);
        var n3 = names.stream().noneMatch(name -> name.equals("jason"));
        System.out.println(n3);

        // reduce
        var numbers = List.of(1, 2, 3, 4, 5);
        var sum = numbers.stream().reduce(Integer::sum).get();
        var mul = numbers.stream().reduce(1, (x, y) -> x * y);
        System.out.println(sum);
        System.out.println(mul);

        // 지금까지는 중간연산을 했고 지금부턴 최종연산

        // 최종연산 Collectors
        var nameList = names.stream().collect(Collectors.toList());
        var nameList2 = names.stream().toList();
        var nameSet = names.stream().collect(Collectors.toSet());
        var nameMap = names.stream().collect(Collectors.toMap(name -> name, name -> name.length()));
        System.out.println(nameSet);
        System.out.println(nameMap);

        // 어떤배열의 총 갯수
        var count1 = names.size();
        var count2 = names.stream().count();
        var count3 = names.stream().collect(Collectors.counting());
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);

        // joining->String

        var joining1 = names.stream().collect(Collectors.joining());
        System.out.println(joining1);
        var joining2 = names.stream().collect(Collectors.joining(", "));
        System.out.println(joining2);
        var joining3 = names.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(joining3);

        // 평균 합계
        var sumLength = names.stream().collect(Collectors.summingInt((String l) -> l.length()));
        System.out.println(sumLength);
        var avgLength = names.stream().collect(Collectors.averagingInt(l -> l.length()));
        System.out.println(avgLength);

        // 최대 최소
        var MinLength = names.stream().collect(Collectors.minBy(Comparator.comparingInt(l->l.length()))).get();
        var MinLength1 =names.stream().min(Comparator.comparingInt(l->l.length())).get(); 

        System.out.println(MinLength);
        System.out.println(MinLength1);

        var MaxLength = names.stream().collect(Collectors.maxBy(Comparator.comparingInt(l->l.length()))).get();
        var MaxLength1 =names.stream().max(Comparator.comparingInt(l->l.length())).get(); 
        System.out.println(MaxLength);
        System.out.println(MaxLength1);
    }

}
