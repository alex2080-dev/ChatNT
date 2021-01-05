package Java3;

public class TestBoxing {

    public static void main(String[] args) {

        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Apple a3 = new Apple();
        Apple a4 = new Apple();
        Apple a5 = new Apple();
        Orange o1 = new Orange();
        Orange o2 = new Orange();
        Orange o3 = new Orange();

        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();
        Box<?> box3 = new Box<>();

        box1.addFruit(a1);box1.addFruit(a2);box1.addFruit(a3);box1.addFruit(a4);box1.addFruit(a5);
        box2.addFruit(o1);box2.addFruit(o2);box2.addFruit(o3);

        System.out.println("Вес этих коробок совпадает - " + box1.compare(box2));

        box3.addBox(box1);

        System.out.println(box3.getlist());
    }

}
