package org.anasoid.jmix.demo.core.entity.catalog;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.anasoid.jmix.demo.core.entity.AbstractAuditableItem;
import org.anasoid.jmix.demo.core.listener.CategoryListener;

import java.util.List;

@JmixEntity
@Table(name = "CORE_CATEGORY")
@Entity(name = "core_Category")
@EntityListeners(CategoryListener.class)
public class Category extends AbstractAuditableItem {


    @InstanceName
    @NotBlank
    @Column(name = "CODE", nullable = false)
    @NotNull
    private String code;

    @JoinTable(name = "CORE_CATEGORY_PRODUCT_LINK",
            joinColumns = @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "PK"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PK"))
    @ManyToMany
    private List<Product> products;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}