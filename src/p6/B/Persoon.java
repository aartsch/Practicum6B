package p6.B;

import java.util.ArrayList;
import java.util.Iterator;

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
        if (budget > g.huidigeWaarde() && !mijnGames.contains(g))  {
            budget = budget - g.huidigeWaarde();
            mijnGames.add(g);
            return true;
        }
        else {
            return false;
        }
    }
    public boolean verkoop(Game g, Persoon koper)    {
        if (koper.budget > g.huidigeWaarde() && !koper.mijnGames.contains(g) && mijnGames.contains(g)) {
            koper.budget = koper.budget - g.huidigeWaarde();
            budget = budget + g.huidigeWaarde();
            mijnGames.remove(g);
            koper.mijnGames.add(g);
            mijnGames.remove(g);
            return true;
        }
        else    {
            return false;
        }
    }

    public Game  zoekGameOpNaam(String g)    {
        Iterator<Game> iterator = mijnGames.iterator();
            while (iterator.hasNext())   {
                Game mijnGame = iterator.next();
                if (mijnGame.getNaam().equals(g)) {
                    return mijnGame;
                }
            }
            return null;
    }

    public ArrayList<Game> bepaalGamesNietInBezit(ArrayList<Game> teKoop) {
        ArrayList<Game> nogNietInBezit = new ArrayList<Game>();
        Iterator<Game> iterator = mijnGames.iterator();
        Iterator<Game> iterator2 = teKoop.iterator();
        while (iterator.hasNext() && iterator2.hasNext()) {
            Game mijnGame = iterator.next();
            Game koop = iterator2.next();
            if (mijnGame.getNaam().equals(koop.getNaam()) && mijnGame.getReleaseJaar() == (koop.getReleaseJaar())) {
                nogNietInBezit.add(koop);
                //return nogNietInBezit;
            }
        }
        return nogNietInBezit;
    }
    public String toString()    {
        String s = naam + " heeft een budget van $" + String.format("%.2f", budget) + " en bezit de volgende games:" + "\n" + mijnGames.toString();
        return s;
    }

}

