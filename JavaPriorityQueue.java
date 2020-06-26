import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class JavaPriorityQueue {

    static class Student implements Comparable<Student> {
        int id;
        String name;
        double cgpa;

        Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        @Override
        public int compareTo(Student o) {
            if (this.cgpa < o.cgpa) {
                return 1;
            } else if (this.cgpa > o.cgpa) {
                return -1;
            } else {
                if (this.name.compareTo(o.name) == 0) {
                    if (this.id > o.id) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    return this.name.compareTo(o.name);
                }
            }
        }
    }

    static class Priority {

        private final Queue<Student> students;

        Priority() {
            this.students = new PriorityQueue<>();
        }

        public List<Student> getStudents(List<String> events) {
            int i = 1;
            for (String event : events) {
                if (event.charAt(0) == 'E') {
                    String[] temp = event.split(" ");
                    int id = Integer.parseInt(temp[3]);
                    String name = temp[1];
                    double cgpa = Double.parseDouble(temp[2]);
                    this.students.add(new Student(id, name, cgpa));
                } else {
                    this.students.poll();
                }
                assert this.students.peek() != null;
                System.out.println(i + " " + this.students.peek().getName());
                i++;
            }
            List<Student> students = new ArrayList<>();
            while (this.students.size() > 0) {
                students.add(this.students.poll());
            }
            return students;
        }
    }

    public static void main(String[] args) {
        Priority p = new Priority();
        List<String> events = new ArrayList<>();
        events.add("ENTER John 3.75 50");
        events.add("ENTER Mark 3.8 24");
        events.add("ENTER Shafaet 3.7 35");
        events.add("SERVED");
        events.add("SERVED");
        events.add("ENTER Samiha 3.85 36");
        events.add("SERVED");
        events.add("ENTER Ashley 3.9 42");
        events.add("ENTER Maria 3.6 46");
        events.add("ENTER Anik 3.95 49");
        events.add("ENTER Dan 3.95 50");
        events.add("SERVED");

        List<Student> students = p.getStudents(events);
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

}
