import java.util.ArrayList;
import java.util.HashMap;

public class gradeSimulator {

    private static HashMap<Integer, Integer> gradeMap;

    public static void initGradeMap() {
        gradeMap = new HashMap<>();
        int mark;
        for (mark = 0; mark < 38; mark++) {
            gradeMap.put(mark, mark);
        }
        int grade;
        grade = 40;
        for (mark = 38; mark <= 100; mark++) {
            if (mark < grade && mark + 3 > grade) {
                gradeMap.put(mark, grade);
            } else {
                gradeMap.put(mark, mark);
            }
            if (mark > grade) {
                grade += 5;
            }
        }
    }

    public static void main(String[] args) {
        initGradeMap();
        System.out.println(gradeMap);
    }

}
