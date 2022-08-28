package com.epam.rd.autotasks.figures;

import javax.swing.text.Segment;

class Quadrilateral extends Figure {
    Point a, b, c, d;
    double aLen, bLen, cLen, adLen, cdLen, dLen;
    public Quadrilateral(Point a, Point b, Point c, Point d) {

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        if (a == null || b == null || c == null || d == null) {
            throw new IllegalArgumentException();
        }
        if (aLen == 0 || bLen == 0 || cLen == 0 || dLen == 0 || cdLen == 0 || adLen == 0) {
            throw new IllegalArgumentException();
        }
        if (area() == 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Point centroid() {
        return null;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return false;
    }

    public double area() {
        aLen = Math.sqrt(Math.pow(a.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
        bLen = Math.sqrt(Math.pow(c.getX() - b.getX(), 2) + Math.pow(c.getY() - b.getY(), 2));
        cLen = Math.sqrt(Math.pow(c.getX() - a.getX(), 2) + Math.pow(c.getY() - a.getY(), 2));

        adLen = Math.sqrt(Math.pow(c.getX() - a.getX(), 2) + Math.pow(c.getY() - a.getY(), 2));
        cdLen = Math.sqrt(Math.pow(d.getX() - c.getX(), 2) + Math.pow(d.getY() - c.getY(), 2));
        dLen = Math.sqrt(Math.pow(d.getX() - a.getX(), 2) + Math.pow(d.getY() - a.getY(), 2));

        double halfPerimeter = (aLen + bLen + cLen) / 2;
        double halfPerimeterTwo = (adLen + cdLen + dLen) / 2;
        double area = Math.sqrt(halfPerimeter * (halfPerimeter - aLen) * (halfPerimeter - bLen) * (halfPerimeter - cLen));
        double areaTwo = Math.sqrt(halfPerimeterTwo * (halfPerimeterTwo - adLen) * (halfPerimeterTwo - cdLen) * (halfPerimeterTwo - dLen));
        return area + areaTwo;
    }
}

