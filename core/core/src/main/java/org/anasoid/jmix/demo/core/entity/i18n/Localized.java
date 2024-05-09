package org.anasoid.jmix.demo.core.entity.i18n;

import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import org.anasoid.jmix.demo.core.entity.AbstractItem;

@JmixEntity(name = "core_Localized")
@MappedSuperclass
public abstract class Localized<T extends AbstractLocalizedItem> extends AbstractItem {


    @JoinColumn(name = "LANG", nullable = false, updatable = false)
    @ManyToOne(optional = false)
    @NotNull
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ITEM_PK", nullable = false, updatable = false)
    @NotNull
    private T item;

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

}
