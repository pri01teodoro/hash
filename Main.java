public class Main {
    public static void main(String[] args) {
        TabelaHash table = new TabelaHash(5);

        table.put(null, 0);
        table.remove(null);
        table.clear();
        table.isEmpty();
        //table.remove("Teodoro");
        
    }
}
