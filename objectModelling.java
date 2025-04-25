import java.util.*;

// Enum for ball colors
enum Color{
    RED, YELLOW, GREEN;
}

// Ball class
class Ball{
    Color color;

    Ball(Color color) {
        this.color = color;
    }
}

class Bag{
    final int capacity = 12;
    int yCount = 0;
    int gCount = 0;
    int rCount = 0;
    int totalCount = 0;

    List<Ball> balls = new ArrayList<>();

    boolean add(Ball ball) {
        // Bag is full
        if (totalCount >= capacity) {
            return false; 
        }
    
        // true if red balls are less than green balls
        if (ball.color == Color.RED) {
            if (rCount + 1 < gCount) {
                rCount++;
            } 
            else {
                return false;
            }
        } 
        // true if yellow balls are less than or equal or 40 percent of bag capacity
        else if (ball.color == Color.YELLOW) {
            if (yCount + 1 <= (0.4 * capacity)) {
                yCount++;
            } 
            else {
                return false;
            }
        } 
        else if (ball.color == Color.GREEN) {
            gCount++;
        } 
        else {
            return false; 
        }
    
        // if above conditions are true then balls are added to list
        balls.add(ball);
        totalCount++;
        return true;
    }    
}

public class ObjectModelling {
    public static void main(String args[]){
        Bag bag = new Bag();

        Ball ball1 = new Ball(Color.RED);
        Ball ball2 = new Ball(Color.GREEN);
        Ball ball3 = new Ball(Color.GREEN);
        Ball ball4 = new Ball(Color.YELLOW);

        System.out.println(bag.add(ball1)); // false
        System.out.println(bag.add(ball2)); // true
        System.out.println(bag.add(ball4)); // true
        System.out.println(bag.add(ball3)); // true
    }  
}
