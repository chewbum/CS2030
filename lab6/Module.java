import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

class Module extends KeyableMap<Assessment> {

    Module(String module) {
        super(module);
    }
    
    Module(String module, ImmutableMap<String, Assessment> m) {
        super(module, m);
    }
    
    @Override
    Module put(Assessment a) {
        return new Module(super.getKey(), super.getMap().put(a.getKey(), a));
    }

}


