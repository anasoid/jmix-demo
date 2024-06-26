package org.anasoid.jmix.demo.core.entity.catalog;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.anasoid.jmix.demo.core.entity.i18n.Localized;

@JmixEntity
@Table(name = "CORE_PRODUCT_LOCALIZED", uniqueConstraints = {
        @UniqueConstraint(name = "IDX_CORE_PRODUCT_LOCALIZED_UNQ", columnNames = {"LANG", "ITEM_PK"})
})
@Entity(name = "core_ProductLocalized")
public class ProductLocalized extends Localized<Product> {
    @InstanceName
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION", length = 1000)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ITEM_PK", nullable = false, updatable = false)
    @NotNull
    @AssociationOverride(name = "item")
    private Product item;


    public Product getItem() {
        return item;
    }
    public void setItem(Product item) {
        this.item = item;
    }
}