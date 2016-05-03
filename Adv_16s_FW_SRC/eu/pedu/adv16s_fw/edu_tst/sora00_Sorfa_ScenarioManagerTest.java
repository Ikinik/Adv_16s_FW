package eu.pedu.adv16s_fw.edu_tst;
import eu.pedu.adv16s_fw.game_txt.IGSMFactory;
import eu.pedu.adv16s_fw.test_util.default_game.DemoGSMFactory;
import eu.pedu.adv16s_fw.test_util.default_game.game.DemoScenarioManagerLit;
import org.junit.Test;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Adam on 1.5.2016.
 */
public class sora00_Sorfa_ScenarioManagerTest implements IStreamTest {
    /***************************************************************************
     * Vrátí class-objekt tovární třídy testované hry.
     *
     * @return Class-objekt tovární třídy testované hry
     */
    @Override
    public Class<? extends IGSMFactory> getDefaultFactoryClass() {
        return DemoGSMFactory.FACTORY_CLASS;
    }

    /***************************************************************************
     * Vypíše názvy všech scénářů spravovaných aktuálním správcem.
     */
    @Test
    public void printScenarioNames() {
        DemoScenarioManagerLit.getInstance()
                .stream()
                .forEach(i->System.out.println(i.getName()));
    }

    /***************************************************************************
     * Vypíše názvy scénářů aktuálního správce následované vždy
     * pomlčkou a počtem kroků daného scénáře.
     */
    @Test
    public void printScenarioStepsCount() {
        DemoScenarioManagerLit.getInstance()
                .stream()
                .forEach(i->{
                    System.out.printf("%10s - %2d\n",i.getName(),i.stream().count());
                });
    }

    /***************************************************************************
     * Vypíše vždy název scénáře a pod ním příkazy jeho nestandardních kroků,
     * vždy jeden příkaz na jeden řádek odsazený o znaky vpravo,
     * aby se dalo snadno poznat, kde začíná další scénář
     * (jeho název odsazený nebude).
     */
    @Test
    public void printNonStandardScenarioStepCommands() {
        DemoScenarioManagerLit.getInstance()
        .forEach(i->{
            System.out.println(i.getName());

            i.stream().filter(j->{
                return j.typeOfStep.toString().matches("^tsNON(.*)");
            }).forEach(g->{
                System.out.println("\t" + g.getCommand());
            });
        });
    }

    /***************************************************************************
     * Vypíše abecedně seřazené názvy všech prostorů ve scénářích
     * spravovaných aktuálním správcem.
     */
    @Test
    public void printScenarioSpaceNames() {
        Set<String> neightbours = new LinkedHashSet<String>();

        DemoScenarioManagerLit.getInstance()
        .stream().forEach(i->{
            i.stream().forEach(j->{
                Arrays.stream(j.neighbors).forEach(g->{
                    neightbours.add(g.toString());
                });
            });
        });

        neightbours.stream().sorted().forEach(c->{
            System.out.println(c.toString());
        });
    }

    /***************************************************************************
     * Vypíše abecedně seřazené názvy všech h-objektů ve scénářích
     * spravovaných aktuálním správcem.
     * Každý název bude vypsán jen jednou nezávisle na počtu instancí.
     */
    @Test
    public void printScenarioItemNames() {
        Set<String> items = new LinkedHashSet<String>();

        DemoScenarioManagerLit.getInstance()
        .stream().forEach(i->{
            i.stream().forEach(g->{
                Arrays.stream(g.items).forEach(c->{
                    items.add(c.toString());
                });
            });
        });

        items.stream().sorted().forEach(c->{
            System.out.println(c.toString());
        });

    }
}
