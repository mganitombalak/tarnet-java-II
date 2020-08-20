package com.tarnet.di;

import com.tarnet.annotation.Dependent;
import com.tarnet.annotation.MyClassLoader;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.TreeMap;

public class TKContainer {


    private   TreeMap<String, Class > allComponents= new TreeMap<>();
    private String packageName  ;

    public TKContainer() {
        packageName = this.getClass().getPackage().getName() ;
    }

    public <T extends Object> T resolve(Class<T> awesomeClass) {

        return (T) (getComponet(awesomeClass));
    }

    @SneakyThrows
    private <T extends Object> T getComponet(Class<T> klazz) {
        Class klazzFound =  allComponents.get(klazz.getName());
        return klazzFound==null ? (T) lookDependecieAndCreate(findComponent(klazz)) : (T) klazzFound.newInstance();

    }

    @SneakyThrows
    private  <T extends Object> T lookDependecieAndCreate(Class component) {
        Object o = component.newInstance();

        Arrays.stream(component.getDeclaredFields())
                .filter(f-> Arrays.stream(f.getAnnotations()).anyMatch(a->a instanceof Dependent))
                .forEach(f->{f.setAccessible(true);
                            f.set(o,f.getAnnotation(Dependent.class).klazz().newInstance())
                        ;});
        return (T) o;
    }

    private <T extends Object> Class findComponent(Class<T> klazz) throws ClassNotFoundException {
        ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
        MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
        Class klazzCreated = classLoader.loadClass(klazz.getProtectionDomain().getCodeSource().getLocation().getPath());
        allComponents.put(klazz.getName(),klazzCreated);
        return klazzCreated;
    }
}
