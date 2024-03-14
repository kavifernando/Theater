public class Ticket {
    private final int row;
    private final int seat;
    private Person person;
    private final double price;

    public Ticket(int row, int seat, double price, Person person){

        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;

    }

    public void print() {

        System.out.print("\nName: " + person.getName());
        System.out.print("\nsurname: " + person.getSurname());
        System.out.print("\nemail: " + person.getEmail());
        System.out.print("\nseat_no: " + seat);
        System.out.print("\nrow_no: " + row);
        System.out.print("\nprice: " + price);
    }

    public int getRow() {return row;}
    public int getSeat() {return seat;}
    public Person getPerson() {return person;}
    public double getPrice() {return price;}

}
