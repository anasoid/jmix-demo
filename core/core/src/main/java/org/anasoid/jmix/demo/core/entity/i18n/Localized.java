package org.anasoid.jmix.demo.core.entity.i18n;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.anasoid.jmix.demo.core.entity.AbstractItem;

import java.util.UUID;

@JmixEntity(name = "core_Localized")
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Localized<T extends AbstractLocalizedItem> extends AbstractItem {


    @Column(name = "LANG", length = 10, nullable = false, updatable = false)
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
