package exam1.ex3.repository;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private Map<Integer, Person> data;
    private int id;

    public Repository() {
        this.data = new HashMap<>();
        this.id = 0;
    }

    public void add(Person person) {
        this.data.putIfAbsent(id++, person);
    }

    public Person get(int id) {
        return this.data.get(id);
    }

    public boolean update(int id, Person newPerson) {
        if (!this.data.containsKey(id)) {
            return false;
        }

        this.data.replace(id, newPerson);
        return true;
    }

    public boolean delete(int id) {
        if (this.data.containsKey(id)) {
            this.data.remove(id);
            return true;
        }
        return false;
    }

    public int getCount() {
        return this.data.size();
    }
}
