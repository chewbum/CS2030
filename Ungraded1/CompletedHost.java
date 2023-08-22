abstract class CompletedHost extends Host { 
    
    CompletedHost(String hostID) {
        super(hostID);
    }
    
    CompletedHost(Host h, Term t) {
        super(h,t);
    }
 
}
    
