package Java3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
 //   private T object;
    public ArrayList<T> fruits;



    public ArrayList<T> getlist(){
        return fruits;

    }


    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }

        return weight;
    }



    public void addFruit (Fruit fruit) {
         this.fruits.add((T) fruit);


    }



    public void addBox (Box<?> box) {

        for (int i = 0; i < box.fruits.size(); i++) {
        this.fruits.add((T) box.fruits.get(i));
        }
        box.fruits.clear();

    }



    public boolean compare (Box<?> box) {
        return Math.abs(this.getWeight() - box.getWeight()) <= 0.0001f;
    }


    public Box() {

    }
}
