import java.util.ArrayList;
import java.util.Random;

/**
 * Created by pober on 03.12.2016.
 */
public class Manager implements LeagueManager {
    private ArrayList<SockerPlayer> players;

    public Manager(){
        players = new ArrayList<SockerPlayer>();
    }

    @Override
    public void addPlayer(SockerPlayer player){
        players.add(player);
    }

    @Override
    public void removePlayer(SockerPlayer player){
        for (int i=0; i<players.size(); i++){
            if (players.get(i).getNickName().equals(player.getNickName())) players.remove(players.get(i));
        }
    }

    @Override
    public SockerPlayer getPlayer(String name){
        for (SockerPlayer element: players){
            if (element.getNickName().equals(name)) return element;
        }
        return null;
    }

    @Override
    public SockerPlayer[] getAllPlayers(){
        return (SockerPlayer[]) players.toArray();
    }

    @Override
    public SockerPlayer[] getPlayers(League league){
        int playersinleague = 0;
        for (SockerPlayer element: players){
            if (element.getLeague().equals(league)){
                playersinleague++;
            }
        }
        SockerPlayer[] sockerplayer = new SockerPlayer[playersinleague];
        int i=0;
        for (SockerPlayer element: players){
            if (element.getLeague().equals(league)){
                sockerplayer[i] = element;
                i++;
            }
        }
        return sockerplayer;
    }

    @Override
    public SockerPlayer[] getPlayers(Country country){
        int playersincountry = 0;
        for (SockerPlayer element: players){
            if (element.getCountry().equals(country)){
                playersincountry++;
            }
        }
        SockerPlayer[] sockerplayer = new SockerPlayer[playersincountry];
        int i=0;
        for (SockerPlayer element: players){
            if (element.getCountry().equals(country)){
                sockerplayer[i] = element;
                i++;
            }
        }
        return sockerplayer;
    }

    @Override
    public void addPoints (String name, int points){
        SockerPlayer player = getPlayer(name);
        player.setPoints(player.getPoints() + points);
    }

    public void createRandomSituation(){
        Random rand = new Random();
        for (int i = 0; i< rand.nextInt(16)+15; i++){
            switch (rand.nextInt(6)+1){
                case 1:
                switch(rand.nextInt(3)+1){
                    case 1:
                        players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.Premier, Country.Spain));
                        break;
                    case 2:
                        players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.First, Country.Spain));
                        break;
                    case 3:
                        players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.Second, Country.Spain));
                        break;
                }
                    break;
                case 2:
                    switch(rand.nextInt(3)+1){
                        case 1:
                            players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.Premier, Country.Portugal));
                            break;
                        case 2:
                            players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.First, Country.Portugal));
                            break;
                        case 3:
                            players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.Second, Country.Portugal));
                            break;
                    }
                    break;
                case 3:
                    switch(rand.nextInt(3)+1){
                        case 1:
                            players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.Premier, Country.Argentina));
                            break;
                        case 2:
                            players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.First, Country.Argentina));
                            break;
                        case 3:
                            players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.Second, Country.Argentina));
                            break;
                    }
                    break;
                case 4:
                    switch(rand.nextInt(3)+1){
                        case 1:
                            players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.Premier, Country.England));
                            break;
                        case 2:
                            players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.First, Country.England));
                            break;
                        case 3:
                            players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.Second, Country.England));
                            break;
                    }
                    break;
                case 5:
                    switch(rand.nextInt(3)+1){
                        case 1:
                            players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.Premier, Country.France));
                            break;
                        case 2:
                            players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.First, Country.France));
                            break;
                        case 3:
                            players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.Second, Country.France));
                            break;
                    }
                    break;
                case 6:
                    switch(rand.nextInt(3)+1){
                        case 1:
                            players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.Premier, Country.Germany));
                            break;
                        case 2:
                            players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.First, Country.Germany));
                            break;
                        case 3:
                            players.add(new Player("Игрок"+(i+1), (Integer)(rand.nextInt(26)+75),League.Second, Country.Germany));
                            break;
                    }
                    break;
            }
        }
    }

    @Override
    public String toString(){
        String allplayers = "";
        for (SockerPlayer element: players){
            allplayers += "Страна: " + element.getCountry() + " Лига: " + element.getLeague() + " Имя: " + element.getNickName() + " Очки: " + element.getPoints() + "\n";
        }
        return allplayers;
    }

    public ArrayList<SockerPlayer> getPlayersList(){
        return this.players;
    }
}
