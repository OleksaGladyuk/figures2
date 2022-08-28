package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    public Point a;
    public Point b;
    public Point c;

    public Triangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException();
        }
        this.a = a;
        this.b = b;
        this.c = c;
        if (area() < 0){
            throw new IllegalArgumentException();
        }
    }

    private boolean checkTriangleGenerative(Point a, Point b, Point c) {

        double ab = lengthBetweenPoints(a, b);
        double bc = lengthBetweenPoints(b, c);
        double ac = lengthBetweenPoints(a, c);
        if (ab >= bc + ac || bc >= ab + ac || ac >= ab + bc) {
            return false;
        } else {
            return true;
        }
    }

    private double lengthBetweenPoints(Point a, Point b) {
        double kx = a.getX() - b.getX();
        double ky = a.getY() - b.getY();
        double lengthBetweenPoints = Math.sqrt(Math.pow(kx, 2) + Math.pow(ky, 2));
        return lengthBetweenPoints;
    }

    public double area() {
        double ab = lengthBetweenPoints(a, b);
        double bc = lengthBetweenPoints(b, c);
        double ac = lengthBetweenPoints(a, c);
        double p = (ab + bc + ac) / 2;
        double area = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
        return area;

    }

    @Override
    public Point centroid() {
        double centroidX = (a.getX() + b.getX() + c.getX()) / 3;
        double centroidY = (a.getY() + b.getY() + c.getY()) / 3;
        return new Point(centroidX, centroidY);
    }


    @Override
    public boolean isTheSame(Figure figure) {

        if (figure.getClass() != Triangle.class) {
            return false;
        }
        Point [] figureTriangle = {((Triangle) figure).a, ((Triangle) figure).b, ((Triangle) figure).c };
        boolean isAHasTheSamePoint = false;
        boolean isBHasTheSamePoint = false;
        boolean isCHasTheSamePoint = false;
        for (Point p: figureTriangle
             ) {
          boolean isTheSamePoints = isPointTheSame  (a, p);
          if (isTheSamePoints) {
              isAHasTheSamePoint = true;
              break;
          }
        }
        for (Point p: figureTriangle
        ) {
            boolean isTheSamePoints = isPointTheSame  (b, p);
            if (isTheSamePoints) {
                isBHasTheSamePoint = true;
                break;
            }
        }
        for (Point p: figureTriangle
        ) {
            boolean isTheSamePoints = isPointTheSame  (c, p);
            if (isTheSamePoints) {
                isCHasTheSamePoint = true;
                break;
            }
        }
        if (isAHasTheSamePoint == true && isBHasTheSamePoint == true && isCHasTheSamePoint == true) {
            return true;
        }
        return false;
    }
    public boolean isPointTheSame (Point a, Point a1) {
        if (a.getX() == a1.getX() || a.getY() == a.getY()) {
            return true;
        } else {
          return false;
        }
    }
}

