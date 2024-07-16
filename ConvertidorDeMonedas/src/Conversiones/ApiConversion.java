package Conversiones;

public record ApiConversion(
        String base_code,
        String target_code,
        float conversion_rate,
        float conversion_result
) {
}
