package org.anasoid.jmix.demo.core.entity.catalog;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.anasoid.jmix.demo.core.entity.i18n.AbstractLocalizedItem;
import org.anasoid.jmix.demo.core.i18n.LocalContext;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@JmixEntity
@Entity(name = "CORE_PRODUCT")
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

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Composition
    private Set<ProductLocalized> localizedAttributes = new HashSet<>();

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

}