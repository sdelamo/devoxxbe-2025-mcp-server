package example.micronaut.weather.model;

import java.util.List;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ForecastProperties(
    List<Period> periods) {
}
