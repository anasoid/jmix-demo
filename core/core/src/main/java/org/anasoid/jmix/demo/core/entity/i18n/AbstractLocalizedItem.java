package org.anasoid.jmix.demo.core.entity.i18n;

import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import org.anasoid.jmix.demo.core.entity.AbstractAuditableItem;

import java.util.Set;

@JmixEntity
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractLocalizedItem<T extends Localized<?>> extends AbstractAuditableItem {

    public abstract Set<T> getLocalizations();
}