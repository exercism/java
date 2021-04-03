class ReverseString {

    String reverse(String inputString) {

        char[] cs = inputString.toCharArray();
        int size = cs.length;
        char[] copy = new char[size];

        for(int i=size-1; i >=0; i--) {
            copy[(size-1)-i] = cs[i];
        }

        return new String(copy);
    }
  
}
