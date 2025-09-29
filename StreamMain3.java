import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamMain3 {
    
    public static void main(String[] args) {
        List<String> names = List.of("java", "javascript", "python", "c", "c++", "c#", "ruby");
        //groupingBy => 어떤 기준으로 그룹핑해서 Map형태로 반환
        // 기준의 값이 key, 그값에 해당하는 컬랙션이 value

        var as = names.stream().collect(Collectors.groupingBy(n->n.length()));
        System.out.println(as);

        var b =as.get(4);
        System.out.println(b);
        // name,score 
        List<Exam> cExams=List.of(new Exam("zs", 50),
        new Exam("ab", 10),
        new Exam("bc", 20),
        new Exam("cd", 10),
        new Exam("de", 40),
        new Exam("ef", 30),
        new Exam("fg", 50),
        new Exam("gh", 10),
        new Exam("hz", 20)
        );
        var groupExam = cExams.stream().collect(Collectors.groupingBy(n->n.score));
        System.out.println(groupExam);
        var groupExam1 = cExams.stream().collect(Collectors.groupingBy(exam->exam.score,Collectors.mapping(exam->exam.name,Collectors.toList())));

         var groupExam2 = cExams.stream().collect(Collectors.groupingBy(exam->exam.score,Collectors.mapping(exam->exam.name,Collectors.toList())));
        System.out.println(groupExam1);
        
        //partitioningBy 구역을 나눠서 저장
        var partitioningByMap = cExams.stream().collect(Collectors.partitioningBy(exam->exam.score<=20, Collectors.mapping(exam->exam.name, Collectors.toList())));
        System.out.println(partitioningByMap);



    }
}
