package org.anasoid.jmix.demo.core.listener;

import jakarta.persistence.*;
import org.anasoid.jmix.demo.core.entity.catalog.Categorie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryListener {
    private static final Logger logger = LoggerFactory.getLogger(CategoryListener.class);

    @PrePersist
    void onPrePersist(Categorie c) {
        logger.info("Before persisting " + c.getCode());
    }

    @PostPersist
    void onPostPersist(Categorie c) {
        logger.info("After persisting " + c.getCode());
    }

    @PostLoad
    void onPostLoad(Categorie c) {
        //logger.info("After Load " + c.getCode());
    }

    @PreUpdate
    void onPreUpdate(Categorie c) {
        logger.info("Before update " + c.getCode());
    }

    @PostUpdate
    void onPostUpdate(Categorie c) {
        logger.info("After update " + c.getCode());
    }

    @PreRemove
    void onPreRemove(Categorie c) {
        logger.info("Before remove " + c.getCode());
    }

    @PostRemove
    void onPostRemove(Categorie c) {
        logger.info("After remove " + c.getCode());
    }
}
