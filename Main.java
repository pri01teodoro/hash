
public class Main {
    public static void main(String[] args) {
        TabelaHash table = new TabelaHash(5);

        table.put("Priscila", 1);
        table.put("Hurtado", 2);
        table.put("Teodoro", 3);

        //table.remove("Hurtado");

        table.print();
        
    }
}
