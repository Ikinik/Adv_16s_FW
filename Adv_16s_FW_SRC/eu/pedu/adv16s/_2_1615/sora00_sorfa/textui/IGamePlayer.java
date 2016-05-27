package eu.pedu.adv16s._2_1615.sora00_sorfa.textui;

/**
 * Instance interfejsu {@code IGamePlayer} definují variantní části
 * univerzálního textového uživatelského rozhraní pro hraní textových her.
 */
public interface IGamePlayer {

    /**
     * Pošle uživateli zadanou zprávu a převezme od něj další příkaz.
     * @param message Posílaná zpráva
     * @return Uživatelem zadaný příkaz
     */
    public String askCommand(String message);

    /**
     * Pošle uživateli zadanou zprávu
     * @param message Posílaná zpráva
     */
    public void sendMessage(String message);

}
