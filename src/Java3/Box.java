package Java3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    public T object;
    public ArrayList<T> fruits = new ArrayList();



    public ArrayList<T> getlist(){
        return fruits;
    }


    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : this.fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }



    public void addFruit (T t) {
         this.fruits.add(t);


    }



    public void addBox (Box<T> box) {

            for (int i = 0; i < box.fruits.size(); i++) {
                this.addFruit((T) box.fruits.get(i));
            }
            box.fruits.clear();
        }




    public boolean compare (Box<?> box) {

        return Math.abs(this.getWeight() - box.getWeight()) <= 0.0001f;
    }


    public Box() {



    }
}
