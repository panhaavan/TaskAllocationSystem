import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the maximum number of team members and tasks from the user
        System.out.print("Enter the maximum number of team members: ");
        int maxTeamMembers = scanner.nextInt();
        System.out.print("Enter the maximum number of tasks: ");
        int maxTasks = scanner.nextInt();
        //*Prompts the user to enter the maximum number of team members and tasks. The entered values are read using the nextInt method of the Scanner class.

        //Creates an instance of the TaskAllocationSystem using the maximum number of team members and tasks obtained from the user.
        TaskAllocationSystem taskAllocationSystem = new TaskAllocationSystem(maxTeamMembers, maxTasks);

        // Input information for team members
        for (int i = 0; i < maxTeamMembers; i++) {
            System.out.println("\n\nEnter information for Team Member " + (i + 1));
            System.out.print("\tName: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            
            System.out.print("\tNumber of skills: ");
            int numSkills = scanner.nextInt();
            String[] skills = new String[numSkills];
            System.out.print("\tSkills (separated by space): ");
            for (int j = 0; j < numSkills; j++) {
                skills[j] = scanner.next();
            }
            System.out.print("\tWorkload: ");
            int workload = scanner.nextInt();
            System.out.print("\tAvailable (true/false): ");
            boolean available = scanner.nextBoolean();

            taskAllocationSystem.addTeamMember(new TeamMember(name, skills, workload, available));
        }

        // Input information for tasks
        for (int i = 0; i < maxTasks; i++) {
            System.out.println("\n\nEnter information for Task " + (i + 1));
            System.out.print("\tName: ");
            String taskName = scanner.next();
            System.out.print("\tNumber of required skills: ");
            int numRequiredSkills = scanner.nextInt();
            String[] requiredSkills = new String[numRequiredSkills];
            System.out.print("\tRequired Skills (separated by space): ");
            for (int j = 0; j < numRequiredSkills; j++) {
                requiredSkills[j] = scanner.next();
            }

            taskAllocationSystem.addTask(new Task(taskName, requiredSkills));
        }

        // Allocate tasks
        taskAllocationSystem.allocateTasks();
        
        scanner.close();
    }
}