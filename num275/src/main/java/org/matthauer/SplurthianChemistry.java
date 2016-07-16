package org.matthauer;

import java.util.HashMap;

/**
 * Created by sta7ic on 7/14/2016.
 */
public class SplurthianChemistry {
    private static HashMap<String, String> elementMap = new HashMap<String, String>();

    public SplurthianChemistry(){
        ;
    }
    public String addElement(String elementName){
        String useName = elementName.toLowerCase();
        return null;
    }
    /**
     * THE RULES:
     * All chemical symbols must be exactly two letters, so B is not a valid symbol for Boron.
     * Both letters in the symbol must appear in the element name, but the first letter of the element name does not
     *      necessarily need to appear in the symbol. So Hg is not valid for Mercury, but Cy is.
     * The two letters must appear in order in the element name. So Vr is valid for Silver, but Rv is not. To be clear,
     *      both Ma and Am are valid for Magnesium, because there is both an a that appears after an m, and an m that
     *      appears after an a.
     * If the two letters in the symbol are the same, it must appear twice in the element name. So Nn is valid for
     *      Xenon, but Xx and Oo are not.
     * @param element   The string for the chemical element name
     * @param symbol    The symbol to check for validity
     * @return
     */
    public boolean checkSymbol(String element, String symbol){
        String useName = element.toLowerCase(),
                useSymbol = symbol.toLowerCase();
        // rule one
        if(symbol.length() != 2)
            return false;

        // rule two
        final int posOne = useName.indexOf(useSymbol.charAt(0)),
                posTwo = useName.lastIndexOf(useSymbol.charAt(1));
        if(posOne == -1 || posTwo == -1){
            return false;
        }

        // rule three
        if(posTwo < posOne){
            return false;
        }

        // rule four
        if(posTwo == posOne){
            int dupe = useName.substring(posOne+1).indexOf(useSymbol.charAt(0));
            if(dupe == -1){
                return false;
            }
        }

        return true;
    }

    // return first valid two-letter symbol that matches the rules, with the 'lowest' letter for each position
    public String buildAlphaSymbol(String element) throws Exception {
        String useName = element.toLowerCase();
        char first, second;
        // get the first letter
        first = useName.charAt(0);
        // get the next UNIQUE letter (so 'r' in aardvark)
        int i = 1;
        while(useName.charAt(i) == first && i < useName.length())
            ++i;
        second = useName.charAt(i);
        // ordered correctly?
        if(first > second){
            char swap = second;
            second = first;
            first = swap;
        }
        for(char c : useName.substring(i+1).toCharArray()){
            char hold = 'Z';
            if(c < first){
                second = first;
                first = c;
            }
        }
        // probably could use a StringBuilder, but need to capture that case convention.
        return new String(new char[]{first}).toUpperCase().concat(new String(new char[]{second}));
//        throw new Exception("unable to build symbol for "+element);
    }
}
