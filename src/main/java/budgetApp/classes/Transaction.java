package budgetApp.classes;

/* This transaction interface sits above the Expenditure and Income class. If you want to think of the 'hierarchy' in terms of
    what classes call what think of the following:

                  Account Class
                        |
               Transaction Interface
                |               |
        Expenditure Class   Income Class

 */

public interface Transaction {

    double getValue();

}
