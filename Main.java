import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Segment first = new Segment(new Point(0, 0), new Point(4, 0));
        Segment second = new Segment(new Point(2, 1), new Point(1, 2));
        Point intersection = first.intersection(second);

        System.out.println(intersection == null);

    }

}

