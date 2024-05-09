package org.anasoid.jmix.demo.app.view.user;

import org.anasoid.jmix.demo.app.entity.User;
import org.anasoid.jmix.demo.app.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "users", layout = MainView.class)
@ViewController("app_User.list")
@ViewDescriptor("user-list-view.xml")
@LookupComponent("usersDataGrid")
@DialogMode(width = "64em")
public class UserListView extends StandardListView<User> {
}