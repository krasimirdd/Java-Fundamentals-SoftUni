package heroRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeroRepository {
    private List<Hero> data;

    public HeroRepository() {
        this.data = new ArrayList<>();
    }

    public void add(Hero hero) {
        this.data.add(hero);
    }

    public void remove(String name) {

        Hero heroToRemove = null;
        for (Hero hero : data) {
            if (hero.getName().equals(name)) {
                heroToRemove = hero;
            }
        }

        this.data.remove(heroToRemove);
    }

    public Hero getHeroWithHighestStrength() {
        this.data.sort(Comparator.comparingInt(h -> h.getItem().getStrength()));
        return this.data.get(this.data.size() - 1);
    }

    public Hero getHeroWithHighestAgility() {
        this.data.sort(Comparator.comparingInt(h -> h.getItem().getAgility()));
        return this.data.get(this.data.size() - 1);
    }

    public Hero getHeroWithHighestIntelligence() {
        this.data.sort(Comparator.comparingInt(h -> h.getItem().getIntelligence()));
        return this.data.get(this.data.size() - 1);
    }

    public int getCount() {
        return this.data.size();
    }

    @Override
    public String toString() {

        String finalString = "";

        data.sort(Comparator.comparingInt(Hero::getLevel));
        for (Hero hero : data) {

            finalString += String.format("%s%n%s%n",
                    hero.toHeroString()
                    , hero.getItem().toItemString());
        }
        return finalString;
    }
}
