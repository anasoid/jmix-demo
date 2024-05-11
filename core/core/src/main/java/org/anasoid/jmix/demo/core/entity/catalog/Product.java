package org.anasoid.jmix.demo.core.entity.catalog;

import io.jmix.core.DeletePolicy;
import io.jmix.core.MetadataTools;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.anasoid.jmix.demo.core.entity.i18n.AbstractLocalizedItem;
import org.anasoid.jmix.demo.core.i18n.LocalContext;
import org.anasoid.jmix.demo.core.listener.ProductListener;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@JmixEntity
@Table(name = "CORE_PRODUCT", uniqueConstraints = {
        @UniqueConstraint(name = "IDX_CORE_PRODUCT_UNQ", columnNames = {"CODE", "CATALOG_VERSION"})
})
@Entity(name = "core_Product")
@EntityListeners(ProductListener.class)
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

    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    @Composition
    private Set<ProductLocalized> localizedAttributes;

    @JoinTable(name = "CORE_CATEGORY_PRODUCT_LINK",
            joinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PK"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORIE_ID", referencedColumnName = "PK"))
    @ManyToMany
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
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

    @JmixProperty
    public String getName() {
        //With fallback language as English
        if (localizedAttributes == null) {
            return "";
        }
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

    @JmixProperty
    public String getDescription() {
// With fallback language as English
        if (localizedAttributes == null) {
            return "";
        }
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