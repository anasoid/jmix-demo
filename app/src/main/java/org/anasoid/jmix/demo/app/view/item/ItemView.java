package org.anasoid.jmix.demo.app.view.item;


import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import org.anasoid.jmix.demo.app.view.main.MainView;

@Route(value = "item-view", layout = MainView.class)
@ViewController("app_ItemView")
@ViewDescriptor("item-view.xml")
@EditedEntityContainer("itemDc")
public abstract class ItemView<T> extends StandardDetailView<T> {


}