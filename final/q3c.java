// Write the entire class for q3(c) below. Do not remove this comment.
class GetDistance<City> extends Command<City> {

    GetDistance(List<String> param) {
        super(param);
    }

    @Override 
    City execute(City recevier) {
        String newStartLocation = parameters.get(0);
        String newEndLocation = parameters.get(1);
        Route other = new Route(newStartLocation, newEndLocation);
        String os = city.getDistance(other).map(x -> String.format("Distance from %s to %s is %s",newStartLocation,
        newEndLocation, x)).orElse(String.format("No route exists from %s to %s!",newStartLocation,
        newEndLocation));
        System.out.println(os);
        return receiver;
    }
}

