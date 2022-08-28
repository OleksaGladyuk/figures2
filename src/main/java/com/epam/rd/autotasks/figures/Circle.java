package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private Point center;
    private double d;

    public Circle(Point center, double d) {
        if (center == null || d <= 0) {
            throw new IllegalArgumentException();
        }
        this.center = center;
        this.d = d;
    }

    @Override
    public Point centroid() {
        return new Point(center.getX(), center.getY());
    }


    @Override
    public boolean isTheSame(Figure figure) {
        if (figure.getClass() != Circle.class) {
            return false;
        } else if (center.getX() == ((Circle) figure).center.getX() && center.getY() == ((Circle) figure).center.getY()) {
                return true;
            } else {
            return false;
            }
        }
    }

