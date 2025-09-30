public class DisplayDevice implements Observer {
    private String name;

    public DisplayDevice(String name) {
        this.name = name;
    }

    @Override
    public void update(String weather) {
        System.out.println(name + " received weather update: " + weather);
    }
}
