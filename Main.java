public class Main {
    public static void main(String[] args) {
        TabelaHash table = new TabelaHash(10);

        table.put("Priscila", 12);
        table.put("Maria", 10);
        table.put("Clara", 7);
        table.put("Marcos", 0);


        //table.remove("Priscila");
        
        table.clear();
        System.out.println(table.isEmpty()); 
        System.out.println(table.size());
        table.print();
    }
}
