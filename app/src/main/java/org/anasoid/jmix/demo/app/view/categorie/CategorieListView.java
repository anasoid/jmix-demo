package org.anasoid.jmix.demo.app.view.categorie;

import org.anasoid.jmix.demo.core.entity.catalog.Categorie;

import org.anasoid.jmix.demo.app.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "categories", layout = MainView.class)
@ViewController("core_Categorie.list")
@ViewDescriptor("categorie-list-view.xml")
@LookupComponent("categoriesDataGrid")
@DialogMode(width = "64em")
public class CategorieListView extends StandardListView<Categorie> {
}