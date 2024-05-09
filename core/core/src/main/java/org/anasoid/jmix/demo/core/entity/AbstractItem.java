package org.anasoid.jmix.demo.core.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@JmixEntity(name = "core_AbstractItem")
@MappedSuperclass
public abstract class AbstractItem {
    @JmixGeneratedValue
    @Column(name = "PK", nullable = false)
    @Id
    private Long pk;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }
}