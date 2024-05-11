package org.anasoid.jmix.demo.app.view.category;

import org.anasoid.jmix.demo.core.entity.catalog.Category;

import org.anasoid.jmix.demo.app.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "categories", layout = MainView.class)
@ViewController("core_Category.list")
@ViewDescriptor("category-list-view.xml")
@LookupComponent("categoriesDataGrid")
@DialogMode(width = "64em")
public class CategoryListView extends StandardListView<Category> {
}