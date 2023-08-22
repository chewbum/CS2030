// Answer 4a below. Do not remove this comment.
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.Optional;
import java.util.function.Function;

interface ImList<E> extends Iterable<E> {
   /* private final ArrayList<E> elems;

    ImList() {
        this.elems = new ArrayList<E>();
    }

    ImList(List<? extends E> list) {
        this.elems = new ArrayList<E>(list);
    }
*/
    static <E> ImList<E> of() {
        return ImList.<E>of(List.of());
    }

    static <E> ImList<E> of(List<? extends E> list) {
        return new ImList<E>() {

            private final ArrayList<E> elems = new ArrayList<E>(list);

            public ImList<E> add(E elem) {
                List<E> newList = new ArrayList<E>(this.elems);
                newList.add(elem);
                return ImList.of(newList);
            }

            public ImList<E> addAll(ImList<? extends E> list) {
                List<E> newList = new ArrayList<E>(this.elems);
                newList.addAll(list.elems);
                return ImList.of(newList);
            }

            public E get(int index) {
                return this.elems.get(index);
            }

            public boolean isEmpty() {
                return this.elems.isEmpty();
            }

            @Override
            public Iterator<E> iterator() {
                return this.elems.iterator();
            }

            public <U> U reduce(U identity, BiFunction<? super U, ? super E, ? extends U> acc) {
                for (E t : this) {
                    identity = acc.apply(identity, t);
                }
                return identity;
            }

            public Optional<E> reduce(Function<? super E, Function<? super E, ? extends E>> f) {
                return this.size() == 0 ? Optional.<E>empty() : 
                    Optional.of(elems.get(0))
                        .map(x -> this.remove(0)
                            .reduce(x, (a,b) -> f.apply(a).apply(b)));
            }

            public ImList<E> remove(int index) {
                List<E> newList = new ArrayList<E>(this.elems);
                if (index < this.size()) {
                    newList.remove(index);
                }
                return ImList.<E>of(newList);
            }

            public int size() {
                return this.elems.size();
            }

            @Override
            public String toString() {
                return this.elems.toString();
            }
};  
}
        public ImList<E> add(E elem);
        public ImList<E> addAll(ImList<? extends E> list) ;
        public int size();
        public String toString();
        public ImList<E> remove(int index);
        public Optional<E> reduce(Function<? super E, Function<? super E, ? extends E>> f);
        public <U> U reduce(U identity, BiFunction<? super U, ? super E, ? extends U> acc);
        public Iterator<E> iterator();
        public boolean isEmpty();
        public E get(int index);
}






// Answer 4b below. Do not remove this comment.



















