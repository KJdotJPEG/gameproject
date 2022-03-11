package com.company;

//handles vector graphics

public class Vector2f {

    public float x;
    public float y;

    public static float worldx;
    public static float worldy;

    public Vector2f() {
        x = 0;
        y = 0;

    }

    public Vector2f(Vector2f vec) {
        new Vector2f(vec.x,vec.y);

    }

    public Vector2f(float x,float y) {
        this.x = x;
        this.y = y;
    }

    public void addX(float f) { x += f;}
    public void addY(float f) { y += f;}

    public void setX(float f) { x += f;}
    public void setY(float f) { x = f;}

    public void setVector(Vector2f vec) {
        this.x = vec.x;
        this.y = vec.y;
    }

    public void setVector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static void setWorldVar(float x, float y) {
        worldx = x;
        worldy = y;
    }

    public Vector2f getWorldVar() {
        return new Vector2f(x - worldx, - worldy);
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }

}
