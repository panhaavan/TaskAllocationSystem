class Task {
    private String name;
    private String[] requiredSkills;

    public Task(String name, String[] requiredSkills) {
        this.name = name;
        this.requiredSkills = requiredSkills;
    }

    public String getName() {
        return name;
    }

    public String[] getRequiredSkills() {
        return requiredSkills;
    }
}