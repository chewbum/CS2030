import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

class KeyableMap<V extends Keyable> implements Keyable {
    private final String key; 
    private final ImmutableMap<String,V> map;

    KeyableMap(String key) {
        this.key = key;
        this.map = new ImmutableMap<String,V>();
    }

    KeyableMap(String key, ImmutableMap<String,V> map) {
        this.key = key;
        this.map = map;
    }

    ImmutableMap<String,V> getMap() {
        return this.map;
    }

    @Override
    public String getKey() {
        return this.key;
    }
    
    KeyableMap<V> put(V item) {
        return new KeyableMap<V>(this.getKey(), this.map.put(item.getKey(), item));
    }

    Optional<V> get(String key) {
        return this.map.get(key);
    }

    @Override 
    public String toString() {
        String s = this.key + ": {";
        for (Map.Entry<String, V> entry : this.map) {
            s += entry.getValue() + ", ";
        }
        if (this.map.isEmpty() == false) {
            s = s.substring(0, s.length() - 2);
        }
        s += "}";
        return s;
    }

}