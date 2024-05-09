package org.anasoid.jmix.demo.core.entity.i18n;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum Language implements EnumClass<String> {

    ENGLISH("en"),
    GERMAN("de"),
    FRENCH("fr");

    private final String id;

    Language(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Language fromId(String id) {
        for (Language at : Language.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}