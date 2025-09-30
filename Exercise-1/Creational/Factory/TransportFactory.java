public class TransportFactory {
    public static Transport getTransport(String type) {
        switch (type.toLowerCase()) {
            case "car":
                return new Car();
            case "plane":
                return new Plane();
            case "ship":
                return new Ship();
            default:
                return null; // unknown type
        }
    }
}
