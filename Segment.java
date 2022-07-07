public class Segment {
    private Point start;
    private Point end;

    @Override
    public String toString() {
        return "Segment{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public Segment(Point start, Point end) {
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new IllegalArgumentException();
        } else if (start == null || end == null) {
            throw new IllegalArgumentException();
        } else {
            this.start = start;
            this.end = end;
        }
    }

    double length() {
        Segment segment = new Segment(start, end);
        return Math.sqrt((Math.pow((segment.end.getX() - segment.start.getX()), 2)) +
                Math.pow((segment.end.getY() - segment.start.getY()), 2));
    }

    Point middle() {
        Point resPoint = new Point((this.start.getX() + this.end.getX()) / 2,
                (this.start.getY() + this.end.getY()) / 2);
        return resPoint;
    }

    Point intersection(Segment segment2) {
        Segment segment1 = new Segment(start, end);
        Point resPoint;

        double k1 = (segment1.start.getY() - segment1.end.getY()) /
                (segment1.start.getX() - segment1.end.getX());
        double b1 = segment1.end.getY() - k1 * segment1.end.getX();

        double k2 = (segment2.start.getY() - segment2.end.getY()) /
                (segment2.start.getX() - segment2.end.getX());
        double b2 = segment2.end.getY() - k2 * segment2.end.getX();

        if (b2 == b1 && k1 == k2) {
            return null;
        } else if (k1 == k2) {
            return null;
        }

        double x = (b2 - b1) / (k1 - k2);
        double y = k1 * x + b1;


        return resPoint = new Point(x, y);
    }

}
