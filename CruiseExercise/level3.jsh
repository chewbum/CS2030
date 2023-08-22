ImList<Service> serveCruises(ImList<Cruise> cruises) {
   ImList<Service> active = new ImList<Service>();
   ImList<Service> expired = new ImList<Service>();
   ImList<Service> result = new ImList<Service>();
   for (Cruise cruise : cruises) {
       int numLoaders = cruise.getNumOfLoadersRequired();
       if (active.isEmpty() == true && expired.isEmpty() == true) {
           for (int i = 1; i < numLoaders + 1; i++) {
               Service s = new Service(new Loader(i), cruise);
               active = active.add(s);
               result = result.add(s);
}
           continue;
}
       int counter = active.size();
       ImList<Service> temp = new ImList<Service>();
       if (active.isEmpty() != true) {
           for (int i = 0; i < counter; i++) {
               if (active.get(i).getServiceEndTime() <= cruise.getArrivalTime()) {
                   expired = expired.add(active.get(i));
}

               
               else {
                   temp = temp.add(active.get(i));
}
}
}

       active = temp;
       int expiredCounter = expired.size();
       if (numLoaders > expiredCounter) {
           // what if the size = 1
           for (int i = 0; i < (numLoaders-expiredCounter); i++) {
               expired = expired.add(new Service(new Loader(expired.size() + active.size() + 1), cruise)); 
               }
           }

       ImList<Service> tp = new ImList<Service>();
       for (int i = 0; i < numLoaders; i++) {
           Service a = expired.get(0);
            // work on this ltr
           tp = tp.add(new Service(a.getLoader(), cruise));
           active = active.add(new Service(a.getLoader(), cruise));
           int index = expired.indexOf(a);
           expired = expired.remove(index);
}
       result = result.addAll(tp);
}
       return result;
}

