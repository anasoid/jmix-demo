package org.anasoid.jmix.demo.core.listener;

import jakarta.persistence.*;
import org.anasoid.jmix.demo.core.entity.catalog.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductListener {

    private static final Logger logger = LoggerFactory.getLogger(ProductListener.class);

    @PrePersist
    void onPrePersist(Product p) {
        logger.info("Before persisting " + p.getCode());
    }

    @PostPersist
    void onPostPersist(Product p) {
        logger.info("After persisting " + p.getCode());
    }

    @PostLoad
    void onPostLoad(Product p) {
        //logger.info("After Load " + p.getCode());
    }

    @PreUpdate
    void onPreUpdate(Product p) {
        logger.info("Before update " + p.getCode());
    }

    @PostUpdate
    void onPostUpdate(Product p) {
        logger.info("After update " + p.getCode());
    }

    @PreRemove
    void onPreRemove(Product p) {
        logger.info("Before remove " + p.getCode());
    }

    @PostRemove
    void onPostRemove(Product p) {
        logger.info("After remove " + p.getCode());
    }
}
