/**
 * {@link CamiciaResult} shows the result of a Camicia game
 */
public record CamiciaResult(String status, int cards, int tricks) {

    /**
     * @return the game status
     */
    public String status() {
        return status;
    }

    /**
     * @return the total played cards
     */
    public int cards() {
        return cards;
    }

    /**
     * @return the total tricks used
     */
    public int tricks() {
        return tricks;
    }
}


