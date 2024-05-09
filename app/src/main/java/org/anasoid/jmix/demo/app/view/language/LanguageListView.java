package org.anasoid.jmix.demo.app.view.language;

import org.anasoid.jmix.demo.core.entity.i18n.Language;

import org.anasoid.jmix.demo.app.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "languages", layout = MainView.class)
@ViewController("Language.list")
@ViewDescriptor("language-list-view.xml")
@LookupComponent("languagesDataGrid")
@DialogMode(width = "64em")
public class LanguageListView extends StandardListView<Language> {
}