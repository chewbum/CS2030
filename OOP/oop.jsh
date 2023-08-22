class A extends Mother {
    
}

A a1 = new A();
A a2 = new A();
a1.set(a2);
a2.set(a1);

abstract class Mother {
    private Mother other;

    void set(Mother other) {
        this.other = other;
    }

    Mother get() {
        return this.other;
    }
}

class B extends Mother{

}

class C extends Mother {

}



return words.stream().map(x -> x.length()).reduce(0, (x,y) -> x + y)

return words.stream().reduce(0, (x,y) -> x + y.length())