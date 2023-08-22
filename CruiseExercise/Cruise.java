class Cruise {
    private final String id;
    // time in HHMM
    private final int arrival;
    // service time in minutes
    private final int serviceTime;
    private final int numOfLoaders;
    private static final int minHour = 60;
    private static final int chartwo = 2;
    private static final int charthree = 3;
    private static final int charfour = 4;

    Cruise(String id, int arrival, int numOfLoaders, int serviceTime) {
        this.id = id;
        this.arrival = arrival;
        this.serviceTime = serviceTime;
        this.numOfLoaders = numOfLoaders;
    }

    int getServiceTime() {
        return this.serviceTime;
    }
   
    String getID() {
        return this.id;
    }

    int getArrival() {
        return this.arrival;
    }

    // arrival time in number of minutes since midnight
    int getArrivalTime() {
        String time = Integer.toString(this.getArrival());
        int numOfChar = time.length();
        int minutes = 0;
        if (numOfChar > chartwo) {
            if (numOfChar == charthree) {
                String timeHour = time.substring(0,1);
                minutes += Integer.parseInt(timeHour) * minHour;
                String timeMinutes = time.substring(1, charthree);
                minutes += Integer.parseInt(timeMinutes);
            } else {
                String timeHour = time.substring(0, chartwo);
                minutes += Integer.parseInt(timeHour) * minHour;
                String timeMinutes = time.substring(2, charfour);
                minutes += Integer.parseInt(timeMinutes);
            }
        } else {
            minutes += Integer.parseInt(time);     
        }
        return minutes;
    }

    int getNumOfLoadersRequired() {
        return this.numOfLoaders;
    }

    @Override
    public String toString() {
        return this.getID() + String.format("@%04d", this.getArrival());
    } 

}
