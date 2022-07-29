package FuramaResort.Services;

import FuramaResort.Models.Contract;

import java.util.Comparator;

public class ContractComparator implements Comparator<Contract> {
    @Override
    public int compare(Contract o1, Contract o2) {
        return o1.getNumberContract()-o2.getNumberContract();
    }
}
