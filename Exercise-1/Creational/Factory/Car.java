

public class Car implements Transport {
    @Override
    public void deliver(String item) {
        System.out.println(" Delivering " + item + " by road.");
    }
}
