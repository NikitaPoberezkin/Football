import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by pober on 06.12.2016.
 */
public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Manager manager = new Manager();
        manager.createRandomSituation();
        System.out.println(manager.toString());

        do_operation: while (true) {
            System.out.println("\n1. Вывести всех игроков\n" +
                    "2. Вывести всех игроков из Лиги\n" +
                    "3. Вывести всех игроков из Страны\n" +
                    "4. Добавить игрока\n" +
                    "5. Убрать игрока\n" +
                    "6. Добавить игроку очки\n" +
                    "7. Выйти из системы");
            switch (scan.nextInt()) {
                case 1:
                    System.out.println(manager.toString());
                    break;
                case 2:
                    System.out.println("Выберите лигу: 1-Premier, 2-First, 3-Second");
                    switch(scan.nextInt()){
                        case 1:
                        SockerPlayer[] premierleagueplayers = manager.getPlayers(League.Premier);
                            Arrays.sort(premierleagueplayers, Collections.reverseOrder());
                        for (int i=0; i<premierleagueplayers.length; i++){
                            System.out.println("Имя: " + premierleagueplayers[i].getNickName() + " Очки: " + premierleagueplayers[i].getPoints());
                        }
                            break;
                        case 2:
                            SockerPlayer[] firstleagueplayers = manager.getPlayers(League.First);
                            Arrays.sort(firstleagueplayers, Collections.reverseOrder());
                            for (int i=0; i<firstleagueplayers.length; i++){
                                System.out.println("Имя: " + firstleagueplayers[i].getNickName() + " Очки: " + firstleagueplayers[i].getPoints());
                            }
                            break;
                        case 3:
                            SockerPlayer[] secondleagueplayers = manager.getPlayers(League.Second);
                            Arrays.sort(secondleagueplayers, Collections.reverseOrder());
                            for (int i=0; i<secondleagueplayers.length; i++){
                                System.out.println("Имя: " + secondleagueplayers[i].getNickName() + " Очки: " + secondleagueplayers[i].getPoints());
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Выберите страну: 1-Spain, 2-Portugal, 3-Argentina, 4-England, 5-France, 6-Germany");
                    switch(scan.nextInt()) {
                        case 1:
                            SockerPlayer[] spainplayers = manager.getPlayers(Country.Spain);
                            Arrays.sort(spainplayers, Collections.reverseOrder());
                            System.out.println();
                            for (int i = 0; i < spainplayers.length; i++) {
                                System.out.println("Имя: " + spainplayers[i].getNickName() + " Очки: " + spainplayers[i].getPoints());
                            }
                            break;
                        case 2:
                            SockerPlayer[] portugalplayers = manager.getPlayers(Country.Portugal);
                            Arrays.sort(portugalplayers, Collections.reverseOrder());
                            System.out.println();
                            for (int i = 0; i < portugalplayers.length; i++) {
                                System.out.println("Имя: " + portugalplayers[i].getNickName() + " Очки: " + portugalplayers[i].getPoints());
                            }
                            break;
                        case 3:
                            SockerPlayer[] argentinaplayers = manager.getPlayers(Country.Argentina);
                            Arrays.sort(argentinaplayers, Collections.reverseOrder());
                            System.out.println();
                            for (int i = 0; i < argentinaplayers.length; i++) {
                                System.out.println("Имя: " + argentinaplayers[i].getNickName() + " Очки: " + argentinaplayers[i].getPoints());
                            }
                            break;
                        case 4:
                            SockerPlayer[] englandplayers = manager.getPlayers(Country.England);
                            Arrays.sort(englandplayers, Collections.reverseOrder());
                            System.out.println();
                            for (int i = 0; i < englandplayers.length; i++) {
                                System.out.println("Имя: " + englandplayers[i].getNickName() + " Очки: " + englandplayers[i].getPoints());
                            }
                            break;
                        case 5:
                            SockerPlayer[] franceplayers = manager.getPlayers(Country.France);
                            Arrays.sort(franceplayers, Collections.reverseOrder());
                            System.out.println();
                            for (int i = 0; i < franceplayers.length; i++) {
                                System.out.println("Имя: " + franceplayers[i].getNickName() + " Очки: " + franceplayers[i].getPoints());
                            }
                            break;
                        case 6:
                            SockerPlayer[] germanyplayers = manager.getPlayers(Country.Germany);
                            System.out.println();
                            for (int i = 0; i < germanyplayers.length; i++) {
                                System.out.println("Имя: " + germanyplayers[i].getNickName() + " Очки: " + germanyplayers[i].getPoints());
                            }
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Введите имя: ");
                    String name = scan.next();
                    System.out.println("Введите количество очков: ");
                    Integer score = scan.nextInt();
                    System.out.println("Введите страну (Spain, Portugal, Argentina, England, France, Germany)");
                    String country = scan.next();
                    System.out.println("Введите лигу (Premier, First, Second)");
                    String league = scan.next();
                    manager.addPlayer(new Player(name, score, League.valueOf(league), Country.valueOf(country)));
                    break;
                case 5:
                    System.out.println("Введите имя игрока: ");
                    name = scan.next();
                    SockerPlayer player = null;
                    for (SockerPlayer element: manager.getPlayersList()){
                        if (element.getNickName().equals(name)){
                            player = element;
                        }
                    }
                    manager.removePlayer(player);
                    break;
                case 6:
                    System.out.println("Введите имя игрока: ");
                    name = scan.next();
                    System.out.println("Введите кол-во очков: ");
                    score = scan.nextInt();
                    manager.addPoints(name, score);
                    break;
                case 7: break do_operation;

            }
        }
        System.out.println();

    }
}
