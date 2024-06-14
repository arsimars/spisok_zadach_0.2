package ru.example.todo;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Factory {

    //final Map<String, ClassnoVypolnil> commands = new HashMap<>();

    private final List<ClassnoVypolnil> commands = new ArrayList<>();

    public Factory() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /*
        Reflections reflections = new Reflections(App.class.getPackage().getName());
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(CommandInterface.class);
        for (Class cls : classes) {
            CommandInterface target = (CommandInterface) cls.getAnnotation(CommandInterface.class);
            commands.put(target.name(),  (ClassnoVypolnil) cls.getDeclaredConstructor().newInstance());
        }

         */
        Reflections reflections = new Reflections(App.class.getPackage().getName());
        Set<Method> classes = reflections.getMethodsWithSignature(ClassnoVypolnil.class);
        for (Method cls : classes) {
            ClassnoVypolnil target = (ClassnoVypolnil) cls.getName(ClassnoVypolnil);
            commands.put(target.name(),  (ClassnoVypolnil) cls.getDeclaredAnnotation(ClassnoVypolnil).newInstance());
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
