import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Comparable {

    /**
     * student id
     */
    private int id;

    /**
     * student name and surname separated by the whitespace for example:
     * fullName = "David Luis";
     */
    private String fullName;

    /**
     * student date of birth in "yyyy-MM-dd" format
     */
    private Date birthDate;




    /**
     * student average mark
     */
    private double avgMark;

    public Student(int id, String fullName, Date birthDate, double avgMark) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.avgMark = avgMark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public double getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(double avgMark) {
        this.avgMark = avgMark;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    /**
     * DO NOT change this method it will be used during the task check
     */
    @Override
    public int compareTo(Object o) {
        Student other = (Student) o;
        return (this.fullName.compareTo(other.fullName));
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        return  id + " "+ fullName + " " +simpleDateFormat.format(birthDate)  +
                " " + avgMark;
    }
}