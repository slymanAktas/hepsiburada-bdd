package bdd.models.api;

import java.util.List;

public class Clients {
    private List<String> clients;

    public List<String> getClients() {
        return clients;
    }

    public Clients(List<String> clients) {
        this.clients = clients;
    }
}
