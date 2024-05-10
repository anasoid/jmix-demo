package org.anasoid.jmix.demo.core.entity.catalog;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.anasoid.jmix.demo.core.entity.AbstractAuditableItem;

@JmixEntity
@Table(name = "CORE_CATALOG_VERSION", indexes = {
        @Index(name = "IDX_CORE_CATALOG_VERSION_CATALOG", columnList = "CATALOG")
})
@Entity(name = "core_CatalogVersion")
public class CatalogVersion extends AbstractAuditableItem {

    @NotBlank
    @Column(name = "VERSION", nullable = false)
    @NotNull
    private String version;

    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "CATALOG", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Catalog catalog;

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}