package org.anasoid.jmix.demo.app.view.product;

import org.anasoid.jmix.demo.core.entity.catalog.ProductLocalized;

import org.anasoid.jmix.demo.app.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "productLocalized/:id", layout = MainView.class)
@ViewController("core_ProductLocalized.detail")
@ViewDescriptor("product-localized-detail-view.xml")
@EditedEntityContainer("productLocalizedDc")
public class ProductLocalizedDetailView extends StandardDetailView<ProductLocalized> {
}