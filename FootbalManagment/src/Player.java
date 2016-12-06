/**
 * Created by pober on 04.12.2016.
 */
public class Player implements SockerPlayer, Comparable<Player> {
    private String nickname;
    private Integer points;
    private League league;
    private Country country;

    public Player(String nickname, Integer points, League league, Country country){
        this.nickname = nickname;
        this.points = points;
        this.league = league;
        this.country = country;
    }

    @Override
    public String getNickName(){
        return nickname;
    }

    @Override
    public Integer getPoints() {
        return points;
    }

    @Override
    public League getLeague(){
        return league;
    }

    @Override
    public Country getCountry(){
        return country;
    }

    @Override
    public int hashCode(){
        return this.nickname != null? this.nickname.hashCode():0;
    }

    @Override
    public boolean equals (Object o){
        if (this == o){
            return true;
        }

        if (o == null){
            return false;
        }

        Player player;
        if (!(o instanceof Player)){
            return false;
        }
        else {
            player = (Player)o;
        }

        if (this.points.equals(player.points)){
            return false;
        }

        if (!this.league.equals(player.league)){
            return false;
        }

        if (!this.country.equals(player.country)){
            return false;
        }

        if (!this.nickname.equals(player.nickname)){
            return false;
        }

        return true;
    }

    @Override
    public void setPoints(Integer points){
        this.points = points;
    }

    public int compareTo(Player o) {
        int result;
        result = Integer.compare(points, o.points);
        if (result != 0) return result;
        return result;
    }
}
