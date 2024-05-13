package org.anasoid.jmix.demo.core.entity.i18n;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@JmixEntity
@Table(name = "CORE_LANGUAGE")
@Entity(name = "core_Language")
public class Language {

    @NotBlank
    @Column(name = "ID", nullable = false, updatable = false)
    @Id
    private String id;


    @NotBlank
    @Column(name = "NAME", nullable = false)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @InstanceName
    public String getInstanceName() {
        return getName();
    }
}