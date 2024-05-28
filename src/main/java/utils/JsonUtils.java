package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.FrameworkConstants;
import enums.ConfigProperties;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public final class JsonUtils {
    private static Map<String, String> CONFIGMAP;

    private JsonUtils() {}

    static {
        try {
            CONFIGMAP = new ObjectMapper()
                    .readValue(new File(FrameworkConstants.getConfigJsonFilePath()), new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(ConfigProperties property) {
        if (Objects.isNull(property) || Objects.isNull(CONFIGMAP.get(property.name().toLowerCase())))
            try {
                throw new Exception("Property " + property + " is not found. Please check config.json");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        System.out.println("INSIDE JSONUTILS");
        System.out.println(CONFIGMAP.get(property.name().toLowerCase()).trim());
        return CONFIGMAP.get(property.name().toLowerCase()).trim();
    }
}
