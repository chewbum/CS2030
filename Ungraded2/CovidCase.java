abstract class CovidCase { 
      private final Person person;
      private final Test test; 

      CovidCase(Person person, Test test) {
           this.person = person;
           this.test = test;
       }

      
       abstract ImList<CovidCase> getLineage();
       abstract CovidCase test(Test t); 
       abstract Protocol getCurrentProtocol();
       abstract 
