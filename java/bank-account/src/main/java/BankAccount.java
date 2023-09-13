class BankAccount {

    private boolean active = false;
    private int balance = 0;

    void open() {
        setActive(true);
    }

    void close() {
        setActive(false);
    }

    boolean getActive() {
        return this.active;
    }

    synchronized int getBalance() throws BankAccountActionInvalidException {
        if (!getActive())
            throw new BankAccountActionInvalidException("Account closed");

        return this.balance;
    }

    synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        if (amount < 0)
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");

        if (!getActive())
            throw new BankAccountActionInvalidException("Account closed");

        setBalance(getBalance() + amount);
    }

    synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        if (getBalance() <= 0)
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");

        if ((getBalance() - amount) < 0)
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");

        if (amount < 0)
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");

        setBalance(getBalance() - amount);
    }

    private void setActive(boolean isActive) {
        this.active = isActive;
    }

    private void setBalance(int amount) {
        this.balance = amount;
    }

}