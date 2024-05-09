package org.anasoid.jmix.demo.app.view.item;


import org.anasoid.jmix.demo.app.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.StandardView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "auditableItem-view", layout = MainView.class)
@ViewController("app_AuditableitemView")
@ViewDescriptor("auditableItem-view.xml")
public class AuditableItemView<T> extends ItemView<T> {
}