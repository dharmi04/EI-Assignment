

public class Ship implements Transport {
    @Override
    public void deliver(String item) {
        System.out.println("🚢 Delivering " + item + " by sea.");
    }
}
