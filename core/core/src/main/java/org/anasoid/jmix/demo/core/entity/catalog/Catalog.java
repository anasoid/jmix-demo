package org.anasoid.jmix.demo.core.entity.catalog;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.anasoid.jmix.demo.core.entity.AbstractAuditableItem;

@JmixEntity
@Table(name = "CORE_CATALOG", indexes = {
        @Index(name = "IDX_CORE_CATALOG_UNQ_ID", columnList = "ID", unique = true)
})
@Entity(name = "core_Catalog")
public class Catalog extends AbstractAuditableItem {

    @NotBlank
    @InstanceName
    @Column(name = "NAME")
    private String name;

    @NotBlank
    @Column(name = "ID", nullable = false)
    @NotNull
    private String id;

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

}