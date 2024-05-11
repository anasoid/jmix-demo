package org.anasoid.jmix.demo.app.view.category;

import org.anasoid.jmix.demo.app.view.item.AuditableItemView;
import org.anasoid.jmix.demo.core.entity.catalog.Category;

import org.anasoid.jmix.demo.app.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "category/:id", layout = MainView.class)
@ViewController("core_Category.detail")
@ViewDescriptor("category-detail-view.xml")
@EditedEntityContainer("itemDc")
public class CategoryDetailView extends AuditableItemView<Category> {
}