package collections.commonproblems.insurancepolicymanagementsystem;
import java.util.*;

public class InsurancePolicyManagementSystem {
    private static class Policy implements Comparable<Policy> {
        private String policyNumber;
        private String policyHolderName;
        private Date expiryDate;
        private String coverageType;
        private double premiumAmount;
        //constructor
        public Policy(String policyNumber, String policyHolderName, Date expiryDate, String coverageType, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyHolderName = policyHolderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }
          //getter methods
        public String getPolicyNumber() { return policyNumber; }
        public Date getExpiryDate() { return expiryDate; }
        public String getCoverageType() { return coverageType; }
      //overriding the compare to ans equals method
        @Override
        public int compareTo(Policy other) {
            return this.expiryDate.compareTo(other.expiryDate);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Policy policy = (Policy) obj;
            return Objects.equals(policyNumber, policy.policyNumber);
        }
       //hashcode to return the objects
        @Override
        public int hashCode() {
            return Objects.hash(policyNumber);
        }

        @Override
        public String toString() {
            return "Policy{" +
                    "Policy Number='" + policyNumber + '\'' +
                    ", Holder='" + policyHolderName + '\'' +
                    ", Expiry=" + expiryDate +
                    ", Coverage='" + coverageType + '\'' +
                    ", Premium=" + premiumAmount +
                    '}';
        }
    }
    //creating sets - hashset, linked hashset, treeset
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("All Policies (HashSet): " + hashSetPolicies);
        System.out.println("All Policies (LinkedHashSet): " + linkedHashSetPolicies);
        System.out.println("All Policies (TreeSet - Sorted by Expiry Date): " + treeSetPolicies);
    }

    public void findExpiringSoon() {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date threshold = cal.getTime();

        System.out.println("Policies Expiring Soon:");
        for (Policy policy : treeSetPolicies) {
            if (policy.getExpiryDate().before(threshold)) {
                System.out.println(policy);
            }
        }
    }

    public void findByCoverageType(String type) {
        System.out.println("Policies with Coverage Type: " + type);
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(policy);
            }
        }
    }
     //method to find duplicate policies
    public void findDuplicatePolicies() {
        Set<String> seen = new HashSet<>();
        Set<Policy> duplicates = new HashSet<>();
        for (Policy policy : hashSetPolicies) {
            if (!seen.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        System.out.println("Duplicate Policies: " + duplicates);
    }
     //method to compare performance of all three
    public void comparePerformance() {
        int testSize = 100000;
        List<Policy> testPolicies = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < testSize; i++) {
            cal.add(Calendar.DAY_OF_YEAR, 1);
            testPolicies.add(new Policy("P" + i, "Holder" + i, cal.getTime(), "Health", 5000 + i));
        }

        System.out.println("Performance Test (Adding " + testSize + " policies):");

        long start = System.nanoTime();
        for (Policy p : testPolicies) hashSetPolicies.add(p);
        long hashSetTime = System.nanoTime() - start;
        System.out.println("HashSet: " + hashSetTime / 1e6 + " ms");

        start = System.nanoTime();
        for (Policy p : testPolicies) linkedHashSetPolicies.add(p);
        long linkedHashSetTime = System.nanoTime() - start;
        System.out.println("LinkedHashSet: " + linkedHashSetTime / 1e6 + " ms");

        start = System.nanoTime();
        for (Policy p : testPolicies) treeSetPolicies.add(p);
        long treeSetTime = System.nanoTime() - start;
        System.out.println("TreeSet: " + treeSetTime / 1e6 + " ms");

        System.out.println("Performance Test (Searching a random policy):");
        Policy searchPolicy = testPolicies.get(testSize / 2);

        start = System.nanoTime();
        boolean found = hashSetPolicies.contains(searchPolicy);
        hashSetTime = System.nanoTime() - start;
        System.out.println("HashSet: " + hashSetTime / 1e6 + " ms (Found: " + found + ")");

        start = System.nanoTime();
        found = linkedHashSetPolicies.contains(searchPolicy);
        linkedHashSetTime = System.nanoTime() - start;
        System.out.println("LinkedHashSet: " + linkedHashSetTime / 1e6 + " ms (Found: " + found + ")");

        start = System.nanoTime();
        found = treeSetPolicies.contains(searchPolicy);
        treeSetTime = System.nanoTime() - start;
        System.out.println("TreeSet: " + treeSetTime / 1e6 + " ms (Found: " + found + ")");

        System.out.println("Performance Test (Removing a policy):");

        start = System.nanoTime();
        hashSetPolicies.remove(searchPolicy);
        hashSetTime = System.nanoTime() - start;
        System.out.println("HashSet: " + hashSetTime / 1e6 + " ms");

        start = System.nanoTime();
        linkedHashSetPolicies.remove(searchPolicy);
        linkedHashSetTime = System.nanoTime() - start;
        System.out.println("LinkedHashSet: " + linkedHashSetTime / 1e6 + " ms");

        start = System.nanoTime();
        treeSetPolicies.remove(searchPolicy);
        treeSetTime = System.nanoTime() - start;
        System.out.println("TreeSet: " + treeSetTime / 1e6 + " ms");
    }
  //main methods
    public static void main(String[] args) {
        //create the instance of the class
        InsurancePolicyManagementSystem manager = new InsurancePolicyManagementSystem();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 10);

        manager.addPolicy(new Policy("AL123", "Arjun", cal.getTime(), "Health", 5000));
        cal.add(Calendar.DAY_OF_YEAR, 5);
        manager.addPolicy(new Policy("AL124", "Shristy", cal.getTime(), "Pediatrition", 6000));
        cal.add(Calendar.DAY_OF_YEAR, 20);
        manager.addPolicy(new Policy("AL125", "Vamini", cal.getTime(), "Home", 8000));

        manager.displayAllPolicies();
        manager.findExpiringSoon();
        manager.findByCoverageType("Health");
        manager.findDuplicatePolicies(); //find duplicate policies
        manager.comparePerformance();  //compare performance call
    }
}
