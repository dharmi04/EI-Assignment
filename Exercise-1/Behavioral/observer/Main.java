public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        Observer phone = new DisplayDevice("Phone");
        Observer laptop = new DisplayDevice("Laptop");

        station.addObserver(phone);
        station.addObserver(laptop);

        station.setWeather("Sunny ☀️");
        station.setWeather("Rainy 🌧️");

        station.removeObserver(laptop);
    }
}