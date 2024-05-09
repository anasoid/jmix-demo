package org.anasoid.jmix.demo.app.view.catalog;

import org.anasoid.jmix.demo.core.entity.catalog.Catalog;

import org.anasoid.jmix.demo.app.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "catalogs", layout = MainView.class)
@ViewController("core_Catalog.list")
@ViewDescriptor("catalog-list-view.xml")
@LookupComponent("catalogsDataGrid")
@DialogMode(width = "64em")
public class CatalogListView extends StandardListView<Catalog> {
}