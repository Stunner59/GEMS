// Main.java ( ! Create this file )

import java.io.*;

class Main {
    public static void main(String args[]) throws IOException, FileNotFoundException {
        String airportName,cityName,countryCode;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the name of the airport");
        airportName = br.readLine();
        System.out.println("Enter the city name");
        cityName = br.readLine();
        System.out.println("Enter the country code");
        countryCode = br.readLine();
        File file = new File("airport.csv");
        FileWriter fw = new FileWriter(file);
        fw.write(airportName+","+cityName+","+countryCode+"\n");
        fw.close();
        br.close();
    }
}
