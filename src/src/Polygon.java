import java.util.ArrayList;
import java.util.List;

public record Polygon(List<Vec2> points) {
    private static final double EPS = 1e-9;
    public Polygon(List<Vec2> points) {
        if (points == null) {
            throw new IllegalArgumentException("points cannot be null");
        }

        List<Vec2> cleaned = sanitize(points);

        checkMinPoints(cleaned);

        this.points = List.copyOf(cleaned);
    }

    private List<Vec2> sanitize(List<Vec2> points) {

        final List<Vec2> sanPoints = new ArrayList<>();



        for (Vec2 point : points) {
            if (Double.isNaN(point.getX()) || Double.isNaN(point.getY()) ||
                    Double.isInfinite(point.getX()) || Double.isInfinite(point.getY())) {
                throw new IllegalArgumentException("invalid coordinate");
            }

            if (sanPoints.isEmpty() || point.dist2(sanPoints.getLast()) > EPS * EPS) {
                sanPoints.add(point);
            }
        }

        if (sanPoints.size() >= 2 && sanPoints.getFirst().dist2(sanPoints.getLast()) < EPS * EPS) {
            sanPoints.removeLast();
        }

        return sanPoints;
    }

    private void checkMinPoints(List<Vec2> points) {
        if (points.size() < 3) {
            throw new IllegalArgumentException("polygon must have at least 3 distinct points");
        }
    }
}
