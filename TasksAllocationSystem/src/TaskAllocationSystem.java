import java.util.Arrays;
class TaskAllocationSystem {
	
	//Declares private member variables teamMembers and tasks as arrays, representing team members and tasks in the system.
    private TeamMember[] teamMembers;
    private Task[] tasks;

    //Declares private member variables teamMembersCount and tasksCount to keep track of the number of team members and tasks in the system.
    private int teamMembersCount;
    private int tasksCount;

    //Defines a constructor for the TaskAllocationSystem class. It initializes arrays with the specified sizes and sets counts to zero.
    public TaskAllocationSystem(int maxTeamMembers, int maxTasks) {
        this.teamMembers = new TeamMember[maxTeamMembers];
        this.tasks = new Task[maxTasks];
        this.teamMembersCount = 0;
        this.tasksCount = 0;
    }

    //Provides a method addTeamMember to add a team member to the system. It checks if there's space in the array before adding.
    public void addTeamMember(TeamMember member) {
        if (teamMembersCount < teamMembers.length) {
            teamMembers[teamMembersCount++] = member;
        } else {
            System.out.println("Team members array is full. Cannot add more members.");
        }
    }

    //Provides a method addTask to add a task to the system. It checks if there's space in the array before adding.
    public void addTask(Task task) {
        if (tasksCount < tasks.length) {
            tasks[tasksCount++] = task;
        } else {
            System.out.println("Tasks array is full. Cannot add more tasks.");
        }
    }

    //Provides a method allocateTasks to iterate through tasks and allocate them to suitable team members.
    public void allocateTasks() {
        for (Task task : tasks) {
            if (task != null) {
                TeamMember[] suitableMembers = findSuitableMembers(task);
                if (suitableMembers.length > 0) {
                    TeamMember selectedMember = selectBestMember(suitableMembers);
                    assignTask(selectedMember, task);
                } else {
                    System.out.println("No suitable team member found for task: " + task.getName());
                }
            }
        }
    }

    //Provides a private method findSuitableMembers to find team members suitable for a given task based on skills, workload, and availability.
    private TeamMember[] findSuitableMembers(Task task) {
        TeamMember[] suitableMembers = new TeamMember[teamMembersCount];
        int count = 0;
        for (TeamMember member : teamMembers) {
            if (member != null && member.isAvailable() && member.getWorkload() >= 0 &&
                    Arrays.asList(member.getSkills()).containsAll(Arrays.asList(task.getRequiredSkills()))) {
                suitableMembers[count++] = member;
            }
        }
        return Arrays.copyOf(suitableMembers, count);
    }

    //Provides a private method selectBestMember to select the best team member from the array of suitable members.
    private TeamMember selectBestMember(TeamMember[] suitableMembers) {
        // Implementation omitted for brevity
        // This method should select and return the best team member from the array of suitable members based on specific criteria.
        // For simplicity, let's just return the first suitable member.
        return suitableMembers[0];
    }

    //Provides a private method assignTask to assign a task to a team member and update their workload.
    private void assignTask(TeamMember member, Task task) {
        // Deduct assigned skills from the member's skillset (assuming skills are removed after assignment)
        String[] memberSkills = member.getSkills();
        String[] taskSkills = task.getRequiredSkills();
        for (int i = 0; i < memberSkills.length; i++) {
            for (int j = 0; j < taskSkills.length; j++) {
                if (memberSkills[i].equals(taskSkills[j])) {
                    memberSkills[i] = null; // Remove the assigned skill from member's skills
                    break;
                }
            }
        }
        member.setSkills(memberSkills);

        // Deduct workload from the member's workload
        member.setWorkload(member.getWorkload() + 1); // Assuming each task adds 1 to the workload

        // Update member's availability (assuming member is not available while working on the task)
        member.setAvailable(false);

        // Print task assignment details
        System.out.println("\nTask \"" + task.getName() + "\" assigned to Team Member: ");
        System.out.println("\tName: " + member.getName());
        System.out.println("\tSkills: " + Arrays.toString(taskSkills)); // Print required skills for the task
        System.out.println("\tWorkload: " + member.getWorkload());//Workload after assignment
        System.out.println("\tAvailable: " + member.isAvailable());//Availability after assignment
        
        /*System.out.println("\nTask \"" + task.getName() + "\" assigned to Team Member: " + member.getName());
        System.out.println("Workload after assignment: " + member.getWorkload());
        System.out.println("Availability after assignment: " + (member.isAvailable() ? "Available" : "Not Available"));*/
    }
}