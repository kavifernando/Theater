public class arraylist {
    public static void main(String args[]) {
        String[] cars = {"volvo", "benz", "bmw", "toyoto", "honda"};
        cars[2] = "vezel";
        for (String i : cars) {
            System.out.println(i);
        }
        
        System.out.println(cars[3]);
    }
}
