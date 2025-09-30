public class TransportFactory {
    public static Transport getTransport(String type) {
        switch (type.toLowerCase()) {
            case "car": return new Car();
            case "ship": return new Ship();
            case "plane": return new Plane();
            default: throw new IllegalArgumentException("Unknown transport: " + type);
        }
    }
}
