package Json;

import Entities.DeliveryService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JasonParser {
    private static final String filePath = "DeliveryService/src/main/resources/Data.json";

    public static void WriteJSON(DeliveryService service) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(new File(filePath), service);
    }

    public static DeliveryService ReadJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(new File(filePath), DeliveryService.class);
    }

}
