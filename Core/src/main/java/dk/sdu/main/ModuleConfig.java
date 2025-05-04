package dk.sdu.main;

import dk.sdu.common.input.IInput;
import dk.sdu.common.service.IEntityProcessor;
import dk.sdu.common.service.IPostEntity;
import dk.sdu.common.service.IGamePlugin;
import dk.sdu.common.bullet.BulletSPI;


import java.util.Collection;
import java.util.ServiceLoader;
import static java.util.stream.Collectors.toList;

public class ModuleConfig {
    public static Collection<IGamePlugin> getPluginServices() {
        return ServiceLoader.load(IGamePlugin.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

    public static Collection<IEntityProcessor> getIEntityServices() {
        return ServiceLoader.load(IEntityProcessor.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

    public static Collection<IPostEntity> getPostServices() {
        return ServiceLoader.load(IPostEntity.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

    public static Collection<IInput> getIInputServices() {
        return ServiceLoader.load(IInput.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
