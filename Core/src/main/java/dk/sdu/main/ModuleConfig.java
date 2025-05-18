package dk.sdu.main;

import dk.sdu.common.input.IInput;
import dk.sdu.common.service.IEntityProcessor;
import dk.sdu.common.service.IPostEntity;
import dk.sdu.common.service.IGamePlugin;
import dk.sdu.common.service.ScoreSPI;


import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.ServiceLoader;
import static java.util.stream.Collectors.toList;

public class ModuleConfig {

    public static ModuleLayer getLayer() {
        ModuleFinder finder = ModuleFinder.of(Paths.get("split-packages"));
        ModuleLayer layer = ModuleLayer.boot();
        List<String> modules = finder.findAll().stream().map(m -> m.descriptor().name()).collect(toList());
        Configuration config = layer.configuration().resolve(finder, ModuleFinder.of(), modules);
        ModuleLayer moduleLayer = layer.defineModulesWithOneLoader(config, ClassLoader.getSystemClassLoader());
        return moduleLayer;
    }

    public static Collection<IGamePlugin> getPluginServices() {
        return ServiceLoader.load(getLayer(), IGamePlugin.class).stream().map(ServiceLoader.Provider::get).collect(toList());
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

    public static Collection<ScoreSPI> getScoreServices() {
        return ServiceLoader.load(ScoreSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

}
