
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        //  throw new UnsupportedOperationException("Please implement the BirdWatcher.getLastWeek() method");
        int[] birdCount = new int[] {0,2,5,3,7,8,4};
        return birdCount;
    }

    public int getToday() {
        //  throw new UnsupportedOperationException("Please implement the BirdWatcher.getToday() method");
        return birdsPerDay[birdsPerDay.length-1];
    }

    public void incrementTodaysCount() {
        ///   throw new UnsupportedOperationException("Please implement the BirdWatcher.incrementTodaysCount() method");
        birdsPerDay[birdsPerDay.length-1] += 1;
    }

    public boolean hasDayWithoutBirds() {
        // throw new UnsupportedOperationException("Please implement the BirdWatcher.hasDayWithoutBirds() method");
        boolean noBird = false;
        for(int count : birdsPerDay){
            if (count == 0){
                noBird = true;
            }

        }
        return noBird;
    }

    public int getCountForFirstDays(int numberOfDays) {
        //  throw new UnsupportedOperationException("Please implement the BirdWatcher.getCountForFirstDays() method");
        int getTotalCount=0;
        if(numberOfDays>birdsPerDay.length){
            numberOfDays = birdsPerDay.length;
        }
        for(int i=0;i<numberOfDays;i++){
            getTotalCount += birdsPerDay[i];
        }
        return getTotalCount;

    }

    public int getBusyDays() {
        //     throw new UnsupportedOperationException("Please implement the BirdWatcher.getBusyDays() method");

        int busyDays=0;
        for (int count : birdsPerDay){
            if(count >= 5) {
                busyDays++;
            }
        }
        return busyDays;
    }
}