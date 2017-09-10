import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
	public static Date convertToDate(int year, int month, int day) {
		return new GregorianCalendar(year, --month, day).getTime();
	}

	public static void main(String[] args) throws InterruptedException {
		Student[] students = new Student[8];
		students[0] = new Student(3, "Nona Non", convertToDate(2016, 12, 30), 5.0);
		students[1] = new Student(2, "Mina Nitrov", convertToDate(1988, 11, 14), 5.0);
		students[2] = new Student(1, "Lol Bopin", convertToDate(1987, 3, 14), 5.0);
		students[3] = new Student(4, "Hom Lins", convertToDate(1987, 4, 14), 6.0);
		students[4] = new Student(5, "Mop Lans", convertToDate(1993, 5, 14), 5.0);
		students[5] = new Student(7, "L Cout", convertToDate(1976, 6, 14), 6.3);
		students[6] = new Student(6, "Viva Arunop", convertToDate(1994, 7, 14), 5.0);
		students[7] = new Student(8, "Boba Xopy", convertToDate(1990, 8, 14), 5.0);
	}
}