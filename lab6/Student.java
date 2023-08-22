import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

class Student extends KeyableMap<Module> {

    Student(String name) {
        super(name);
    }

    Student(String name, ImmutableMap<String,Module> map) {
        super(name,map);
    }

    @Override
    Student put(Module m) {
        return new Student(super.getKey(), super.getMap().put(m.getKey(),m));
    }

}