class ResistorColorTrio{
    private enum Color{
        BLACK,BROWN,RED,ORANGE,YELLOW,GREEN,BLUE,VIOLET,GREY,WHITE;
    }

    public static long getValueOfResistor(Color[] colors) {
        long val = colors[0].ordinal() * 10L + colors[1].ordinal();
        int amountOfZeros = colors[2].ordinal();

        for(int i = 0;i<amountOfZeros;i++){
            val = val * 10;
        }
        return val;
    }

    public static String getLabelOfResistor(long val) {
        if(val >=1_000_000_000){
            return val/1_000_000_000 + " gigaohms";
        }
        if(val >=1_000_000){
            return val/1_000_000 + " megaohms";
        }if(val >=1_000){
            return val/1_000 + " kiloohms";
        }
        else{
            return val + " ohms";
        }
    }
}