package collections.commonproblems.insurancepolicymanagementsystempart2;
import java.util.*;
public class InsurancePolicyManagement {
        private static class Policy {
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
            //getter method
            public String getPolicyNumber() { return policyNumber; }
            public String getPolicyHolderName() { return policyHolderName; }
            public Date getExpiryDate() { return expiryDate; }

            @Override
            public String toString() {
                return "Policy{" +
                        "Number='" + policyNumber + '\'' +
                        ", Holder='" + policyHolderName + '\'' +
                        ", Expiry=" + expiryDate +
                        ", Coverage='" + coverageType + '\'' +
                        ", Premium=" + premiumAmount +
                        '}';
            }
        }
         //creating maps
        private Map<String, Policy> hashMapPolicies = new HashMap<>(); //hash maps
        private Map<String, Policy> linkedHashMapPolicies = new LinkedHashMap<>(); //linked hashmap
        private TreeMap<Date, Policy> treeMapPolicies = new TreeMap<>(); //tree map

        public void addPolicy(Policy policy) {
            hashMapPolicies.put(policy.getPolicyNumber(), policy);
            linkedHashMapPolicies.put(policy.getPolicyNumber(), policy);
            treeMapPolicies.put(policy.getExpiryDate(), policy);
        }

        public Policy getPolicyByNumber(String policyNumber) {
            return hashMapPolicies.get(policyNumber);
        }
       // generate list of soon expiring policies
        public void listExpiringSoon() {
            Date today = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(today);
            cal.add(Calendar.DAY_OF_YEAR, 30);
            Date threshold = cal.getTime();

            System.out.println("Policies Expiring in Next 30 Days:");
            for (Map.Entry<Date, Policy> entry : treeMapPolicies.entrySet()) {
                if (entry.getKey().before(threshold)) {
                    System.out.println(entry.getValue());
                }
            }
        }

        public void listPoliciesByHolder(String policyHolderName) {
            System.out.println("Policies for Policyholder: " + policyHolderName);
            for (Policy policy : hashMapPolicies.values()) {
                if (policy.getPolicyHolderName().equalsIgnoreCase(policyHolderName)) {
                    System.out.println(policy);
                }
            }
        }
     //remove all expired policies
        public void removeExpiredPolicies() {
            Date today = new Date();
            Iterator<Map.Entry<Date, Policy>> iterator = treeMapPolicies.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Date, Policy> entry = iterator.next();
                if (entry.getKey().before(today)) {
                    String policyNumber = entry.getValue().getPolicyNumber();
                    hashMapPolicies.remove(policyNumber);
                    linkedHashMapPolicies.remove(policyNumber);
                    iterator.remove();
                }
            }
            System.out.println("Expired policies removed.");
        }
        //method to display policies
        public void displayAllPolicies() {
            System.out.println("All Policies (LinkedHashMap - Insertion Order):");
            for (Policy policy : linkedHashMapPolicies.values()) {
                System.out.println(policy);
            }
        }
    public static void main(String[] args) {
            //create the instance of the class
        InsurancePolicyManagement manager = new InsurancePolicyManagement();
        Calendar cal = Calendar.getInstance();
        //add the elements in policy in each name
        cal.add(Calendar.DAY_OF_YEAR, 10);
        manager.addPolicy(new Policy("AL101", "Arjun", cal.getTime(), "Health", 5000));

        cal.add(Calendar.DAY_OF_YEAR, 5);
        manager.addPolicy(new Policy("AL102", "Shristy", cal.getTime(), "Auto", 6000));

        cal.add(Calendar.DAY_OF_YEAR, -50); // Expired policy
        manager.addPolicy(new Policy("AL103", "Nancy", cal.getTime(), "Home", 8000));

        manager.displayAllPolicies();
        System.out.println("\nRetrieving Policy by Number (AL102): " + manager.getPolicyByNumber("AL102"));

        System.out.println();
        manager.listExpiringSoon(); // to show the expiry soon
        //search by name
        System.out.println();
        manager.listPoliciesByHolder("Arjun");

        System.out.println();
        manager.removeExpiredPolicies();  //remove the exppired policies
        manager.displayAllPolicies();     //display all policies
    }
}
