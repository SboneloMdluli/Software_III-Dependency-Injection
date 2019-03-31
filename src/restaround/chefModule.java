package restaround;

import com.google.inject.AbstractModule;

class menuModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Menu.class).to(MenuImpl.class);
    }
}
