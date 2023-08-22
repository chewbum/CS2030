import java.util.Optional;

class City {
    // Answer q2(a) below. Do not remove this comment.
    private final ImList<Route> routesList;

    City() {
        this.routesList = new ImList<Route>();
    }

    City(ImList<Route> new) {
        this.routesList = new;
    }



    // Answer q2(b) below. Do not remove this comment.
    City updateRoute(Route r) {
        Route temp;
        for (int i = 0; i < routesList.size(); i++) {
            temp = routesList.get(i);
            String tempOrigin = String.toLowerCase(temp.getOrigin());
            String rOrigin = String.toLowerCase(r.getOrigin());
            String tempDestination = String.toLowerCase(temp.getDestination());
            String rDestination = String.toLowerCase(r.getDestination());
            if (tempOrigin == rOrigin && tempDestination == rDestination) {
                if(temp.getDistance() == r.getDistance()) {
                    return this;
                } else {
                    ImList<Route> new = this.routesList.set(i, temp);
                    return new City(new);
                }
            }
        }
        ImList<Route> new = this.routesList.add(r);
        return new City(new);
    }



    // Answer q2(c) below. Do not remove this comment.
    Optional<String> getDistance(Route r) {
        Route temp;
        for (int i = 0; i < routesList.size(); i++) {
            temp = routesList.get(i);
            String tempOrigin = String.toLowerCase(temp.getOrigin());
            String rOrigin = String.toLowerCase(r.getOrigin());
            String tempDestination = String.toLowerCase(temp.getDestination());
            String rDestination = String.toLowerCase(r.getDestination());
            if (tempOrigin == rOrigin && tempDestination == rDestination) {
                return Optional.of(temp.getDistance());
            } 
        }
        return Optional.<String>empty();

    }


} // end of class City. Do not remove this comment.
