package com.sts.services.survey.factory;

import java.util.Optional;
import java.util.function.Consumer;

public class FieldUtils {

    public static <T> void ifNotNull(Object object, Consumer<T> consumer) {
        if (object != null) {
            consumer.accept((T) object);
        }
    }

    public static <T> void ifOptionalDefined(Optional<T> optional, Consumer<T> consumer) {
        if (optional != null) {
            consumer.accept(optional.orElse(null));
        }
    }

}
