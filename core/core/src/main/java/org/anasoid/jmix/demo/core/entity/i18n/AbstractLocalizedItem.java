package org.anasoid.jmix.demo.core.entity.i18n;

import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import org.anasoid.jmix.demo.core.entity.AbstractAuditableItem;
import org.anasoid.jmix.demo.core.i18n.LocalContext;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@JmixEntity
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractLocalizedItem<T extends Localized<?>> extends AbstractAuditableItem {

    public abstract Set<T> getLocalizedAttributes();

    protected <R> R getLocalizedValue(Function<T, R> function) {
        //With fallback language as English
        Set<T> localizedAttributes = getLocalizedAttributes();
        if (localizedAttributes == null) {
            return null;
        }
        Map<String, T> toMap = localizedAttributes.stream().collect(Collectors.toMap(t -> t.getLanguage().getId(), t -> t));
        T localizedAttribute;
        localizedAttribute = toMap.get(LocalContext.getCurrentLocale());
        if (localizedAttribute == null) {
            localizedAttribute = toMap.get(LocalContext.getDefaultLocale());
        }
        if (localizedAttribute == null) {
            return null;
        }

        return function.apply(localizedAttribute);
    }
}