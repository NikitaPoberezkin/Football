/**
 * Created by pober on 03.12.2016.
 */
public interface LeagueManager {

    void addPlayer(SockerPlayer player);

    void removePlayer(SockerPlayer player);

    SockerPlayer getPlayer(String name);

    SockerPlayer[] getAllPlayers();

    SockerPlayer[] getPlayers(League league);

    SockerPlayer[] getPlayers(Country country);

    void addPoints (String name, int points);
}
