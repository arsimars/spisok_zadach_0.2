package ru.example.todo;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Factory {

    //final Map<String, ClassnoVypolnil> commands = new HashMap<>();

    private final List<ClassnoVypolnil> commands = new ArrayList<>();

    public Factory() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Reflections reflections = new Reflections(App.class.getPackage().getName());
        Set<Class<? extends ClassnoVypolnil>> classes = reflections.getSubTypesOf(ClassnoVypolnil.class);
        for (Class cls : classes) {
            commands.add(
                    (ClassnoVypolnil) cls.getDeclaredConstructor().newInstance());
        }
    }

    public ClassnoVypolnil createCommand(String command) {
        for (var cmd : commands) {
            if (cmd.supports(command)) {
                return cmd;
            }
        }
        return null;
    }
}
