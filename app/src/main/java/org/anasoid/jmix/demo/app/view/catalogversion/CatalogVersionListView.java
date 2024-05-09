package org.anasoid.jmix.demo.app.view.catalogversion;

import org.anasoid.jmix.demo.core.entity.catalog.CatalogVersion;

import org.anasoid.jmix.demo.app.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "catalogVersions", layout = MainView.class)
@ViewController("core_CatalogVersion.list")
@ViewDescriptor("catalog-version-list-view.xml")
@LookupComponent("catalogVersionsDataGrid")
@DialogMode(width = "64em")
public class CatalogVersionListView extends StandardListView<CatalogVersion> {
}