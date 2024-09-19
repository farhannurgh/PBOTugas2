public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;

    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */
    public TicketMachine(int ticketCost) {
        if (ticketCost > 0) {
            price = ticketCost;
        } else {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }
        balance = 0;
        total = 0;
    }

    /**
     * Return the price of a ticket.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     */
    public void insertMoney(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Please insert a positive amount.");
        }
    }

    /**
     * Return the total amount of money collected by this machine
     * excluding the current balance.
     */
    public int getTotal() {
        return total;
    }

    /**
     * Calculate and return the change, if any.
     */
    public int calculateChange() {
        if (balance >= price) {
            return balance ;
        } else {
            return 0;
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the balance by the ticket price. Print an error
     * message if more money is required.
     */
    public void printTicket() {
        if (balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price of the ticket.
            total += price;
            // Deduct the price from the balance.
            balance -= price;

            // If there is change, return it to the customer.
            int change = calculateChange();
            if (change > 0) {
                System.out.println("Please take your change: " + change + " cents.");
            }

        } else {
            System.out.println("Please insert at least " + (price - balance) + " more cents.");
        }
    }
}