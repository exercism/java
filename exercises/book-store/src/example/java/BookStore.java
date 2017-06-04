import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class BookStore {

  private static final int BOOK_PRICE = 8, MAX_GROUP_SIZE = 5;

  private static double[] DISCOUNT_TIERS = {0, 5, 10, 20, 25};

  double calculateBasketCost(final List<Integer> books) {
    return calculateBasketCost(books, 0);
  }

  private double calculateBasketCost(final List<Integer> books, final double priceSoFar) {
    if (books.size() == 0) {
      return priceSoFar;
    }

    List<Integer> availableBookNumbers = books.stream()
        .distinct()
        .collect(Collectors.toList());

    double minPrice = Double.MAX_VALUE;

    for (int i = 0; i < availableBookNumbers.size(); i++) {
      List<Integer> newGroupBooks = new ArrayList<>(availableBookNumbers.subList(0, i + 1));
      List<Integer> remainingBooks = new ArrayList<>(books);

      for (final Integer newGroupBook : newGroupBooks) {
        //noinspection UseBulkOperation - we want to remove _one_ of each book number, not _all_ of each book number.
        remainingBooks.remove(newGroupBook);
      }

      double price = calculateBasketCost(remainingBooks, priceSoFar + costOfGroupSize(newGroupBooks.size()));
      minPrice = Math.min(minPrice, price);
    }

    return minPrice;
  }

  private double costOfGroupSize(int groupSize) {
    if (groupSize < 1 || groupSize > MAX_GROUP_SIZE) {
      throw new IllegalStateException("Invalid group size : " + groupSize);
    }

    return BOOK_PRICE * groupSize * (100 - DISCOUNT_TIERS[groupSize - 1]) / 100;
  }

}
