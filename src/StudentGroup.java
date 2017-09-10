import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentGroup implements StudentArrayOperation {

    private Student[] students;

    /**
     * DO NOT remove or change this constructor, it will be used during task
     * check
     *
     * @param length
     */
    public StudentGroup(int length) {
        this.students = new Student[length];
    }

    @Override
    public Student[] getStudents() {
        // Add your implementation here
        return students;
    }

    @Override
    public void setStudents(Student[] students) {
        if (students == null) {
            throw new IllegalArgumentException();
        }

        this.students = students;
    }

    @Override
    public Student getStudent(int index) {
        if (index < 0 || index >= students.length) {
            throw new IllegalArgumentException();
        }

        return students[index];
    }

    @Override
    public void setStudent(Student student, int index) {
        if (student == null || index < 0 || index >= students.length) {
            throw new IllegalArgumentException();
        }

        students[index] = student;
    }

    @Override
    public void addFirst(Student student) {
        if (student == null) {
            throw new IllegalArgumentException();
        }

        Student[] newStudents = new Student[students.length + 1];
        newStudents[0] = student;

        for (int i = 0; i < students.length; i++) {
            newStudents[i + 1] = students[i];
        }
        students = newStudents;
    }

    @Override
    public void addLast(Student student) {
        if (student == null) {
            throw new IllegalArgumentException();
        }

        Student[] newStudents = new Student[students.length + 1];
        newStudents[students.length] = student;

        for (int i = 0; i < students.length; i++) {
            newStudents[i] = students[i];
        }
        students = newStudents;
    }

    @Override
    public void add(Student student, int index) {
        if (student == null || index < 0 || index >= students.length) {
            throw new IllegalArgumentException();
        }

        Student[] newStudents = new Student[students.length + 1];
        newStudents[index] = student;

        for (int i = 0; i < index; i++) {
            newStudents[i] = students[i];
        }

        for (int i = index + 1; i < newStudents.length; i++) {
            newStudents[i] = students[i - 1];
        }
        students = newStudents;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= students.length) {
            throw new IllegalArgumentException();
        }

        students[index] = null;
    }

    @Override
    public void remove(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student not\n" +
                    "     * exist");
        }

        for (int i = 0; i < students.length; i++) {
            if (student.equals(students[i])) {
                students[i] = null;
            }
        }
    }

    @Override
    public void removeFromIndex(int index) {
        if (index < 0 || index >= students.length) {
            throw new IllegalArgumentException();
        }
        int a = index + 1;

        for (int i = a; i < students.length; i++) {
            students[i] = null;
        }
    }

    @Override
    public void removeFromElement(Student student) {
        if (student == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(student)) {
                removeFromIndex(i);
                break;
            }
        }
    }

    @Override
    public void removeToIndex(int index) {
        if (index < 0 || index >= students.length) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < index; i++) {
            students[i] = null;
        }
    }

    @Override
    public void removeToElement(Student student) {
        if (student == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < students.length; i++) {
            if (student.equals(students[i])) {
                removeToIndex(i);
                break;
            }
        }
    }

    @Override
    public void bubbleSort() {
        for (int i = 0; i < students.length; i++) {
        	
            for (int j = i + 1; j < students.length; j++) {
                if (students[i] != null && students[j].getId() < students[i].getId()) {
                    Student student = students[i];
                    students[i] = students[j];
                    students[j] = student;
                }
            }
        }
    }

    @Override
    public Student[] getByBirthDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException();
        }

        int count = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && date.equals(students[i].getBirthDate())) {
                count++;
            }
        }

        Student[] studentsBorn = new Student[count];

        for (int i = 0, j = 0; i < students.length; i++) {
            if (students[i] != null && date.equals(students[i].getBirthDate())) {
                studentsBorn[j] = students[i];
                j++;
            }
        }

        return studentsBorn;
    }

    @Override
    public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
        if (firstDate == null || lastDate == null) {
            throw new IllegalArgumentException();
        }
        long date1InMs = firstDate.getTime();
        long day2InMs = lastDate.getTime();
        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null
                    && students[i].getBirthDate().getTime() >= date1InMs
                    && students[i].getBirthDate().getTime() <= day2InMs) {
                studentList.add(students[i]);
            }
        }
        Student[] newStudents = studentList.toArray(new Student[studentList.size()]);

        return newStudents;
    }

    @Override
    public Student[] getNearBirthDate(Date date, int days) {
        if (date == null) {
            throw new IllegalArgumentException();
        }
        long dateInMs = date.getTime();
        long daysInMs = (long) days * 24 * 60 * 60 * 1000;
        Date date2 = new Date(dateInMs + daysInMs);
        return getBetweenBirthDates(date, date2);
    }

    @Override
    public int getCurrentAgeByDate(int indexOfStudent) {
        if (indexOfStudent == 0) {
            throw new IllegalArgumentException();
        }
        long fullYears = 0;
        Date date = new Date();
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getId() == indexOfStudent) {
                fullYears = date.getTime() - students[i].getBirthDate().getTime();
                fullYears = fullYears / 1000 / 60 / 60 / 24 / 365;
                break;
            }
        }
        return (int) fullYears;
    }

    @Override
    public Student[] getStudentsByAge(int age) {
        if (age == 0) {
            throw new IllegalArgumentException();
        }

        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && age == getCurrentAgeByDate(students[i].getId())) {
                studentList.add(students[i]);
            }
        }
        return studentList.toArray(new Student[studentList.size()]);
    }

    @Override
    public Student[] getStudentsWithMaxAvgMark() {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getAvgMark() >= 6.0) {
                studentList.add(students[i]);
            }
        }
        return studentList.toArray(new Student[studentList.size()]);
    }

    @Override
    public Student getNextStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException();
        }
        int lastIndex = students.length - 1;
        for (int a = 0; a < students.length; a++) {
            if (student != students[lastIndex] && student.equals(students[a])) {
                System.out.println(students[a + 1]);
                return students[a + 1];

            }
        }
        return null;
    }
}
