package com.company;

public class Collisions { //AABB

    private Vector2f pos;
    private float xoffset = 0;
    private float yoffset = 0;
    private float w; // width
    private float h; //height
    private float r; // radius
    private int size;
    private Entity e;

    public Collisions(Vector2f pos, int w, int h) {
        this.pos = pos;
        this.w = w;
        this.h = h;

        size = Math.max(w,h);

    }

    public Collisions (Vector2f pos, int r) {
        this.pos = pos;
        size = r;
        this.r = r;


    }
    public Vector2f getpos() { return pos;}

    public float getRadius() { return r;}
    public float getWidth() {return w; }
    public float getHeight() {return h; }

    public void setBox(Vector2f pos, int w, int h){
        this.pos = pos;
        this.w = w;
        this.h = h;

        size = Math.max(w,h);
    }
    public void setCircle(Vector2f pos, int r, Entity e) {
        this.pos = pos;
        this.r = r;

        size = r;
    }
    public void setWidth(float f) { w = f; }
    public void setHeight(float f) { h = f;}

    public void setXoffset(float f) {xoffset = f; }
    public void setYoffset(float f) {yoffset = f; }

    public boolean Collides(Collisions bBox) {
        float ax = ((pos.getWorldVar().x + (xoffset)) + (w/2)); // middle of the position
        float ay = ((pos.getWorldVar().y + (yoffset)) + (h/2));
        float bx = ((bBox.pos.getWorldVar().x + (bBox.xoffset / 2)) + (w / 2));
        float by = ((bBox.pos.getWorldVar().y + (bBox.yoffset / 2)) + (h / 2));

        if (Math.abs(ax - bx) < (this.w / 2) + (bBox.w / 2)) {
            if(Math.abs(ay - by) < (this.h / 2) + (bBox.h / 2)) {
                return true;
            }
        }
        return false;
    }

    public boolean colCirclesBox(Collisions bBox ) {
        // sqrt means square root
        float cx = (float) (pos.getWorldVar().x + r / Math.sqrt(2) - )
        return false;
    }


 }
