package Snake;

import Snake.Course;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class GameModel {
    public Point Food;
    private int height;
    private int weight;
    public ArrayList<Point> Snake;
    public Course DirCourse;
    public Point pCourse;
    public int SnakeLength;
    public boolean existFood;
    public int Score;

    GameModel(int h, int w){
        existFood = false;
        DirCourse = new Course();
        this.pCourse = DirCourse.Course.get("DOWN");
        this.height = h;
        this.weight = w;
        this.Snake = new ArrayList<Point>();
        SetSnake();
        SpawnFood();
        this.SnakeLength = Snake.size();
    }
//    public void Set_Course(KeyEvent event) {
//        switch (event.getKeyCode()) {
//            case KeyEvent.VK_RIGHT:
//                Course = eCourse.RIGHT;
//                break;
//            case KeyEvent.VK_LEFT:
//                Course = eCourse.LEFT;
//                break;
//            case KeyEvent.VK_DOWN:
//                Course = eCourse.DOWN;
//                break;
//            case KeyEvent.VK_UP:
//                Course = eCourse.UP;
//                break;
//        }
//    }

    private void moveHead(){
        int x = this.Snake.get(0).x + pCourse.y;
        int y = this.Snake.get(0).y + pCourse.x;

        if (y < 0)
            y = this.height-1;
        if (y > this.height - 1)
            y = 0;
        if (x < 0)
            x = this.weight - 1;
        if (x > this.weight - 1)
            x = 0;
        Snake.set(0, new Point(x, y));
        if (Snake.get(0).x == Food.x && Snake.get(0).y == Food.y )
        {
            Score++;
            Snake.add(Food);
            SnakeLength++;
            existFood = false;
        }
    }

    public void RefreshField() {
        SpawnFood();
        Point prev_segment;
        Point next_segment;
        prev_segment = this.Snake.get(0);
        moveHead();
        for (int i = 0; i < this.SnakeLength-1; i++) {
            next_segment = Snake.get(i + 1);
            Snake.set(i + 1, prev_segment);
            prev_segment = next_segment;
        }
    }
    public void Print(){
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < weight; j++){
                Point cp = new Point(i,j);
                if (cp.x == Food.x && cp.y == Food.y){
                    System.out.print("o");
                }
                else{
                    if (Snake.contains(cp)){
                        if (cp.x == Snake.get(0).x && cp.y == Snake.get(0).y)
                            System.out.print("S");
                        else
                            System.out.print("s");}
                    else
                        System.out.print(".");}
            }
            System.out.println();
        }
    }
    private void SpawnFood(){
           while (!existFood){
               Random rnd = new Random();
               int x = rnd.nextInt(height);
               int y = rnd.nextInt(weight);
               Point tempFood = new Point(x,y);
               if (!Snake.contains(tempFood))
               {Food = tempFood;
                   existFood = true;}
           }

    }
    private void SetSnake(){
        for (int i = 0; i < 2;i++){
            this.Snake.add(new Point(0,i ));
        }
    }
}