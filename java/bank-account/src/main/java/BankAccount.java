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
        if (depositNotAllowed(amount))
            throw new BankAccountActionInvalidException(getMessage(amount));

        setBalance(getBalance() + amount);
    }

    synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        if (withdrawNotAllowed(amount))
            throw new BankAccountActionInvalidException(getMessage(amount));

        setBalance(getBalance() - amount);
    }

    private void setActive(boolean isActive) {
        this.active = isActive;
    }

    private void setBalance(int amount) {
        this.balance = amount;
    }

    private boolean withdrawNotAllowed(int amountToWithdraw) throws BankAccountActionInvalidException {
        return getBalance() <= 0 || ((getBalance() - amountToWithdraw) < 0) || amountToWithdraw < 0;
    }

    private boolean depositNotAllowed(int amountToDeposit) throws BankAccountActionInvalidException {
        return (amountToDeposit < 0) || !getActive();
    }

    private String getMessage(int amount) throws BankAccountActionInvalidException {
        if (amount < 0)
            return "Cannot deposit or withdraw negative amount";
        if (getBalance() <= 0)
            return "Cannot withdraw money from an empty account";
        if ((getBalance() - amount) < 0)
            return "Cannot withdraw more money than is currently in the account";

        return "An unknown error occurred";
    }

}