package org.anasoid.jmix.demo.core.entity.catalog;

import io.jmix.core.DeletePolicy;
import io.jmix.core.MetadataTools;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.anasoid.jmix.demo.core.entity.i18n.AbstractLocalizedItem;
import org.anasoid.jmix.demo.core.i18n.LocalContext;

import java.util.*;
import java.util.stream.Collectors;

@JmixEntity
@Table(name = "CORE_PRODUCT", uniqueConstraints = {
        @UniqueConstraint(name = "IDX_CORE_PRODUCT_UNQ", columnNames = {"CODE", "CATALOG_VERSION"})
})
@Entity(name = "core_Product")
public class Product extends AbstractLocalizedItem<ProductLocalized> {

    @NotBlank
    @Column(name = "CODE", nullable = false, updatable = false)
    private String code;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;


    @OnDeleteInverse(DeletePolicy.DENY)
    @NotNull
    @JoinColumn(name = "CATALOG_VERSION", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CatalogVersion catalogVersion;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    @Composition
    private Set<ProductLocalized> localizedAttributes = new HashSet<>();

    @JoinTable(name = "CORE_CATEGORIE_PRODUCT_LINK",
            joinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PK"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORIE_ID", referencedColumnName = "PK"))
    @ManyToMany
    private List<Categorie> categories;

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public String getCode() {
        return code;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public CatalogVersion getCatalogVersion() {
        return catalogVersion;
    }

    @Override
    public Set<ProductLocalized> getLocalizedAttributes() {
        return localizedAttributes;
    }

    public String getName() {
        //With fallback language as English
        Map<String, ProductLocalized> toMap = localizedAttributes.stream().collect(Collectors.toMap(t -> t.getLanguage().getId(), t -> t));

        if (toMap.get(LocalContext.getCurrentLocale()) == null) {
            if (toMap.get(LocalContext.getDefaultLocale()) == null) {
                return null;
            } else {
                return toMap.get(LocalContext.getDefaultLocale()).getName();
            }
        }
        return toMap.get(LocalContext.getCurrentLocale()).getName();
    }

    public String getDescription() {
// With fallback language as English
        Map<String, ProductLocalized> toMap = localizedAttributes.stream().collect(Collectors.toMap(t -> t.getLanguage().getId(), t -> t));
        if (toMap.get(LocalContext.getCurrentLocale()) == null) {
            if (toMap.get(LocalContext.getDefaultLocale()) == null) {
                return null;
            } else {
                return toMap.get(LocalContext.getDefaultLocale()).getDescription();
            }
        }
        return toMap.get(LocalContext.getCurrentLocale()).getDescription();
    }

    public void setCode(@NotBlank String code) {
        this.code = code;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setCatalogVersion(@NotNull CatalogVersion catalogVersion) {
        this.catalogVersion = catalogVersion;
    }

    public void setLocalizedAttributes(Set<ProductLocalized> localizedAttributes) {
        this.localizedAttributes = localizedAttributes;
    }

    @InstanceName
    @DependsOnProperties({"code", "catalogVersion"})
    public String getInstanceName(MetadataTools metadataTools) {
        return String.format("%s(%s)",
                metadataTools.format(code),
                metadataTools.format(catalogVersion));
    }
}