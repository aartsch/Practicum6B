package p6.B;

import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames;

    public Persoon (String naam, double budget) {
        this.naam = naam;
        this.budget = budget;
        mijnGames = new ArrayList<Game>();
    }
    public double getBudget() {return budget;  }
    public boolean koop(Game g) {
        if (budget > g.huidigeWaarde())  {
            mijnGames.add(g);
            return true;
        }
        else {
            return false;
        }
    }
    public boolean verkoop(Game g, Persoon koper)    {
        if (koper.budget > g.huidigeWaarde() && !koper.mijnGames.contains(g) && mijnGames.contains(g)) {
            budget = budget - g.huidigeWaarde();
            koper.mijnGames.add(g);
            mijnGames.remove(g);
            return true;
        }
        else    {
            return false;
        }
    }
    public String toString()    {
        String s = naam + " heeft een budget van $" + String.format("%.2f", budget) + " en bezit de volgende games:" + "\n" + mijnGames.toString();
        return s;
    }

}

