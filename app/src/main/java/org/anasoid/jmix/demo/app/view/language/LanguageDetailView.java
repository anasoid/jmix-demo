package org.anasoid.jmix.demo.app.view.language;

import org.anasoid.jmix.demo.core.entity.i18n.Language;

import org.anasoid.jmix.demo.app.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "languages/:id", layout = MainView.class)
@ViewController("Language.detail")
@ViewDescriptor("language-detail-view.xml")
@EditedEntityContainer("languageDc")
public class LanguageDetailView extends StandardDetailView<Language> {
}