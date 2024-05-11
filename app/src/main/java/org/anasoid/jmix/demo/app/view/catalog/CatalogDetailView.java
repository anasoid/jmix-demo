package org.anasoid.jmix.demo.app.view.catalog;

import org.anasoid.jmix.demo.core.entity.catalog.Catalog;

import org.anasoid.jmix.demo.app.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "catalogs-detail/:id", layout = MainView.class)
@ViewController("core_Catalog.detail")
@ViewDescriptor("catalog-detail-view.xml")
@EditedEntityContainer("itemDc")
public class CatalogDetailView extends StandardDetailView<Catalog> {
}