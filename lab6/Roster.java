class Roster extends KeyableMap<Student> {

    Roster(String identifier) {
        super(identifier);
    }

    Roster(String identifier, ImmutableMap<String, Student> m) {
        super(identifier, m);
    }
     
    @Override
    Roster put(Student s) {
        return new Roster(super.getKey(), super.getMap().put(s.getKey(), s));
    }

    String getGrade(String name, String module, String assessment) {
        return super.get(name).flatMap(x -> x.get(module)).flatMap(x -> x.get(assessment))
            .map(x -> x.getGrade())
                .orElse("No such record: " + name + " " + module + " " + assessment);
    }

    Roster add(String name, String module, String assessment, String grade) {
        Student s = super.get(name).orElse(new Student(name));;
        Module m = s.get(module).orElse(new Module(module));
        m = m.put(new Assessment(assessment, grade));
        s = s.put(m);
        return this.put(s);
    }

}