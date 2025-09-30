public class Main {
    public static void main(String[] args) {
        Transport t1 = TransportFactory.getTransport("car");
        t1.deliver("Books");

        Transport t2 = TransportFactory.getTransport("plane");
        t2.deliver("Medicines");

        Transport t3 = TransportFactory.getTransport("ship");
        t3.deliver("Electronics");
    }
}
