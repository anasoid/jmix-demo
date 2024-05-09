package org.anasoid.jmix.demo.app.view.catalogversion;

import org.anasoid.jmix.demo.app.view.item.AuditableItemView;
import org.anasoid.jmix.demo.app.view.item.ItemView;
import org.anasoid.jmix.demo.core.entity.catalog.CatalogVersion;

import org.anasoid.jmix.demo.app.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "catalogVersion/:id", layout = MainView.class)
@ViewController("core_CatalogVersion.detail")
@ViewDescriptor("catalog-version-detail-view.xml")
public class CatalogVersionDetailView extends AuditableItemView<CatalogVersion> {
}