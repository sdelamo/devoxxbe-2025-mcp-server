package example.micronaut;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.jsonschema.JsonSchema;
import io.micronaut.serde.annotation.Serdeable;

/**
 *
 * @param state Two-letter US state code (e.g. CA, NY)
 */
@JsonSchema
@Serdeable
public record GetAlertInput(String state) {
}
