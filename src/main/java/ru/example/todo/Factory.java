package ru.example.todo;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Factory {

    final Map<String, ClassnoVypolnil> commands = new HashMap<>();

    public Factory() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Reflections reflections = new Reflections(App.class.getPackage().getName());
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(CommandInterface.class);
        for (Class cls : classes) {
            CommandInterface target = (CommandInterface) cls.getAnnotation(CommandInterface.class);
            commands.put(target.name(),  (ClassnoVypolnil) cls.getDeclaredConstructor().newInstance());
        }
    }

    public ClassnoVypolnil createCommand(String command) {
        return commands.get(command);
    }
}
