import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamMain {

    // Stream API 란?
    // Java 8에서 도입된 Stream API는 컬렉션(예: List, Set 등)의 요소들을 함수형 프로그래밍 스타일로 처리할 수 있게
    // 해주는 기능입니다.
    // Stream API를 사용하면 데이터의 필터링, 매핑, 정렬, 집계 등의 작업을 간결하고 효율적으로 수행할 수 있습니다.
    /*
     * 스트림이란 우리가 앞서배운 람다식을 이용한 기술
     * 데이터들을 조작 및 가공해서 원하는 값으로 반환해주는 인터페이스이다.
     * jdk8부터 제공되는 기능이다.
     * 
     * 특징
     * 1. 스트림은 원본 데이터를 변경하지않는다
     * Stream API는 원돈 데이터를 조회하여 별도의 Stream 객체로 생성한다.
     * 따라서 정령 필터 등등 작업을 하더라도 원본 데이터는 변경되지 않는다.
     * ex List<Integer> list = Arrays.asList(1,2,3,4,5);
     * Stream<Integer> stream = list.stream().filter(n->n%2==0);
     * System.out.println(list); // [1,2,3,4,5]
     * System.out.println(stream); // [2,4]
     * 
     * 2. 스트림은 재사용이 불가능하다.
     * 람다식을 이용하기때문에 한번 사용한 스트림은 재사용이 불가능하다.
     * ex Stream<Integer> stream = list.stream();
     * stream.forEach(System.out::println); // 1 2 3 4 5
     * stream.forEach(System.out::println); // 에러발생
     * 
     * 3. 스트림은 내부 반복으로 작업을 처리한다.
     * 반복문으로 처리한다 따라서 순수 반복문 보다는 성능이 떨어지지만 개의치않아도 된다.
     * 
     * 4. 스트림은 지연된 연산을 수행한다.
     * 필터링, 매핑 등 중간처리 작업은 최종처리 작업이 수행되기 전까지는 실제로 수행되지 않는다.
     * 즉 중간처리 작업은 최종처리 작업이 수행될때 한번에 처리된다.
     * 
     * Stream의 과정
     * Stream은 생성->중간연산->최종연산의 이 3가지의 과저을 통해 처리가 이루어진다.
     * ex) 객체.stream생성().중간연산().최종연산();
     */
    public static void main(String[] args) {
        List<String> lists = List.of("java", "javascript", "python", "c", "c++", "c#", "ruby");
        // 알파벳 c가 들어간 이름을 모아서 출력
        // Predicate<t> 는 매개변수 t를 받아서 boolean값을 반환하는 함수형 인터페이스이다.
        // 매개변수 t가 알파벳 c를 포함하고 있으면 true
        var stream = lists.stream(); // 스트림 생성
        var result = stream
                .filter(list -> list.contains("c")) // 중간연산
                .toList(); // 최종연산
        System.out.println(result);

        var stream2 = new ArrayList<String>();
        lists.forEach(list -> {
            if (list.contains("c")) {
                stream2.add(list);
            }
        });
        // stream2.add("java");
        // 불변성에 위배됨 언제든지 변경가능
        System.err.println(stream2);

        var mappedLists = lists.stream()
                // .map(list->list.toUpperCase()) //중간연산
                .filter(list -> list.contains("c"))
                .map(String::toUpperCase)   //중간연산//map(매개변수)->반환값 //매개변수를 받아서 반환값으로 변환  중요
                .toList();
        System.out.println(mappedLists);


        //flatMap
        //이차원배열일때 두개의 배열을 하나의 배열로 합치는것
        var lists1 =  List.of(
            List.of(1,2,3),
            List.of(4,5,6),
            List.of(2,5,1)
            );

            var flapMapList = lists1.stream()
            .flatMap(list->list.stream())
            .toList();

        System.err.println(flapMapList);

        //limit 2개로 제한해줘 
        var Limitedlist = lists.stream().limit(2).toList();
        System.err.println(Limitedlist);

        //skip 건너뛴다.

        var skipList = lists.stream().skip(2).toList();
        System.err.println(skipList);


        //sort 정렬

        var sortedList = lists.stream().sorted().toList();
        System.err.println(sortedList);
        var rev=lists.stream()
        .sorted(Comparator.reverseOrder())
        .toList();
        System.err.println(rev);


        //forEach
        lists.stream()
        .sorted(Comparator.reverseOrder())
        .forEach( System.out::println);
       
        //disrint 중복제거
        var duplicateList = List.of("java", "c", "c", "c", "c++", "c#", "ruby");
        var du = duplicateList.stream().distinct().toList();
        var du2 = duplicateList.stream().collect(Collectors.toSet());

        //set 은 순서보장 x 중복은 보장해줌
        
        System.err.println(du);
        System.out.println(du2);


    }

}
