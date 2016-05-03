/* The file is saved in UTF-8 codepage.
* Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
*/
package eu.pedu.adv16s_fw.edu_tst;

import eu.pedu.adv16s_fw.game_txt.IGSMFactory;


import org.junit.Test;



/*******************************************************************************
 * Instance interfejsu {@code IStreamTest} představují
 * testy analyzující scénáře správce scénářů hry
 * se zadanou tovární třídou.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public interface IStreamTest
{
//== STATIC CONSTANTS ==========================================================
//== STATIC METHODS ============================================================



//##############################################################################
//== ABSTRACT GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí class-objekt tovární třídy testované hry.
     *
     * @return Class-objekt tovární třídy testované hry
     */
    public Class<? extends IGSMFactory> getDefaultFactoryClass()
    ;



//== OTHER ABSTRACT METHODS ====================================================

    /***************************************************************************
     * Vypíše názvy všech scénářů spravovaných aktuálním správcem.
     */
    @Test
    public void printScenarioNames()
    ;

    /***************************************************************************
     * Vypíše názvy scénářů aktuálního správce následované vždy
     * pomlčkou a počtem kroků daného scénáře.
     */
    @Test
    public void printScenarioStepsCount();


    /***************************************************************************
     * Vypíše vždy název scénáře a pod ním příkazy jeho nestandardních kroků,
     * vždy jeden příkaz na jeden řádek odsazený o znaky vpravo,
     * aby se dalo snadno poznat, kde začíná další scénář
     * (jeho název odsazený nebude).
     */
    @Test
    public void printNonStandardScenarioStepCommands()
    ;


    /***************************************************************************
     * Vypíše abecedně seřazené názvy všech prostorů ve scénářích
     * spravovaných aktuálním správcem.
     */
    @Test
    public void printScenarioSpaceNames()
    ;


    /***************************************************************************
     * Vypíše abecedně seřazené názvy všech h-objektů ve scénářích
     * spravovaných aktuálním správcem.
     * Každý název bude vypsán jen jednou nezávisle na počtu instancí.
     */
    @Test
    public void printScenarioItemNames()
    ;



//== DEFAULT GETTERS AND SETTERS ===============================================
//== OTHER DEFAULT METHODS =====================================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
 