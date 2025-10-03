package example.micronaut;

import io.micronaut.jsonschema.JsonSchema;
import io.micronaut.serde.annotation.Serdeable;

/**
 *
 * @param latitude Latitude
 * @param longitude Longitude
 * @param forecast Forecast
 */
@JsonSchema
@Serdeable
public record WeatherForecastByLocation(
        double latitude,
        double longitude,
        String forecast
) {
}
