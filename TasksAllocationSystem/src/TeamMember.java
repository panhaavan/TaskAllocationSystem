class TeamMember {
    private String name;
    private String[] skills;
    private int workload;
    private boolean available;

    public TeamMember(String name, String[] skills, int workload, boolean available) {
        this.name = name;
        this.skills = skills;
        this.workload = workload;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}