public class Leap {

  private int year = 0;

  public Leap(int year) {
    this.year = year;
  }

  public boolean isLeap() {
    if (this.year % 400 == 0) {
      return true;
    } else if (this.year % 100 == 0) {
      return false;
    } else {
      return this.year % 4 == 0;
    }
  }
}
