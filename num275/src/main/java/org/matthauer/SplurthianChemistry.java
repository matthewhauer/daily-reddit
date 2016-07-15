package org.matthauer;

/**
 * Created by sta7ic on 7/14/2016.
 */
public class SplurthianChemistry {
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
}
