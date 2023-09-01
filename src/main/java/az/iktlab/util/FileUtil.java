package az.iktlab.util;

import az.iktlab.dao.FlightRepository;
import az.iktlab.dao.impl.FlightDaoImpl;
import az.iktlab.dto.FlightDto;
import az.iktlab.model.Flight;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FileUtil {
    public void readFromFile(String path) {
        ObjectMapper objectMapper = new ObjectMapper();


        try {
            FlightDto flightData = objectMapper.readValue(new File("C:\\Users\\Acer\\IdeaProjects\\finalApp\\docs\\flights.json"), FlightDto.class);


            FlightRepository flightRepository = new FlightDaoImpl();
            for (Flight flight : flightData.getFlights()) {
                flightRepository.insertFlight(flight);
            }

            System.out.println("Data insertion completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
