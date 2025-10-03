package example.micronaut;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest(startApplication = false)
class ToolsTest {
    // Latitude 37.3349° N and Longitude -122.0090° W (Apple Park, Cupertino) in microdegrees.
    public static final double LATITUDE = 37.3349;
    public static final double LONGITUDE = -122.0090;
    
    @Test
    void getWeatherForecastByLocation(Tools tools) {
        assertDoesNotThrow(() -> tools.getWeatherForecastByLocation(LATITUDE, LONGITUDE));
    }

    @Test
    void getAlerts(Tools tools) {
        assertDoesNotThrow(() -> tools.getAlerts(new GetAlertInput("CA")));
    }

}