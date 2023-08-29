class ReverseString {
    String reverse(String inputString) {
        if (inputString.length() == 0)
          return inputString;
        
        char[] charArray = inputString.toCharArray();

        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left += 1;
            right -= 1;
        }
        
        return new String(charArray);
    }
}
