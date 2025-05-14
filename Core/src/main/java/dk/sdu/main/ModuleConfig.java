package dk.sdu.main;

import dk.sdu.common.input.IInput;
import dk.sdu.common.service.IEntityProcessor;
import dk.sdu.common.service.IPostEntity;
import dk.sdu.common.service.IGamePlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;
import java.util.ServiceLoader;
import static java.util.stream.Collectors.toList;

@Configuration
public class ModuleConfig {


    @Bean
    public Game game() {
        return new Game(gamePlugins(), postEntities(), entityProcessors(), inputs());
    }

    @Bean
    public List<IPostEntity> postEntities() {
        return ServiceLoader.load(IPostEntity.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

    @Bean
    public List<IGamePlugin> gamePlugins() {
        return ServiceLoader.load(IGamePlugin.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

    @Bean
    public List<IEntityProcessor> entityProcessors() {
        return ServiceLoader.load(IEntityProcessor.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

    @Bean
    public List<IInput> inputs() {
        return ServiceLoader.load(IInput.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

}
