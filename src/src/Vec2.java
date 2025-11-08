public class Vec2 {
    private double x;
    private double y;

    public Vec2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double dist2(Vec2 point) {
        double dx = point.getX() - this.x;
        double dy = point.getY() - this.y;

        return dx * dx + dy * dy;
    }

    public double dist(Vec2 point) {
        return Math.sqrt(dist2(point));
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}
