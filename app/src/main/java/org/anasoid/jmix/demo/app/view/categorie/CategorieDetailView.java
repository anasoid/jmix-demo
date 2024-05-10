package org.anasoid.jmix.demo.app.view.categorie;

import org.anasoid.jmix.demo.app.view.item.AuditableItemView;
import org.anasoid.jmix.demo.core.entity.catalog.Categorie;

import org.anasoid.jmix.demo.app.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "categorie/:id", layout = MainView.class)
@ViewController("core_Categorie.detail")
@ViewDescriptor("categorie-detail-view.xml")
@EditedEntityContainer("itemDc")
public class CategorieDetailView extends AuditableItemView<Categorie> {
}