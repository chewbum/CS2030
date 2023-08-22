abstract class OGTask {

    OGTask() {
    }
    
    abstract int getDay();

    abstract boolean getIdentifier();
    
    abstract int getStart();
    
    abstract ImList<OGTask> getTaskList();
     
    abstract int getEnd();

}
