import java.util.Comparator;

class PQComparator implements Comparator<Event> {
    public int compare(Event e1, Event e2) {
        double diff = e1.getEventTime() - e2.getEventTime();
        int idDiff = e1.getCust().getID() - e2.getCust().getID();
        if (diff < 0) {
            return -1;
        } else if (diff > 0) {
            return 1;
        } else {
            if (idDiff < 0) {
                return -1;
            } else {
                return 1;
            }            
        } 
    }
}   
