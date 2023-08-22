void findBestBooking(Request request, List<Driver> list) {
    String s = "";
    ImList<Booking> bookingList = new ImList<Booking>();

    for (int i = 0; i < list.size(); i++) {
       bookingList = bookingList.add(new Booking(list.get(i), request)).add(new Booking(list.get(i), request, true)); 
       } 
    
    ImList<Booking> sortedList = bookingList.sort(new BookingComparator());
    for (Booking i : sortedList) { 
        System.out.println(i.toString());
    }  

}
    
