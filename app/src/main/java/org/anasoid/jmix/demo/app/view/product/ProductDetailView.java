package org.anasoid.jmix.demo.app.view.product;

import org.anasoid.jmix.demo.app.view.item.AuditableItemView;
import org.anasoid.jmix.demo.core.entity.catalog.Product;

import org.anasoid.jmix.demo.app.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "product/:id", layout = MainView.class)
@ViewController("core_Product.detail")
@ViewDescriptor("product-detail-view.xml")
@EditedEntityContainer("itemDc")
public class ProductDetailView extends AuditableItemView<Product> {
}