class RaindropConverter {

    String convert(int number) {
        String drops = "";
        drops += (number % 3 == 0) ? "Pling" : "";
        drops += (number % 5 == 0) ? "Plang" : "";
        drops += (number % 7 == 0) ? "Plong" : "";
        return drops.isEmpty() ? Integer.toString(number) : drops;
    }

}
