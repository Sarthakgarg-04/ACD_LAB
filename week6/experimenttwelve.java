package Week6;

public class experimenttwelve {
    public static boolean match(String input) {
        // Define the states
        enum State {
            START, M, MR, MS, ACCEPT
        }

        // Initialize the current state
        State currentState = State.START;

        // Iterate through each character in the input string
        for (char c : input.toCharArray()) {
            switch (currentState) {
                case START:
                    if (c == 'M') {
                        currentState = State.M;
                    } else {
                        return false;
                    }
                    break;
                case M:
                    if (c == 'r') {
                        currentState = State.MR;
                    } else if (c == 's') {
                        currentState = State.MS;
                    } else {
                        return false;
                    }
                    break;
                case MR:
                case MS:
                    // After reading "Mr" or "Ms", any character is allowed
                    currentState = State.ACCEPT;
                    break;
                case ACCEPT:
                    // Once in the ACCEPT state, stay there
                    break;
            }
        }

        // Check if the automaton reached the final ACCEPT state
        return currentState == State.ACCEPT;
    }

    public static void main(String[] args) {
        // Sample names
        String[] names = {"Mr. Rajesh", "Ms. Priya", "Dr. Patel", "Mrs. Patel", "Mr. Sharma", "Ms. Khan"};

        // Match names
        for (String name : names) {
            if (match(name)) {
                System.out.println(name + " starts with \"Mr\" or \"Ms\"");
            } else {
                System.out.println(name + " does not start with \"Mr\" or \"Ms\"");
            }
        }
    }
}

