package exam2.ex1;

import java.util.*;

public class Main {
    private static boolean patientAdded = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String[]> departments = new HashMap<>();
        Map<String, TreeSet<String>> doctorsAndPatients = new HashMap<>();

        String input = scanner.nextLine();

        while (!"Output".equals(input)) {

            String[] data = input.split("\\s+");
            String department = data[0];
            String doc = data[1] + " " + data[2];
            String patient = data[3];

            if (!departments.containsKey(department)) {
                departments.put(department, new String[60]);
            }

            patientAdded = addPatient(departments, department, patient);
            addDoctor(doctorsAndPatients, doc, patient);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] split = input.split("\\s+");

            if (split.length == 1) {
                printPatientsInDepartment(departments, split[0]);

            } else if (split.length == 2) {

                if (Character.isDigit(split[1].charAt(0))) {
                    printPatientsInRoom(departments, split);

                } else {
                    printDocsPatients(doctorsAndPatients, split);
                }

            }

            input = scanner.nextLine();
        }
    }

    private static void printDocsPatients(Map<String, TreeSet<String>> doctorsAndPatients, String[] split) {
        String doc = split[0] + " " + split[1];
        doctorsAndPatients.get(doc)
                .forEach(System.out::println);
    }

    private static void printPatientsInRoom(Map<String, String[]> departments, String[] split) {
        String department = split[0];
        int room = Integer.parseInt(split[1]) - 1;

        int startIndex = room * 3;
        Arrays.stream(departments.get(department))
                .skip(startIndex)
                .limit(3)
                .filter(Objects::nonNull)
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }

    private static void printPatientsInDepartment(Map<String, String[]> departments, String department1) {
        String department = department1;

        Arrays.stream(departments.get(department))
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }

    private static void addDoctor(Map<String, TreeSet<String>> doctorsAndPatients, String doc, String patient) {
        if (!doctorsAndPatients.containsKey(doc)) {
            doctorsAndPatients.put(doc, new TreeSet<>());
        }
        if (patientAdded) {
            doctorsAndPatients.get(doc).add(patient);
        }
    }

    private static boolean addPatient(Map<String, String[]> departments, String department, String patient) {
        boolean patientAdded = false;
        //  Initial:
        for (int room = 0; room < departments.get(department).length; room++) {
            if (departments.get(department)[room] == null) {
                departments.get(department)[room] = patient;
                //   break Initial;
                patientAdded = true;
                break;
            }

        }
        return patientAdded;
    }
}
