import javax.imageio.plugins.tiff.TIFFImageReadParam;

// Write the entire class for q3(b) below. Do not remove this comment.
class UpdateRoute<City> extends Command<City> {

    UpdateRoute(List<String> param) {
        super(param);
    }

    @Override 
    City execute(City recevier) {
        String newStartLocation = this.param.get(0);
        String newEndLocation = this.param.get(1);
        String distance = this.param.get(2);
        City other = new City(newStartLocation, newEndLocation, distance);
        System.out.println(String.format("Route from %s to %s with distance %skm updated", newStartLocation,
        newEndLocation, distance));
        return receiver.updateRoute(other);
    }
}