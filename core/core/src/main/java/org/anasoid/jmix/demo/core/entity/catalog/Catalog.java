package org.anasoid.jmix.demo.core.entity.catalog;

import io.jmix.core.MetadataTools;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.anasoid.jmix.demo.core.entity.AbstractAuditableItem;

import java.util.Set;

@JmixEntity
@Table(name = "CORE_CATALOG", indexes = {
        @Index(name = "IDX_CORE_CATALOG_UNQ_ID", columnList = "ID", unique = true)
})
@Entity(name = "core_Catalog")
public class Catalog extends AbstractAuditableItem {

    @NotBlank
    @Column(name = "ID", nullable = false)
    @NotNull
    private String id;

    @NotBlank
    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL, orphanRemoval = true)
    @Composition
    private Set<CatalogVersion> catalogVersions;

    public Set<CatalogVersion> getCatalogVersions() {
        return catalogVersions;
    }

    public void setCatalogVersions(Set<CatalogVersion> catalogVersions) {
        this.catalogVersions = catalogVersions;
    }


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
    @DependsOnProperties({"id", "name"})
    public String getInstanceName(MetadataTools metadataTools) {
        return String.format("%s (%s)",
                metadataTools.format(id),
                metadataTools.format(name));
    }
}